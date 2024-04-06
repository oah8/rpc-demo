package oah.project;


import oah.project.utils.ReflectionUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

public class RpcServerApplicationTests {

	ServiceManager sm;

	@Before
	public void init() {
		sm = new ServiceManager();
		register();
	}


	@Test
	public void register() {
		TestInterface bean = new TestClass();
		sm.register(TestInterface.class, bean);
	}

	@Test
	public void lookup() {
		Method method = ReflectionUtils.getPublicMethods(TestInterface.class)[0];
		ServiceDescriptor sdp = ServiceDescriptor.from(TestInterface.class, method);
		Request request = new Request();
		request.setServiceDescriptor(sdp);
		ServiceInstance sis = sm.lookup(request);
		Assert.assertNotNull(sis);
	}

}
