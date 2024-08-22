package com.github.web8trace.kanban.service;

import com.github.web8trace.kanban.memory.InMemoryHistoryManager;
import com.github.web8trace.kanban.memory.InMemoryTaskManager;

public class Managers {

    public static TaskManager getDefault(){
        HistoryManager historyManager = getDefaultHistoryManager();
        return new InMemoryTaskManager(historyManager);
    }

    private static HistoryManager getDefaultHistoryManager(){
        return new InMemoryHistoryManager();
    }
}
