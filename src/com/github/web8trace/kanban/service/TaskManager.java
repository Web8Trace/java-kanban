package com.github.web8trace.kanban.service;

import com.github.web8trace.kanban.model.Epic;
import com.github.web8trace.kanban.model.Subtask;
import com.github.web8trace.kanban.model.Task;

import java.util.ArrayList;
import java.util.HashMap;

public class TaskManager {

    private static int id = 0;
    HashMap<Integer, Task> tasks = new HashMap<>();
    HashMap<Integer, Epic> epics = new HashMap<>();
    HashMap<Integer, Subtask> subtasks = new HashMap<>();

    private Integer id() {
        id++;
        return id;
    }

    public HashMap<Integer, Task> addNewTask(Task t) {
        t.setId(id());
        tasks.put(t.getId(), t);
        t.setStatus(TaskStatus.IN_PROGRESS);
        return tasks;
    }

    public HashMap<Integer, Subtask> addNewTask(Subtask s) {
        s.setId(id());
        subtasks.put(s.getId(), s);
        s.setStatus(TaskStatus.IN_PROGRESS);
        return subtasks;
    }

    public HashMap<Integer, Epic> addNewTask(Epic e) {
        e.setId(id());
        epics.put(e.getId(), e);
        e.setStatus(TaskStatus.IN_PROGRESS);
        return epics;
    }

    public HashMap<Integer, Epic> addSubtaskInEpic(Epic e, Subtask s) {
        ArrayList<Subtask> list = e.getSubtasks();
        list.add(s);
        e.setStatus(TaskStatus.IN_PROGRESS);
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

    public HashMap<Integer, ? extends Task> print(String type) {
        if (type.equals("Subtask")) {
            return subtasks;
        }
        if (type.equals("Epic")) {
            return epics;
        }
        return tasks;
    }

    public void deleteAllTask() {
        tasks.clear();
        subtasks.clear();
        epics.clear();
    }

    public HashMap<Integer, Task> updateTask(Task t) {
        if (tasks.containsKey(t.getId())) {
            tasks.put(t.getId(), t);
        }
        return tasks;
    }

    public HashMap<Integer, Subtask> updateTask(Subtask s) {
        if (subtasks.containsKey(s.getId())) {
            subtasks.put(s.getId(), s);
        }
        return subtasks;
    }

    public HashMap<Integer, Epic> updateTask(Epic e) {
        if (epics.containsKey(e.getId())) {
            epics.put(e.getId(), e);
        }
        return epics;
    }

    public void removeTask(Integer id) {
        if (tasks.containsKey(id)) {
            tasks.remove(id);
        }
        if (subtasks.containsKey(id))
            subtasks.remove(id);
        if (epics.containsKey(id)) {
            epics.remove(id);
        }
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
}