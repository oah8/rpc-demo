package oah.project;

import lombok.Data;
import oah.project.impl.HTTPTransportClient;
import oah.project.impl.JSONDecoder;
import oah.project.impl.JSONEncoder;
import oah.project.impl.RandomTransportSelector;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName RpcClientConfig
 * @Description TODO
 * @Author _oah
 * @Date 2024.04.04 13:34
 * @Version 1.0
 */
@Data
public class RpcClientConfig {
    private Class<? extends TransportClient> transportClass = HTTPTransportClient.class;

    private Class<? extends Encoder> encoderClass = JSONEncoder.class;

    private Class<? extends Decoder> decoderClass = JSONDecoder.class;

    private Class<? extends TransportSelector> selectorClass = RandomTransportSelector.class;

    private int connectCount = 1;

    private List<Peer> servers = Collections.singletonList(new Peer("127.0.0.1", 3000));

}















