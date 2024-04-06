package oah.project;

/**
 * @ClassName RpcServerConfig
 * @Description TODO
 * @Author _oah
 * @Date 2024.04.04 11:27
 * @Version 1.0
 */

import lombok.Data;
import oah.project.impl.HttpTransportServer;
import oah.project.impl.JSONDecoder;
import oah.project.impl.JSONEncoder;

/**
 * server配置
 */
@Data
public class RpcServerConfig {

	private Class<? extends TransportServer> transportClass = HttpTransportServer.class;
	private Class<? extends Encoder> encoderClass = JSONEncoder.class;
	private Class<? extends Decoder> decoderClass = JSONDecoder.class;
	private int port = 3000;


}
