/**
 * 
 */
package idv.zanyking.client.presenter;

import javax.inject.Inject;

import idv.zanyking.client.view.SidebarView;
import idv.zanyking.client.view.SidebarView.Presenter;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.assistedinject.Assisted;
import com.google.web.bindery.event.shared.EventBus;

/**
 * @author Ian YT Tsai (Zanyking)
 *
 */
public class SidebarPrensenter extends AbstractActivity implements Presenter {
	
	private SidebarView view;
	private EventBus evtBus;
	private Place place;

	/**
	 * 
	 * @author Ian YT Tsai (Zanyking)
	 *
	 */
	public interface Factory {
		SidebarPrensenter create(Place place);
	}
	@Inject
	public SidebarPrensenter(SidebarView view, EventBus evtBus, @Assisted Place place) {
		this.view = view;
		this.evtBus = evtBus;
		this.place = place;
		view.setPresenter(this);
	}


	/* (non-Javadoc)
	 * @see idv.zanyking.client.view.SidebarView.Presenter#getView()
	 */
	@Override
	public SidebarView getView() {
		return view;
	}


	@Override
	public void start(AcceptsOneWidget panel,
			com.google.gwt.event.shared.EventBus eventBus) {
		// TODO add view to panel
		
	}

}
