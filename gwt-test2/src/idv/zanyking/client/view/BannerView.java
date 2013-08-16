/**
 * 
 */
package idv.zanyking.client.view;

import com.google.gwt.user.client.ui.IsWidget;

/**
 * @author Ian YT Tsai (Zanyking)
 *
 */
public interface BannerView  extends IsWidget{

	/**
	 * 
	 * @param name
	 */
	void setUserName(String name);
	
	/**
	 * 
	 * @param newTile
	 */
	void setTitle(String newTile);
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
		BannerView getView();
		void setUserName(String txt);
	}
}
