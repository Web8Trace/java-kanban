package com.github.web8trace.kanban.memory;

import com.github.web8trace.kanban.model.Task;
import com.github.web8trace.kanban.service.HistoryManager;

import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {

    private List<Task> history = new ArrayList<>();

    @Override
    public void add(Task task) {
        if (history.size() == 10){
            history.remove(0);
        }
        history.add(task);
    }

    @Override
    public List<Task> getHistory() {
        ArrayList<Task> historyCopy = new ArrayList<>(history);
        return historyCopy;
    }
}
