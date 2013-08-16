/**
 * 
 */
package idv.zanyking.client.activity;

import idv.zanyking.client.MyAppGinjector;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * @author Ian YT Tsai (Zanyking)
 *
 */
public class BaseActivity extends AbstractActivity{
	private MyAppGinjector injector;
	private Place place;
	
	
	public BaseActivity(MyAppGinjector injector, Place place) {
		this.injector = injector;
		this.place = place;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		panel.setWidget(injector.getBannerP().create(place).getView());
		panel.setWidget(injector.getSidebarP().create(place).getView());
		panel.setWidget(injector.getContentP().create(place).getView());
		
	}

}
