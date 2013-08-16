/**
 * 
 */
package idv.zanyking.client;

import idv.zanyking.client.place.FirstPlace;
import idv.zanyking.client.place.SecondPlace;
import idv.zanyking.client.place.ThirdPlace;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

/**
 * @author Ian YT Tsai (Zanyking)
 *
 */
@WithTokenizers({
	FirstPlace.Tokenizer.class,
	SecondPlace.Tokenizer.class,
	ThirdPlace.Tokenizer.class
})
public interface MyAppPlaceMapper extends PlaceHistoryMapper{

}
