package org.academiadecodigo.ramsters.todoList.task;

import org.academiadecodigo.ramsters.todoList.priorityLevel.PriorityLevel;

public class Task implements Comparable<Task> {

    private PriorityLevel priority;

    private int urgency;

    private String message;

    public Task(String message, PriorityLevel priority, int urgency) {

        this.message = message;

        this.urgency = urgency;

        this.priority = priority;

    }

    public String getMessage() {

        return message;

    }

    public int getUrgency() {

        return urgency;

    }

    public PriorityLevel getPriority() {

        return priority;

    }

    @Override
    public int compareTo(Task next) {

        if (priority.getLevel() == next.getPriority().getLevel()) {

            return urgency > next.getUrgency() ? 1 : -1;

        }

        return priority.getLevel() > next.getPriority().getLevel() ? 1 : -1;

    }

}
