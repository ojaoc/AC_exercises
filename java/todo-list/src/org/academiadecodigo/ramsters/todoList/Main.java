package org.academiadecodigo.ramsters.todoList;

import org.academiadecodigo.ramsters.todoList.list.TodoList;
import org.academiadecodigo.ramsters.todoList.priorityLevel.PriorityLevel;
import org.academiadecodigo.ramsters.todoList.task.Task;

import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {

        PriorityQueue<Task> list = new TodoList().getList();

        list.add(new Task("Feed the midlane", PriorityLevel.EXTREME, 0));
        list.add(new Task("Vote", PriorityLevel.LOW, 1));
        list.add(new Task("Wipe my ass", PriorityLevel.HIGH, 1));
        list.add(new Task("Study JavaScript", PriorityLevel.LOW, 0));
        list.add(new Task("Study Java", PriorityLevel.HIGH, 0));
        list.add(new Task("Go home", PriorityLevel.NORMAL, 0));


        /*for (int i = 0; i < list.size(); i++) {

            System.out.println(list.peek().getMessage());
        }*/


        while (list.peek() != null) {

            System.out.println(list.poll().getMessage());
            
        }

    }

}
