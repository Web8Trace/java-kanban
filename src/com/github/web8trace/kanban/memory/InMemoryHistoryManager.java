package com.github.web8trace.kanban.memory;

import com.github.web8trace.kanban.model.Task;
import com.github.web8trace.kanban.service.HistoryManager;
import com.github.web8trace.kanban.service.Node;

import java.util.*;

public class InMemoryHistoryManager implements HistoryManager {
    private Node head;
    private Node tail;
    private int size = 0;

    private List<Task> history = new LinkedList<>();

    private Map<Integer, Node> history1 = new HashMap<>();

    @Override
    public void add(Task task) {
        if (history.size() == 10){
            history.remove(0);
        }
        history.add(task);
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Task> getHistory() {
        ArrayList<Task> historyCopy = new ArrayList<>(history);
        return historyCopy;
    }
}
