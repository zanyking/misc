/**
 * 
 */
package idv.zanyking.client.event;

import com.google.gwt.event.shared.GwtEvent;

/**
 * @author Ian YT Tsai (Zanyking)
 *
 */
public class UserChangeEvent extends GwtEvent<UserNameChangedEventHandler> {

	public static final Type<UserNameChangedEventHandler> TYPE = new Type<UserNameChangedEventHandler>();
	private String newName;
	
	public UserChangeEvent(String newName) {
		this.newName = newName;
	}

	@Override
	public Type<UserNameChangedEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(UserNameChangedEventHandler handler) {
		handler.onUserNameChanaged(newName);
	}

}
