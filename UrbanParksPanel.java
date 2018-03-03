	package user_interface;
	import java.awt.BorderLayout;
	import java.awt.Color;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JMenu;
	import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
	import javax.swing.JPanel;
	import java.util.Observable;
	import model.UrbanParksEmployee;

	public class UrbanParksPanel  extends JPanel implements Observer {

		private static final long serialVersionUID = 1L;

		private UrbanParksEmployee myEmployee;

		public UrbanParksPanel() {

			myEmployee = new UrbanParksEmployee("NoName", "NoName");
			setLayout(new BorderLayout());
			this.setSize(1000,1000);
			this.setBackground(Color.CYAN);
			add(new MenuBar(), BorderLayout.NORTH);
		}

		
		
		
		
		
		
		public class MenuBar extends JMenuBar {
			private static final long serialVersionUID = 1L;
			
			private JButton SignOut;
			private JButton Update;
			private JButton ViewJobs;
			//Or JMenuItem

			public MenuBar() {
				super();
				SignOut = new JButton("SignOut");
				Update = new JButton("Update");
				ViewJobs = new JButton("ViewJobs");
				this.add(SignOut);
				this.add(Update);
				this.add(ViewJobs);
				viewJobs();
				update();
				signOut();
			}

			private void viewJobs() {
				//ViewJobs = new JMenu("View All Jobs");
				ViewJobs.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(final ActionEvent theEvent) {
						new ParkEmployeeDisplayJobs(myEmployee); 
					}
				});
			}

			private void update() {
//				Update = new JMenu("Update Admin options");
				Update.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(final ActionEvent theEvent) {
						 String userInput = JOptionPane.showInputDialog("Enter Max amount of Jobs:");
						 try
						 {
							 int newMax = new Integer(userInput);
							 myEmployee.changeLegalJobAmount(newMax);
							 JOptionPane pane = new JOptionPane("Changed");
						 }
						 catch (NumberFormatException e)
						 {
							 JOptionPane pane = new JOptionPane("Not Valid");
						 }
					}
				});
			}

			private void signOut() {
				//SignOut = new JMenu("Sign Out");
				SignOut.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(final ActionEvent theEvent) {
						
					}
				});
			}
		}

		@Override
		public void update(Observable o, Object arg) {
			// TODO Auto-generated method stub
		}
	}

