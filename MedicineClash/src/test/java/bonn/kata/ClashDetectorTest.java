package bonn.kata;

import java.util.Set;

import org.joda.time.DateTime;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClashDetectorTest {

	@Test
	public void patientWithoutMedicationHasNoClashes() {
		Patient patient = new Patient();

		Set<DateTime> clashes = ClashDetector.clash(patient, "ASS");

		Assert.assertEquals(clashes.size(), 0, "Must contain no clashes");
	}

	@Test
	public void patientGetsOnePerscription() {
		Perscription perscription = new Perscription(5, 10);
		Medicine medicine = new Medicine("ASS", perscription);
		Patient patient = new Patient();

		patient.addPerscription("ASS", 5, 10);

		Assert.assertEquals(patient.getMedicines().get(0), medicine);
	}
	
	@Test
	public void patientGetsTwoMedicines() {
		Perscription perscriptionAss = new Perscription(5, 10);
		Medicine medicineAss = new Medicine("ASS", perscriptionAss);
		
		Perscription perscriptionIbu = new Perscription(1, 60);
		Medicine medicineIbu = new Medicine("IBU", perscriptionIbu);
		
		Patient patient = new Patient();

		patient.addPerscription("ASS", 5, 10);
		patient.addPerscription("IBU", 1, 60);

		Assert.assertTrue(patient.getMedicines().contains(medicineAss));
		Assert.assertTrue(patient.getMedicines().contains(medicineIbu));
	}
	
	@Test
	public void unequalMedicinesAreNotEqual() {
		Medicine medicine1 = new Medicine("asd", new Perscription(2, 10));
		Medicine medicine2 = new Medicine("", new Perscription(2, 10));
		
		Boolean result = medicine1.equals(medicine2);
		
		Assert.assertFalse(result);
	}
	
	@Test
	public void getAClash() {
		
		Patient patient = new Patient();

		patient.addPerscription("ASS", 5, 9);
		patient.addPerscription("IBU", 1, 10);
		
		Set<DateTime> clashes = ClashDetector.clash(patient, "ASS");
		
		Assert.assertEquals(clashes.size(), 1);
	}
	
}
