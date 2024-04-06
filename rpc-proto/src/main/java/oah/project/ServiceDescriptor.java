package oah.project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

/**
 * @ClassName ServiceDescriptor
 * @Description TODO 表示服务
 * @Author _oah
 * @Date 2024.04.03 19:52
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDescriptor {

	/**
	 * 类名
	 */
	private String clazz;

	/**
	 * 方法名
	 */
	private String method;

	/**
	 * 返回值类型
	 */
	private String returnType;

	/**
	 * 参数类型
	 */
	private String[] parameterTypes;



	@SuppressWarnings("rawtypes")
	public static ServiceDescriptor from(Class clazz, Method method) {
		ServiceDescriptor sdp = new ServiceDescriptor();
		sdp.setClazz(clazz.getName());
		sdp.setMethod(method.getName());
		sdp.setReturnType(method.getReturnType().getName());

		Class[] parameterClasses = method.getParameterTypes();

		String[] parameterTypes = new String[parameterClasses.length];
		for (int i = 0; i < parameterClasses.length; i++) {
			parameterTypes[i] = parameterClasses[i].getName();
		}
		sdp.setParameterTypes(parameterTypes);
		return sdp;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		ServiceDescriptor that = (ServiceDescriptor) o;
		return this.toString().equals(that.toString());
	}

	@Override
	public int hashCode() {
		return toString().hashCode();
	}

	@Override
	public String toString() {
		return "clazz=" + clazz
				+ "," + "method=" + method
				+ "," + "returnType" + returnType
				+ "," + "parameterTypes" + Arrays.toString(parameterTypes);
	}
}
