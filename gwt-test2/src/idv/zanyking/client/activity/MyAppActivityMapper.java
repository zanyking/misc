/**
 * 
 */
package idv.zanyking.client.activity;

import idv.zanyking.client.MyAppGinjector;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

/**
 * @author Ian YT Tsai (Zanyking)
 * 
 */
public class MyAppActivityMapper implements ActivityMapper {

	private MyAppGinjector injector;

	public MyAppActivityMapper(MyAppGinjector injector) {
		this.injector = injector;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.google.gwt.activity.shared.ActivityMapper#getActivity(com.google.
	 * gwt.place.shared.Place)
	 */
	@Override
	public Activity getActivity(Place place) {
		// TODO detact place to use different setting, but I see no point in
		// current scenario, do it in the future.
		return new BaseActivity(injector, place);
	}

}
