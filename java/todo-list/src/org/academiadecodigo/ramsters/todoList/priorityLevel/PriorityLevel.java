package org.academiadecodigo.ramsters.todoList.priorityLevel;

public enum PriorityLevel {

    EXTREME(4),
    HIGH(3),
    NORMAL(2),
    LOW(1);

    private int level;

    PriorityLevel(int level) {

        this.level = level;

    }

    public int getLevel() {

        return level;

    }

}
