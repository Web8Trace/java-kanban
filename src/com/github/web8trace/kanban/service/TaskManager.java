package com.github.web8trace.kanban.service;

import com.github.web8trace.kanban.model.Epic;
import com.github.web8trace.kanban.model.Subtask;
import com.github.web8trace.kanban.model.Task;

import java.util.ArrayList;

public interface TaskManager {

    public void addTask(Task task);

    public void addSubtask(Subtask subtask);

    public void addEpic(Epic epic);

    public void deleteTasks();

    public void deleteSubtasks();

    public void deleteEpics();

    public void updateTask(Task task);

    public void updateSubtask(Subtask subtask);

    public void updateEpic(Epic epic);

    public void removeTask(Integer id);

    public void removeSubtask(Integer id);

    public void removeEpic(Integer id);

    public Task getTask(Integer id);

    public Subtask getSubtask(Integer id);

    public Epic getEpic(Integer id);

    public ArrayList<Task> getTasks();

    public ArrayList<Epic> getEpics();

    public ArrayList<Subtask> getSubtasks();

    public ArrayList<Subtask> getSubtasksInEpic(Integer id);
}
