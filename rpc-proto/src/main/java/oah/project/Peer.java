package oah.project;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName Peer
 * @Description TODO 表示网路传输的一个端点
 * @Author _oah
 * @Date 2024.04.03 19:51
 * @Version 1.0
 */
@Data
@AllArgsConstructor
public class Peer {
	private String host;
	private int port;
}
