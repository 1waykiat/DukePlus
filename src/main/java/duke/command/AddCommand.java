package duke.command;

import duke.error.DukeException;
import duke.general.Storage;
import duke.general.TaskType;
import duke.general.Tasklist;
import duke.general.Ui;
import duke.task.Task;

/**
 * Command for the program to add a task
 */
public class AddCommand extends Command {
    private TaskType type;
    private String[] input;

    /**
     * Constructs the AddCommand object
     * @param t Task type
     * @param inputSplit Input by user
     */
    public AddCommand(TaskType t, String[] inputSplit) {
        assert(input != null) : "Input into command was null!";
        this.type = t;
        this.input = inputSplit;
    }

    @Override
    public String execute(Tasklist tasks, Storage storage, Ui ui) throws DukeException {
        Task t = tasks.addTask(this.type, this.input);
        storage.appendSave(t);
        return ui.addResponse(t, tasks.size());
    }
}
