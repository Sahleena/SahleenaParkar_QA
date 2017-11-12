import java.awt.EventQueue;
import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;

public class Window {

	private JFrame frame;
	TicketMachine tm = new TicketMachine();
	int countStandard; 
	int countOAP;
	int countStudent; 
	int countChild;
	
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);		
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setTitle("Cinema system");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel intro_Lbl = new JLabel("Please select your ticket(s)");
		JLabel discount_btn = new JLabel("");
		JLabel totalpriceLbl = new JLabel("Total price: ");
		
		if (tm.discount == true){
			discount_btn.setText("Discount applied");
		} else {
			discount_btn.setText("Discount not applied");
		}
		
		JLabel standard_label = new JLabel("");
		JButton standardBtn = new JButton("Standard - £8");
		standardBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		standardBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tm.chooseTicket("standard");
				float p = tm.calculatePrice();
				totalpriceLbl.setText("Total price: £" + p);
				countStandard += 1;
				standard_label.setText("x" + countStandard);
				
			}
		});
		JButton standard_remove = new JButton("x");
		standard_remove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (countStandard > 0){
					tm.removeTicket("standard");
					countStandard -=1;
					float p = tm.calculatePrice();
					totalpriceLbl.setText("Total price: £" + p);
					standard_label.setText("x" + countStandard);
				}
			}
			
		});
		
		
		JLabel OAP_lbl = new JLabel("");
		JButton OAP_Btn = new JButton("OAP - £6");
		OAP_Btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tm.chooseTicket("OAP");
				float p = tm.calculatePrice();
				totalpriceLbl.setText("Total price: £" + p);
				countOAP += 1;
				OAP_lbl.setText("x" + countOAP);
				
			}
		});
		JButton OAP_remove = new JButton("x");
		OAP_remove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (countOAP > 0){
					tm.removeTicket("OAP");
					countOAP -=1;
					float p = tm.calculatePrice();
					totalpriceLbl.setText("Total price: £" + p);
					OAP_lbl.setText("x" + countOAP);
				}
				
			}
		});
		
		
		JLabel student_lbl = new JLabel("");
		JButton student_Btn = new JButton("Student - £6");
		student_Btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tm.chooseTicket("student");
				float p = tm.calculatePrice();
				totalpriceLbl.setText("Total price: £" + p);
				countStudent += 1;
				student_lbl.setText("x" + countStudent);
				
			}
		});
		JButton student_remove = new JButton("x");
		student_remove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (countStudent > 0){
					tm.removeTicket("student");
					countStudent -=1;
					float p = tm.calculatePrice();
					totalpriceLbl.setText("Total price: £" + p);
					student_lbl.setText("x" + countStudent);
				}
				
			}
		});
		
		
		
		JLabel child_lbl = new JLabel("");
		JButton child_Btn = new JButton("Child - £4");
		child_Btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tm.chooseTicket("child");
				float p = tm.calculatePrice();
				totalpriceLbl.setText("Total price: £" + p);
				countChild += 1;
				child_lbl.setText("x" + countChild);
			}
		});
		
		JButton child_remove = new JButton("x");
		child_remove.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (countChild > 0){
					tm.removeTicket("child");
					countChild -=1;
					float p = tm.calculatePrice();
					totalpriceLbl.setText("Total price: £" + p);
					child_lbl.setText("x" + countChild);
				}
				
				
				
				
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		GroupLayout layoutGroup = new GroupLayout(frame.getContentPane());
		layoutGroup.setHorizontalGroup(
			layoutGroup.createParallelGroup(Alignment.LEADING)
				.addGroup(layoutGroup.createSequentialGroup()
					.addContainerGap()
					.addGroup(layoutGroup.createParallelGroup(Alignment.LEADING)
						.addGroup(layoutGroup.createSequentialGroup()
							.addGroup(layoutGroup.createParallelGroup(Alignment.LEADING)
								.addComponent(OAP_Btn, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
								.addComponent(standardBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(child_Btn, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
								.addComponent(student_Btn, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(layoutGroup.createParallelGroup(Alignment.LEADING)
								.addComponent(child_lbl, GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
								.addComponent(student_lbl, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addGroup(Alignment.TRAILING, layoutGroup.createSequentialGroup()
									.addComponent(OAP_lbl, GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
									.addGap(8))
								.addComponent(standard_label, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(layoutGroup.createParallelGroup(Alignment.LEADING)
								.addComponent(OAP_remove)
								.addGroup(layoutGroup.createParallelGroup(Alignment.LEADING)
									.addComponent(child_remove)
									.addGroup(layoutGroup.createSequentialGroup()
										.addComponent(student_remove)
										.addPreferredGap(ComponentPlacement.RELATED))
									.addComponent(standard_remove, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
							.addGap(45)
							.addGroup(layoutGroup.createParallelGroup(Alignment.LEADING)
								.addComponent(totalpriceLbl)
								.addComponent(discount_btn, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)))
						.addComponent(intro_Lbl))
					.addGap(55))
		);
		layoutGroup.setVerticalGroup(
			layoutGroup.createParallelGroup(Alignment.LEADING)
				.addGroup(layoutGroup.createSequentialGroup()
					.addGroup(layoutGroup.createParallelGroup(Alignment.LEADING)
						.addGroup(layoutGroup.createSequentialGroup()
							.addGap(23)
							.addComponent(intro_Lbl)
							.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
							.addGroup(layoutGroup.createParallelGroup(Alignment.BASELINE)
								.addComponent(OAP_Btn)
								.addComponent(OAP_lbl)
								.addComponent(OAP_remove, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
						.addGroup(layoutGroup.createSequentialGroup()
							.addGap(91)
							.addComponent(discount_btn)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(layoutGroup.createParallelGroup(Alignment.LEADING)
						.addGroup(layoutGroup.createSequentialGroup()
							.addGroup(layoutGroup.createParallelGroup(Alignment.BASELINE)
								.addComponent(standardBtn)
								.addComponent(standard_label))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(layoutGroup.createParallelGroup(Alignment.BASELINE)
								.addComponent(student_remove)
								.addComponent(student_Btn)
								.addComponent(student_lbl))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(layoutGroup.createParallelGroup(Alignment.BASELINE)
								.addComponent(child_Btn)
								.addComponent(child_remove)
								.addComponent(child_lbl)))
						.addGroup(layoutGroup.createParallelGroup(Alignment.BASELINE)
							.addComponent(totalpriceLbl)
							.addComponent(standard_remove)))
					.addContainerGap(64, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(layoutGroup);
	}
}
