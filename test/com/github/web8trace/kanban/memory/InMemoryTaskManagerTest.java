package com.github.web8trace.kanban.memory;

import com.github.web8trace.kanban.model.Epic;
import com.github.web8trace.kanban.model.Subtask;
import com.github.web8trace.kanban.model.Task;
import com.github.web8trace.kanban.model.TaskStatus;
import com.github.web8trace.kanban.service.HistoryManager;
import com.github.web8trace.kanban.service.Managers;
import com.github.web8trace.kanban.service.TaskManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class InMemoryTaskManagerTest {

    private TaskManager taskManager;

    @BeforeEach
    void init() {
        taskManager = Managers.getDefault();
    }

    @Test
    void addTaskShouldSaveTask() {
        Task task1 = new Task();
        task1.setName("задача 1");
        task1.setDescription("простая задачка");
        task1.setStatus(TaskStatus.NEW);

        taskManager.addTask(task1);
        task1.setId(1);


        Task task2 = new Task();
        task2.setName("задача 2");
        task2.setDescription("простая задачка");
        task2.setStatus(TaskStatus.NEW);

        taskManager.addTask(task2);
        task2.setId(1);

        assertNotNull(task1);
        assertNotNull(task1.getId());
        assertNotNull(task2);
        assertNotNull(task2.getId());
        assertEquals(task1, task2);

    }

    @Test
    void addSubtaskShouldSaveSubtask() {
        Subtask subtask1 = new Subtask();
        subtask1.setName("задача 3");
        subtask1.setDescription("простая задачка");
        subtask1.setStatus(TaskStatus.NEW);

        taskManager.addSubtask(subtask1);
        subtask1.setId(1);


        Subtask subtask2 = new Subtask();
        subtask2.setName("задача 4");
        subtask2.setDescription("простая задачка");
        subtask2.setStatus(TaskStatus.NEW);

        taskManager.addSubtask(subtask2);
        subtask2.setId(1);

        assertNotNull(subtask1);
        assertNotNull(subtask1.getId());
        assertNotNull(subtask2);
        assertNotNull(subtask2.getId());
        assertEquals(subtask1, subtask2);
    }

    @Test
    void addEpicShouldSaveEpic() {
        Epic epic1 = new Epic();
        epic1.setName("задача 5");
        epic1.setDescription("простая задачка");
        epic1.setStatus(TaskStatus.NEW);

        taskManager.addEpic(epic1);
        epic1.setId(10);

        Epic epic2 = new Epic();
        epic2.setName("задача 6");
        epic2.setDescription("простая задачка");
        epic2.setStatus(TaskStatus.NEW);

        taskManager.addEpic(epic2);
        epic2.setId(10);

        assertNotNull(epic1);
        assertNotNull(epic1.getId());
        assertNotNull(epic2);
        assertNotNull(epic2.getId());
        assertEquals(epic1, epic2);
    }

    @Test
    void managersCreatedObjects() {
        assertNotNull(taskManager);
    }

    @Test
    void mangersCreatedTask() {
        Task task1 = new Task();
        task1.setName("задача 1");
        task1.setDescription("простая задачка");
        task1.setStatus(TaskStatus.NEW);
        taskManager.addTask(task1);
        task1.setId(10);

        Task expectedTask = new Task();
        expectedTask.setId(10);

        assertEquals(expectedTask, task1);
        assertEquals(10, task1.getId());
    }

    @Test
    void mangersCreatedEpic() {
        Epic epic1 = new Epic();
        epic1.setName("задача 1");
        epic1.setDescription("простая задачка");
        epic1.setStatus(TaskStatus.NEW);
        taskManager.addEpic(epic1);
        epic1.setId(10);

        Epic expectedEpic = new Epic();
        expectedEpic.setId(10);

        assertEquals(expectedEpic, epic1);
        assertEquals(10, epic1.getId());
    }

    @Test
    void mangersCreatedSubtask() {
        Subtask subtask1 = new Subtask();
        subtask1.setName("задача 1");
        subtask1.setDescription("простая задачка");
        subtask1.setStatus(TaskStatus.NEW);
        taskManager.addSubtask(subtask1);
        subtask1.setId(10);

        Subtask expectedSubtask = new Subtask();
        expectedSubtask.setId(10);

        assertEquals(expectedSubtask, subtask1);
        assertEquals(10, subtask1.getId());
    }

    @Test
    void idNotConflict() {
        Task task1 = new Task();
        task1.setName("задача 1");
        task1.setDescription("простая задачка");
        task1.setStatus(TaskStatus.NEW);
        taskManager.addTask(task1);

        Task expectedTask = new Task();
        expectedTask.setId(task1.getId());
        assertEquals(expectedTask.getId(), task1.getId());
    }
}