package com.github.Web8Trace.kanban;

import com.github.Web8Trace.kanban.model.Epic;
import com.github.Web8Trace.kanban.model.Subtask;
import com.github.Web8Trace.kanban.model.Task;
import com.github.Web8Trace.kanban.service.TaskManager;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        Task t1 = new Task("name1", "des1");
        System.out.println(t1);
        taskManager.addNewTask(t1);
        System.out.println(t1);
        System.out.println(taskManager.print("Task"));
        System.out.println("----------------------------");
        Task t2 = new Task("name1", "des2");
        taskManager.addNewTask(t2);
        System.out.println(taskManager.print("Task"));
        System.out.println("----------------------------");
        Subtask s1 = new Subtask("sub1", "des3");
        Subtask s2 = new Subtask("sub2", "des4");
        Epic e1 = new Epic("epic1", "des5");
        taskManager.addSubtaskInEpic(e1, s1);
        taskManager.addSubtaskInEpic(e1, s2);
        System.out.println("----------------------------");
        System.out.println(taskManager.print("Epic"));
        System.out.println(e1);
        taskManager.addNewTask(s1);
        taskManager.addNewTask(s2);
        System.out.println(e1);

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
////        com.github.Web8Trace.kanban.model.Subtask s1 = new com.github.Web8Trace.kanban.model.Subtask("sub1", "des3");
////        com.github.Web8Trace.kanban.model.Subtask s2 = new com.github.Web8Trace.kanban.model.Subtask("sub2", "des4");
////        System.out.println(s1);
////        System.out.println(s2);
////
////        taskManager.addNewTask(s1);
////        taskManager.addNewTask(s2);
////        System.out.println(taskManager.subtask);
////        ArrayList<com.github.Web8Trace.kanban.model.Subtask> list = new ArrayList<>();
////        list.add(s1);
////        list.add(s2);
////        System.out.println("------------------------------");
////        com.github.Web8Trace.kanban.model.Epic e1 = new com.github.Web8Trace.kanban.model.Epic("ep1", "des5");
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
////        com.github.Web8Trace.kanban.model.Task tt = new com.github.Web8Trace.kanban.model.Task("ssssssss","sdsasasddfsdfsd");
////        System.out.println(taskManager.addNewTask(new com.github.Web8Trace.kanban.model.Task("ssssssss","sdsasasddfsdfsd")));
//    }
//}