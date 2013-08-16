/**
 * 
 */
package idv.zanyking.client;

import idv.zanyking.client.activity.MyAppActivityMapper;
import idv.zanyking.client.place.FirstPlace;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.SimplePanel;

/**
 * @author Ian YT Tsai (Zanyking)
 *
 */
public class MyDemoEntryPoint implements EntryPoint  {

	
	MyAppPlaceMapper historyMapper = GWT.create(MyAppPlaceMapper.class);
	PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
	
	FirstPlace defaultPlace = new FirstPlace();
	SimplePanel panel = new SimplePanel();
	
	@Override
	public void onModuleLoad() {
		
		MyAppGinjector injector = GWT.create(MyAppGinjector.class);
		
		PlaceController placeController = injector.getPlaceController();
		historyHandler.register(
				placeController, 
				injector.getEventBus(), 
				defaultPlace);
		MyAppActivityMapper myMapper = new MyAppActivityMapper(injector);
		ActivityManager activityManager = new ActivityManager(myMapper, injector.getEventBus());
        activityManager.setDisplay(panel);
		// do this part in Activity...
//		RootPanel.get("header").add(injector.getBannerP().create(place).getView());
//		RootPanel.get("sidebar").add(injector.getSidebarP().create(place).getView());
//		RootPanel.get("content").add(injector.getContentP().create(place).getView());
		
		historyHandler.handleCurrentHistory();
	}

}
