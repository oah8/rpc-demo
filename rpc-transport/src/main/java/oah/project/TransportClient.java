package oah.project;

/**
 * @ClassName TransportClient
 * @Description TODO
 * @Author _oah
 * @Date 2024.04.03 22:01
 * @Version 1.0
 */

import java.io.InputStream;

/**
 * 1、创建连接
 * 2、发送数据，并且等待响应
 * 3、关闭连接
 */
public interface TransportClient {

	void connect(Peer peer);

	InputStream write(InputStream data);

	void close();



}
