package oah.project;

import lombok.Data;

/**
 * @ClassName Request
 * @Description TODO 表示RPC的一个请求
 * @Author _oah
 * @Date 2024.04.03 19:55
 * @Version 1.0
 */
@Data
public class Request {
	/**
	 * 服务
	 */
	private ServiceDescriptor service;

	/**
	 * 存储参数
	 */
	private Object[] args;
}
