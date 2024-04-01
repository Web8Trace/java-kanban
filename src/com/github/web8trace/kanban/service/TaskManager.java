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
        if (epics.containsKey(subtask.getEpicId())) {
            Epic epic = epics.get(subtask.getEpicId());
            ArrayList<Subtask> newSubtasks = epic.getSubtasks();
            newSubtasks.add(subtask);
        }
    }

    public void addEpic(Epic epic) {
        epic.setId(id());
        epics.put(epic.getId(), epic);
    }

    public void deleteTasks() {
        tasks.clear();
    }

    public void deleteSubtasks() {
        for (Epic epic : epics.values()) {
            ArrayList<Subtask> newSubtasks = epic.getSubtasks();
            newSubtasks.clear();
        }
        subtasks.clear();
    }

    public void deleteEpics() {
        for (Epic epic : epics.values()) {
            ArrayList<Subtask> newSubtasks = epic.getSubtasks();
            newSubtasks.clear();
        }
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
        for (Epic epic : epics.values()) {
            for (Subtask newSubtask : epic.getSubtasks()) {
                epic.getSubtasks().remove(newSubtask);
                epic.getSubtasks().add(subtask);
                break;
            }
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
        for (Epic epic : epics.values()) {
            for (Subtask subtask : epic.getSubtasks()) {
                if (subtask.getId() == id) {
                    epic.getSubtasks().remove(subtask);
                    break;
                }
            }
        }
    }

    public void removeEpic(Integer id) {
        for (Epic epic : epics.values()) {
            if (epic.getId() == id) {
                epic.getSubtasks().clear();
            }
        }
        if (epics.containsKey(id)) {
            epics.remove(id);
        }
    }

    public Task getTask(Integer id) {
        return tasks.get(id);
    }

    public Subtask getSubtask(Integer id) {
        return subtasks.get(id);
    }

    public Epic getEpic(Integer id) {
        return epics.get(id);
    }

    public ArrayList<Task> getTasks() {
        ArrayList<Task> newTasks = new ArrayList<>();
        newTasks.addAll(tasks.values());
        return newTasks;
    }

    public ArrayList<Epic> getEpics() {
        ArrayList<Epic> newEpics = new ArrayList<>();
        newEpics.addAll(epics.values());
        return newEpics;
    }

    public ArrayList<Subtask> getSubtasks() {
        ArrayList<Subtask> newSubtasks = new ArrayList<>();
        newSubtasks.addAll(subtasks.values());
        return newSubtasks;
    }

    public ArrayList<Subtask> getSubtasksInEpic(Integer id) {
        if (epics.containsKey(id)) {
            return epics.get(id).getSubtasks();
        }
        return null;
    }

    private Integer id() {
        id++;
        return id;
    }
}