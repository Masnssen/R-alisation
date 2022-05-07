package modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class Aeroport {
	
	protected String idAeroport ;
	protected String nomAeroport ;
	protected String pays ;
	
	/**
	 * constructeur
	 * @param nomAeroport
	 * @param pays
	 */
	public Aeroport( String nomAeroport, String pays) {
		
		this.nomAeroport = nomAeroport;
		this.pays = pays;
	}
	/**
	 * constructeur
	 * @param idAeroport
	 * @param nomAeroport
	 * @param pays
	 */
	public Aeroport(String idAeroport, String nomAeroport, String pays) {
		super();
		this.idAeroport = idAeroport;
		this.nomAeroport = nomAeroport;
		this.pays = pays;
	}
	/**
	 * getter du non de l'aeroport
	 * @return
	 */
	public String getNomAeroport() {
		return nomAeroport;
	}
	/**
	 * getter de du pays 	
	 * @return pays
	 */
	public String getPays() {
		return pays;
	}
	/**
	 * getter de l'id de l'aeroport
	 * @return ideroport
	 */
	public String getIdAeroport() {
		return idAeroport;
	}
	
	/**
	 * fonction pour ajouter un aeroport a la base de donnée
	 */
	 public void  AjouterAeroport() {
			
	    	Connection cnx = null;
	    	PreparedStatement requete = null ;
	    	ResultSet resultat = null ;
	    	
			cnx = ConnexionMySQL.connectDB();	
			String sql = "INSERT INTO Aeroport (idAeroport,NOMAEROPORT,PAYS) VALUES(?,?,?)";
			
			try {
				requete = cnx.prepareStatement(sql);
				requete.setString(1,getIdAeroport().toString());
				requete.setString(2,getNomAeroport().toString());
				requete.setString(3,getPays().toString());
				requete.execute();
				JOptionPane.showMessageDialog(null, "ajouter avec succes ");
				
			   
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				
				e1.printStackTrace();
			}		
			
	    }
	 /**
	  * fonction pour modifier un aeroport de la base de donnée
	  */
	    public void Modifier() {
	    	
	    	Connection cnx = null;
	    	PreparedStatement requete = null ;
	    	ResultSet resultat = null ;
	    		
			cnx = ConnexionMySQL.connectDB();	
			String sql = "UPDATE Aeroport   SET idAeroport = ?, NOMAEROPORT = ? , PAYS = ? WHERE idAeroport  = '"+getIdAeroport()+"'";
			
			try {
				requete = cnx.prepareStatement(sql);
				requete.setString(1,getIdAeroport().toString());
				requete.setString(2,getNomAeroport().toString());
				requete.setString(3,getPays().toString());
				requete.execute();
				JOptionPane.showMessageDialog(null, "Modifier avec succes ");
				
			   
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				
				e1.printStackTrace();
			}		
		}
	    /**
	     * fonction pour supprimer un aeroport de la base de donnée
	     */
	    public void Supprimer() {
			
	    	Connection cnx = null;
	    	PreparedStatement requete = null ;
	    	ResultSet resultat = null ;
	    	
	    	cnx = ConnexionMySQL.connectDB();	
			String sql = "DELETE FROM Aeroport WHERE IDAEROPORT = '"+getIdAeroport()+"'";
			
			try {
				requete = cnx.prepareStatement(sql);
				requete.execute();
				JOptionPane.showMessageDialog(null, "supprimer avec succes ");
				
			   
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				
				e1.printStackTrace();
			}
			
		}
	    /**
	     * fonction qui retourn la liste d'aeroport de la base de donnée
	     * @return ArrayList<Aeroport>
	     */
	    public static ArrayList<Aeroport> listeAeroport() {
	 	   Connection cnx = null;
	 	   	PreparedStatement requete = null ;
	 	   	ResultSet resultat = null ;
	 	   	ArrayList<Aeroport> listeAeroport = new ArrayList<Aeroport>();
	 		   
	 			cnx = ConnexionMySQL.connectDB();	
	 			String sql = "SELECT * FROM Aeroport";

	 			try {
	 				requete = cnx.prepareStatement(sql);
	 				resultat = requete.executeQuery();
	 				while(resultat.next()) {
	 					listeAeroport.add(new Aeroport(resultat.getString("idAeroport"), resultat.getString("NOMAEROPORT"),resultat.getString("PAYS")));
	 				}
	 			} catch (SQLException e) {
	 				// TODO Auto-generated catch block
	 				e.printStackTrace();
	 			}
	 	return listeAeroport;
	 	   
	    }
}
	   

