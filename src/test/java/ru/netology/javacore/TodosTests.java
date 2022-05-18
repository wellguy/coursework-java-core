package ru.netology.javacore;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.Queue;
import java.util.stream.Stream;

public class TodosTests {

    Todos sut;

    @BeforeEach
    public void init() {
        sut = new Todos();
    }

    @BeforeAll
    public static void start() {
        System.out.println("Start tests");
    }

    @AfterAll
    public static void finish() {
        System.out.printf("Tests finished");
    }

    @Test
    public void addTaskTestVerify() {
        Todos todos = Mockito.spy(Todos.class);
        todos.addTask("123");
        Mockito.verify(todos).addTask("123");

    }

    @Test
    public void removeTaskVerify() {
        Todos todos = Mockito.spy(Todos.class);
        todos.removeTask("123");
        Mockito.verify(todos).removeTask("123");

    }

    @Test
    public void getAllTasksTest() {
        //given
        String task1 = "Кальян";
        String task2 = "Арбуз";
        String task3 = "Яблоко";
        String expected = "Арбуз Кальян Яблоко ";

        //when
        sut.addTask(task1);
        sut.addTask(task2);
        sut.addTask(task3);
        String result = sut.getAllTasks();


        //then
        Assertions.assertEquals(expected, result);
    }

}
