package GUI_Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.Rectangle;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class frametest extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frametest frame = new frametest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public frametest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setMinimumSize(new Dimension(1000, 1000));
		panel_1.setPreferredSize(new Dimension(100, 100));
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(new Rectangle(0, 0, 0, 500));
		contentPane.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		JButton btnNewButton_4 = new JButton("New button");
		panel_2.add(btnNewButton_4);
		
		JButton btnNewButton_3 = new JButton("New button");
		panel_2.add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("New button");
		panel_2.add(btnNewButton);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		JButton btnNewButton_2 = new JButton("New button");
		panel.add(btnNewButton_2);
	}

}
