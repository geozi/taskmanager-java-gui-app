package taskmanager.model;

/**
 * The {@link Task} class is the abstract
 * representation of a task.
 */
public class Task {
	private String description;

	// Constructors
	
	/**
	 * Initializes the field(s) of a newly-created {@link Task} class
	 * to default value(s).
	 */
	public Task() {}
	
	/**
	 * Initializes the field(s) of a newly-created {@link Task} class
	 * to the value(s) provided by the caller.
	 * @param description The task description of type String.
	 */
	public Task(String description) {
		this.description = description;
	}
	
	/**
	 * Initializes the field(s) of a newly-created {@link Task} class
	 * to the value(s) of an inserted Task object.
	 * @param task A {@link Task} object.
	 */
	public Task(Task task) {
		this.description = task.getDescription();
	}
	
	// Getters and Setters
	
	/**
	 * Returns the description of a {@link Task} object.
	 * @return The task description of type String.
	 */
	public String getDescription() {
		return description;
	}

	
	/**
	 * Updates the description of a {@link Task} object.
	 * @param description The new description of type String.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Returns the current state of a {@link Task} object.
	 */
	@Override
	public String toString() {
		return this.description;
	}

}
