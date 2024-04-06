package oah.project.impl;

import com.alibaba.fastjson.JSON;
import oah.project.Encoder;


/**
 *  基于json的序列化实现
 */
public class JSONEncoder implements Encoder {
    @Override
    public byte[] encode(Object obj) {
        return JSON.toJSONBytes(obj);
    }
}
