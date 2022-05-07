package modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class Piste  {
	
	protected int IdPiste ;
	protected double Longeur ;
	protected Aeroport aeroport;
	
	/**
	 * Constructeur
	 * @param longeur
	 * @param idAeroport
	 */
	
	public Piste ( double longeur,String idAeroport) {
		
		this.Longeur = longeur;
		initAeroport(idAeroport);
	}
	
	/**
	 * Constructeur
	 * @param idPiste
	 * @param longeur
	 * @param idAeroport
	 */
	public Piste(int idPiste, double longeur,String idAeroport) {
		super();
		IdPiste = idPiste;
		Longeur = longeur;
		initAeroport(idAeroport);
	}
	/**
	 * Constructeur
	 * @param idPiste
	 */
	public Piste(int idPiste) {
		super();
		initpiste(idPiste);
	}
	/**
	 * avoir une piste grace a l'id  
	 * @param idpiste
	 */
	private void initpiste(int idpiste) {

		Connection cnx = null;
		PreparedStatement requete = null ;
		ResultSet resultat = null ;
	
		cnx = ConnexionMySQL.connectDB();	
		String sql = "SELECT * FROM piste WHERE IDpiste ="+idpiste;
		
		try {
			requete = cnx.prepareStatement(sql);
			resultat = requete.executeQuery();
			while(resultat.next()) {
				initAeroport(resultat.getString("idAeroport"));
				this.Longeur = resultat.getDouble("LONGEUR");
				this.IdPiste = idpiste;
			}
			requete.close();
			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}	
	}

	/**
	 * avoir un aeroport grace a l'id 
	 * @param idAeroport
	 */
   private void initAeroport(String idAeroport) {
		
		Connection cnx = null;
		PreparedStatement requete = null ;
		ResultSet resultat = null ;
	
		cnx = ConnexionMySQL.connectDB();	
		String sql = "SELECT * FROM aeroport WHERE IDAEROPORT = '"+idAeroport+"'";
		
		try {
			requete = cnx.prepareStatement(sql);
			resultat = requete.executeQuery();
			while(resultat.next()) {
		this.aeroport = new Aeroport(resultat.getString("IDAEROPORT"), resultat.getString("NOMAEROPORT"), resultat.getString("PAYS"));
			}
			requete.close();
			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}

	}
   /**
    * getter de longeur
    * @return double
    */
	public double getLongeur() {
		return Longeur;
	}
	/**
	 * getter de l'id de piste
	 * @return int
	 */
	public int getIdPiste() {
		return IdPiste;
	}
	/**
	 * getter de l'aerport
	 * @return Aeroport
	 */
    public Aeroport getAeroport() {
		return aeroport;
	}
    /**
     * fonction pour ajouter une piste
     */
	public  void AjouterPiste() {
		
    	Connection cnx = null;
    	PreparedStatement requete = null ;
    	ResultSet resultat = null ;
    	
		cnx = ConnexionMySQL.connectDB();	
		String sql = "INSERT INTO PISTE (LONGEUR,idAeroport) VALUES(?,?)";
		
		try {
			requete = cnx.prepareStatement(sql);
			requete.setDouble(1,getLongeur());
			requete.setString(2,getAeroport().getIdAeroport());
			requete.execute();
			JOptionPane.showMessageDialog(null, "ajouter avec succes ");
			requete.close();
			cnx.close();
			
		   
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			
			e1.printStackTrace();
		}		
		
    }
	/**
	 * fonction pour modifier une piste
	 */
    public void Modifier() {
    	
    	Connection cnx = null;
    	PreparedStatement requete = null ;
    	ResultSet resultat = null ;
    		
		cnx = ConnexionMySQL.connectDB();	
		String sql = "UPDATE PISTE SET LONGEUR = ?,idAeroport = ? WHERE IDPISTE = "+getIdPiste();
		
		try {
			requete = cnx.prepareStatement(sql);
			//requete.setString(1,getEtat().toString());
			requete.setDouble(1,getLongeur());
			requete.setString(2,getAeroport().getIdAeroport());
			requete.execute();
			JOptionPane.showMessageDialog(null, "Modifier avec succes ");
			
			requete.close();
			cnx.close();
			
		   
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			
			e1.printStackTrace();
		}		
	}
    /**
     * fonction pour supprimer une piste
     */
    public void Supprimer() {
		
    	Connection cnx = null;
    	PreparedStatement requete = null ;
    	ResultSet resultat = null ;
    	
    	cnx = ConnexionMySQL.connectDB();	
		String sql = "DELETE FROM PISTE WHERE IDPISTE = "+getIdPiste();
		
		try {
			requete = cnx.prepareStatement(sql);
			requete.execute();
			JOptionPane.showMessageDialog(null, "supprimer avec succes ");
			
			requete.close();
			cnx.close();
			
		   
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			
			e1.printStackTrace();
		}
		
	}
  /**
   * fonction qui retourne la liste des piste
   * @return ArrayList<Piste> 
   */
   public static ArrayList<Piste> listePiste() {
	   Connection cnx = null;
	   	PreparedStatement requete = null ;
	   	ResultSet resultat = null ;
	   	ArrayList<Piste> listePiste = new ArrayList<Piste>();
		   
			cnx = ConnexionMySQL.connectDB();	
			String sql = "SELECT * FROM PISTE";

			try {
				requete = cnx.prepareStatement(sql);
				resultat = requete.executeQuery();
				while(resultat.next()) {
					
					listePiste.add(new Piste(Integer.parseInt(resultat.getString("IDPISTE")),Double.parseDouble(resultat.getString("LONGEUR")), resultat.getString("idAeroport")));				      
				}
				requete.close();
				cnx.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	return listePiste;
	   
   }
  
 	

}
