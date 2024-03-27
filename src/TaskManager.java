import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class TaskManager {

    static int id = 0;

    public Integer id(){
        id++;
        return id;
    }

    HashMap<Integer, Task> task = new HashMap<>();
    HashMap<Integer, Epic> epic = new HashMap<>();
    HashMap<Integer, Subtask> subtask = new HashMap<>();

    public HashMap<Integer, Task> addNewTask(Task t) {
        task.put(id(), t);
        t.status = StatusOfTask.IN_PROGRESS;
        return task;
    }

    public HashMap<Integer, Subtask> addNewTask(Subtask s) {
        subtask.put(id(), s);
        s.status = StatusOfTask.IN_PROGRESS;
        return subtask;
    }

    public HashMap<Integer, Epic> addNewTask(Epic e) {
        epic.put(id(), e);
        e.status = StatusOfTask.IN_PROGRESS;
        return epic;
    }

    public void statusTaskDone(Integer id) {
        if (task.containsKey(id)) {
            Task t = task.get(id);
            t.status = StatusOfTask.DONE;
        }
        if (subtask.containsKey(id)) {
            Subtask s = subtask.get(id);
            s.status = StatusOfTask.DONE;
        }

        for (Epic s: epic.values()){
            s.chekStatus();
        }
    }

    public HashMap<Integer,? extends Task> print(String type){
        if (type.equals("Subtask")){
            return subtask;
        }
        if (type.equals("Epic")){
            return epic;
        }
        return task;
    }

    public void deleteAllTask(){
        task.clear();
        subtask.clear();
        epic.clear();
    }

    public HashMap<Integer,Task> updateTask(int id, Task t){
        if (task.containsKey(id)){
            task.put(id, t);
        }
        return task;
    }

    public HashMap<Integer,Subtask> updateTask(int id, Subtask s){
        if (subtask.containsKey(id)){
            subtask.put(id, s);
        }
        return subtask;
    }

    public HashMap<Integer,Epic> updateTask(int id, Epic e){
        if (epic.containsKey(id)){
            epic.put(id, e);
        }
        return epic;
    }


    public void removeTask(Integer id){
        if (task.containsKey(id)) {
            task.remove(id);
        }
        if (subtask.containsKey(id))
            subtask.remove(id);
        if (epic.containsKey(id)){
            epic.remove(id);
        }
    }


    @Override
    public String toString() {
        return "TaskManager{" +
                "id=" + id() +
                ", task=" + task +
                ", epic=" + epic +
                ", subtask=" + subtask +
                '}';
    }
}
