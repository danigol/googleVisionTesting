package googleVisionTesting;

public class Ratings {

	/**
	 * Likeliness values are Unknown, Very Unlikely, Unlikely, Possible, Likely, and Very Likely
	 * Unknown = -1, Very likely = 4
	 * @author Danielle Golinsky
	 */
	public enum Likliness {
		UNKNOWN(-1),
		VERY_UNLIKELY(0),
		UNLIKELY(1),
		POSSIBLE(2),
		LIKELY(3),
		VERY_LIKELY(4);
		
		private int value = -1;
		
		public int getValue() {
			return this.value;
		}
		
		Likliness(int lv) {
			this.value = lv;
		}
	}
}
