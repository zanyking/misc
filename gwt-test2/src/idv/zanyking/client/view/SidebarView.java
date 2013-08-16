/**
 * 
 */
package idv.zanyking.client.view;

import com.google.gwt.user.client.ui.IsWidget;

/**
 * @author Ian YT Tsai (Zanyking)
 *
 */
public interface SidebarView  extends IsWidget{
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
		SidebarView getView();
	}
}
