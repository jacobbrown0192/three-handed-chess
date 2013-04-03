package GUI_Interface;

import javax.swing.JPanel;
import java.awt.GridLayout;


import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JToggleButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import threePlayerChessa.Game;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/** Graphics for the control of the <code>PlayerConfigurationMenu</code>.
 * <p>Contains three text boxes for setting the name of each player. These
 * names are reflected in the labels above each text box.
 * <p>Contains buttons for selecting the colour of each player's pieces.
 * (To be implemented).
 * <p>Contains buttons to select if each player will be a Computer player
 * or a Human player. (To be implemented).
 * <p>Contains sliders to select the difficulty of each Computer player's AI
 * (To be implemented).
 */
public class PlayerConfigurationMenuGUI extends JPanel 
{
	private static final long serialVersionUID = 1L;
	private JTextField txtPlayer;
	private JTextField txtPlayer_1;
	private JTextField txtPlayer_2;
	private JLabel labelPlayer1;
	private JLabel labelPlayer2;
	private JLabel labelPlayer3;
	Game theGame;
	

	/**
	 * Create the panel.
	 */
	public PlayerConfigurationMenuGUI(Game aGame)
	{
		theGame = aGame;
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setLayout(new GridLayout(7, 3, 0, 20));
		
		JLabel label = new JLabel("");
		add(label);
		
		JLabel title = new JLabel("Player Configuration");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		add(title);
		
		JLabel label_1 = new JLabel("");
		add(label_1);
		
		labelPlayer1 = new JLabel("Player 1");
		labelPlayer1.setHorizontalAlignment(SwingConstants.CENTER);
		add(labelPlayer1);
		
		labelPlayer2 = new JLabel("Player 2");
		labelPlayer2.setHorizontalAlignment(SwingConstants.CENTER);
		add(labelPlayer2);
		
		labelPlayer3 = new JLabel("Player 3");
		labelPlayer3.setHorizontalAlignment(SwingConstants.CENTER);
		add(labelPlayer3);
		
		txtPlayer = new JTextField();
		txtPlayer.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				String input = txtPlayer.getText();
				labelPlayer1.setText(input);
				theGame.getPlyerConfig().player0SetName(input);
				
			}
		});
		
		txtPlayer.setText("Player 1");
		add(txtPlayer);
		txtPlayer.setColumns(30);
		
		txtPlayer_1 = new JTextField();
		txtPlayer_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String input = txtPlayer_1.getText();
				labelPlayer2.setText(input);
				theGame.getPlyerConfig().player1SetName(input);
			}
		});
		txtPlayer_1.setText("Player 2");
		add(txtPlayer_1);
		txtPlayer_1.setColumns(30);
		
		txtPlayer_2 = new JTextField();
		txtPlayer_2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String input = txtPlayer_2.getText();
				labelPlayer3.setText(input);
				theGame.getPlyerConfig().player2SetName(input);
			}
		});
		txtPlayer_2.setText("Player 3");
		add(txtPlayer_2);
		txtPlayer_2.setColumns(30);
		
		JButton btnNewButton_2 = new JButton("Choose Colour");
		add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Choose Colour");
		add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Choose Colour");
		add(btnNewButton);
		
		JToggleButton tglbtnNewToggleButton_2 = new JToggleButton("Computer");
		add(tglbtnNewToggleButton_2);
		
		JToggleButton tglbtnNewToggleButton_1 = new JToggleButton("Computer");
		add(tglbtnNewToggleButton_1);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Computer");
		add(tglbtnNewToggleButton);
		
		JSlider slider_2 = new JSlider();
		slider_2.setValue(5);
		slider_2.setMaximum(10);
		add(slider_2);
		
		JSlider slider_1 = new JSlider();
		slider_1.setMaximum(10);
		slider_1.setValue(5);
		add(slider_1);
		
		JSlider slider = new JSlider();
		slider.setMaximum(10);
		slider.setValue(5);
		add(slider);
		
		JLabel label_2 = new JLabel("");
		add(label_2);
		
		JButton btnNewButton_3 = new JButton("Close");
		btnNewButton_3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				theGame.getPlyerConfig().close();
			}
		});
		add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("");
		add(lblNewLabel);
	}
}
