/*
 * Jingbo Wang
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Guiprogram implements ActionListener
{
	final int SIZE = 4;
	JButton boardButtons[]= new JButton[SIZE];
	JFrame f = new JFrame(); // main window object
	JButton b1;
	JButton b2;
	JButton b3;
	JButton b4;
	JButton b5;
	JTextArea centerTextArea;
	
	// constructor
	public Guiprogram(String title) 
	{

		// creating a JFrame window with the title
		f = new JFrame(title);
		
		b1 = new JButton("New Playing");
		b1.setFont(new Font("SansSerif", Font.PLAIN, 20));
		b1.addActionListener(this);
		
		b2 = new JButton("Media Guide");
		b2.setFont(new Font("SansSerif", Font.PLAIN, 20));
		b2.addActionListener(this);
		
		b3 = new JButton("Library");
		b3.setFont(new Font("SansSerif", Font.PLAIN, 20));
		b3.addActionListener(this);
		
		b4 = new JButton("Help & Info");
		b4.setFont(new Font("SansSerif", Font.PLAIN, 20));
		b4.addActionListener(this);
		
		// The JPanel holds the buttons
		JPanel upperLayerPanel = new JPanel();
		upperLayerPanel.setLayout(new GridLayout(2, 2));
		// creating memory for the buttons
		for(int i=0;i<SIZE;i++)
		{
			boardButtons[i] = new JButton();
			boardButtons[i].setText(Integer.toString(i));
			boardButtons[i].setFont(new Font("SansSerif", Font.PLAIN, 20));
			boardButtons[i].addActionListener(this);
			
			// adding the button to the Panel
			upperLayerPanel.add(boardButtons[i]);
		}
			
		b5 = new JButton("Ok");
		b5.setFont(new Font("SansSerif", Font.PLAIN, 20));
		b5.addActionListener(this);
		
		// Panel holding buttons at the west side	
		JPanel westPanel = new JPanel();
		westPanel.setLayout(new FlowLayout());
		westPanel.add(b1);
		westPanel.add(b2);
		westPanel.add(b3);
		westPanel.add(b4);
		
		
		// Panel holding buttons at the east side
		JPanel eastPanel = new JPanel();
		eastPanel.setLayout(new GridLayout(2, 1));
		
		eastPanel.add(upperLayerPanel, BorderLayout.NORTH);
		eastPanel.add(b5, BorderLayout.SOUTH);
		centerTextArea = new JTextArea();
		
		// Panel holding buttons at the center side
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(1, 3));
		northPanel.add(westPanel, BorderLayout. WEST);
		northPanel.add(centerTextArea,BorderLayout.CENTER);
		northPanel.add(eastPanel, BorderLayout. EAST);
		
		// Panel holding buttons at the cernet bottom
		JLabel Label1= new JLabel("                                           Movies");
		Label1.setPreferredSize(new Dimension(40, 40));
		
		JLabel Label2= new JLabel("Music");
		Label2.setPreferredSize(new Dimension(40, 40));
		
		JLabel Label3= new JLabel("Videos");
		Label3.setPreferredSize(new Dimension(40, 40));
		
		JLabel Label4= new JLabel("DVD");
		Label4.setPreferredSize(new Dimension(40, 40));
		
		JLabel Label5= new JLabel("Web Pages");
		Label5.setPreferredSize(new Dimension(40, 40));
		
		JLabel gameStatusCenterLabel= new JLabel();
		gameStatusCenterLabel.setLayout(new GridLayout(1, 3));
		gameStatusCenterLabel.add(Label2,BorderLayout.WEST);
		gameStatusCenterLabel.add(Label3,BorderLayout.CENTER);
		gameStatusCenterLabel.add(Label4,BorderLayout.EAST);
		
		JLabel gameStatusLabel= new JLabel();
		gameStatusLabel.setPreferredSize(new Dimension(100, 40));
		gameStatusLabel.setLayout(new GridLayout(1, 3));
		gameStatusLabel.add(Label1,BorderLayout.WEST);
		gameStatusLabel.add(gameStatusCenterLabel,BorderLayout.CENTER);
		gameStatusLabel.add(Label5,BorderLayout.EAST);
		
		f.setLayout(new BorderLayout());
		f.add(northPanel, BorderLayout. CENTER);
		f.add(gameStatusLabel, BorderLayout. SOUTH);
		
		f.setSize(640, 540);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	// determine which cell button triggered the action event
	public void actionPerformed(ActionEvent event) 
	{
		if(event.getSource().equals(b1))
		{
			String text = centerTextArea.getText();
			this. centerTextArea.setText("New Playing\n");
			centerTextArea.append(text + "\n");
		} 
		else if(event.getSource().equals(b2))
		{
			String text = centerTextArea.getText();
			this.centerTextArea.setText("Media Guide\n");
			centerTextArea.append(text + "\n");
		}  
		else if(event.getSource().equals(b3))
		{
			String text = centerTextArea.getText();
			this.centerTextArea.setText("Library\n");
			centerTextArea.append(text + "\n");
		} 
		else if(event.getSource().equals(b4))
		{
			String text = centerTextArea.getText();
			this.centerTextArea.setText("Help & Info\n");
			centerTextArea.append(text + "\n");
		} 
		else if(event.getSource().equals(b5))
		{
			String text = centerTextArea.getText();
			this.centerTextArea.setText("Ok\n");
			centerTextArea.append(text + "\n");
		}
		else
		{
			for(int i=0;i<SIZE;i++)
			{
				if(event.getSource().equals(boardButtons[i])) // button found
				{
					String text = centerTextArea.getText();
					this.centerTextArea.setText(i + "\n");
					centerTextArea.append(text + "\n");
				}
			}
						
		}
	}
	
	// main driver program
	public static void main(String[] args) 
	{
		// create an object of the Guiprogram class
		@SuppressWarnings("unused")
		Guiprogram guiProgram = new Guiprogram("Movie on Thursday");
    }
}
