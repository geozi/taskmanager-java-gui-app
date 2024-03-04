package taskmanager;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import taskmanager.model.Task;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * The {@link AppGUI} class provides the GUI
 * for interacting with the application.
 */
public class AppGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField taskDescriptionTxt;
	private DefaultListModel<Task> tasks;
	private final JList<Task> list;
	private int index =-1;
	
	
	/**
	 * Creates the frame and all necessary components.
	 */
	public AppGUI() {
		setTitle("Task Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 788);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 248, 220));
		panel.setBounds(12, 51, 560, 592);
		contentPane.add(panel);
		panel.setLayout(null);
		
		tasks = Main.getTaskManager().getTasks();
		list = new JList<>(tasks);
		list.setFont(new Font("Lato", Font.BOLD, 18));
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				index = list.getSelectedIndex();
			}
		});
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setBounds(12, 12, 536, 568);
		scrollPane.setBackground(new Color(255, 255, 255));
		panel.add(scrollPane);
		
		taskDescriptionTxt = new JTextField();
		taskDescriptionTxt.setFont(new Font("Dialog", Font.PLAIN, 14));
		taskDescriptionTxt.setBounds(12, 655, 289, 68);
		contentPane.add(taskDescriptionTxt);
		taskDescriptionTxt.setColumns(10);
		
		JButton addNoteBtn = new JButton("Add note");
		addNoteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Task newTask = new Task(taskDescriptionTxt.getText());
				Main.getTaskManager().add(newTask);
				taskDescriptionTxt.setText("");
				list.setModel(updateModelList());
			}
		});
		addNoteBtn.setBounds(313, 655, 117, 25);
		contentPane.add(addNoteBtn);
		
		JLabel taskManagerLbl = new JLabel("Your Tasks");
		taskManagerLbl.setForeground(new Color(165, 42, 42));
		taskManagerLbl.setFont(new Font("Open Sans", Font.BOLD, 20));
		taskManagerLbl.setBounds(228, 14, 150, 25);
		contentPane.add(taskManagerLbl);
		
		JButton deleteNoteBtn = new JButton("Delete");
		deleteNoteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Main.getTaskManager().remove(index);
					list.setModel(updateModelList());
				} catch(IndexOutOfBoundsException  iobe) {
					System.out.println("You must choose an item from list!");
				}

			}
		});
		deleteNoteBtn.setBounds(313, 692, 117, 25);
		contentPane.add(deleteNoteBtn);
	}
	
	private DefaultListModel<Task> updateModelList(){
		return Main.getTaskManager().getTasks();
	}
}
