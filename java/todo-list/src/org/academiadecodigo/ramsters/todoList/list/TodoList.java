package org.academiadecodigo.ramsters.todoList.list;

import org.academiadecodigo.ramsters.todoList.task.Task;

import java.util.PriorityQueue;

public class TodoList {

    private PriorityQueue<Task> list;

    public TodoList() {

        this.list = new PriorityQueue<>();

    }

    public PriorityQueue<Task> getList() {

        return list;

    }

}
