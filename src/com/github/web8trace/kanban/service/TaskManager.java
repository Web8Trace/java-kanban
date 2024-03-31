package com.github.web8trace.kanban.service;

import com.github.web8trace.kanban.model.Epic;
import com.github.web8trace.kanban.model.Subtask;
import com.github.web8trace.kanban.model.Task;

import java.util.ArrayList;
import java.util.HashMap;

public class TaskManager {

    private static int id = 0;
    private HashMap<Integer, Task> tasks = new HashMap<>();
    private HashMap<Integer, Epic> epics = new HashMap<>();
    private HashMap<Integer, Subtask> subtasks = new HashMap<>();

    public void addTask(Task task) {
        task.setId(id());
        tasks.put(task.getId(), task);
    }

    public void addSubtask(Subtask subtask) {
        subtask.setId(id());
        subtasks.put(subtask.getId(), subtask);
    }

    public void addEpic(Epic epic) {
        epic.setId(id());
        epics.put(epic.getId(), epic);
    }

    public void deleteTasks() {
        tasks.clear();
    }

    public void deleteSubtasks() {
        subtasks.clear();
    }

    public void deleteEpics() {
        epics.clear();
    }

    public void updateTask(Task task) {
        if (tasks.containsKey(task.getId())) {
            tasks.put(task.getId(), task);
        }
    }

    public void updateSubtask(Subtask subtask) {
        if (subtasks.containsKey(subtask.getId())) {
            subtasks.put(subtask.getId(), subtask);
        }
    }

    public void updateEpic(Epic epic) {
        if (epics.containsKey(epic.getId())) {
            epics.put(epic.getId(), epic);
        }
    }

    public void removeTask(Integer id) {
        if (tasks.containsKey(id)) {
            tasks.remove(id);
        }
    }

    public void removeSubtask(Integer id) {
        if (subtasks.containsKey(id)) {
            subtasks.remove(id);
        }
    }

    public void removeEpic(Integer id) {
        if (epics.containsKey(id)) {
            epics.remove(id);
        }
    }

    public Task getTask(Integer id) {
        Task task = null;
        if (tasks.containsKey(id)) {
            task = tasks.get(id);
        }
        return task;
    }

    public Subtask getSubtask(Integer id) {
        Subtask subtask = null;
        if (subtasks.containsKey(id)) {
            subtask = subtasks.get(id);
        }
        return subtask;
    }

    public Epic getEpic(Integer id) {
        Epic epic = null;
        if (epics.containsKey(id)) {
            epic = epics.get(id);
        }
        return epic;
    }

    public HashMap<Integer, Task> getTasks() {
        return tasks;
    }

    public HashMap<Integer, Epic> getEpics() {
        return epics;
    }

    public HashMap<Integer, Subtask> getSubtasks() {
        return subtasks;
    }

    public ArrayList<Subtask> getSubtasksInEpic(Epic epic) {
        return epic.getSubtasks();
    }

    @Override
    public String toString() {
        return "TaskManager{" +
                "id=" + id() +
                ", task=" + tasks +
                ", epic=" + epics +
                ", subtask=" + subtasks +
                '}';
    }

    private Integer id() {
        id++;
        return id;
    }
}