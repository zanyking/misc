/**
 * 
 */
package idv.zanyking.client.view;

import com.google.gwt.user.client.ui.IsWidget;

/**
 * 
 * @author Ian YT Tsai (Zanyking)
 *
 */
public interface ContentView  extends IsWidget{
	/**
	 * 
	 * @param presenter
	 */
	void setPresenter(Presenter presenter);
	/**
	 * 
	 * @author Ian YT Tsai (Zanyking)
	 *
	 */
	interface Presenter{
		ContentView getView();
	}
}
