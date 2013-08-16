/**
 * 
 */
package idv.zanyking.client;

import idv.zanyking.client.presenter.BannerPresenter;
import idv.zanyking.client.presenter.ContentPresenter;
import idv.zanyking.client.presenter.SidebarPrensenter;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

/**
 * @author Ian YT Tsai (Zanyking)
 *
 */
@GinModules(MyAppGinModule.class)
public interface MyAppGinjector extends Ginjector {

	BannerPresenter.Factory getBannerP();
	SidebarPrensenter.Factory getSidebarP();
	ContentPresenter.Factory getContentP();
	EventBus getEventBus();
	PlaceController getPlaceController(); 
}
