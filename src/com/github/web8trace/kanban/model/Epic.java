package com.github.web8trace.kanban.model;

import java.util.ArrayList;

public class Epic extends Task {

    private ArrayList<Subtask> subtasks = new ArrayList<>();

    public ArrayList<Subtask> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(ArrayList<Subtask> subtasks) {
        this.subtasks = subtasks;
    }

    @Override
    public String toString() {
        return "Epic{" +
                "name='" + getName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", status=" + getStatus() +
                " [subtasks=" + subtasks + ']' +
                '}';
    }
}
