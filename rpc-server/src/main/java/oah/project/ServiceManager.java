package oah.project;

import lombok.extern.slf4j.Slf4j;
import oah.project.utils.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName ServiceManager
 * @Description TODO 管理rpc暴露的服务
 * @Author _oah
 * @Date 2024.04.04 11:34
 * @Version 1.0
 */
@Slf4j
public class ServiceManager {

	private Map<ServiceDescriptor, ServiceInstance> services;

	public ServiceManager() {
		this.services = new ConcurrentHashMap<>();
	}

	public <T> void register(Class<T> interfaceClass, T bean) {
		Method[] methods = ReflectionUtils.getPublicMethods(interfaceClass);

		for (Method method : methods) {
			ServiceInstance sis = new ServiceInstance(bean, method);
			ServiceDescriptor sdp = ServiceDescriptor.from(interfaceClass, method);
			services.put(sdp, sis);

			log.info("register service: {} {}", sdp.getClazz(), sdp.getMethod());
		}
	}

	public ServiceInstance lookup(Request request) {
		ServiceDescriptor sdp = request.getService();
		return services.get(sdp);
	}




}
