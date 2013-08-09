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
public class MyCXFPreferencesImpl implements MyCXFPreferences{

	
	
	@Override
	public Map<Class<?>, ResourceProvider> getJaxRsResources() {
		return null;
	}

}
