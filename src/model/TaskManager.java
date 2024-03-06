package taskmanager.model;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 * The {@link TaskManager} class implements the
 * Singleton pattern and manages the connection
 * to the in-memory database.
 */
public class TaskManager {
	private final ArrayList<Task> tasksDB;
	private static TaskManager instance;
	
	private TaskManager() {
		this.tasksDB = new ArrayList<>();
	}
	
	/**
	 * Returns the unique instance of a {@link TaskManager} class.
	 * @return A {@link TaskManager} object reference.
	 */
	public static TaskManager getInstance() {
		if(instance == null) {
			instance = new TaskManager();
		}
		
		return instance;
	}
	
	// Methods
	
	/**
	 * Adds a new task to the task list.
	 * @param task A {@link Task} object.
	 */
	public void add(Task task) {
		Task newEntry = new Task(task);
		tasksDB.add(newEntry);
		System.out.println("Task added!");
	}
	
	/**
	 * Removes a task from the task list.
	 * @param index The index of the {@link Task} object to be removed. 
	 */
	public void remove(int index) {
		tasksDB.remove(index);
		System.out.println("Selected task removed!");
	}
	
	/**
	 * Returns the task list to the caller.
	 * @return An object of type DefaultListModel<Task>.
	 */
	public DefaultListModel<Task> getTasks() {
		DefaultListModel<Task> dbConn = new DefaultListModel<>();
		dbConn.addAll(tasksDB);
		return dbConn;
	}
	
}
