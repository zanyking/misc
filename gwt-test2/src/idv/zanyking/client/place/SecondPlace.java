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
public class SecondPlace extends Place{
	private String placeName;

	public SecondPlace(String placeName) {
		this.placeName = placeName;
	}
	

	public SecondPlace() {
		this.placeName = "second_place";
	}


	public String getPlaceName() {
		return placeName;
	}
	
	public static class Tokenizer implements PlaceTokenizer<SecondPlace>{
		@Override
		public SecondPlace getPlace(String token) {
 			return new SecondPlace(token);
		}
		@Override
		public String getToken(SecondPlace place) {
			return place.getPlaceName();
		}
	}
}
