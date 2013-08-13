/**
 * 
 */
package com.mycom.jaxrs.survey.cxf;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.MappingJsonFactory;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mycom.jaxrs.survey.model.JsonBean;


/**
 * @author Ian YT Tsai (Zanyking)
 *
 */
public class CustomerServiceIT {
private static String endpointUrl;
	
	@BeforeClass
	public static void beforeClass() {
		endpointUrl = System.getProperty("service.url");
		if(endpointUrl==null||endpointUrl.isEmpty()){// the test is running in an IDE context...
			endpointUrl = "http://localhost:8080/cxf_demo/cxf_json";
		}
	}
	@Test
	public void testPing() throws Exception {
		WebClient client = WebClient.create(endpointUrl + "/hello/echo/SierraTangoNevada");
		Response r = client.accept("application/json").get();
		assertEquals(Response.Status.OK.getStatusCode(), r.getStatus());
		String value = IOUtils.toString((InputStream)r.getEntity());
		assertEquals("SierraTangoNevada", value);
		
	}
	
	@Test
	public void testJsonRoundtrip() throws Exception {
		 List<Object> providers = new ArrayList<Object>();
	    providers.add(new org.codehaus.jackson.jaxrs.JacksonJsonProvider());
	    JsonBean inputBean = new JsonBean();
	    inputBean.setVal1("Maple");
		WebClient client = WebClient.create(endpointUrl + "/hello/jsonBean", providers);
		Response r = client.accept("application/json")
				.type("application/json")
				.post(inputBean);
		assertEquals(Response.Status.OK.getStatusCode(), r.getStatus());
		MappingJsonFactory factory = new MappingJsonFactory();
		JsonParser parser = factory.createJsonParser((InputStream)r.getEntity());
		JsonBean output = parser.readValueAs(JsonBean.class);
		assertEquals("Maple", output.getVal2());
	}
	
	
}
