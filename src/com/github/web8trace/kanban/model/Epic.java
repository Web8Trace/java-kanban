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
    public TaskStatus getStatus() {
        TaskStatus epicStatus = TaskStatus.IN_PROGRESS;
        int areAllSubtasksNew = 0;
        int areAllSubtasksDone = -1;
        for (int i = 0; i < subtasks.size(); i++) {
            if (subtasks.get(i).getStatus() == TaskStatus.NEW) {
                areAllSubtasksNew++;
            }
            if (subtasks.get(i).getStatus() == TaskStatus.DONE) {
                areAllSubtasksDone++;
            }
        }
        if (areAllSubtasksNew == subtasks.size() || subtasks.size() == 0) {
            epicStatus = TaskStatus.NEW;
        }
        if (areAllSubtasksDone == subtasks.size() - 1) {
            epicStatus = TaskStatus.DONE;
        }
        return epicStatus;
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
