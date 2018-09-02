package googleVisionTesting;

import googleVisionTesting.Ratings.Likliness;

public class Result {
	
	private final String originalFileName;
	private final String resultFileName;
	private final Likliness adult;
	private final Likliness spoof;
	private final Likliness medical;
	private final Likliness violence;
	private final Likliness racy;
	
	/**
	 * @param _fileName
	 * @param _adult
	 * @param _spoof
	 * @param _medical
	 * @param _violence
	 * @param _racy
	 */
	public Result(final String _fileName,
					final Likliness _adult,
					final Likliness _spoof,
					final Likliness _medical,
					final Likliness _violence,
					final Likliness _racy) {
		originalFileName = _fileName;
		adult = _adult;
		spoof = _spoof;
		medical = _medical;
		violence = _violence;
		racy = _racy;
		resultFileName = generateResultFileName();
	}
	
	private String generateResultFileName() {
		String fileNameNoExtension = this.originalFileName.substring(
				0, this.originalFileName.lastIndexOf("."));
		String extension = this.originalFileName.replace(fileNameNoExtension, "");
		String results = String.format("a-%d_s-%d_m-%d_v-%d_r-%d", 
				this.adult.getValue(),
				this.spoof.getValue(),
				this.medical.getValue(),
				this.violence.getValue(),
				this.racy.getValue());
		
		return fileNameNoExtension + "_" + results + extension;
	}
	
	public String getOriginalFileName() {
		return this.originalFileName;
	}
	public String getResultFileName() {
		return this.resultFileName;
	}
	
	public Likliness getAdultLikliness() {
		return adult;
	}
	public Likliness getSpoofLikliness() {
		return spoof;
	}
	public Likliness getMedicalLikliness() {
		return medical;
	}
	public Likliness getViolenceLikliness() {
		return violence;
	}
	public Likliness getRacyLikliness() {
		return racy;
	}
	
	/**
	 * Output this result as a string
	 * @return
	 */
	public String getResultString() {
		return "--- Result ---\n"
				+ "  Original File Name: " + this.originalFileName + "\n"
				+ "  Tagged Result File Name: " + this.resultFileName + "\n"
				+ "    Adult Likliness: " + this.adult.getValue() + "\n"
				+ "    Spoof Likliness: " + this.spoof.getValue() + "\n"
				+ "    Medical Likliness: " + this.medical.getValue() + "\n"
				+ "    Violence Likliness: " + this.violence.getValue() + "\n"
				+ "    Racy Likliness: " + this.racy.getValue() + "\n\n";
	}
	
}
