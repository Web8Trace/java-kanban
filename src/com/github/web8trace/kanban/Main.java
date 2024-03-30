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
        taskManager.addTask(e1);
        System.out.println(taskManager.getEpic(1));
        System.out.println(e1.getSubtasks().size());

        Subtask s1 = new Subtask();
        s1.setName("sub1");
        s1.setDescription("des4");
        s1.setStatus(TaskStatus.IN_PROGRESS);

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

//        Task t2 = new Task();
//        t2.setName("name2");
//        t2.setDescription("des2");
//        System.out.println(t2);
//        taskManager.addTask(t2);
//        System.out.println("---------------------------------------------");

//        System.out.println("---------------------------------------------");
//        Epic e1 = new Epic();
//        e1.setName("ep1");
//        e1.setDescription("des3");
//        System.out.println(e1);
//        System.out.println(e1.getStatus());
//        taskManager.addTask(e1);
//
//        System.out.println(e1.getStatus());
//        System.out.println("---------------------------------------------");
//        Subtask s1 = new Subtask();
//        s1.setName("sub1");
//        s1.setDescription("des4");
//        System.out.println(s1);
//        taskManager.addTask(s1);
//        System.out.println(s1);
//
//
//        Subtask s2 = new Subtask();
//        s2.setName("sub2");
//        s2.setDescription("des5");
//        System.out.println(s2);
//        taskManager.addTask(s2);
//        System.out.println(s2);
//
//        System.out.println("---------------------------------------------");
//        taskManager.statusTaskDone(5);
//
//
//
//        System.out.println("---------------------------------------------");
//        Subtask s3 = new Subtask();
//        s3.setName("sub3");
//        s3.setDescription("des6");
//        System.out.println(s3);
//        taskManager.addTask(s3);
//        System.out.println(s3);
//
//        System.out.println("---------------------------------------------");
//        taskManager.statusTaskDone(6);
//        taskManager.statusTaskDone(4);
//
//        System.out.println("---------------------------------------------");
//        Subtask s4 = new Subtask();
//        s3.setName("sub4");
//        s3.setDescription("des7");
//        taskManager.addTask(s4);
//
//
//        System.out.println("---------------------------------------------");
//        taskManager.statusTaskDone(7);























//
//        Task t1 = new Task("name1", "des1");
//        System.out.println(t1);
//        taskManager.addNewTask(t1);
//        System.out.println(t1);
//        System.out.println(taskManager.print("Task"));
//        System.out.println("----------------------------");
//        Task t2 = new Task("name1", "des2");
//        taskManager.addNewTask(t2);
//        System.out.println(taskManager.print("Task"));
//        System.out.println("----------------------------");
//        Subtask s1 = new Subtask("sub1", "des3");
//        Subtask s2 = new Subtask("sub2", "des4");
//        Epic e1 = new Epic("epic1", "des5");
//        taskManager.addSubtaskInEpic(e1, s1);
//        taskManager.addSubtaskInEpic(e1, s2);
//        System.out.println("----------------------------");
//        System.out.println(taskManager.print("Epic"));
//        System.out.println(e1);
//        taskManager.addNewTask(s1);
//        taskManager.addNewTask(s2);
//        System.out.println(e1);

    }
}
//        System.out.println(t1);
//        System.out.println(t2);
//        taskManager.addNewTask(t1);
//        taskManager.addNewTask(t2);
//        System.out.println(taskManager.tasks);
//
//        System.out.println("------------------------------");
////
////        model.com.github.web8trace.kanban.Subtask s1 = new model.com.github.web8trace.kanban.Subtask("sub1", "des3");
////        model.com.github.web8trace.kanban.Subtask s2 = new model.com.github.web8trace.kanban.Subtask("sub2", "des4");
////        System.out.println(s1);
////        System.out.println(s2);
////
////        taskManager.addNewTask(s1);
////        taskManager.addNewTask(s2);
////        System.out.println(taskManager.subtask);
////        ArrayList<model.com.github.web8trace.kanban.Subtask> list = new ArrayList<>();
////        list.add(s1);
////        list.add(s2);
////        System.out.println("------------------------------");
////        model.com.github.web8trace.kanban.Epic e1 = new model.com.github.web8trace.kanban.Epic("ep1", "des5");
//////        System.out.println("------------------------------");
////        System.out.println(e1);
////        taskManager.addNewTask(e1);
////        System.out.println(taskManager.epic);
////        e1.addSubtask(list);
////        System.out.println("------------------------------");
////        System.out.println(taskManager.epic);
////
////        System.out.println("------------------------------------------------------------");
////
////        taskManager.statusTaskDone(1);
////        System.out.println(taskManager.task);
////        System.out.println(t1);
////
////        System.out.println("------------------------------------------------------------");
////        taskManager.statusTaskDone(3);
////        System.out.println(taskManager.subtask);
////        System.out.println(s1);
//
//          Subtask s1 = new Subtask("name1","des1");
//          Subtask s2 = new Subtask("name2","des2");
//
//          ArrayList<Subtask> list = new ArrayList<>();
//          list.add(s1);
//          list.add(s2);
//
//          Epic e1 = new Epic("name3","des3",list);
//          Epic e2 = new Epic("name3","des3",list);
//
//        System.out.println(e1);
//        System.out.println(e2);
//        System.out.println("-----------------------------------------------");
//
//        taskManager.addNewTask(e1);
//        taskManager.addNewTask(e2);
//        System.out.println(taskManager.epics);
//
//        System.out.println("-----------------------------------------------");
//        taskManager.addNewTask(s1);
//        taskManager.addNewTask(s2);
//
//        System.out.println("-----------------------------------------------");
//
//
//        System.out.println(taskManager.epics);
//
//        taskManager.statusTaskDone(5);
//        System.out.println("-----------------------------------------------");
//
//
//        System.out.println(taskManager.epics);
//
//
//        taskManager.statusTaskDone(6);
//        System.out.println("-----------------------------------------------");
//
//
//        System.out.println(taskManager.epics);
//
//        System.out.println(s1);
//        System.out.println(s2);
//
////        taskManager.deleteAllTask();
////        System.out.println(taskManager);
//
////        taskManager.addNewTask(t1);
////        taskManager.addNewTask(t2);
////        System.out.println(taskManager.task);
////        System.out.println("------------------------------------------------------------");
////        System.out.println(t1.getId());
////        System.out.println(t2.getId());
////        model.com.github.web8trace.kanban.Task tt = new model.com.github.web8trace.kanban.Task("ssssssss","sdsasasddfsdfsd");
////        System.out.println(taskManager.addNewTask(new model.com.github.web8trace.kanban.Task("ssssssss","sdsasasddfsdfsd")));
//    }
//}