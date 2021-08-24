package duke.task;

import duke.task.Task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * duke.task.Deadline encapsulates the name of the deadline as well as
 * when the task needs to be completed by.
 */

public class Deadline extends Task {
    private LocalDate doneBy;
    private String by;

    /**
     * Constructs duke.task.Deadline object with given name, and deadline of the task.
     * @param name The name of the duke.task.Deadline
     * @param by duke.task.Deadline of the task
     */
    public Deadline(String name, String by) {
        super(name);
        this.by = by;
        this.doneBy = LocalDate.parse(by);
    }


    @Override
    public String getType() {
        return "D";
    }

    @Override
    public String getInfo() {
        return this.by;
    }

    /**
     * Converts the deadline object into a string
     * @return A string containing the type (duke.task.Deadline), completion status and time
     * of the deadline to be done by.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + doneBy.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }
}
