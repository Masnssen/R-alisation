package controle.pharmacien;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Vue.Pharmacien.PanneauPharmacien;
import model.pharmacien.MatierePremiere;
import model.pharmacien.TypeMedicament;

public class ControleurPharmacien implements ActionListener, ListSelectionListener {
	
	private PanneauPharmacien vue;
	private MatiereListeModel type;
	private MatiereListeModel mat;
	
	
	public ControleurPharmacien(PanneauPharmacien vue) {
		this.vue = vue;
		
		type = new MatiereListeModel("Type medicament");
		mat = new MatiereListeModel("Matiere premiere");
		//Les tableau
		vue.getTableMatPrem().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		vue.getTableMatPrem().getSelectionModel().addListSelectionListener(this);
		
		vue.getTableTypeMed().getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		vue.getTableTypeMed().getSelectionModel().addListSelectionListener(this);
		
		vue.getTableMatPrem().setModel(mat);
		vue.getTableMatPrem().repaint();
		
		vue.getTableTypeMed().setModel(type);
		vue.getTableTypeMed().repaint();
		
		//Les buttons
		vue.getBtnAjouter().addActionListener(this);
		vue.getBtnModifier().addActionListener(this);
		vue.getBtnSupprimer().addActionListener(this);
		
		vue.getBtnAjouterType().addActionListener(this);
		vue.getBtnModifierType().addActionListener(this);
		vue.getBtnSupprimerType().addActionListener(this);
		
		vue.getBtnNouvelleMatiere().addActionListener(this);
		vue.getBtnNouveauType().addActionListener(this);
		
		
		vue.getBtnModifier().setEnabled(false);
		vue.getBtnSupprimer().setEnabled(false);
		
		vue.getBtnNouvelleMatiere().setEnabled(false);
		vue.getBtnNouveauType().setEnabled(false);
		vue.getBtnModifierType().setEnabled(false);
		vue.getBtnSupprimerType().setEnabled(false);
		
		//Les id 
		vue.getTextId().setText(String.valueOf(MatierePremiere.id + 1));
		
		vue.getTextIdType().setText(String.valueOf(TypeMedicament.id));
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Ajouter matiere")) {
			if(vue.getTextNom().getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "Voullez remplire le nom de la matiere");
			}else {
				MatierePremiere matPrem = new MatierePremiere(vue.getTextNom().getText());
				MatierePremiere.getListeMatiere().add(matPrem);
				vue.getTableMatPrem().revalidate();
				
				//reitialiser l'id et le nom 
				vue.getTextId().setText(String.valueOf(MatierePremiere.id + 1));
				vue.getTextNom().setText("");
			}
			
			
		}else if(e.getActionCommand().equals("Modifier matiere")) {
			int index = vue.getTableMatPrem().getSelectedRow();
			if(index > -1) {
				if(vue.getTextNom().getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Voullez remplire le nom de la matiere");
				}else {
					vue.getTextId().setText(MatierePremiere.getListeMatiere().get(index).getNomMatiere());
					MatierePremiere.getListeMatiere().get(index).setNomMatiere(vue.getTextNom().getText());
					vue.getTableMatPrem().revalidate();
					vue.getTableMatPrem().repaint();	
				}
				vue.getTextId().setText(MatierePremiere.getListeMatiere().get(index).getNomMatiere());
				MatierePremiere.getListeMatiere().get(index).setNomMatiere(vue.getTextNom().getText());
				vue.getTableMatPrem().revalidate();
				vue.getTableMatPrem().repaint();
				
				//reitialiser l'id et le nom 
				vue.getTextId().setText(String.valueOf(MatierePremiere.id + 1));
				vue.getTextNom().setText("");
				
				//Les buttons
				vue.getBtnAjouter().setEnabled(true);
				vue.getBtnModifier().setEnabled(false);
				vue.getBtnSupprimer().setEnabled(false);
				vue.getBtnNouvelleMatiere().setEnabled(false);
			}
			
		}else if(e.getActionCommand().equals("Supprimer matiere")) {
			int index = vue.getTableMatPrem().getSelectedRow();
			if(index > -1) {
				MatierePremiere.getListeMatiere().remove(index);
				vue.getTableMatPrem().revalidate();
				
				//reinitialiser id et nom
				vue.getTextId().setText(String.valueOf(MatierePremiere.id + 1));
				vue.getTextNom().setText("");
				
				//Les buttons
				vue.getBtnAjouter().setEnabled(true);
				vue.getBtnModifier().setEnabled(false);
				vue.getBtnSupprimer().setEnabled(false);
				vue.getBtnNouvelleMatiere().setEnabled(false);
			}
			
			
		}else if(e.getActionCommand().equals("Ajouter type")) {
			if(vue.getTextLabel().getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "Voullez remplire le label du type");
			}else {
				TypeMedicament typeMed = new TypeMedicament(vue.getTextLabel().getText(),vue.getTextDescription().getText());
				TypeMedicament.getListType().add(typeMed);
				
				vue.getTableTypeMed().revalidate();
				
				//Reinitialiser id label et description
				vue.getTextIdType().setText(String.valueOf(TypeMedicament.id));
				vue.getTextLabel().setText("");
				vue.getTextDescription().setText("");
			}
			
			
			
		}else if(e.getActionCommand().equals("Modifier type")) {
			int index = vue.getTableTypeMed().getSelectedRow();
			if(index > -1) {
				if(vue.getTextLabel().getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "Voullez remplire le label du type");
				}else {
					TypeMedicament.getListType().get(index).setLabel(vue.getTextLabel().getText());
					TypeMedicament.getListType().get(index).setDescription(vue.getTextDescription().getText());
					vue.getTableTypeMed().revalidate();
					vue.getTableTypeMed().repaint();
					
					//Reinitialiser id label et description
					vue.getTextIdType().setText(String.valueOf(TypeMedicament.id));
					vue.getTextLabel().setText("");
					vue.getTextDescription().setText("");
					
					//Les buttons
					vue.getBtnAjouterType().setEnabled(true);
					vue.getBtnModifierType().setEnabled(false);
					vue.getBtnSupprimerType().setEnabled(false);
					vue.getBtnNouveauType().setEnabled(false);
				}
				
			}
		}else if(e.getActionCommand().equals("Supprimer type")) {
			int index = vue.getTableTypeMed().getSelectedRow();
			if(index > -1) {
				TypeMedicament.getListType().remove(index);
				vue.getTableTypeMed().revalidate();
				
				//Reinitialiser id label et description
				vue.getTextIdType().setText(String.valueOf(TypeMedicament.id));
				vue.getTextLabel().setText("");
				vue.getTextDescription().setText("");
				//Les buttons
				vue.getBtnAjouterType().setEnabled(true);
				vue.getBtnModifierType().setEnabled(false);
				vue.getBtnSupprimerType().setEnabled(false);
				vue.getBtnNouveauType().setEnabled(false);
			}
			
			
		}else if(e.getActionCommand().equals("Nouvelle matiere")) {
			
			vue.getTextId().setText(String.valueOf(MatierePremiere.id + 1));
			vue.getTextNom().setText("");
			
			vue.getBtnAjouter().setEnabled(true);
			vue.getBtnModifier().setEnabled(false);
			vue.getBtnSupprimer().setEnabled(false);
			vue.getBtnNouvelleMatiere().setEnabled(false);
		}else if(e.getActionCommand().equals("Nouveau type")) {
			//Reinitialiser id label et description
			vue.getTextIdType().setText(String.valueOf(TypeMedicament.id));
			vue.getTextLabel().setText("");
			vue.getTextDescription().setText("");
			
			//Les buttons
			vue.getBtnAjouterType().setEnabled(true);
			vue.getBtnModifierType().setEnabled(false);
			vue.getBtnSupprimerType().setEnabled(false);
			vue.getBtnNouveauType().setEnabled(false);
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		int index;
		if(e.getSource() == vue.getTableMatPrem().getSelectionModel()) {
			index = vue.getTableMatPrem().getSelectedRow();
			//afficher l'id et le nom
			vue.getTextId().setText(String.valueOf(MatierePremiere.getListeMatiere().get(index).getIdMatiere()));
			vue.getTextNom().setText(MatierePremiere.getListeMatiere().get(index).getNomMatiere());
			
			//Les buttons
			vue.getBtnAjouter().setEnabled(false);
			vue.getBtnModifier().setEnabled(true);
			vue.getBtnSupprimer().setEnabled(true);
			vue.getBtnNouvelleMatiere().setEnabled(true);
		}else {
			index = vue.getTableTypeMed().getSelectedRow();
			//Afficher id et nom et description
			vue.getTextIdType().setText(String.valueOf(TypeMedicament.getListType().get(index).getId()));
			vue.getTextLabel().setText(TypeMedicament.getListType().get(index).getLabel());
			vue.getTextDescription().setText(TypeMedicament.getListType().get(index).getDescription());
			
			//Les buttons
			vue.getBtnAjouterType().setEnabled(false);
			vue.getBtnModifierType().setEnabled(true);
			vue.getBtnSupprimerType().setEnabled(true);
			vue.getBtnNouveauType().setEnabled(true);
			
		}
	}


	
}
