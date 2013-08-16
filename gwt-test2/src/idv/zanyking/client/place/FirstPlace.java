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
public class FirstPlace extends Place{
	
	private String placeName;

	public FirstPlace(String placeName) {
		this.placeName = placeName;
	}

	public FirstPlace() {
		this.placeName = "first_place";
	}

	public String getPlaceName() {
		return placeName;
	}
	
	public static class Tokenizer implements PlaceTokenizer<FirstPlace>{
		@Override
		public FirstPlace getPlace(String token) {
 			return new FirstPlace(token);
		}
		@Override
		public String getToken(FirstPlace place) {
			return place.getPlaceName();
		}
	}
}
