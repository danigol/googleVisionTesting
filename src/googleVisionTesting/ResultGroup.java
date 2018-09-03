package googleVisionTesting;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

/**
 * Stores the 
 * @author Danielle Golinsky
 */
public class ResultGroup {

	private final String resultGroupName;
	private final String parentGroupName;
	private ArrayList<String> childGroupNames;
	private TreeMap<String, Result> resultsList;
	
	public ResultGroup(final String _resultGroupName, final String _parentGroupName) {
		this.resultGroupName = _resultGroupName;
		this.parentGroupName = _parentGroupName;
		this.childGroupNames = null;
		this.resultsList = new TreeMap<String, Result>();
	}
	
	public ResultGroup(final String _resultGroupName, final String _parentGroupName,
						final ArrayList<String> _childGroupNames) {
			this.resultGroupName = _resultGroupName;
			this.parentGroupName = _parentGroupName;
			this.childGroupNames = _childGroupNames;
			this.resultsList = new TreeMap<String, Result>();
	}
	
	public ResultGroup(final String _resultGroupName, final String _parentGroupName,
						final ArrayList<String> _childGroupNames, final TreeMap<String, Result> _resultsList) {
		this.resultGroupName = _resultGroupName;
		this.parentGroupName = _parentGroupName;
		this.childGroupNames = _childGroupNames;
		this.resultsList = _resultsList;
	}
		
	public String getGroupName() {
		return this.resultGroupName;
	}
	public String getParentGroupName() {
		return this.parentGroupName;
	}
	public TreeMap<String, Result> getResultsList() {
		return this.resultsList;
	}
	public ArrayList<String> getChildGroupNames() {
		return this.childGroupNames;
	}
	
	/**
	 * Gets the result for the original file
	 * If you're asking for this, you likely don't have the saved result file
	 * 		that includes the ratings in the file name for easy tagging purposes.
	 * @param fileName
	 * @return
	 */
	public Result getResult(String fileName) {
		return this.resultsList.get(fileName);
	}
	
	
	public String getAllResultsString() {
		StringBuilder allResults = new StringBuilder();
		Set<String> results = resultsList.keySet();
		for (String r : results) {
			allResults.append(resultsList.get(r).getResultString());
		}
		return allResults.toString();
	}
	
	public void addResult(Result result) {
		this.resultsList.put(result.getOriginalFileName(), result);
	}
	
	public void addResults(final TreeMap<String, Result> _resultList) {
		this.resultsList.putAll(resultsList);
	}
}
