package chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: ChatServerTest
 * Package: chat
 * Description:
 *
 * @Author cherry
 * @Create 2023/7/28 10:46
 * @Version 1.0
 */
public class ChatServerTest {
    static List<Socket> online = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8989);

        while (true){
            Socket accept = server.accept();
            online.add(accept);     //建立连接的用户添加到在线表中
            //获取当前的socket中的数据并分发给其他socket
            Messagehandler messagehandler = new Messagehandler(accept);
            messagehandler.start();
        }

    }

    static class Messagehandler extends Thread{
        private String ip;
        private Socket socket;

        public Messagehandler(Socket socket) {
            super();
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                ip = socket.getInetAddress().getHostAddress();
                sendToOther(ip + "上线了");
                InputStream inputStream = socket.getInputStream();
                InputStreamReader reader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(reader);

                String str;
                while ((str = bufferedReader.readLine()) != null){
                    sendToOther(ip + ":" +str);
                }

                sendToOther(ip + "下线了");
            } catch (Exception e) {
                try {
                    sendToOther(ip + "掉线了");
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }finally {
                online.remove(socket);
            }

        }

        private void sendToOther(String message) throws Exception{
            for (Socket on : online){
                OutputStream every = on.getOutputStream();
                PrintStream ps = new PrintStream(every);
                ps.println(message);
            }
        }
    }
}
