package test;

import org.junit.Test;

import googleVisionTesting.Ratings.Likliness;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

import org.junit.Assert;
import org.junit.Before;

import googleVisionTesting.Result;
import googleVisionTesting.ResultGroup;

public class ResultGroupTest {
	
	private Result vlTestResult;
	private Result lTestResult;
	private Result pTestResult;
	private Result ulTestResult;
	private Result vulTestResult;
	
	private List<Result> results;
	
	private ResultGroup subject;
	
	@Before
	public void setup() {
		vlTestResult = new Result("test4.jpg", Likliness.VERY_LIKELY, Likliness.VERY_LIKELY, 
				Likliness.VERY_LIKELY, Likliness.VERY_LIKELY, Likliness.VERY_LIKELY);
		lTestResult = new Result("test3.jpg", Likliness.LIKELY, Likliness.LIKELY, 
				Likliness.VERY_LIKELY, Likliness.LIKELY, Likliness.LIKELY);
		pTestResult = new Result("test2.jpg", Likliness.POSSIBLE, Likliness.POSSIBLE, 
				Likliness.POSSIBLE, Likliness.POSSIBLE, Likliness.POSSIBLE);
		ulTestResult = new Result("test1.jpg", Likliness.UNLIKELY, Likliness.UNLIKELY, 
				Likliness.UNLIKELY, Likliness.UNLIKELY, Likliness.UNLIKELY);
		vulTestResult = new Result("test0.jpg", Likliness.VERY_UNLIKELY, Likliness.VERY_UNLIKELY, 
				Likliness.VERY_UNLIKELY, Likliness.VERY_UNLIKELY, Likliness.VERY_UNLIKELY);
		
		results = new ArrayList<Result>();
		results.add(vlTestResult);
		results.add(lTestResult);
		results.add(pTestResult);
		results.add(ulTestResult);
		results.add(vulTestResult);
		// We use a sorted tree map in ResultGroup based on the original name as a key
		// Therefore, sort before we test
		Collections.sort(results); 
	}
	
	private String getAllResultsString() {
		StringBuilder resultsString = new StringBuilder();
		
		if (results != null) {
			results.forEach(r -> resultsString.append(r.getResultString()));
		}
		
		return resultsString.toString();
	}
	
	private TreeMap<String, Result> getResultMap() {
		TreeMap<String, Result> map = new TreeMap<String, Result>();
		results.forEach(r -> map.put(r.getOriginalFileName(), r));
		return map;
	}
	
	private void addAllToSubject() {
		if (subject != null) {
			results.forEach(r -> subject.addResult(r));
		}
	}
	
	private void testContents() {
		Assert.assertEquals("Results group did not contain all results.",
				getAllResultsString(), 
				subject.getAllResultsString());
	}
	
	private ArrayList<String> getChildNames() {
		ArrayList<String> childNames = new ArrayList<String>();
		childNames.add("Child0");
		childNames.add("Child1");
		childNames.add("Child2");
		return childNames;
	}

	@Test
	public void testParentGroupNameOnlyNoChildGroups() {
		String subjectGroupName = "ParentGroup";
		subject = new ResultGroup(subjectGroupName, "");
		addAllToSubject();
		
		Assert.assertEquals("Group name did not match",
				subjectGroupName,
				subject.getGroupName());
		// Verify each test result is present
		testContents();
	}
	
	@Test
	public void testParentGroupProvidedMapNoChildGroups() {
		String subjectGroupName = "ParentGroup";
		subject = new ResultGroup(subjectGroupName, "");
		addAllToSubject();
		
		Assert.assertEquals("Group name did not match",
				subjectGroupName,
				subject.getGroupName());
		// Verify each test result is present
		testContents();		
	}

	@Test
	public void testParentGroupNameOnly() {
		String subjectGroupName = "ParentGroup";
		subject = new ResultGroup(subjectGroupName, "", getChildNames());
		addAllToSubject();
		
		Assert.assertEquals("Group name did not match",
				subjectGroupName,
				subject.getGroupName());
		// Verify each test result is present
		testContents();
	}
	
	@Test
	public void testParentGroupProvidedMap() {
		String subjectGroupName = "ParentGroup";
		subject = new ResultGroup(subjectGroupName, "", getChildNames(), getResultMap());
		
		Assert.assertEquals("Group name did not match",
				subjectGroupName,
				subject.getGroupName());
		// Verify each test result is present
		testContents();		
	}
	
	@Test
	public void testParentGroupAddMap() {
		String subjectGroupName = "ParentGroup";
		subject = new ResultGroup(subjectGroupName, "", getChildNames());
		subject.addResults(getResultMap());
		Assert.assertEquals("Group name did not match",
				subjectGroupName,
				subject.getGroupName());
		// Verify each test result is present
		testContents();		
	}
	
	@Test
	public void testChildGroupNamesOnly() {
		String subjectGroupName = "ChildGroup";
		String subjectParentGroupName = "ParentGroup";
		subject = new ResultGroup(subjectGroupName, subjectParentGroupName);
		addAllToSubject();
		
		Assert.assertEquals("Group name did not match",
				subjectGroupName,
				subject.getGroupName());
		
		Assert.assertEquals("Parent Group name did not match",
				subjectParentGroupName,
				subject.getParentGroupName());
		// Verify each test result is present
		testContents();
	}
	
	@Test
	public void testChildGroupProvidedMap() {
		String subjectGroupName = "ChildGroup";
		String subjectParentGroupName = "ParentGroup";
		subject = new ResultGroup(subjectGroupName, subjectParentGroupName, null, getResultMap());
		
		Assert.assertEquals("Group name did not match",
				subjectGroupName,
				subject.getGroupName());
		
		Assert.assertEquals("Parent Group name did not match",
				subjectParentGroupName,
				subject.getParentGroupName());
		// Verify each test result is present
		testContents();
	}
}
