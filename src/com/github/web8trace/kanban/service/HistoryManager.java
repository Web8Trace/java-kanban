package com.github.web8trace.kanban.service;

import com.github.web8trace.kanban.model.Task;

import java.util.List;

public interface HistoryManager {

    void add(Task task);

    List<Task> getHistory();

}
