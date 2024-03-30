package com.github.web8trace.kanban.service;

import com.github.web8trace.kanban.model.Epic;
import com.github.web8trace.kanban.model.Subtask;
import com.github.web8trace.kanban.model.Task;
import com.github.web8trace.kanban.model.TaskStatus;

import java.util.ArrayList;
import java.util.HashMap;

public class TaskManager {

    private static int id = 0;
    private HashMap<Integer, Task> tasks = new HashMap<>();
    private HashMap<Integer, Epic> epics = new HashMap<>();
    private HashMap<Integer, Subtask> subtasks = new HashMap<>();

    public HashMap<Integer, Task> addTask(Task task) {
        task.setId(id());
        tasks.put(task.getId(), task);
        return tasks;
    }

    public HashMap<Integer, Subtask> addTask(Subtask subtask) {
        subtask.setId(id());
        subtasks.put(subtask.getId(), subtask);
        return subtasks;
    }

    public HashMap<Integer, Epic> addTask(Epic epic) {
        epic.setId(id());
        epics.put(epic.getId(), epic);
        return epics;
    }

    public void statusTaskDone(Integer id) {
        if (tasks.containsKey(id)) {
            Task t = tasks.get(id);
            t.setStatus(TaskStatus.DONE);
        }
        if (subtasks.containsKey(id)) {
            Subtask s = subtasks.get(id);
            s.setStatus(TaskStatus.DONE);
        }

        for (Epic s : epics.values()) {
            int areAllSubtasksDone = 0;
            for (int i = 0; i < s.getSubtasks().size(); i++) {
                if (s.getSubtasks().get(i).getStatus() == TaskStatus.DONE) {
                    areAllSubtasksDone++;
                }
            }
            if (areAllSubtasksDone == s.getSubtasks().size()) {
                s.setStatus(TaskStatus.DONE);
            }
        }
    }

    public HashMap<Integer, Task> deleteTask() {
        tasks.clear();
        return tasks;
    }

    public HashMap<Integer, Subtask> deleteSubtask() {
        subtasks.clear();
        return subtasks;
    }

    public HashMap<Integer, Epic> deleteEpic() {
        epics.clear();
        return epics;
    }

    public HashMap<Integer, Task> updateTask(Task task) {
        if (tasks.containsKey(task.getId())) {
            tasks.put(task.getId(), task);
        }
        return tasks;
    }

    public HashMap<Integer, Subtask> updateTask(Subtask subtask) {
        if (subtasks.containsKey(subtask.getId())) {
            subtasks.put(subtask.getId(), subtask);
        }
        return subtasks;
    }

    public HashMap<Integer, Epic> updateTask(Epic epic) {
        if (epics.containsKey(epic.getId())) {
            epics.put(epic.getId(), epic);
        }
        return epics;
    }

    public HashMap<Integer, Task> removeTask(Integer id) {
        if (tasks.containsKey(id)) {
            tasks.remove(id);
        }
        return tasks;
    }

    public HashMap<Integer, Subtask> removeSubtask(Integer id) {
        if (subtasks.containsKey(id)) {
            subtasks.remove(id);
        }
        return subtasks;
    }

    public HashMap<Integer, Epic> removeEpic(Integer id) {
        if (epics.containsKey(id)) {
            epics.remove(id);
        }
        return epics;
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

    public ArrayList<Subtask> getSubtasksInEic(Epic epic){
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