package modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class MembreEquippage {
	
	protected Equipage equipage;
	protected Membre membre;
	
	/**
	 * Constructeur
	 * @param idEquipage
	 * @param idMembre
	 */
    public MembreEquippage(int idEquipage, int idMembre) {
		super();
		intEquipage(idEquipage) ;
		iniMembre(idMembre);
	}
	/**
	 * avoir un membre grace a l'id pour l'utiliser dans le constructeur
	 * @param idMembre
	 */
    private void iniMembre(int idMembre) {
		
		Connection cnx = null;
		PreparedStatement requete = null ;
		ResultSet resultat = null ;
	
		cnx = ConnexionMySQL.connectDB();	
		String sql = "SELECT * FROM MEMBRE WHERE IDMEMBRE  = "+idMembre;
		
		try {
			requete = cnx.prepareStatement(sql);
			resultat = requete.executeQuery();
			while(resultat.next()) {
       this.membre = new Membre(Integer.parseInt(resultat.getString("idMembre")), resultat.getString("nomMembre"), Integer.parseInt(resultat.getString("nbHeureVol")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
 }
 
    /**
     * avoir un equipage grace a l'id pour l'utiliser dans le constructeur
     * @param idEquipage
     */
    private void intEquipage(int idEquipage) {
		
		Connection cnx = null;
		PreparedStatement requete = null ;
		ResultSet resultat = null ;
	
		cnx = ConnexionMySQL.connectDB();	
		String sql = "SELECT * FROM Equippage WHERE IDEQUIPPAGE  = "+idEquipage;
		
		try {
			requete = cnx.prepareStatement(sql);
			resultat = requete.executeQuery();
			while(resultat.next()) {
       this.equipage = new Equipage(resultat.getInt("IDEQUIPPAGE"), resultat.getString("LIBELLEREQUIPPAGE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
 }
    /**
     * getter de l'equipage
     * @return Equipage
     */
	   public Equipage getEquipage() {
			return equipage;
		}
	   /**
	    * getter du membre 
	    * @return Membre
	    */
		public Membre getMembre() {
			return membre;
		}
		/**
		 * fonction pour ajouter une membre dans la base de donnée
		 */
	  public void AjouterMembreEquipage() {
			
	    	Connection cnx = null;
	    	PreparedStatement requete = null ;
	    	ResultSet resultat = null ;
	    	
			cnx = ConnexionMySQL.connectDB();	
			String sql = "INSERT INTO Equip_Membree VALUES(?,?)";
			
			try {
				requete = cnx.prepareStatement(sql);
				requete.setInt(1,getMembre().getIdMembre());
				requete.setInt(2,getEquipage().getIdEquipage());
				requete.execute();
				JOptionPane.showMessageDialog(null, "ajouter avec succes ");
				
			   
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				
				e1.printStackTrace();
			}		
			
	    }
	 /**
	  * fonction pour modifier un membre de la base de donnée
	  */
	    public void Modifier() {
	    	
	    	Connection cnx = null;
	    	PreparedStatement requete = null ;
	    	ResultSet resultat = null ;
	    		
			cnx = ConnexionMySQL.connectDB();	
			String sql = "UPDATE Equip_Membree  SET IDMEMBRE = ? , IDEQUIPAGE = ? WHERE IDMEMBRE = "+getMembre().getIdMembre()+" and IDEQUIPAGE = "+getEquipage().getIdEquipage();
			
			try {
				requete = cnx.prepareStatement(sql);
				requete.setInt(1,getMembre().getIdMembre());
				requete.setInt(2,getEquipage().getIdEquipage());
				requete.execute();
				JOptionPane.showMessageDialog(null, "Modifier avec succes ");
				
			   
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				
				e1.printStackTrace();
			}		
		}
	    /**
	     * fonction pour supprimer un membre d'equipe
	     */
	    public void Supprimer() {
			
	    	Connection cnx = null;
	    	PreparedStatement requete = null ;
	    	ResultSet resultat = null ;
	    	
	    	cnx = ConnexionMySQL.connectDB();	
			String sql = "DELETE FROM Equip_Membree WHERE IDMEMBRE = "+getMembre().getIdMembre()+" and IDEQUIPAGE = "+getEquipage().getIdEquipage();
			
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
