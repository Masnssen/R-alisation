package modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class Attribution {
	
	protected int idAttribution ;
	protected Fonction fonction ;
	protected Membre membreEquipe;
	protected String dateattribution ;
	
	/**
	 * contructeur
	 * @param idMembreEquipe
	 * @param Fonction
	 * @param date
	 */
	public Attribution(int idMembreEquipe,Fonction Fonction,String date) {

		 initMembre(idMembreEquipe);
		 this.fonction = Fonction;
		this.dateattribution = date;
	}
	/**
	 * constructeur
	 * @param idAttribution
	 * @param idMembreEquipe
	 * @param Fonction
	 * @param date
	 */
     public Attribution(int idAttribution,int idMembreEquipe,Fonction Fonction,String date) {
		super();
		this.idAttribution = idAttribution;
		initMembre(idMembreEquipe);
		this.fonction = Fonction;
		this.dateattribution = date;
	}
     /**
      *avoir une Membre d'equipe grace a l'id du membre que on utilisera dans le constructeur qui va etre rechercher dans la base de donnée

      * @param idMembre
      */
     private void initMembre(int idMembre) {
		
		Connection cnx = null;
		PreparedStatement requete = null ;
		ResultSet resultat = null ;
	
		cnx = ConnexionMySQL.connectDB();	
		String sql = "SELECT * FROM membre WHERE IDMEMBRE = "+idMembre ;
		
		try {
			requete = cnx.prepareStatement(sql);
			resultat = requete.executeQuery();
			while(resultat.next()) {
		this.membreEquipe = new Membre(resultat.getInt("IDMEMBRE"),resultat.getString("NOMMEMBRE"), resultat.getInt("NBHEUREVOL"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
	}
     /**
      * getter de la fonction
      * @return Fonction
      */
	 public Fonction getFonction() {
		return fonction;
	}
	 /**
	  * getter du membre d'equipe
	  * @return Membre
	  */
	public Membre getMembreEquipe() {
		return membreEquipe;
	}
	/**
	 * getter de la date d'attribution
	 * @return String
	 */
	public String getDateattribution() {
		return dateattribution;
	}
	/**
	 * getter de l'id de l'attribution
	 * @return int
	 */
	public int getIdAttribution() {
		return idAttribution;
	}
	/**
	 * fonction pour ajouter une attribution dans la base de donnée
	 */
	public void Ajouter() {			

		    Connection cnx = null;
	    	PreparedStatement requete = null ;
	    	ResultSet resultat = null ;
					
			cnx = ConnexionMySQL.connectDB();	
			String sql = "INSERT INTO Attribution(IDMEMBRE,FONCTION,DAT) VALUES(?,?,?)";
			
			try {
				requete = cnx.prepareStatement(sql);
				requete.setInt(1,getMembreEquipe().getIdMembre());
				requete.setString(2,getFonction().toString());
				requete.setString(3,getDateattribution());				

				requete.execute();
				JOptionPane.showMessageDialog(null, "ajouter avec succes ");
				
			   
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				
				e1.printStackTrace();
			
		}
	 }
	/**
	 * fonction pour modifier une attribution dans la base de donnée
	 */

	 public void Modifier() {
			
		 Connection cnx = null;
	    	PreparedStatement requete = null ;
					
			cnx = ConnexionMySQL.connectDB();	
			String sql = "UPDATE Attribution SET IDMEMBRE = ? , FONCTION = ? , dat =? WHERE IDATTRIBUTION = "+getIdAttribution();
			
			try {
				requete = cnx.prepareStatement(sql);
				requete.setInt(1,getMembreEquipe().getIdMembre());
				requete.setString(2,getFonction().toString());
				requete.setString(3,getDateattribution().toString());				

				requete.execute();
				JOptionPane.showMessageDialog(null, "Modifier avec succes ");
				
			   
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				
				e1.printStackTrace();
			
		}
		}
	 /**
	  * fonction pour supprimer une attribution dans la base de donnée
	  */
	  public void Supprimer() {
			
		     Connection cnx = null;
	    	PreparedStatement requete = null ;
	    	ResultSet resultat = null ;
		cnx = ConnexionMySQL.connectDB();	
		String sql = "DELETE FROM Attribution WHERE IDATTRIBUTION = "+getIdAttribution();
		
		try {
			requete = cnx.prepareStatement(sql);
			requete.execute();
			JOptionPane.showMessageDialog(null, "supprimer avec succes ");
			
		   
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			
			e1.printStackTrace();
		}
		
	}
}
