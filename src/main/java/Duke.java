import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        boolean loop = true;
        Scanner textInput = new Scanner(System.in);
        ArrayList<Task> list = new ArrayList<>();

        while (loop) {
            String input = textInput.nextLine();
            String[] inputSplit = input.split(" ", 2);

            try {
                switch (inputSplit[0]) {
                    case "todo":
                        if (inputSplit.length < 2) {
                            throw new DukeException("Description of ToDo cannot be empty!");
                        }

                        Task todo = new ToDo(inputSplit[1]);
                        list.add(todo);
                        System.out.println("Got it. I've added this task: \t");
                        System.out.println(todo.toString());
                        System.out.println("Now you have " + list.size() + " tasks in your list.");
                        break;
                    case "deadline":
                        if (inputSplit.length < 2) {
                            throw new DukeException("Description cannot be empty!");
                        } else if (inputSplit[1].split("/by ", 2).length < 2) {
                            throw new DukeException("Deadline not specified!");
                        }
                        String desc = inputSplit[1].split("/by ", 2)[0];
                        String dead = inputSplit[1].split("/by ", 2)[1];
                        Task deadline = new Deadline(desc, dead);
                        list.add(deadline);
                        System.out.println("Got it. I've added this task: ");
                        System.out.println(deadline.toString());
                        System.out.println("Now you have " + list.size() + " tasks in your list.");
                        break;
                    case "event":
                        if (inputSplit.length < 2) {
                            throw new DukeException("Description cannot be empty!");
                        } else if (inputSplit[1].split("/at ", 2).length < 2) {
                            throw new DukeException("Date of event not specified!");
                        }
                        String name = inputSplit[1].split("/at ", 2)[0];
                        String at = inputSplit[1].split("/at ", 2)[1];
                        Task event = new Event(name, at);
                        list.add(event);
                        System.out.println("Got it. I've added this task: ");
                        System.out.println(event.toString());
                        System.out.println("Now you have " + list.size() + " tasks in your list.");
                        break;
                    case "bye":
                        loop = false;
                        break;
                    case "list":
                        for (int i = 1; i <= list.size(); i++) {
                            Task task = list.get(i - 1);
                            System.out.println(i + "."
                                    + task.toString());
                        }
                        break;
                    case "done":
                        int index = Integer.parseInt(inputSplit[1]);
                        Task task = list.get(index - 1);
                        task.toggleCompleted();
                        System.out.println("Nice! I've marked this task as done: ");
                        System.out.println("[X] " + task.getName());
                        break;
                    case "delete":
                        int i = Integer.parseInt(inputSplit[1]);
                        System.out.println("Noted. I've removed this task: ");
                        System.out.println(list.get(i - 1));
                        list.remove(i - 1);
                        System.out.println("Now you have " + list.size() + " tasks in your list.");
                        break;
                    default:
                        throw new DukeException("That is not within my scope of action!");
                }
            } catch (DukeException e){
                System.out.println(e.toString().split(" ", 2)[1]);
            }
        }


        System.out.println("Bye bye. Duke going to sleep now.");
    }
}
