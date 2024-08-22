package com.github.web8trace.kanban.memory;

import com.github.web8trace.kanban.model.Epic;
import com.github.web8trace.kanban.model.Subtask;
import com.github.web8trace.kanban.model.Task;
import com.github.web8trace.kanban.service.HistoryManager;
import com.github.web8trace.kanban.service.TaskManager;

import java.util.ArrayList;
import java.util.HashMap;

public class InMemoryTaskManager implements TaskManager {

    private static int id = 0;
    private HashMap<Integer, Task> tasks = new HashMap<>();
    private HashMap<Integer, Epic> epics = new HashMap<>();
    private HashMap<Integer, Subtask> subtasks = new HashMap<>();
    private HistoryManager historyManager;

    public InMemoryTaskManager(HistoryManager historyManager) {
        this.historyManager = historyManager;
    }

    @Override
    public void addTask(Task task) {
        task.setId(id());
        tasks.put(task.getId(), task);
    }

    @Override
    public void addSubtask(Subtask subtask) {
        subtask.setId(id());
        subtasks.put(subtask.getId(), subtask);
        if (epics.containsKey(subtask.getEpicId())) {
            Epic epic = epics.get(subtask.getEpicId());
            ArrayList<Subtask> newSubtasks = epic.getSubtasks();
            newSubtasks.add(subtask);
        }
    }

    @Override
    public void addEpic(Epic epic) {
        epic.setId(id());
        epics.put(epic.getId(), epic);
    }

    @Override
    public void deleteTasks() {
        tasks.clear();
    }

    @Override
    public void deleteSubtasks() {
        for (Epic epic : epics.values()) {
            ArrayList<Subtask> newSubtasks = epic.getSubtasks();
            newSubtasks.clear();
        }
        subtasks.clear();
    }

    @Override
    public void deleteEpics() {
        for (Epic epic : epics.values()) {
            ArrayList<Subtask> newSubtasks = epic.getSubtasks();
            newSubtasks.clear();
        }
        epics.clear();
    }

    @Override
    public void updateTask(Task task) {
        if (tasks.containsKey(task.getId())) {
            tasks.put(task.getId(), task);
        }
    }

    @Override
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

    @Override
    public void updateEpic(Epic epic) {
        if (epics.containsKey(epic.getId())) {
            epics.put(epic.getId(), epic);
        }
    }

    @Override
    public void removeTask(Integer id) {
        if (tasks.containsKey(id)) {
            tasks.remove(id);
        }
    }

    @Override
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

    @Override
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

    @Override
    public Task getTask(Integer id) {
        historyManager.add(tasks.get(id));
        return tasks.get(id);
    }

    @Override
    public Subtask getSubtask(Integer id) {
        historyManager.add(subtasks.get(id));
        return subtasks.get(id);
    }

    @Override
    public Epic getEpic(Integer id) {
        historyManager.add(epics.get(id));
        return epics.get(id);
    }

    @Override
    public ArrayList<Task> getTasks() {
        ArrayList<Task> newTasks = new ArrayList<>();
        newTasks.addAll(tasks.values());
        return newTasks;
    }

    @Override
    public ArrayList<Epic> getEpics() {
        ArrayList<Epic> newEpics = new ArrayList<>();
        newEpics.addAll(epics.values());
        return newEpics;
    }

    @Override
    public ArrayList<Subtask> getSubtasks() {
        ArrayList<Subtask> newSubtasks = new ArrayList<>();
        newSubtasks.addAll(subtasks.values());
        return newSubtasks;
    }

    @Override
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