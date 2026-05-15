public class Base64Util {

    private static final String BASE64_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

    // Giải mã Base64
    public static String decode(String base64) {
        StringBuffer decoded = new StringBuffer();
        int[] buffer = new int[4];
        int index = 0;

        // Duyệt qua từng ký tự trong chuỗi Base64
        for (int i = 0; i < base64.length(); i++) {
            char c = base64.charAt(i);
            if (c == '=') break;  // Dừng lại nếu gặp dấu "=" (padding)

            int charIndex = BASE64_CHARS.indexOf(c);
            if (charIndex == -1) continue; // Bỏ qua ký tự không hợp lệ

            buffer[index++] = charIndex;

            // Khi có đủ 4 ký tự, chuyển đổi chúng thành byte
            if (index == 4) {
                decoded.append((char) ((buffer[0] << 2) | (buffer[1] >> 4)));
                decoded.append((char) ((buffer[1] << 4) | (buffer[2] >> 2)));
                decoded.append((char) ((buffer[2] << 6) | buffer[3]));
                index = 0;
            }
        }

        // Xử lý phần còn lại nếu không đủ 4 ký tự
        if (index > 1) {
            decoded.append((char) ((buffer[0] << 2) | (buffer[1] >> 4)));
        }
        if (index > 2) {
            decoded.append((char) ((buffer[1] << 4) | (buffer[2] >> 2)));
        }

        return decoded.toString();
    }
}
