/**
 * 
 */
package idv.zanyking.client.presenter;

import idv.zanyking.client.event.UserChangeEvent;
import idv.zanyking.client.view.BannerView;
import idv.zanyking.client.view.BannerView.Presenter;

import javax.inject.Inject;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.assistedinject.Assisted;
import com.google.web.bindery.event.shared.EventBus;

/**
 * @author Ian YT Tsai (Zanyking)
 * 
 */
public class BannerPresenter implements Presenter {

	private BannerView view;
	private EventBus evtBus;
	private Place place;

	/**
	 * 
	 * @author Ian YT Tsai (Zanyking)
	 *
	 */
	public interface Factory {
		BannerPresenter create(Place place);
	}

	/**
	 * 
	 * @param view
	 * @param evtBus
	 */
	@Inject
	public BannerPresenter(BannerView view, EventBus evtBus, @Assisted Place place) {
		this.view = view;
		this.evtBus = evtBus;
		this.place = place;
		view.setPresenter(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see idv.zanyking.client.view.BannerView.Presenter#getView()
	 */
	@Override
	public BannerView getView() {
		return view;
	}

	@Override
	public void setUserName(String newUserName) {
		evtBus.fireEvent(new UserChangeEvent(newUserName));
		view.setTitle("hello! " + newUserName);
		view.setUserName(newUserName);
	}

	public void start(AcceptsOneWidget panel,
			com.google.gwt.event.shared.EventBus eventBus) {
		// TODO: bind view to panel.
	}

}
