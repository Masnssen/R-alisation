package modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import net.proteanit.sql.DbUtils;


public class Connexion {
	
	protected String pseudo ;
	protected String motPasse ;
	protected Poste poste ;
	protected ArrayList<Utilisateur> listeUtilisateurs ;
	
	/**
	 * Constructeur
	 * @param pseudo
	 * @param motPasse
	 * @param poste
	 */
	public Connexion(String pseudo, String motPasse, Poste poste) {
		super();
		this.pseudo = pseudo ;
		this.motPasse = motPasse ;
		this.poste = poste ;
		
	}
    /**
     * getter du pseudo
     * @return String
     */
	public String getPseudo() {
		return pseudo;
	}
	/**
	 * getter du mot de passe 
	 * @return String
	 */
	public String getMotPasse() {
		return motPasse;
	}
	/**
	 * getter du poste
	 * @return Poste
	 */
	public Poste getPoste() {
		return poste;
	}
	/**
	 * fonction qui verifier si l'utilisateur exite
	 * @return boolean
	 */
	public boolean existe() {
		   Connection cnx = null;
	    	PreparedStatement requete = null ;
	    	ResultSet resultat = null ;
			cnx = ConnexionMySQL.connectDB();	
			String sql = "select * from utilisateur WHERE POSTE ='"+poste.toString()+"'";

			try {
				requete = cnx.prepareStatement(sql);
				resultat = requete.executeQuery();
				while(resultat.next()) {
					 if(resultat.getString("PSEUDO").equals(pseudo)  && resultat.getString("MOTDEPASSE").equals(motPasse))
						 return true ;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		
		}
}