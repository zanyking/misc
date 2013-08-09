/**
 * 
 */
package idv.zanyking.jaxrs.model;

import com.google.inject.AbstractModule;

/**
 * @author Ian YT Tsai (Zanyking)
 *
 */
public class MyServiceModule extends AbstractModule {

	protected void configure() {
		CustomerService cs = new CustomerService(new User("Ian Tsai"));
		bind(CustomerService.class).toInstance(cs);
	}
	
	
	

}
