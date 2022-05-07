package model.commercial;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Fournisseur extends Collaborateur {
	
	public static ArrayList<Fournisseur> listefournisseur = new ArrayList<>();
	private static int cpt = 1;

	public Fournisseur(int idcollaborateur, String nomcollaborateur, String prenomcollaborateur) {
		super(idcollaborateur, nomcollaborateur, prenomcollaborateur);
	}
	public Fournisseur(String nomcollaborateur, String prenomcollaborateur) {
		super(nomcollaborateur, prenomcollaborateur);
	}
	public Fournisseur(int idcollaborateur) {
		super(idcollaborateur);
	}
	public void ajouter() {
		super.setIdcollaborateur(cpt++);
		listefournisseur.add(this);
		
		}
	public void modifier() {
		for (Fournisseur fournisseur : listefournisseur) {
			if(fournisseur.getIdcollaborateur() == getIdcollaborateur()) {
				fournisseur.setNomcollaborateur(getNomcollaborateur());
				fournisseur.setPrenomcollaborateur(getPrenomcollaborateur());
				break;
			}
		}
		JOptionPane.showMessageDialog(null, "Modifier avec succes ");
	}
	public void supprimer() {
		for (Fournisseur fournisseur : listefournisseur) {
			if(fournisseur.getIdcollaborateur() == getIdcollaborateur()) {
				listefournisseur.remove(fournisseur);
				break;
			}
		}
		JOptionPane.showMessageDialog(null, "Supprimer avec succes ");
	}
	public String getType() {
		return "Fournisseur";
	}
	
	public static Fournisseur getFournisseur(String nom) {
		for(int i = 0; i < Fournisseur.listefournisseur.size(); i++) {
			if(Fournisseur.listefournisseur.get(i).getNomcollaborateur().equals(nom)) {
				return Fournisseur.listefournisseur.get(i);
			}
		}
		return new Fournisseur("INCONNU", "INCONNU");
		
	}
}
