package duke.command;

import duke.error.DukeException;
import duke.general.Storage;
import duke.general.Tasklist;
import duke.general.Ui;
import duke.task.Task;

/**
 * Command for the program to mark a task as completed
 */
public class DoneCommand extends Command {
    private String[] input;

    public DoneCommand(String[] input) {
        assert(input != null) : "Input into command was null!";
        this.input = input;
    }

    @Override
    public String execute(Tasklist tasks, Storage storage, Ui ui) throws DukeException {
        Task t = tasks.doneTask(input);
        if (t != null) {
            storage.modifySave(tasks.getList());
            return ui.doneResponse(t);
        }
        return "What do i done again???";
    }
}
