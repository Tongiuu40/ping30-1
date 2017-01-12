package maquette;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import DAO.CoursDAO;
import DAO.EnseignantDAO;
import DAO.EtudiantDAO;
import DAO.PresenceEtudiantDAO;
import DAO.SalleDAO;
import ping30.Cours;
import ping30.DateLabelFormatter;
import ping30.Enseignant;
import ping30.Etudiant;
import ping30.PresenceEtudiant;
import ping30.Salle;

public class FModifier extends JFrame implements ItemListener,ActionListener {
	JPanel contentPane = new JPanel();
	private JTextField textField;
	public FModifier(){
		
	}
	public FModifier(String s1,String s2){
		
	}
	public void CFModCours() throws ParseException{
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
		
		/*JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(128, 248, 404, 22);
		contentPane.add(comboBox_3);*/
		
		
				
		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl hDatePanelImpl = new JDatePanelImpl(model, p);
		JDatePickerImpl datePicker = new JDatePickerImpl(hDatePanelImpl, new DateLabelFormatter());
		contentPane.add(datePicker);
		
		JButton btnEnseigner = new JButton("Enseigner");
		btnEnseigner.setBounds(265, 317, 103, 25);
		contentPane.add(btnEnseigner);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(388, 317, 103, 25);
		contentPane.add(btnAnnuler);
	
		 ArrayList<Cours> listcours = new ArrayList<Cours>();
		 CoursDAO coursDAO = new CoursDAO();
		 listcours = coursDAO.getAll();
		   for (Cours cours : listcours) {
	        comboBox.addItem(cours);  
	       
	    	 comboBox.addItemListener(new ItemListener() {
				
				@Override
				public void itemStateChanged(ItemEvent e) {
					// TODO Auto-generated method stub
					  if(e.getStateChange() == ItemEvent.SELECTED)
			             {
						  Cours co = (Cours) comboBox.getSelectedItem();
						  textField.setText(co.getNomCours());
			               // comboBox_3.setSelectedItem(co.getDateCours());
			             }
				}
			});
			}
		 
		 ArrayList<Enseignant> listEN = new ArrayList<Enseignant>();
		 EnseignantDAO enDao = new EnseignantDAO();
		 listEN = enDao.getAll();
		 for (Enseignant enseignant : listEN){
			 comboBox_1.addItem(enseignant.getNomEnseignant()+" "+enseignant.getPrenomEnseignant());
			 
		 }
		 
		 ArrayList<Salle> listSalle = new ArrayList<Salle>();
		 SalleDAO salleDAO = new SalleDAO();
		 listSalle = salleDAO.getAll();
		 for (Salle salle:listSalle){
			 comboBox_2.addItem(salle.getNomSalle());
		 }
		 
		 
		
	}
	
	public static void main(String[] args) throws ParseException {
		FModifier fModifier = new FModifier();
		fModifier.CFModCours();
		fModifier.setVisible(true);
	}
	
   

	
	public Salle CrSalle(){
		Salle newSalle = new Salle();
		SalleDAO mSalleDAO = new SalleDAO();
		mSalleDAO.create(newSalle);
		return newSalle;

	}
	public void SupSalle(){
		Salle newSalle = new Salle();
		SalleDAO mSalleDAO = new SalleDAO();
		mSalleDAO.delete(newSalle);
	}
	public Salle ModSalle(){
		Salle newSalle = new Salle();
		SalleDAO mSalleDAO = new SalleDAO();
		mSalleDAO.update(newSalle);
		return newSalle;
	}
	
	
	public Cours CrCours(){
		Cours newCour = new Cours();
		CoursDAO mCoursDAO =  new CoursDAO();
		mCoursDAO.create(newCour);
		return newCour;
	}
	public void SupCours(){
		Cours newCour = new Cours();
		CoursDAO mCoursDAO =  new CoursDAO();
		mCoursDAO.delete(newCour);
	}
	public Cours ModCours(){
		Cours newCour = new Cours();
		CoursDAO mCoursDAO =  new CoursDAO();
		mCoursDAO.update(newCour);
		return newCour;
	}
	
	public Etudiant CrEtudiant(){
		Etudiant newEtudiant = new Etudiant();
		EtudiantDAO mEtudiantDAO = new EtudiantDAO();
		mEtudiantDAO.create(newEtudiant);
		return newEtudiant;
	}
	public void SupEtudiant(){
		Etudiant newEtudiant = new Etudiant();
		EtudiantDAO mEtudiantDAO = new EtudiantDAO();
		mEtudiantDAO.delete(newEtudiant);
	}
	public Etudiant ModEtudiant(){
		Etudiant newEtudiant = new Etudiant();
		EtudiantDAO mEtudiantDAO = new EtudiantDAO();
		mEtudiantDAO.update(newEtudiant);
		return newEtudiant;
	}
	
	public Enseignant CrEnseignant(){
		Enseignant newEnseignant = new Enseignant();
		EnseignantDAO mEnseignantDAO = new EnseignantDAO();
		mEnseignantDAO.create(newEnseignant);
		return newEnseignant;
	}
	public void SupEnseignant(){
		Enseignant newEnseignant = new Enseignant();
		EnseignantDAO mEnseignantDAO = new EnseignantDAO();
		mEnseignantDAO.delete(newEnseignant);
	}
	public Enseignant ModEnseignant(){
		Enseignant newEnseignant = new Enseignant();
		EnseignantDAO mEnseignantDAO = new EnseignantDAO();
		mEnseignantDAO.update(newEnseignant);
		return newEnseignant;
	}
	
	public PresenceEtudiant CrListe(){
		PresenceEtudiant nPresenceEtudiant = new PresenceEtudiant();
		PresenceEtudiantDAO mPresenceEtudiantDAO = new PresenceEtudiantDAO();
		mPresenceEtudiantDAO.create(nPresenceEtudiant);
		return nPresenceEtudiant;
	}
	public void SupListe(){
		PresenceEtudiant nPresenceEtudiant = new PresenceEtudiant();
		PresenceEtudiantDAO mPresenceEtudiantDAO = new PresenceEtudiantDAO();
		mPresenceEtudiantDAO.delete(nPresenceEtudiant);
	}
	public PresenceEtudiant ModListe(){
		PresenceEtudiant nPresenceEtudiant = new PresenceEtudiant();
		PresenceEtudiantDAO mPresenceEtudiantDAO = new PresenceEtudiantDAO();
		mPresenceEtudiantDAO.update(nPresenceEtudiant);
		return nPresenceEtudiant;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
