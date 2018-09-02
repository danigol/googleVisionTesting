package test;

import org.junit.Test;

import googleVisionTesting.Ratings.Likliness;
import org.junit.Assert;
import googleVisionTesting.Result;
import googleVisionTesting.ResultGroup;

public class ResultGroupTest {

	@Test
	public void testParentGroup() {
		String subjectGroupName = "ParentGroup";
		ResultGroup subject = new ResultGroup(subjectGroupName);
		Result vlTestResult = new Result("test0.jpg", Likliness.VERY_LIKELY, Likliness.VERY_LIKELY, Likliness.VERY_LIKELY, Likliness.VERY_LIKELY, Likliness.VERY_LIKELY);
		Result vulTestResult = new Result("test1.jpg", Likliness.VERY_UNLIKELY, Likliness.VERY_UNLIKELY, Likliness.VERY_UNLIKELY, Likliness.VERY_UNLIKELY, Likliness.VERY_UNLIKELY);
		
		subject.addResult(vlTestResult);
		subject.addResult(vulTestResult);
		
		Assert.assertEquals("Group name did not match",
				subjectGroupName,
				subject.getGroupName());
		// TODO Every other public method and public constructor
	}
}
