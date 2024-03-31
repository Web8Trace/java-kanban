package com.github.web8trace.kanban;

import com.github.web8trace.kanban.model.Epic;
import com.github.web8trace.kanban.model.Subtask;
import com.github.web8trace.kanban.model.Task;
import com.github.web8trace.kanban.model.TaskStatus;
import com.github.web8trace.kanban.service.TaskManager;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        Epic e1 = new Epic();
        e1.setName("ep1");
        e1.setDescription("des3");
        taskManager.addEpic(e1);
        System.out.println(taskManager.getEpic(1));
        System.out.println(e1.getSubtasks().size());
        Subtask s1 = new Subtask();
        s1.setName("sub1");
        s1.setDescription("des4");
        s1.setStatus(TaskStatus.IN_PROGRESS);
        taskManager.addSubtask(s1);
        ArrayList<Subtask> list = new ArrayList<>();
        list.add(s1);
        e1.setSubtasks(list);
        System.out.println(taskManager.getEpic(1));
        s1.setStatus(TaskStatus.NEW);
        System.out.println(taskManager.getEpic(1));
        s1.setStatus(TaskStatus.DONE);
        System.out.println(taskManager.getEpic(1));
        System.out.println("----------------------------------------");
        Subtask s2 = new Subtask();
        s2.setName("sub2");
        s2.setDescription("des4");
        s2.setStatus(TaskStatus.IN_PROGRESS);
        list.add(s2);
        e1.setSubtasks(list);
        System.out.println(taskManager.getEpic(1));
        s2.setStatus(TaskStatus.DONE);
        System.out.println(taskManager.getEpic(1));
        System.out.println("----------------------------------------");
        taskManager.getEpics();
        System.out.println(taskManager.getSubtasksInEpic(e1));
        System.out.println(taskManager.getSubtask(2));
        System.out.println("----------------------------------------");
    }
}