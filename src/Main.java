import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<String> tasks = new ArrayList<String>();
    static ArrayList<String> taskStatus = new ArrayList<String>();

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        boolean isRunning = true;
        int choice;

        do{

            System.out.println("-----Task Tracker-----");
            System.out.println("1. Add task");
            System.out.println("2. View tasks");
            System.out.println("3. Change task status");
            System.out.println("4. Delete task");
            System.out.println("5. Exit");

            System.out.print("Select: ");

            choice = scan.nextInt();
            scan.nextLine();

            switch (choice){
                case 1:
                    addTask(scan);
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    changeStatus(scan);
                    break;
                case 4:
                    deleteTask(scan);
                    break;
                case 5 :
                    System.out.println("Bye!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }while(isRunning);
    }
    static void addTask(Scanner scan){
        System.out.print("Enter description of the task: ");
        String description = scan.nextLine();
        tasks.add(description);
        taskStatus.add("[Undone]");
        System.out.println("Task added.");
    }

    static void viewTasks(){
        for(int i=0; i<tasks.size(); i++){
            System.out.println(i+1 + ". " + tasks.get(i) + " " + taskStatus.get(i));
        }
    }

    static void changeStatus(Scanner scan){
        System.out.println("Select a task to change status:");
        viewTasks();
        int choice = scan.nextInt();
        scan.nextLine();
        System.out.println("1. In progress\n2. Done");
        int status = scan.nextInt();
        scan.nextLine();
        if(status == 1){taskStatus.set(choice-1, "[In progress]");}
        else if(status == 2){taskStatus.set(choice-1, "[Done]");}
        else{
            System.out.println("Invalid input");
        }
    }

    static void deleteTask(Scanner scan){
        System.out.println("Select a task to delete:");
        viewTasks();
        int choice = scan.nextInt();
        scan.nextLine();
        tasks.remove(choice-1);
        taskStatus.remove(choice-1);
    }
}
