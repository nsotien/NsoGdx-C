package javax.wireless.messaging;

public interface TextMessage {
    void setPayloadText(String text);
    String getPayloadText();
    void setAddress(String address);
    String getAddress();
}
