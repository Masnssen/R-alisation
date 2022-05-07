package modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class DemandeVol {
	
	private int idDemande ;
	private Vol vol;
	private String date ;
	private double durree ;
	private String accorder ;
	private String type ;
	private Piste piste;
	private String heure;
	/**
	 * Constructeur
	 * @param idDemande
	 * @param idVol
	 * @param date
	 * @param durree
	 * @param accorder
	 * @param type
	 * @param idPiste
	 * @param heure
	 */
	public DemandeVol(int idDemande, String idVol, String date, double durree, String accorder, String type,int idPiste,String heure) {
		super();
		this.idDemande = idDemande;
		iniVol(idVol);
		this.date = date;
		this.durree = durree;
		this.accorder = accorder;
		this.type = type;
		initPiste(idPiste);
		this.heure = heure;
	}
	/**
	 * Constructeur
	 * @param idVol
	 * @param date
	 * @param durree
	 * @param accorder
	 * @param type
	 * @param idPiste
	 * @param heure
	 */
	public DemandeVol(String idVol, String date, double durree, String accorder, String type,int idPiste,String heure) {
		super();
		iniVol(idVol);
		this.date = date;
		this.durree = durree;
		this.accorder = accorder;
		this.type = type;
		initPiste(idPiste);
		this.heure = heure;
	}
	/**
	 * avoir une piste grace a l ide de la piste quand on utulisera dans le constructeur
	 * @param idPiste
	 */
	private void initPiste(int idPiste) {
 		
 		Connection cnx = null;
 		PreparedStatement requete = null ;
 		ResultSet resultat = null ;
 	
 		cnx = ConnexionMySQL.connectDB();	
 		String sql = "SELECT * FROM Piste WHERE IDPISTE  = "+idPiste;
 		
 		try {
 			requete = cnx.prepareStatement(sql);
 			resultat = requete.executeQuery();
 			while(resultat.next()) {
         		this.piste= new Piste(resultat.getInt("IDPISTE"),resultat.getDouble("LONGEUR"),resultat.getString("idAeroport"));	

 			}
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 	}
  }
	/**
	 * avoir vol grace a l'id du vol qui on utilisera dans le constructeur
	 * @param idVol
	 */
     private void iniVol(String idVol) {
		
		Connection cnx = null;
		PreparedStatement requete = null ;
		ResultSet resultat = null ;
	
		cnx = ConnexionMySQL.connectDB();	
		String sql = "SELECT * FROM Vol WHERE idVol = '"+idVol+"'";
		
		try {
			requete = cnx.prepareStatement(sql);
			resultat = requete.executeQuery();
			while(resultat.next()) {
				if(resultat.getString("TypeVol").equals("COMMERCIAL_regulier"))
					this.vol=(new Vol(resultat.getString("idVol"),resultat.getString("DATEDEP"), resultat.getString("DATEARRIVER"), resultat.getString("IDAEROPORTDEP"), resultat.getString("IDAEROPORTARRIVER"), resultat.getInt("NBESCALE"),
							resultat.getInt("nbPassager"), resultat.getDouble("freVol"),resultat.getString("idCompagnie"), TypeVol.COMMERCIAL_regulier, resultat.getString("idAeronef"), resultat.getInt("idEquipage"),
							resultat.getString("HEUREDEPART"), resultat.getString("HEUREARRIVER"),Double.parseDouble(resultat.getString("distance"))));
				else
						if(resultat.getString("TypeVol").equals("COMMERCIAL_OCCASIONNEL"))
							this.vol=(new Vol(resultat.getString("idVol"),resultat.getString("DATEDEP"), resultat.getString("DATEARRIVER"), resultat.getString("IDAEROPORTDEP"), resultat.getString("IDAEROPORTARRIVER"), resultat.getInt("NBESCALE"),
									resultat.getInt("nbPassager"), resultat.getDouble("freVol"),resultat.getString("idCompagnie"),TypeVol.COMMERCIAL_OCCASIONNEL, resultat.getString("idAeronef"), resultat.getInt("idEquipage"),
									resultat.getString("HEUREDEPART"), resultat.getString("HEUREARRIVER"),Double.parseDouble(resultat.getString("distance"))));
						else
							if(resultat.getString("TypeVol").equals("NON_COMMERCIAL"))
								this.vol=(new Vol(resultat.getString("idVol"),resultat.getString("DATEDEP"), resultat.getString("DATEARRIVER"), resultat.getString("IDAEROPORTDEP"), resultat.getString("IDAEROPORTARRIVER"), resultat.getInt("NBESCALE"),
										resultat.getInt("nbPassager"), resultat.getDouble("freVol"),resultat.getString("idCompagnie"),TypeVol.NON_COMMERCIAL, resultat.getString("idAeronef"), resultat.getInt("idEquipage"),
										resultat.getString("HEUREDEPART"), resultat.getString("HEUREARRIVER"),Double.parseDouble(resultat.getString("distance"))));
							else
								if(resultat.getString("TypeVol").equals("MILITAIRE"))
									this.vol=(new Vol(resultat.getString("idVol"),resultat.getString("DATEDEP"), resultat.getString("DATEARRIVER"), resultat.getString("IDAEROPORTDEP"), resultat.getString("IDAEROPORTARRIVER"), resultat.getInt("NBESCALE"),
											resultat.getInt("nbPassager"), resultat.getDouble("freVol"),resultat.getString("idCompagnie"), TypeVol.MILITAIRE, resultat.getString("idAeronef"), resultat.getInt("idEquipage"),
											resultat.getString("HEUREDEPART"), resultat.getString("HEUREARRIVER"),Double.parseDouble(resultat.getString("distance"))));	
								else
									if(resultat.getString("TypeVol").equals("GOUVERNEMENTAL"))
										this.vol=(new Vol(resultat.getString("idVol"),resultat.getString("DATEDEP"), resultat.getString("DATEARRIVER"), resultat.getString("IDAEROPORTDEP"), resultat.getString("IDAEROPORTARRIVER"), resultat.getInt("NBESCALE"),
												resultat.getInt("nbPassager"), resultat.getDouble("freVol"),resultat.getString("idCompagnie"), TypeVol.GOUVERNEMENTAL, resultat.getString("idAeronef"), resultat.getInt("idEquipage"),
												resultat.getString("HEUREDEPART"), resultat.getString("HEUREARRIVER"),Double.parseDouble(resultat.getString("distance"))));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}
     }
     
     /**
      * getter de la demande de vol
      * @return int
      */
     public int getIdDemande() {
		return idDemande;
	}
     /**
      * getter du vol de la demande
      * @return Vol
      */
	public Vol getVol() {
		return vol;
	}
	/**
	 * getter de la date de la demande
	 * @return String
	 */
	public String getDate() {
		return date;
	}
	/**
	 * getter de la duureee de l'atterissage
	 * @return double
	 */
	public double getDurree() {
		return durree;
	}
	/**
	 * getter de reponse 
	 * @return String
	 */
	public String getAccorder() {
		return accorder;
	}
	/**
	 * getter du type
	 * @return String
	 */
	public String getType() {
		return type;
	}
	/**
	 * getter de la piste
	 * @return Piste
	 */
	public Piste getPiste() {
		return piste;
	}
	/**
	 * getter de l'heure
	 * @return String
	 */
	public String getHeure() {
		return heure;
	}
	/**
	 * fonction pour ajouter une demande de vol
	 */
	public void AjouterDemandeVol() {			

 	    Connection cnx = null;
     	PreparedStatement requete = null ;
     	ResultSet resultat = null ;
 				
 		cnx = ConnexionMySQL.connectDB();	
 		
 		String sql = "INSERT INTO `demandevol`(idVol,date,durree,accorder,type,IDPISTE,heure) VALUES(?,?,?,?,?,?,?)";
 		
 		try {
 			requete = cnx.prepareStatement(sql);
 			requete.setString(1,getVol().getIdvol());
 			requete.setString(2,getDate());
 			requete.setDouble(3,getDurree());
 			requete.setString(4,getAccorder());
 			requete.setString(5,getType());
 			requete.setInt(6,getPiste().getIdPiste());
 			requete.setString(7,getHeure());
 			

 			requete.execute();
 			JOptionPane.showMessageDialog(null, "ajouter avec succes ");
 			
 		   
 		} catch (SQLException e1) {
 			// TODO Auto-generated catch block
 			
 			e1.printStackTrace();
 		
 	}
  }
	/**
	 * fonction qui retourn la liste de demande de vol
	 * @return ArrayList<DemandeVol>
	 */
	public static ArrayList<DemandeVol> listedemande() {
		   Connection cnx = null;
		   	PreparedStatement requete = null ;
		   	ResultSet resultat = null ;
		   	ArrayList<DemandeVol> listedemande = new ArrayList<DemandeVol>();
			   
				cnx = ConnexionMySQL.connectDB();	
				String sql = "SELECT * FROM demandevol";

				try {
					requete = cnx.prepareStatement(sql);
					resultat = requete.executeQuery();
					while(resultat.next()) {
						listedemande.add(new DemandeVol(resultat.getInt("iddemande"), resultat.getString("idvol"),
								resultat.getString("date"), resultat.getDouble("durree"), resultat.getString("accorder"), 
								resultat.getString("type"), resultat.getInt("idpiste"),resultat.getString("heure"))); 
					}
					requete.close();
					cnx.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return listedemande;
		   
	   }
}
