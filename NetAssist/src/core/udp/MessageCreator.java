package core.udp;

/**
 * 用于构建-消息
 */
public class MessageCreator {
    private static final String SN_HEADER = "收到Message，我是（SN）:";
    private static final String PORT_HEADER = "这是Message，请回电端口（Port）:";

    /**
     * 构建带上端口号的消息体
     * @param port
     * @return
     */
    public static String buildWithPort(int port) {
        return PORT_HEADER + port;
    }

    /**
     * 解析端口号
     * @param data
     * @return
     */
    public static int parsePort(String data) {
        if (data.startsWith(PORT_HEADER)) {
            return Integer.parseInt(data.substring(PORT_HEADER.length()));
        }

        return -1;
    }

    /**
     * 构建带上sn的消息体
     * @param sn
     * @return
     */
    public static String buildWithSn(String sn) {
        return SN_HEADER + sn;
    }

    /**
     * 解析sn
     * @param data
     * @return
     */
    public static String parseSn(String data) {
        if (data.startsWith(SN_HEADER)) {
            return data.substring(SN_HEADER.length());
        }
        return null;
    }

}

