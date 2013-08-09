/**
 * 
 */
package idv.zanyking.jaxrs.config;

import java.util.Map;

import org.apache.cxf.jaxrs.lifecycle.ResourceProvider;

/**
 * @author Ian YT Tsai (Zanyking)
 *
 */
public interface MyCXFPreferences {

	
	Map<Class<?>, ResourceProvider> getJaxRsResources();
}
