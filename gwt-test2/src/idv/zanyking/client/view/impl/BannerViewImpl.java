/**
 * 
 */
package idv.zanyking.client.view.impl;

import idv.zanyking.client.view.BannerView;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * @author Ian YT Tsai (Zanyking)
 *
 */
public class BannerViewImpl extends FlowPanel implements BannerView, ClickHandler {

	private Presenter presenter;
	private Label label;
	private TextBox usrNameTxb;
	

	public BannerViewImpl() {
		
		label = new Label("Hello! please type your name!");
		label.setStylePrimaryName("header-title");
		add(label);
		
		Button btn = new Button("Change user name");
		btn.addClickHandler(this);
		add(btn);
		
		usrNameTxb = new TextBox();
		add(usrNameTxb);
	}

	/* (non-Javadoc)
	 * @see com.google.gwt.user.client.ui.IsWidget#asWidget()
	 */
	@Override
	public Widget asWidget() {
		return this;
	}

	/* (non-Javadoc)
	 * @see idv.zanyking.client.view.BannerView#setUserName(java.lang.String)
	 */
	@Override
	public void setUserName(String name) {
		usrNameTxb.setValue("");
		label.setText("hello! user: "+name);
	}

	/* (non-Javadoc)
	 * @see idv.zanyking.client.view.BannerView#setPresenter(idv.zanyking.client.view.BannerView.Presenter)
	 */
	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@Override
	public void onClick(ClickEvent event) {
		presenter.setUserName(usrNameTxb.getText());
	}

}
