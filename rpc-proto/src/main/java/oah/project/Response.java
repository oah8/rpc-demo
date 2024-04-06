package oah.project;

import lombok.Data;

/**
 * @ClassName Response
 * @Description TODO 表示RPC的返回
 * @Author _oah
 * @Date 2024.04.03 19:57
 * @Version 1.0
 */
@Data
public class Response {

	/**
	 * 服务返回的编码，0：成功，非0失败
	 */
	private int code = 0;
	/**
	 * 具体的错误信息
	 */
	private String message = "ok";

	/**
	 * 返回的数据
	 */
	private Object data;

}
