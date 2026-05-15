package javax.wireless.messaging;

public interface MessageConnection {
    TextMessage newMessage(String type);
    void send(Object message) throws Exception;
    void close() throws Exception;
    public static final String TEXT_MESSAGE = "text";
}
