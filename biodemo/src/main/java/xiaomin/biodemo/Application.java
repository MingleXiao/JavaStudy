package xiaomin.biodemo;


import com.fasterxml.jackson.core.util.BufferRecycler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

@SpringBootApplication
public class Application {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(8080);
        try {

            System.out.println("server ready......");
            while (true) {
                Socket socket = serverSocket.accept();
                BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line = is.readLine();
                String result="";
                while (line!=null && line.length()>0)
                {
                    result=result+line;
                    line = is.readLine();
                }
                System.out.println("接收请求：" + result);
                socket.close();
            }

        } catch (IOException e) {
            serverSocket.close();
            e.printStackTrace();
        }


    }
}

