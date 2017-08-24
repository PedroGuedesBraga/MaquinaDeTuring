package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class TMS extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private int pos=0;
	String alfa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TMS frame = new TMS();
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
	public TMS() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		textField = new JTextField();
		textField.setBounds(10, 11, 258, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 95, 161, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(190, 95, 221, 14);
		contentPane.add(lblNewLabel_2);
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(173, 89, 15, 23);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setLocation(-10, 93);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("ok");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pos = 0;
				alfa = textField.getText();
				lblNewLabel.setText("");
				lblNewLabel_1.setText(alfa.substring(0, 1));
				lblNewLabel_2.setText(alfa.substring(1));
				
			}
		});
		btnNewButton.setBounds(10, 42, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton(">>>");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pos++;
				lblNewLabel.setText(alfa.substring(0, pos));
				lblNewLabel_1.setText(alfa.substring(pos, pos+1));
				lblNewLabel_2.setText(alfa.substring(pos+1));
				
			}
		});
		btnNewButton_1.setBounds(308, 146, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("<<<");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pos--;
				lblNewLabel.setText(alfa.substring(0, pos));
				lblNewLabel_1.setText(alfa.substring(pos, pos+1));
				lblNewLabel_2.setText(alfa.substring(pos+1));
			}
		});
		btnNewButton_2.setBounds(10, 146, 89, 23);
		contentPane.add(btnNewButton_2);
		

	}
}
