package oah.project;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Method;

/**
 * @ClassName ServiceInstance
 * @Description TODO 表示一个具体服务
 * @Author _oah
 * @Date 2024.04.04 11:33
 * @Version 1.0
 */
@Data
@AllArgsConstructor
public class ServiceInstance {

	private Object target;

	private Method method;


}
