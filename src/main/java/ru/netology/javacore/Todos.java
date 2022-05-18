package ru.netology.javacore;

import java.util.*;

public class Todos {
    private Queue<String> taskList = new PriorityQueue<>();

    public void addTask(String task) {
        if (!taskList.contains(task)) {
            taskList.offer(task);
            System.out.println("Задача " + "\"" + task + "\"" + " добавлена");
        } else {
            System.out.println("Задача " + "\"" + task + "\"" + " уже была ранее добавлена");
        }
    }

    public void removeTask(String task) {
        if (taskList.contains(task)) {
            taskList.remove(task);
            System.out.println("Задача " + task + " удалена");
        } else {
            System.out.println("Задача " + task + " не найдена в списке");
        }
    }

    public String getAllTasks() {
        StringBuilder sb = new StringBuilder();
        String[] array = new String[taskList.size()];
        taskList.toArray(array);
        Arrays.sort(array);
        for (String task : array) {
            sb.append(task + " ");
        }
        return sb.toString();
    }
}
