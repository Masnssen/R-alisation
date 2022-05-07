package modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class PisteReserver extends Piste {
	
	private int idpisteReserver;
	private String date;
	private String heure;
	
	public PisteReserver(int idpisteReserver,int idPiste,String date,String heure) {
		
		super(idPiste, initPiste(idPiste).getLongeur(),initPiste(idPiste).getAeroport().getIdAeroport());
		// TODO Auto-generated constructor stub
		this.idpisteReserver = idpisteReserver;
		this.date = date;
		this.heure = heure;
	}
   public PisteReserver(int idPiste,String date,String heure) {
		
		super(idPiste, initPiste(idPiste).getLongeur(),initPiste(idPiste).getAeroport().getIdAeroport());
		// TODO Auto-generated constructor stub
		this.date = date;
		this.heure = heure;
	}
     private static Piste initPiste(int idPiste) {
 		
 		Connection cnx = null;
 		PreparedStatement requete = null ;
 		ResultSet resultat = null ;
 		Piste piste = null;
 	
 		cnx = ConnexionMySQL.connectDB();	
 		String sql = "SELECT * FROM Piste WHERE IDPISTE  = "+idPiste;
 		
 		try {
 			requete = cnx.prepareStatement(sql);
 			resultat = requete.executeQuery();
 			while(resultat.next()) {
         		piste= new Piste(resultat.getInt("IDPISTE"),resultat.getDouble("LONGEUR"),resultat.getString("idAeroport"));	

 			}
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 	}
 		return piste;
  }

	public int getIdpisteReserver() {
		return idpisteReserver;
	}

	public void setIdpisteReserver(int idpisteReserver) {
		this.idpisteReserver = idpisteReserver;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHeure() {
		return heure;
	}

	public void setHeure(String heure) {
		this.heure = heure;
	}
   public  void AjouterPisteReserver() {
		
    	Connection cnx = null;
    	PreparedStatement requete = null ;
    	ResultSet resultat = null ;
    	
		cnx = ConnexionMySQL.connectDB();	
		String sql = "INSERT INTO pistereserver (idpiste,date,heure) VALUES(?,?,?)";
		
		try {
			requete = cnx.prepareStatement(sql);
			requete.setInt(1,getIdPiste());
			requete.setString(2,getDate());
			requete.setString(3,getHeure());
			requete.execute();
			JOptionPane.showMessageDialog(null, "ajouter avec succes ");
			requete.close();
			cnx.close();   
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			
			e1.printStackTrace();
		}		
		
    }
	public static ArrayList<PisteReserver> listePisteReserver() {
		   Connection cnx = null;
		   	PreparedStatement requete = null ;
		   	ResultSet resultat = null ;
		   	ArrayList<PisteReserver> listePiste = new ArrayList<PisteReserver>();
			   
				cnx = ConnexionMySQL.connectDB();	
				String sql = "SELECT * FROM pistereserver";

				try {
					requete = cnx.prepareStatement(sql);
					resultat = requete.executeQuery();
					while(resultat.next()) {
					listePiste.add(new PisteReserver(resultat.getInt("idpistereserver"),resultat.getInt("idpiste"), resultat.getString("date"), resultat.getString("heure")));				      
											 		
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
