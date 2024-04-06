package oah.project;

import oah.project.impl.CalculateServiceImpl;

/**
 * @ClassName Server
 * @Description TODO
 * @Author _oah
 * @Date 2024.04.04 14:12
 * @Version 1.0
 */
public class Server {

    public static void main(String[] args) {
        RpcServer server = new RpcServer(new RpcServerConfig());
        server.register(CalculateService.class, new CalculateServiceImpl());
        server.start();
    }


}






















