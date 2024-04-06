package oah.project;


import oah.project.impl.JSONDecoder;
import oah.project.impl.JSONEncoder;
import org.junit.Assert;
import org.junit.Test;

public class RpcCodecApplicationTests {

	@Test
	public void TestEncoder() {
		Encoder encoder = new JSONEncoder();

		TestBean bean = new TestBean();
		bean.setName("demo");
		bean.setAge(18);

		byte[] bytes = encoder.encode(bean);

		Assert.assertNotNull(bytes);

	}

	@Test
	public void contextLoads() {
		JSONEncoder encoder = new JSONEncoder();

		TestBean bean = new TestBean();
		bean.setName("demo");
		bean.setAge(18);

		byte[] bytes = encoder.encode(bean);

		Decoder decoder = new JSONDecoder();

		TestBean bean2 = decoder.decode(bytes, TestBean.class);

		Assert.assertEquals(bean.getName(), bean2.getName());
		Assert.assertEquals(bean.getAge(), bean2.getAge());


	}

}
