import java.util.ArrayList;

public class Epic extends Task {

    ArrayList<Subtask> subtasks;

    public Epic(String name, String description) {
        super(name, description);
    }

    Epic(String name, String description, ArrayList<Subtask> subtask){
        super(name,description);
        this.subtasks = subtask;
    }

    public ArrayList<Subtask> addSubtask(ArrayList<Subtask> subtask){
        subtasks=subtask;
        return subtasks;
    }

    public void chekStatus(){
        for (int i = 0; i < subtasks.size(); i++) {
            if (subtasks.get(i).status == StatusOfTask.DONE){
                this.status = StatusOfTask.DONE;
            }
        }
    }



    @Override
    public String toString() {
        return "Epic{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", subtasks=" + subtasks +
                '}';
    }
}
