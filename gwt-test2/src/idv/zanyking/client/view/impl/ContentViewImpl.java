/**
 * 
 */
package idv.zanyking.client.view.impl;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;

import idv.zanyking.client.view.ContentView;

/**
 * @author Ian YT Tsai (Zanyking)
 *
 */
public class ContentViewImpl extends FlowPanel implements ContentView{

	private Presenter presenter;

	
	@Override
	public Widget asWidget() {
		return this;
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
		
	}

}
