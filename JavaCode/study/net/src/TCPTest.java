import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ClassName: TCPTest
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author cherry
 * @Create 2023/7/28 8:59
 * @Version 1.0
 */
public class TCPTest {
    @Test
    public void test1(){
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            int port = 8989;
            InetAddress localHost = InetAddress.getLocalHost();
            socket = new Socket(localHost, port);
            System.out.println("客户端已开启。。。。。。");
            outputStream = socket.getOutputStream();
            outputStream.write("hello,cherry!".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2(){
        int port = 8989;
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream inputStream = null;
        String str = "";
//        OutputStream outputStream = null;
        try {
            serverSocket = new ServerSocket(port);
            socket = serverSocket.accept();
            System.out.println("服务器已开启。。。。。。");
            System.out.println("收到了来自" + socket.getInetAddress() + "的连接");
            inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            ByteOutputStream baos = new ByteOutputStream();
            while ((len =inputStream.read(bytes)) != -1){
                baos.write(bytes,0,len);
//                可能产生乱码
//                str = new String(bytes,0,len);
//                System.out.println(str);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
