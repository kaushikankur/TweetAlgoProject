import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CountDownLatch;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class createAndShowGUI{
	
	public static String Keyword;
	public static boolean b1=false;
		public static void createGUI() throws InterruptedException {
			
			/// we need to wait in this function till button is not clicked
			final CountDownLatch latch = new CountDownLatch(1);
			//Create and set up the window.
			JFrame frame = new JFrame("Tweet Reaction Analysis");

			frame.setSize(400,400);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			/* nested JPanels can be used
			//JPanel jp=new JPanel();
			//jp.setLayout(new GridLayout(0, 1, 20, 20));*/

			///// input a keyword
			JLabel label=new JLabel("Enter Keyword");
			JPanel jp1=new JPanel();
			jp1.setLayout(null);
			label.setBounds(50, 100, 150, 30);

			final JTextField tempTextField = new JTextField();
			
			tempTextField.setBounds(150, 100, 150, 30);

			
			JButton analyse = new JButton();
			analyse.setText("Analyse");
			analyse.setBounds(150, 150, 90, 30);

			jp1.add(label);
			jp1.add(tempTextField);
			jp1.add(analyse);
			frame.add(jp1);
			//Display the window
			//frame.pack();
			frame.setVisible(true);
			analyse.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String Keyword = tempTextField.getText();
					main.Keyword=Keyword;
					
					latch.countDown();
					//System.out.println("i am here"+Keyword);
				}
			});
			latch.await();
			

		}
}