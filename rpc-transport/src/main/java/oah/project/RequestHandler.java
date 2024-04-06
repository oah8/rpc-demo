package oah.project;

/**
 * @ClassName RequestHandler
 * @Description TODO
 * @Author _oah
 * @Date 2024.04.04 10:30
 * @Version 1.0
 */

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 处理网络请求的handler
 */
public interface RequestHandler {
	void onRequest(InputStream receive, OutputStream toResp);
}
