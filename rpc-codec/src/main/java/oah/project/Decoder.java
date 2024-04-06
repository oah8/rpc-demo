package oah.project;

public interface Decoder {
    <T> T decode(byte[] bytes, Class<T> clazz);
}
