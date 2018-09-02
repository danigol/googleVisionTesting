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
	
	public ResultGroup(final String _resultGroupName) {
		this.resultGroupName = _resultGroupName;
		this.parentGroupName = "";
		this.resultsList = new TreeMap<String, Result>();
		this.childGroupNames = new ArrayList<String>();
	}
	
	public ResultGroup(final String _resultGroupName,
						final String _parentGroupName) {
		this.resultGroupName = _resultGroupName;
		this.parentGroupName = _parentGroupName;
		this.resultsList = new TreeMap<String, Result>();
		this.childGroupNames = new ArrayList<String>();
	}
	
	public ResultGroup(final String _resultGroupName,
						final String _parentGroupName,
						final TreeMap<String, Result> _resultsList) {
		this.resultGroupName = _resultGroupName;
		this.parentGroupName = _parentGroupName;
		this.resultsList = _resultsList;
		this.childGroupNames = new ArrayList<String>();
	}
	
	public ResultGroup(final String _resultGroupName,
			final TreeMap<String, Result> _resultsList) {
			this.resultGroupName = _resultGroupName;
			this.parentGroupName = "";
			this.resultsList = _resultsList;
			this.childGroupNames = new ArrayList<String>();
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
			allResults.append(resultsList.get(r));
		}
		return allResults.toString();
	}
	
	public void addResult(Result result) {
		this.resultsList.put(result.getOriginalFileName(), result);
	}
}
