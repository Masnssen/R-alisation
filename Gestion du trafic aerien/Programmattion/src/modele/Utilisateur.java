package modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import javax.swing.JOptionPane;

public class Utilisateur {
	
	protected int idUtilisateur ;
	protected String pseudo ;
	protected String motDePasse ;
	protected String nom ;
	protected String prenom ;
	protected Poste post ;
	
	public Utilisateur(int idUtilisateur, String pseudo, String motDePasse, String nom, String prenom, Poste post) {

		this.idUtilisateur = idUtilisateur ;
		this.pseudo = pseudo;
		this.motDePasse = motDePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.post = post;
	}
	

    public Utilisateur(String pseudo, String motDePasse, String nom, String prenom, Poste post) {
		super();
		this.pseudo = pseudo;
		this.motDePasse = motDePasse;
		this.nom = nom;
		this.prenom = prenom;
	    this.post = post;
	}

	
	public  int getIdUtilisateur() {
		return idUtilisateur;
	}



	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Poste getPost() {
		return post;
	}

	public void setPost(Poste post) {
		this.post = post;
	}
	public void AjouterUtilisateur() {			

	    Connection cnx = null;
    	PreparedStatement requete = null ;
    	ResultSet resultat = null ;
				
		cnx = ConnexionMySQL.connectDB();	
		String sql = "INSERT INTO utilisateur (PSEUDO, MOTDEPASSE, NOM, PRENOM,POSTE) VALUES (?,?,?,?,?)";
		
		try {
			requete = cnx.prepareStatement(sql);
			requete.setString(1,getPseudo());
			requete.setString(2,getMotDePasse());
			requete.setString(3,getNom());
			requete.setString(4,getPrenom());
			requete.setString(5,getPost().toString());

			requete.execute();
			JOptionPane.showMessageDialog(null, "ajouter avec succes ");
			
		   
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			
			e1.printStackTrace();
		
	}
 }
       public void Modifier() {
		
	    Connection cnx = null;
    	PreparedStatement requete = null ;
    	ResultSet resultat = null ;
		cnx = ConnexionMySQL.connectDB();	
		String sql = "UPDATE utilisateur SET PSEUDO = ? , MOTDEPASSE = ? , NOM = ? , PRENOM = ?, POSTE = ? WHERE IDUTILISATEUR = "+getIdUtilisateur();
		
		try {
			requete = cnx.prepareStatement(sql);
			requete.setString(1,getPseudo().toString());
			requete.setString(2,getMotDePasse().toString());
			requete.setString(3,getNom().toString());
			requete.setString(4,getPrenom().toString());
			requete.setString(5,getPost().toString());
			
			requete.execute();
			JOptionPane.showMessageDialog(null, "Modifier avec succes ");
			
		   
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			
			e1.printStackTrace();
		}		
	}
	  public void Supprimer() {
			
		     Connection cnx = null;
	    	PreparedStatement requete = null ;
	    	ResultSet resultat = null ;
		cnx = ConnexionMySQL.connectDB();	
		String sql = "DELETE FROM utilisateur WHERE IDUTILISATEUR = "+getIdUtilisateur();
		
		try {
			requete = cnx.prepareStatement(sql);
			requete.execute();
			JOptionPane.showMessageDialog(null, "supprimer avec succes ");
			
		   
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			
			e1.printStackTrace();
		}
		
	}
	  public static ArrayList<Utilisateur> listeUtilisateur() {
		   Connection cnx = null;
		   	PreparedStatement requete = null ;
		   	ResultSet resultat = null ;
		   	ArrayList<Utilisateur> listeUtilisateur = new ArrayList<Utilisateur>();
			   
				cnx = ConnexionMySQL.connectDB();	
				String sql = "SELECT * FROM utilisateur";

				try {
					requete = cnx.prepareStatement(sql);
					resultat = requete.executeQuery();
					while(resultat.next()) {
						
						if(resultat.getString("Poste").equals("CONTROLEUR_AERIEN"))
						      listeUtilisateur.add(new Utilisateur(Integer.parseInt(resultat.getString("IDUTILISATEUR")),resultat.getString("PSEUDO"),resultat.getString("MOTDEPASSE"),resultat.getString("NOM"), resultat.getString("PRENOM"), Poste.CONTROLEUR_AERIEN)) ;
						else
							if(resultat.getString("Poste").equals("INGENIEUR_PREPARATEUR_DE_VOL"))
							      listeUtilisateur.add(new Utilisateur(Integer.parseInt(resultat.getString("IDUTILISATEUR")),resultat.getString("PSEUDO"),resultat.getString("MOTDEPASSE"),resultat.getString("NOM"), resultat.getString("PRENOM"),Poste.INGENIEUR_PREPARATEUR_DE_VOL)) ;		
							else 
								if(resultat.getString("Poste").equals("COORDINATEUR_DE_VOL"))
								      listeUtilisateur.add(new Utilisateur(Integer.parseInt(resultat.getString("IDUTILISATEUR")),resultat.getString("PSEUDO"),resultat.getString("MOTDEPASSE"),resultat.getString("NOM"), resultat.getString("PRENOM"),Poste.COORDINATEUR_DE_VOL)) ;		
								else 
									if(resultat.getString("Poste").equals("RESPONSABLE_D_EXPLOITATION_AEROPORTUAIRE"))
									      listeUtilisateur.add(new Utilisateur(Integer.parseInt(resultat.getString("IDUTILISATEUR")),resultat.getString("PSEUDO"),resultat.getString("MOTDEPASSE"),resultat.getString("NOM"), resultat.getString("PRENOM"),Poste.RESPONSABLE_D_EXPLOITATION_AEROPORTUAIRE));  		
									else
										if(resultat.getString("Poste").equals("INGENIEUR_OPERATION_DE_VOL"))
										      listeUtilisateur.add(new Utilisateur(Integer.parseInt(resultat.getString("IDUTILISATEUR")),resultat.getString("PSEUDO"),resultat.getString("MOTDEPASSE"),resultat.getString("NOM"), resultat.getString("PRENOM"),Poste.INGENIEUR_OPERATION_DE_VOL)) ; 		

										else
											if(resultat.getString("Poste").equals("INGENIEUR_SECURITE_AERIEN"))
											      listeUtilisateur.add(new Utilisateur(Integer.parseInt(resultat.getString("IDUTILISATEUR")),resultat.getString("PSEUDO"),resultat.getString("MOTDEPASSE"),resultat.getString("NOM"), resultat.getString("PRENOM"), Poste.INGENIEUR_SECURITE_AERIEN));  		
												else
													if(resultat.getString("Poste").equals("ANALYSTE_DE_VOL"))
													      listeUtilisateur.add(new Utilisateur(Integer.parseInt(resultat.getString("IDUTILISATEUR")),resultat.getString("PSEUDO"),resultat.getString("MOTDEPASSE"),resultat.getString("NOM"), resultat.getString("PRENOM"),Poste.ANALYSTE_DE_VOL))  ;		
													else
		                                               if(resultat.getString("Poste").equals("ADMINISTRATEUR"))
		                     						      listeUtilisateur.add(new Utilisateur(Integer.parseInt(resultat.getString("IDUTILISATEUR")),resultat.getString("PSEUDO"),resultat.getString("MOTDEPASSE"),resultat.getString("NOM"), resultat.getString("PRENOM"), Poste.ADMINISTRATEUR));  		
		 
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return listeUtilisateur;
		   
	   }
}