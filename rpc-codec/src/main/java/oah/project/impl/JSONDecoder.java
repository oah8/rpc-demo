package oah.project.impl;

import com.alibaba.fastjson.JSON;
import oah.project.Decoder;


/**
 * 基于json的反序列化实现
 */
public class JSONDecoder implements Decoder {
    @Override
    public <T> T decode(byte[] bytes, Class<T> clazz) {
        return JSON.parseObject(bytes, clazz);
    }
}
