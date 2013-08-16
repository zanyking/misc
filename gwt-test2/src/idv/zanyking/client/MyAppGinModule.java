/**
 * 
 */
package idv.zanyking.client;

import idv.zanyking.client.presenter.BannerPresenter;
import idv.zanyking.client.presenter.ContentPresenter;
import idv.zanyking.client.presenter.SidebarPrensenter;
import idv.zanyking.client.view.BannerView;
import idv.zanyking.client.view.ContentView;
import idv.zanyking.client.view.SidebarView;
import idv.zanyking.client.view.impl.BannerViewImpl;
import idv.zanyking.client.view.impl.ContentViewImpl;
import idv.zanyking.client.view.impl.SidebarViewImpl;

import javax.inject.Singleton;

import com.google.gwt.core.client.GWT;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.inject.client.assistedinject.GinFactoryModuleBuilder;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

/**
 * @author Ian YT Tsai (Zanyking)
 *
 */
public class MyAppGinModule extends AbstractGinModule {

	/* (non-Javadoc)
	 * @see com.google.gwt.inject.client.AbstractGinModule#configure()
	 */
	@Override
	protected void configure() {
		//all presenter should depends on this event bus.
		bind(EventBus.class).to(SimpleEventBus.class).in(Singleton.class);
		bind(PlaceController.class).in(Singleton.class);
		
		// binding view implementations.
		bind(ContentView.class).to(ContentViewImpl.class);
		bind(BannerView.class).to(BannerViewImpl.class);
		bind(SidebarView.class).to(SidebarViewImpl.class);
		
		//bind presenter impls...
		install(new GinFactoryModuleBuilder().build(ContentPresenter.Factory.class));
//		bind(ContentView.Presenter.class).to(ContentPresenter.class);
		install(new GinFactoryModuleBuilder().build(BannerPresenter.Factory.class));
//		bind(BannerView.Presenter.class).to(BannerPresenter.class);
		install(new GinFactoryModuleBuilder().build(SidebarPrensenter.Factory.class));
//		bind(SidebarView.Presenter.class).to(SidebarPrensenter.class);
	}

}
