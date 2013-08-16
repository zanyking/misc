/**
 * 
 */
package idv.zanyking.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * @author Ian YT Tsai (Zanyking)
 *
 */
public class ThirdPlace extends Place{
	private String placeName;

	public ThirdPlace(String placeName) {
		this.placeName = placeName;
	}

	
	public ThirdPlace() {
		placeName = "third_place";
	}


	public String getPlaceName() {
		return placeName;
	}
	
	public static class Tokenizer implements PlaceTokenizer<ThirdPlace>{
		@Override
		public ThirdPlace getPlace(String token) {
 			return new ThirdPlace(token);
		}
		@Override
		public String getToken(ThirdPlace place) {
			return place.getPlaceName();
		}
	}
}
