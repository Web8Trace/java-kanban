package com.github.web8trace.kanban.memory;

import com.github.web8trace.kanban.model.Epic;
import com.github.web8trace.kanban.model.Subtask;
import com.github.web8trace.kanban.model.Task;
import com.github.web8trace.kanban.model.TaskStatus;
import com.github.web8trace.kanban.service.HistoryManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryHistoryManagerTest {

    HistoryManager historyManager;
    private Task task;
    private Epic epic;
    private Subtask subtask;

    @BeforeEach
    void init() {
        historyManager = new InMemoryHistoryManager();
        task = new Task();
        task.setName("задача 1");
        task.setDescription("описание");
        task.setStatus(TaskStatus.NEW);
        epic = new Epic();
        epic.setName("задача 2");
        epic.setDescription("описание");
        epic.setStatus(TaskStatus.NEW);
        subtask = new Subtask();
        subtask.setName("задача 3");
        subtask.setDescription("описание");
        subtask.setStatus(TaskStatus.NEW);
        subtask.setEpicId(2);
    }

    @Test
    void add() {
        historyManager.add(task);
        List<Task> history = historyManager.getHistory();
        assertNotNull(history);
        assertEquals(1, history.size());
    }

    @Test
    void getHistory() {
        List<Task> history = historyManager.getHistory();
        assertNotNull(history);
        assertTrue(history.isEmpty());
    }
}