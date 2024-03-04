package taskmanager;

import java.awt.EventQueue;

import taskmanager.model.TaskManager;

/**
 * The {@link Main} class is the driver
 * of the application.
 */
public class Main {
	private static AppGUI taskManagerGUI;
	private static TaskManager taskManager;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					taskManager = TaskManager.getInstance();
					
					taskManagerGUI = new AppGUI();
					taskManagerGUI.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static TaskManager getTaskManager() {
		return taskManager;
	}
}
