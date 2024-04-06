package oah.project;

/**
 * @ClassName TransportServer
 * @Description TODO
 * @Author _oah
 * @Date 2024.04.04 10:29
 * @Version 1.0
 */

/**
 * 1、启动，监听
 * 2、接受请求
 * 3、关闭监听
 */
public interface TransportServer {

	void init(int port, RequestHandler handler);

	void start();

	void stop();

}
