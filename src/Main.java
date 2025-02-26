import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User[] users = new User[100]; // max 100 users
        int userCount = 0; // number of users

        while (true) {
            System.out.println("\nTo Do List Manager");
            System.out.println("1. Create User");
            System.out.println("2. Add Task to User");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. View Users Tasks");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // create user
                    System.out.print("Enter user name: ");
                    String userName = scanner.nextLine();
                    users[userCount] = new User(userName);
                    userCount++;
                    System.out.println("User created: " + userName);
                    break;

                case 2: // add task
                    if (userCount == 0) {
                        System.out.println("No users found. Please create a user first.");
                        break;
                    }
                    System.out.print("Enter user name: ");
                    String addTaskUserName = scanner.nextLine();
                    User addTaskUser = findUser(users, userCount, addTaskUserName);
                    if (addTaskUser != null) {
                        System.out.print("Enter task name: ");
                        String taskDescription = scanner.nextLine();
                        addTaskUser.addTask(taskDescription);
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 3: // mark task complete
                    if (userCount == 0) {
                        System.out.println("No users found. Please create a user first.");
                        break;
                    }
                    System.out.print("Enter user name: ");
                    String markTaskUserName = scanner.nextLine();
                    User markTaskUser = findUser(users, userCount, markTaskUserName);
                    if (markTaskUser != null) {
                        System.out.print("Enter task name to mark as completed: ");
                        String taskToMark = scanner.nextLine();
                        markTaskUser.markTaskAsCompleted(taskToMark);
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 4: // view tasks for a user
                    if (userCount == 0) {
                        System.out.println("No users found. Please create a user first.");
                        break;
                    }
                    System.out.print("Enter user name: ");
                    String viewTasksUserName = scanner.nextLine();
                    User viewTasksUser = findUser(users, userCount, viewTasksUserName);
                    if (viewTasksUser != null) {
                        viewTasksUser.printAllTasks();
                    } else {
                        System.out.println("User not found.");
                    }
                    break;

                case 5: // exit program
                    System.out.println("Exiting");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // method to find a user by name
    private static User findUser(User[] users, int userCount, String name) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getName().equals(name)) {
                return users[i];
            }
        }
        return null;
    }
}

