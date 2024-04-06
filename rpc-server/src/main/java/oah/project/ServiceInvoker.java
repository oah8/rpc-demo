package oah.project;

import oah.project.utils.ReflectionUtils;

/**
 * @ClassName ServiceIncoker
 * @Description TODO
 * @Author _oah
 * @Date 2024.04.04 12:57
 * @Version 1.0
 */

/**
 * 调用具体的服务
 */
public class ServiceInvoker {
    public Object invoke(ServiceInstance service,
                         Request request) {
        return ReflectionUtils.invoke(
                service.getTarget(),
                service.getMethod(),
                request.getArgs()
        );
    }
}


















