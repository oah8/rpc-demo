package oah.project.impl;

import lombok.extern.slf4j.Slf4j;
import oah.project.RequestHandler;
import oah.project.TransportServer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName HttpTransportServer
 * @Description TODO
 * @Author _oah
 * @Date 2024.04.04 11:08
 * @Version 1.0
 */
@Slf4j
public class HttpTransportServer implements TransportServer {

	private RequestHandler handler;

	private Server server;

	@Override
	public void init(int port, RequestHandler handler) {
		this.handler = handler;
		this.server = new Server(port);

		// servlet 接收请求
		ServletContextHandler ctx = new ServletContextHandler();
		server.setHandler(ctx);


		ServletHolder holder = new ServletHolder(new RequestServlet());
		ctx.addServlet(holder, "/*");

	}

	@Override
	public void start() {
		try {
			server.start();
			server.join();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	@Override
	public void stop() {
		try {
			server.stop();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

	class RequestServlet extends HttpServlet {
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
			log.info("client connected");

			ServletInputStream in = req.getInputStream();
			ServletOutputStream out = resp.getOutputStream();
			if (handler != null) {
				handler.onRequest(in, out);
			}
			out.flush();
		}
	}
}
