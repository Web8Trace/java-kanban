import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        TaskManager taskManager = new TaskManager();

        Task t1 = new Task("task1", "des1");
        Task t2 = new Task("task2", "des2");
        System.out.println(t1);
        System.out.println(t2);
        taskManager.addNewTask(t1);
        taskManager.addNewTask(t2);
        System.out.println(taskManager.task);

        System.out.println("------------------------------");
//
//        Subtask s1 = new Subtask("sub1", "des3");
//        Subtask s2 = new Subtask("sub2", "des4");
//        System.out.println(s1);
//        System.out.println(s2);
//
//        taskManager.addNewTask(s1);
//        taskManager.addNewTask(s2);
//        System.out.println(taskManager.subtask);
//        ArrayList<Subtask> list = new ArrayList<>();
//        list.add(s1);
//        list.add(s2);
//        System.out.println("------------------------------");
//        Epic e1 = new Epic("ep1", "des5");
////        System.out.println("------------------------------");
//        System.out.println(e1);
//        taskManager.addNewTask(e1);
//        System.out.println(taskManager.epic);
//        e1.addSubtask(list);
//        System.out.println("------------------------------");
//        System.out.println(taskManager.epic);
//
//        System.out.println("------------------------------------------------------------");
//
//        taskManager.statusTaskDone(1);
//        System.out.println(taskManager.task);
//        System.out.println(t1);
//
//        System.out.println("------------------------------------------------------------");
//        taskManager.statusTaskDone(3);
//        System.out.println(taskManager.subtask);
//        System.out.println(s1);

          Subtask s1 = new Subtask("name1","des1");
          Subtask s2 = new Subtask("name2","des2");

          ArrayList<Subtask> list = new ArrayList<>();
          list.add(s1);
          list.add(s2);

          Epic e1 = new Epic("name3","des3",list);
          Epic e2 = new Epic("name3","des3",list);

        System.out.println(e1);
        System.out.println(e2);
        System.out.println("-----------------------------------------------");

        taskManager.addNewTask(e1);
        taskManager.addNewTask(e2);
        System.out.println(taskManager.epic);

        System.out.println("-----------------------------------------------");
        taskManager.addNewTask(s1);
        taskManager.addNewTask(s2);

        System.out.println("-----------------------------------------------");


        System.out.println(taskManager.epic);

        taskManager.statusTaskDone(5);
        System.out.println("-----------------------------------------------");


        System.out.println(taskManager.epic);


        taskManager.statusTaskDone(6);
        System.out.println("-----------------------------------------------");


        System.out.println(taskManager.epic);

        System.out.println(s1);
        System.out.println(s2);

//        taskManager.deleteAllTask();
//        System.out.println(taskManager);

//        taskManager.addNewTask(t1);
//        taskManager.addNewTask(t2);
//        System.out.println(taskManager.task);
//        System.out.println("------------------------------------------------------------");
//        System.out.println(t1.getId());
//        System.out.println(t2.getId());
//        Task tt = new Task("ssssssss","sdsasasddfsdfsd");
//        System.out.println(taskManager.addNewTask(new Task("ssssssss","sdsasasddfsdfsd")));
    }
}