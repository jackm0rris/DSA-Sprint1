public class Task {
    private final String description;
    private boolean isCompleted;

    // constructor
    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    // mark task as completed
    public void markAsCompleted() {
        this.isCompleted = true;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    @Override
    public String toString() {
        return description + " [" + (isCompleted ? "Completed" : "Pending") + "]";
    }
}

