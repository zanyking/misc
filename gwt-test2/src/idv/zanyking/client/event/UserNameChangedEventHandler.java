/**
 * 
 */
package idv.zanyking.client.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * @author Ian YT Tsai (Zanyking)
 *
 */
public interface UserNameChangedEventHandler extends EventHandler{
	/**
	 * 
	 * @param newName
	 */
	void onUserNameChanaged(String newName);
}
