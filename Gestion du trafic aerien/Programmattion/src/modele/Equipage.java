package modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Equipage {
	
	protected int idEquipage ;
	protected String libele ;
	/**
	 * Constructeur
	 * @param idEquipage
	 * @param libele
	 */
	public Equipage(int idEquipage, String libele) {
		super();
		this.idEquipage = idEquipage;
		this.libele = libele;
	}
	/**
	 * Constructeur
	 * @param libele
	 */
	public Equipage(String libele) {
		
		this.libele = libele;
	}
	/**
	 * getter de l'id de l'equipage
	 * @return int
	 */
	public int getIdEquipage() {
		return idEquipage;
	}
	/**
	 * getter du libel
	 * @return String
	 */
	public String getLibele() {
		return libele;
	}
	/**
	 * fonction pour ajouter un equipage a la base de donnée
	 */
	 public void AjouterEquipage() {			

		    Connection cnx = null;
	    	PreparedStatement requete = null ;
	    	ResultSet resultat = null ;
					
			cnx = ConnexionMySQL.connectDB();	
			String sql = "INSERT INTO Equippage(LIBELLEREQUIPPAGE) VALUES(?)";
			
			try {
				requete = cnx.prepareStatement(sql);
				requete.setString(1,getLibele());

				requete.execute();
				JOptionPane.showMessageDialog(null, "ajouter avec succes ");
				
			   
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				
				e1.printStackTrace();
			
		}
	 }
	 /**
	  * fonction pour modifier un equipage de la base de donnée
	  */
	 public void Modifier() {
			
		    Connection cnx = null;
	    	PreparedStatement requete = null ;
	    	ResultSet resultat = null ;
			cnx = ConnexionMySQL.connectDB();	
			String sql = "UPDATE Equippage SET IDEQUIPPAGE = ? , LIBELLEREQUIPPAGE = ? , WHERE IDEQUIPPAGE = "+getIdEquipage();
			
			try {
				requete = cnx.prepareStatement(sql);
				requete.setInt(1,getIdEquipage());
				requete.setString(2,getLibele());
				
				requete.execute();
				JOptionPane.showMessageDialog(null, "Modifier avec succes ");
				
			   
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				
				e1.printStackTrace();
			}		
		}
	 /**
	  * fonction pour supprimer un equipage de la base de donnée
	  */
	  public void Supprimer() {
			
		     Connection cnx = null;
	    	PreparedStatement requete = null ;
	    	ResultSet resultat = null ;
		cnx = ConnexionMySQL.connectDB();	
		String sql = "DELETE FROM Equippage WHERE IDEQUIPPAGE = "+getIdEquipage();
		
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
