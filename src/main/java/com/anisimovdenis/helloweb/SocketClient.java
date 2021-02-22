package com.anisimovdenis.helloweb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SocketClient {

    public static void main(String[] args) throws IOException {
        sendRequest("localhost", 8080, "GET");
        sendRequest("localhost", 8080, "POST");
    }

    public static void sendRequest(String host, int port, String method) throws IOException {
        Socket socket = new Socket(host, port);
        StringBuilder request = new StringBuilder();
        request.append(method).append(" ").append("/hello HTTP/1.1").append("\r\n");
        request.append("Host: ").append(host).append(":").append(port).append("\r\n");
        request.append("Accept: ").append("text/plain;charset=UTF-8").append("\r\n");
        request.append("Connection: ").append("close").append("\r\n");
        request.append("Content-type: ").append("text/plain;charset=UTF-8").append("\r\n");
        request.append("\r\n");

        socket.getOutputStream().write(request.toString().getBytes(StandardCharsets.UTF_8));
        socket.getOutputStream().flush();

        printRequest(socket.getInputStream());
    }

    public static void printRequest(InputStream input) throws IOException {
        System.out.println("---START PRINT---");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
            String data;
            while ((data = reader.readLine()) != null) {
                System.out.println(data);
            }
        }
        System.out.println("---FINISH PRINT---");
    }
}
