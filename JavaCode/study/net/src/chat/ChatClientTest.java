package chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * ClassName: ChatClient
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author cherry
 * @Create 2023/7/28 10:35
 * @Version 1.0
 */
class Send extends Thread{
    private Socket socket;

    public Send(Socket socket) {
        super();
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            Scanner input = new Scanner(System.in);
            OutputStream outputStream = socket.getOutputStream();
            //按行打印
            PrintStream ps = new PrintStream(outputStream);

            while (true){
                System.out.print("自己的话：");
                String str = input.nextLine();
                if ("bye".equals(str)){
                    break;
                }
                ps.println(str);
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Receive extends Thread{
    private Socket socket;

    public Receive(Socket socket) {
        super();
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class ChatClientTest {
    public static void main(String[] args) throws Exception{
        Socket socket = new Socket("127.0.0.1",8989);

        Receive receive = new Receive(socket);
        receive.start();

        Send send = new Send(socket);
        send.start();

        send.join();
        socket.close();
    }
}
