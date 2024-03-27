public class Subtask extends Task{

    Subtask(String name, String description){
        super(name, description);
    }

    @Override
    public String toString() {
        return "Subtask{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
