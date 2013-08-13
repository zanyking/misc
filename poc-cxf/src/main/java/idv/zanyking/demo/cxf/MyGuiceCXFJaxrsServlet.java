/**
 * 
 */
package idv.zanyking.demo.cxf;

import idv.zanyking.demo.model.CustomerService;
import idv.zanyking.demo.model.HelloWorld;
import idv.zanyking.demo.model.User;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.apache.cxf.jaxrs.provider.jsonp.JsonpInInterceptor;
import org.apache.cxf.jaxrs.provider.jsonp.JsonpPostStreamInterceptor;
import org.apache.cxf.jaxrs.provider.jsonp.JsonpPreStreamInterceptor;
import org.apache.cxf.message.Message;
import org.apache.cxf.transport.servlet.CXFNonSpringServlet;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Ian YT Tsai (Zanyking)
 * 
 */
public class MyGuiceCXFJaxrsServlet extends CXFNonSpringServlet {
	private static final long serialVersionUID = 4798627144134171969L;

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		super.init(servletConfig);
		
		Bus bus = this.getBus();
		BusFactory.setDefaultBus(bus);

		JAXRSServerFactoryBean jaxrsFacBean = new JAXRSServerFactoryBean();
		jaxrsFacBean.setBus(getBus());

		
		// config OUT interceptors...
		configInInterceptors( jaxrsFacBean);
		
		// config IN interceptors...
		configOutInterceptors(jaxrsFacBean);
		
		// determine target jax-rs services
		configResources(jaxrsFacBean);
		
		jaxrsFacBean.setProvider(new JacksonJsonProvider());
		jaxrsFacBean.create();
	}
	/**
	 * 
	 * @param jaxrsFacBean
	 */
	protected void configInInterceptors(JAXRSServerFactoryBean jaxrsFacBean) {
		List<Interceptor<? extends Message>> interceptors = 
				new ArrayList<Interceptor<? extends Message>>();
		
		interceptors.add(new JsonpInInterceptor());
		jaxrsFacBean.setInInterceptors(interceptors);
	}
	/**
	 * 
	 * @param jaxrsFacBean
	 */
	protected void configOutInterceptors(JAXRSServerFactoryBean jaxrsFacBean) {
		List<Interceptor<? extends Message>> interceptors = 
				new ArrayList<Interceptor<? extends Message>>();
		interceptors.add(new JsonpPreStreamInterceptor());
		interceptors.add(new JsonpPostStreamInterceptor());
		
		jaxrsFacBean.setOutInterceptors(interceptors);
		
//		interceptors = new ArrayList<Interceptor<? extends Message>>();
//		interceptors.add(new FaultOutInterceptor());
//		jaxrsFacBean.setOutFaultInterceptors(interceptors);
	}
	/**
	 * 
	 * @param jaxrsFacBean
	 */
	protected void configResources(JAXRSServerFactoryBean jaxrsFacBean){
		
		
		//TODO make this configurable...
		
		Injector injector = Guice.createInjector(new AbstractModule() {
			@Override
			protected void configure() {
				bind(User.class).toInstance(new User("Zanyking"));
				bind(CustomerService.class);
				bind(HelloWorld.class);
			}
		});
		
		jaxrsFacBean.setResourceClasses(CustomerService.class);
		jaxrsFacBean.setResourceProvider(CustomerService.class, 
				new SingletonResourceProvider(
						injector.getInstance(CustomerService.class)));
		
		jaxrsFacBean.setResourceClasses(HelloWorld.class);
		jaxrsFacBean.setResourceProvider(HelloWorld.class, 
				new SingletonResourceProvider(
						injector.getInstance(HelloWorld.class)));
	}
	
}
