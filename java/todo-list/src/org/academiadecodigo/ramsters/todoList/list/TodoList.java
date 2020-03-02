package org.academiadecodigo.ramsters.todoList.list;

import org.academiadecodigo.ramsters.todoList.task.Task;

import java.util.Iterator;
import java.util.PriorityQueue;

public class TodoList implements Iterable<Task> {

    private PriorityQueue<Task> list;

    public TodoList() {

        this.list = new PriorityQueue<>();

    }

    public void add(Task task) {

        list.add(task);

    }

    @Override
    public Iterator<Task> iterator() {

        return list.iterator();

    }

}
