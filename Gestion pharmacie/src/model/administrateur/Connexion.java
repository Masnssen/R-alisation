package model.administrateur;

public class Connexion {
	
	private String Pseudo;
	private String password;
	private String poste;
	public Connexion(String Pseudo, String password,String poste) {
		super();
		this.Pseudo = Pseudo;
		this.password = password;
		this.poste = poste;
	}
		
	public String getPseudo() {
		return Pseudo;
	}

	public String getPassword() {
		return password;
	}
	public String getPoste() {
		return poste;
	}

	public boolean verifierConnexion() {
		boolean trouver=false;int i = 0;
		while(i<Compte.listecompte.size()&&trouver==false) {
			if(getPseudo().equals(Compte.getListecompte().get(i).getUser())&&
					getPassword().equals(Compte.getListecompte().get(i).getPassword())
					&&getPoste().equals(Compte.getListecompte().get(i).getFonction())) {
				trouver=true;					
			}else {
				i++;
			}
		}
		if(trouver) {
			return true;
		}
		return false;
	}
}
