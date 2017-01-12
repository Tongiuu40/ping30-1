package maquette;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.GridBagLayout;

import javax.swing.JTextField;

import java.awt.GridBagConstraints;

import javax.swing.JCheckBox;

import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JButton;

import org.jdatepicker.DateModel;
import org.jdatepicker.JDatePicker;

public class ssssssssss extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ssssssssss frame = new ssssssssss();
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
	public ssssssssss() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cours");
		lblNewLabel.setBounds(5, 23, 35, 16);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(5, 40, 527, 22);
		contentPane.add(comboBox);
		
		JLabel lblCours = new JLabel("Cours:");
		lblCours.setBounds(5, 91, 81, 16);
		contentPane.add(lblCours);
		
		textField = new JTextField();
		textField.setBounds(128, 88, 404, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enseignant");
		lblNewLabel_1.setBounds(5, 144, 94, 16);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(128, 141, 404, 22);
		contentPane.add(comboBox_1);
		
		JLabel lblSalle = new JLabel("Salle");
		lblSalle.setBounds(5, 198, 63, 16);
		contentPane.add(lblSalle);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(128, 195, 404, 22);
		contentPane.add(comboBox_2);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(5, 251, 63, 16);
		contentPane.add(lblDate);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(128, 248, 404, 22);
		contentPane.add(comboBox_3);
	
		JButton btnEnseigner = new JButton("Enseigner");
		btnEnseigner.setBounds(265, 317, 103, 25);
		contentPane.add(btnEnseigner);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(388, 317, 103, 25);
		contentPane.add(btnAnnuler);
	}
}
