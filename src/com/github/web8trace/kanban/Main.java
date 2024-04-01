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
        e1.setDescription("des1");
        taskManager.addEpic(e1);
        System.out.println(taskManager.getEpic(1));
        System.out.println(e1.getSubtasks().size());
        Subtask s1 = new Subtask();
        s1.setName("sub1");
        s1.setDescription("des2");
        s1.setStatus(TaskStatus.IN_PROGRESS);
        s1.setEpicId(1);
        taskManager.addSubtask(s1);
        System.out.println(taskManager.getEpic(1));
        Subtask s2 = new Subtask();
        s2.setName("sub2");
        s2.setDescription("des3");
        s2.setStatus(TaskStatus.IN_PROGRESS);
        s2.setEpicId(1);
        taskManager.addSubtask(s2);
        s2.setStatus(TaskStatus.DONE);
        s1.setStatus(TaskStatus.DONE);
        System.out.println(taskManager.getEpic(1));
        Subtask s3 = new Subtask();
        s3.setName("sub3");
        s3.setDescription("de4");
        s3.setStatus(TaskStatus.IN_PROGRESS);
        s3.setEpicId(1);
        taskManager.addSubtask(s3);
        //taskManager.removeSubtask(2);
        System.out.println(taskManager.getEpic(1));
        System.out.println("----------------------------------------");
        System.out.println(e1.getSubtasks());
        System.out.println(taskManager.getSubtasks());
        System.out.println(e1);
        System.out.println("----------------------------------------");

        //taskManager.removeSubtask(3);
        System.out.println(e1);
        System.out.println("----------------------------------------");
        System.out.println(taskManager.getSubtasks());
        System.out.println("----------------------------------------");
        Subtask s10 = new Subtask();
        s10.setName("00000000000000000000");
        s10.setDescription("hduhfsdhfsdgfgsdufds");
        s10.setStatus(TaskStatus.NEW);
        s10.setId(3);
        s10.setEpicId(1);
        taskManager.updateSubtask(s10);
        System.out.println("----------------------------------------");
        System.out.println("----------------------------------------");
        System.out.println(taskManager.getSubtasks());
        System.out.println(taskManager.getSubtasksInEpic(1));
        System.out.println("----------------------------------------");
        taskManager.removeEpic(1);
        System.out.println(taskManager.getEpics());

//        ArrayList<Subtask> list = new ArrayList<>();
//        list.add(s1);
//        e1.setSubtasks(list);
//        System.out.println(taskManager.getEpic(1));
//        s1.setStatus(TaskStatus.NEW);
//        System.out.println(taskManager.getEpic(1));
//        s1.setStatus(TaskStatus.DONE);
//        System.out.println(taskManager.getEpic(1));
//        System.out.println("----------------------------------------");
//        Subtask s2 = new Subtask();
//        s2.setName("sub2");
//        s2.setDescription("des4");
//        s2.setStatus(TaskStatus.IN_PROGRESS);
//        list.add(s2);
//        e1.setSubtasks(list);
//        System.out.println(taskManager.getEpic(1));
//        s2.setStatus(TaskStatus.DONE);
//        System.out.println(taskManager.getEpic(1));
//        System.out.println("----------------------------------------");
//        taskManager.getEpics();
//        System.out.println(taskManager.getSubtasksInEpic(e1));
//        System.out.println(taskManager.getSubtask(2));
//        System.out.println("----------------------------------------");
    }
}