import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress localhost = InetAddress.getByName("localhost");
            System.out.println(InetAddress.getLocalHost());
            System.out.println(localhost.getHostName());
            System.out.println(localhost.getHostAddress());
            System.out.println(localhost);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}

