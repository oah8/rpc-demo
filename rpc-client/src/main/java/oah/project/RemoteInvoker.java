package oah.project;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName RemoteInvoker
 * @Description TODO 调用远程服务的代理类
 * @Author _oah
 * @Date 2024.04.04 13:49
 * @Version 1.0
 */
@Slf4j
public class RemoteInvoker implements InvocationHandler {

    private Class clazz;
    private Encoder encoder;

    private Decoder decoder;

    private TransportSelector selector;


    RemoteInvoker(Class clazz, Encoder encoder,
                  Decoder decoder, TransportSelector selector) {
        this.clazz = clazz;
        this.encoder = encoder;
        this.decoder = decoder;
        this.selector = selector;
    }

    @Override
    public Object invoke(Object proxy,
                         Method method,
                         Object[] args) throws Throwable {

        Request request = new Request();
        request.setService(ServiceDescriptor.from(clazz, method));
        request.setArgs(args);

        Response resp = invokeRemote(request);
        if (resp == null || resp.getCode() != 0) {
            throw new IllegalStateException("fail to invoke remote: " + resp);
        }

        return resp.getData();
    }

    private Response invokeRemote(Request request) {
        TransportClient client = null;
        Response resp = null;
        try {
            client = selector.select();

            byte[] outBytes = encoder.encode(request);

            InputStream receive = client.write(new ByteArrayInputStream(outBytes));

            byte[] inBytes = IOUtils.readFully(receive, receive.available());
            resp = decoder.decode(inBytes, Response.class);

        } catch (IOException e) {
            log.warn(e.getMessage(), e);
            resp = new Response();
            resp.setCode(1);
            resp.setMessage("RpcClient got error: "
                    + e.getClass()
                    + " : " + e.getMessage());
        } finally {
            if (client != null) {
                selector.release(client);
            }
        }
        return resp;
    }
}

















