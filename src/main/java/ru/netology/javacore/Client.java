package ru.netology.javacore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Random;

public class Client {
    public static char pickRandomChar() {

        String chars = "ABCDEFG";
        return chars.charAt(new Random().nextInt(chars.length()));
    }

    //свой метод случайной задачи
    public static String randomTask() {
        String[] tasks = new String[]{
                "Бегать",
                "Плавать",
                "Завтракать",
                "Хулиганить",
                "Ябедничать",
                "Атаковать"
        };
        Random random = new Random();
        int index = random.nextInt(tasks.length);
        return tasks[index];
    }

    public static void main(String[] args) throws IOException {
        try (
                Socket socket = new Socket("localhost", 8989);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        ) {
            out.println("{ \"type\": \"ADD\", \"task\": \"" + randomTask() + "\" }");
            //out.println("{ \"type\": \"ADD\", \"task\": \"task #" + pickRandomChar() + "\" }");
            System.out.println(in.readLine());
        }
    }
}
