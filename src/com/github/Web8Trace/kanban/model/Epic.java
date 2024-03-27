package com.github.Web8Trace.kanban.model;

import java.util.ArrayList;

public class Epic extends Task {

    private ArrayList<Subtask> subtasks;

    public Epic(String name, String description) {
        super(name, description);
        this.subtasks = new ArrayList<>();
    }

    public ArrayList<Subtask> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(ArrayList<Subtask> subtasks) {
        this.subtasks = subtasks;
    }

    @Override
    public String toString() {
        return "Epic{" +
                "subtasks=" + subtasks +
                '}';
    }
}
