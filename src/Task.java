import java.util.Objects;

public class Task {
    String name;
    String description;
    private static int id;
    StatusOfTask status;

    Task(String name, String description){
        this.name = name;
        this.description = description;
        this.id++;
        this.status = StatusOfTask.NEW;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(name, task.name) && Objects.equals(description, task.description) && status == task.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, id, status);
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }

    public static int getId() {
        return id;
    }

    public StatusOfTask getStatus() {
        return status;
    }
}
