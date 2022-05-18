package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TodoServer {
    int port = 8089;
    Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        System.out.println("Starting server at " + port + "...");
        ServerSocket server = new ServerSocket(port);

        while (true) {
            try (Socket client = server.accept();
                 PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));) {

                System.out.printf("New connection accepted\n");
                final String connamd = in.readLine();

                //Gson gson = new Gson();
                //todos = gson.fromJson(connamd, Todos.class);
                final JsonParser parser = new JsonParser();
                final JsonElement element = parser.parse(connamd);
                final JsonObject jsonObject = element.getAsJsonObject();
                final String type = jsonObject.get("type").getAsString();
                final String task = jsonObject.get("task").getAsString();


                if (type.equals("ADD")){
                    todos.addTask(task);
                } else if (type.equals("REMOVE")) {
                    todos.removeTask(task);
                }
                out.println(todos.getAllTasks());


            } catch (IOException e) {
                e.printStackTrace();
            }
        }





    }
}
