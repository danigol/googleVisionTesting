package test;

import org.junit.Test;

import googleVisionTesting.Result;
import googleVisionTesting.Ratings.Likliness;
import org.junit.Assert;

public class ResultTest {

	@Test
	public void makeResult() {
		final String testFileName = "testFile.jpg";
		final String testResultsFileName = 
				String.format("%s_a-%d_s-%d_m-%d_v-%d_r-%d.jpg",
						"testFile", 4, 3, 2, 1, 0);
		final String expectedResultsString = "--- Result ---\n"
				+ "  Original File Name: " + testFileName + "\n"
				+ "  Tagged Result File Name: " + testResultsFileName + "\n"
				+ "    Adult Likliness: " + Likliness.VERY_LIKELY.getValue() + "\n"
				+ "    Spoof Likliness: " + Likliness.LIKELY.getValue() + "\n"
				+ "    Medical Likliness: " + Likliness.POSSIBLE.getValue() + "\n"
				+ "    Violence Likliness: " + Likliness.UNLIKELY.getValue() + "\n"
				+ "    Racy Likliness: " + Likliness.VERY_UNLIKELY.getValue() + "\n\n";
		
		
		Result subject = new Result(testFileName,
				Likliness.VERY_LIKELY, // Adult
				Likliness.LIKELY, // Spoof
				Likliness.POSSIBLE, // Medical 
				Likliness.UNLIKELY, // Violence
				Likliness.VERY_UNLIKELY); // Racy
		
		Assert.assertEquals("Result Adult did not match.",
				Likliness.VERY_LIKELY,
				subject.getAdultLikliness());
		Assert.assertEquals("Result Spoof did not match.", 
				Likliness.LIKELY,
				subject.getSpoofLikliness());
		
		Assert.assertEquals("Result Medical did not match.", 
				Likliness.POSSIBLE,
				subject.getMedicalLikliness());
		Assert.assertEquals("Result Violence did not match.",
				Likliness.UNLIKELY,
				subject.getViolenceLikliness());
		Assert.assertEquals("Result Racy did not match.",
				Likliness.VERY_UNLIKELY,
				subject.getRacyLikliness());
		Assert.assertEquals("Results file name did not match", testResultsFileName, subject.getResultFileName());
		
		Assert.assertEquals("Result output did not match expectation.",
				expectedResultsString,
				subject.getResultString());
	}
}
