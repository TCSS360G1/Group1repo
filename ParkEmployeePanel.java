//	package user_interface;
//	import java.awt.BorderLayout;
//	import java.awt.event.ActionEvent;
//	import java.awt.event.ActionListener;
//	import java.util.Observer;
//	import javax.swing.BorderFactory;
//	import javax.swing.JMenu;
//	import javax.swing.JMenuBar;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//	import java.util.Observable;
//	import model.Job;
//	import model.UrbanParksEmployee;
//
//	public class ParkEmployeePanel  extends JPanel implements Observer {
//
//		private static final long serialVersionUID = 1L;
//
//		private JPanel myUpdatePanel;
//		private UrbanParksEmployee myEmployee;
//
//		public ParkEmployeePanel(UrbanParksEmployee theEmployee) {
//
//			myEmployee = theEmployee;
//			//this.setBorder(BorderFactory.createTitledBorder("All Jobs:"));
//			setLayout(new BorderLayout());
//			add(new MenuBar(), BorderLayout.NORTH);
//		}
//
//		public class MenuBar extends JMenuBar {
//			private static final long serialVersionUID = 1L;
//			
//			private JMenu SignOut;
//			private JMenu Update;
//			private JMenu ViewJobs;
//
//			public MenuBar() {
//				super();
//				signOut();
//				update();
//				viewJobs();
//			}
//
//			private void viewJobs() {
//				ViewJobs = new JMenu("View All Jobs");
//				ViewJobs.addActionListener(new ActionListener() {
//					@Override
//					public void actionPerformed(final ActionEvent theEvent) {
//						new ParkEmployeeDisplayJobs(myEmployee); 
//					}
//				});
//			}
//
//			private void update() {
//				Update = new JMenu("Update Admin options");
//				Update.addActionListener(new ActionListener() {
//					@Override
//					public void actionPerformed(final ActionEvent theEvent) {
//						 String userInput = JOptionPane.showInputDialog("Enter Max amount of Jobs:");
//						 try
//						 {
//							 int newMax = new Integer(userInput);
//							 myEmployee.changeLegalJobAmount(newMax);
//							 JOptionPane pane = new JOptionPane("Changed");
//						 }
//						 catch (NumberFormatException e)
//						 {
//							 JOptionPane pane = new JOptionPane("Not Valid");
//						 }
//					}
//				});
//			}
//
//			private void signOut() {
//				SignOut = new JMenu("Sign Out");
//				SignOut.addActionListener(new ActionListener() {
//					@Override
//					public void actionPerformed(final ActionEvent theEvent) {
//						
//					}
//				});
//			}
//		}
//
//		@Override
//		public void update(Observable o, Object arg) {
//			// TODO Auto-generated method stub
//		}
//	}
//
