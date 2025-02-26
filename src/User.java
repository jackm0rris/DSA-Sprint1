public class User {
    private final String name;
    private final TaskList toDoList;

    // constructor
    public User(String name) {
        this.name = name;
        this.toDoList = new TaskList();
    }

    // add a task to users list
    public void addTask(String description) {
        Task newTask = new Task(description);
        toDoList.addTask(newTask);
        System.out.println("Task added: " + description);
    }

    // mark task complete
    public void markTaskAsCompleted(String description) {
        toDoList.markTaskAsCompleted(description);
    }

    // print all tasks in the users list
    public void printAllTasks() {
        System.out.println("Tasks for user: " + name);
        toDoList.printAllTasks();
    }

    public String getName() {
        return name;
    }
}