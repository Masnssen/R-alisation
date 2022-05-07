 package modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class Vol {
	
	protected String idvol ;
	protected String dateDep  ;
	protected String dateArriver ;
	protected Aeroport aeroportDep ;
	protected Aeroport aeroportArriver ;
	protected int nbEcale ;
	protected int nbPassager  ;
	protected double fretVol ;
	protected Compagnie compagnie ;
	protected TypeVol typeVol ; 
	protected Aeronef aeronef ;
	protected Equipage equipage ;
	protected String heureDepart;
	protected String heureArriver ;
	protected ArrayList<VolEncour> volEncours ;
	private String nbvolcompagnie;
	private double distance ;
	
	
	/**
	 * Constructeur
	 * @param dateDep
	 * @param dateArriver
	 * @param idaeroportDep
	 * @param idaeroportArriver
	 * @param nbEcale
	 * @param nbPassager
	 * @param fretVol
	 * @param idcompagnie
	 * @param typeVol
	 * @param idAeronef
	 * @param idequippage
	 * @param heureDepart
	 * @param heureArriver
	 * @param distance
	 */
       public Vol( Date dateDep, Date dateArriver, String idaeroportDep, String idaeroportArriver,
			int nbEcale, int nbPassager, double fretVol, String idcompagnie, TypeVol typeVol, String idAeronef,
			int idequippage,String heureDepart,String heureArriver,double distance) {
		super();
		
		this.idvol =idcompagnie+""+new SimpleDateFormat("ddMMyy").format(dateDep)+""+Integer.toString(nbvolvompagnie(idcompagnie,new SimpleDateFormat("yyyy-MM-dd").format(dateDep)));
		
			
		this.dateDep = new SimpleDateFormat("yyyy-MM-dd").format(dateDep);
		this.dateArriver = new SimpleDateFormat("yyyy-MM-dd").format(dateArriver);
		initAeroportarriver(idaeroportArriver);
		initAeroportdepart(idaeroportDep);
		this.nbEcale = nbEcale;
		this.nbPassager = nbPassager;
		this.fretVol = fretVol;
		initCompagnie (idcompagnie);
		this.typeVol = typeVol;
		initAeronef( idAeronef);
		initEquipage(idequippage);
		this.heureDepart = heureDepart;
		this.heureArriver = heureArriver;
		this.distance = distance;
	}
       /**
        * Constructeur
        * @param id
        * @param dateDep
        * @param dateArriver
        * @param idaeroportDep
        * @param idaeroportArriver
        * @param nbEcale
        * @param nbPassager
        * @param fretVol
        * @param idcompagnie
        * @param typeVol
        * @param idAeronef
        * @param idequippage
        * @param heureDepart
        * @param heureArriver
        * @param distance
        */
       public Vol(String id, String dateDep, String dateArriver, String idaeroportDep, String idaeroportArriver,
   			int nbEcale, int nbPassager, double fretVol, String idcompagnie, TypeVol typeVol, String idAeronef,
   			int idequippage,String heureDepart,String heureArriver,double distance) {
   		super();
   		this.idvol =id;  
   		this.dateDep = dateDep;
   		this.dateArriver = dateArriver;
   		initAeroportarriver(idaeroportArriver);
   		initAeroportdepart(idaeroportDep);
   		this.nbEcale = nbEcale;
   		this.nbPassager = nbPassager;
   		this.fretVol = fretVol;
   		initCompagnie (idcompagnie);
		this.typeVol = typeVol;
   		initAeronef( idAeronef);
   		initEquipage(idequippage);
   		this.heureDepart = heureDepart;
   		this.heureArriver = heureArriver;
   		this.distance = distance;
   	}
     /**
      * avoir l'equipage grace a l'id 
      * @param idEquipage
      */
       private void initEquipage(int idEquipage) {
      		
      		Connection cnx = null;
      		PreparedStatement requete = null ;
      		ResultSet resultat = null ;
      	
      		cnx = ConnexionMySQL.connectDB();	
      		String sql = "SELECT * FROM Equippage WHERE IDEQUIPPAGE  = "+idEquipage;
      		
      		try {
      			requete = cnx.prepareStatement(sql);
      			resultat = requete.executeQuery();
      			while(resultat.next()) {
      		this.equipage = new Equipage(resultat.getInt("IDEQUIPPAGE"),resultat.getString("LIBELLEREQUIPPAGE"));	
      			}
      			requete.close();
      			cnx.close();
      		} catch (SQLException e) {
      			// TODO Auto-generated catch block
      			e.printStackTrace();
      	}
      		
      	
       }

       /**
        * avoir l'aeronef grace a l'id de l'aeronef
        * @param idAeronef
        */
       private void initAeronef(String idAeronef) {
   		
   		Connection cnx = null;
   		PreparedStatement requete = null ;
   		ResultSet resultat = null ;
   	
   		cnx = ConnexionMySQL.connectDB();	
   		String sql = "SELECT * FROM aeronef WHERE MAT = '"+idAeronef+"'";
   		
   		try {
   			requete = cnx.prepareStatement(sql);
   			resultat = requete.executeQuery();
   			while(resultat.next()) {
   				if(resultat.getString("TYPEAERONEF").equals("SPORT"))
   					this.aeronef = new Aeronef(resultat.getString("MAT"),resultat.getString("NOMCONST"), resultat.getString("IDCOMAGNIE"), TypeAeronef.SPORT,resultat.getDouble("POIDS"), resultat.getInt("CAPACITE"), resultat.getDouble("FRETAERONEF"));				else
					if(resultat.getString("TYPEAERONEF").equals("SERVICES_DIVERS"))
						this.aeronef = new Aeronef(resultat.getString("MAT"),resultat.getString("NOMCONST"), resultat.getString("IDCOMAGNIE"), TypeAeronef.SERVICES_DIVERS,resultat.getDouble("POIDS"), resultat.getInt("CAPACITE"), resultat.getDouble("FRETAERONEF"));					  else
			            	if(resultat.getString("TYPEAERONEF").equals("USAGE_MILITAIRE"))
			            		this.aeronef = new Aeronef(resultat.getString("MAT"),resultat.getString("NOMCONST"), resultat.getString("IDCOMAGNIE"), TypeAeronef.USAGE_MILITAIRE,resultat.getDouble("POIDS"), resultat.getInt("CAPACITE"), resultat.getDouble("FRETAERONEF"));   			
   			}
   			requete.close();
  			cnx.close();
   		} catch (SQLException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();}
       }
       /**
        * avoir compagnie grace a l'id de la compagnie
        * @param idcompagnie
        */
      private void initCompagnie(String idcompagnie) {
		
		Connection cnx = null;
		PreparedStatement requete = null ;
		ResultSet resultat = null ;
	
		cnx = ConnexionMySQL.connectDB();	
		String sql = "SELECT * FROM Compagnie WHERE IDCOMPAGNIE = '"+idcompagnie+"'";
		
		try {
			requete = cnx.prepareStatement(sql);
			resultat = requete.executeQuery();
			while(resultat.next()) {
		this.compagnie = new Compagnie(resultat.getString("IDCOMPAGNIE"), resultat.getString("NOMCOMPAGNIE"), resultat.getString("SITE"),resultat.getString("EMAIL"), resultat.getString("NUMTEL"));
			}
			requete.close();
  			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}

	}
      /**
       * 
       * @param idAeroport
       */
    private void initAeroportarriver(String idAeroport) {
		
		Connection cnx = null;
		PreparedStatement requete = null ;
		ResultSet resultat = null ;
	
		cnx = ConnexionMySQL.connectDB();	
		String sql = "SELECT * FROM aeroport WHERE IDAEROPORT = '"+idAeroport+"'";
		
		try {
			requete = cnx.prepareStatement(sql);
			resultat = requete.executeQuery();
			while(resultat.next()) {
		this.aeroportArriver = new Aeroport(resultat.getString("IDAEROPORT"), resultat.getString("NOMAEROPORT"), resultat.getString("PAYS"));
			}
			requete.close();
  			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}

	}
    /**
     * avoir un aeroport grace a l'id de l'aeroport
     * @param idAeroport
     */
   private void initAeroportdepart(String idAeroport) {
		
		Connection cnx = null;
		PreparedStatement requete = null ;
		ResultSet resultat = null ;
	
		cnx = ConnexionMySQL.connectDB();	
		String sql = "SELECT * FROM aeroport WHERE IDAEROPORT = '"+idAeroport+"'";
		
		try {
			requete = cnx.prepareStatement(sql);
			resultat = requete.executeQuery();
			while(resultat.next()) {
		this.aeroportDep = new Aeroport(resultat.getString("IDAEROPORT"), resultat.getString("NOMAEROPORT"), resultat.getString("PAYS"));
			}
			requete.close();
  			cnx.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}

}
   /**
    * getter date depart du vol
    * @return String
    */
	public String getDateDep() {
		return dateDep;
	}
	/**
	 * getter de date d'arriver du vol
	 * @return String
	 */
	public String getDateArriver() {
		return dateArriver;
	}
	/**
	 * getter de l'aeroport de depart
	 * @return Aerport
	 */
	public Aeroport getAeroportDep() {
		return aeroportDep;
	}
	/**
	 * getter de l'aeroport d'arriver
	 * @return Aeroport
	 */
	public Aeroport getAeroportArriver() {
		return aeroportArriver;
	}
	/**
	 * getter nombre escale
	 * @return int
	 */
	public int getNbEcale() {
		return nbEcale;
	}
	/**
	 * getter nombre de passager
	 * @return int
	 */
	public int getNbPassager() {
		return nbPassager;
	}
	/**
	 * getter fret vol
	 * @return double
	 */
	public double getFretVol() {
		return fretVol;
	}
	/**
	 * getter compagnie
	 * @return Compagnie
	 */
	public Compagnie getCompagnie() {
		return compagnie;
	}
	/**
	 * getter type vol
	 * @return Typevol
	 */
	public TypeVol getTypeVol() {
		return typeVol;
	}
	/**
	 * getter aeornef
	 * @return Aeronef
	 */
	public Aeronef getAeronef() {
		return aeronef;
	}
	/**
	 * getter equippage
	 * @return Equipage
	 */
	public Equipage getEquippage() {
		return equipage;
	}
	/**
	 * getter id vol
	 * @return String
	 */
	public String getIdvol() {
		return idvol;
	}
	/**
	 * getter heure depart
	 * @return String
	 */
	public String getHeureDepart() {
		return heureDepart;
	}
	/**
	 * getter heure arriver
	 * @return String
	 */
	public String getHeureArriver() {
		return heureArriver;
	}
	/**
	 * getter distance
	 * @return
	 */
	public double getDistance() {
		return distance;
	}
	/**
	 * fonction pour ajouter un vol
	 */
	public void AjouterVol() {			

	    Connection cnx = null;
    	PreparedStatement requete = null ;
    	ResultSet resultat = null ;
				
		cnx = ConnexionMySQL.connectDB();	
		String sql = "INSERT INTO `vol` (idVol,dateDep,dateArriver,idAeroportDep,idAeroportArriver,nbEscale,nbPassager,freVol,idCompagnie,idEquipage,TypeVol,idAeronef,HEUREDEPART,HEUREARRIVER,distance) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			requete = cnx.prepareStatement(sql);
			requete.setString(1,getIdvol());
			requete.setString(2,getDateDep());
			requete.setString(3,getDateArriver());
			requete.setString(4,getAeroportDep().getIdAeroport().toString());
			requete.setString(5,getAeroportArriver().getIdAeroport().toString());
			requete.setInt(6,getNbEcale());
			requete.setInt(7,getNbPassager());
			requete.setDouble(8,getFretVol());
			requete.setString(9,getCompagnie().getIdCompagnie());
			requete.setInt(10,getEquippage().getIdEquipage());
			requete.setString(11,getTypeVol().toString());
			requete.setString(12,getAeronef().getMat());
			requete.setString(13,getHeureDepart());
			requete.setString(14,getHeureArriver());
			requete.setDouble(15,getDistance());


			requete.execute();
			requete.close();
  			cnx.close();
			JOptionPane.showMessageDialog(null, "ajouter avec succes ");
			
		   
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			
			e1.printStackTrace();
		
	}
 }
	/**
	 * fonction pour modifier un vol
	 */
     public void Modifier() {
		
	    Connection cnx = null;
    	PreparedStatement requete = null ;
    	ResultSet resultat = null ;
		cnx = ConnexionMySQL.connectDB();	
		String sql = "UPDATE Vol SET IDVOL = ? , DATEDEP = ? , DATEARRIVER = ? , IDAEROPORTDEP = ?, IDAEROPORTARRIVER = ?, NBESCALE = ? , FREVOL = ? , IDCOMPAGNIE = ?, IDEQUIPAGE = ?,TYPEVOL = ?, IDAERONEF = ? , HEUREDEPART = ? ,HEUREARRIVER = ? ,distance =? WHERE IDVOL = '"+getIdvol()+"'";
		
		try {
			requete = cnx.prepareStatement(sql);
			requete.setString(1,getIdvol().toString());
			requete.setString(2,getDateDep().toString());
			requete.setString(3,getDateArriver().toString());
			requete.setString(4,getAeroportDep().getIdAeroport().toString());
			requete.setString(5,getAeroportArriver().getIdAeroport().toString());
			requete.setInt(6,getNbEcale());
			requete.setInt(7,getNbPassager());
			requete.setDouble(8,getFretVol());
			requete.setString(9,getCompagnie().getIdCompagnie());
			requete.setInt(10,getEquippage().getIdEquipage());
			requete.setString(11,getTypeVol().toString());
			requete.setString(11,getAeronef().getMat());
			requete.setString(12,getHeureDepart());
			requete.setString(13,getHeureArriver());
			requete.setDouble(14,getDistance());
			
			requete.execute();
			requete.close();
  			cnx.close();
			JOptionPane.showMessageDialog(null, "Modifier avec succes ");
			
		   
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			
			e1.printStackTrace();
		}		
	}
     /**
      * fonction pour supprimer un vol
      */
  public void Supprimer() {
		
	     Connection cnx = null;
    	PreparedStatement requete = null ;
    	ResultSet resultat = null ;
	cnx = ConnexionMySQL.connectDB();	
	String sql = "DELETE FROM vol WHERE IDVOL = '"+getIdvol()+"'";
	
	try {
		requete = cnx.prepareStatement(sql);
		requete.execute();
		requete.close();
			cnx.close();
		JOptionPane.showMessageDialog(null, "supprimer avec succes ");
		
	   
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		
		e1.printStackTrace();
	}
	
}
 
  /**
   * fonction qui retourne la liste des vol  en cour
   * @return ArrayList<VolEncour>
   */
	  public  static ArrayList<VolEncour> listeVolEncour() {
			Connection cnx = null;
			PreparedStatement requete = null ;
			ResultSet resultat = null ;
			ArrayList<VolEncour> l = new ArrayList<VolEncour>();
		
			cnx = ConnexionMySQL.connectDB();	
			String sql = "SELECT * FROM `vol` WHERE HEUREDEPART < CURRENT_TIME -20 ";
			
			try {
				requete = cnx.prepareStatement(sql);
				resultat = requete.executeQuery();
				while(resultat.next()) {
					if(resultat.getString("Typevol").equals("COMMERCIAL_regulier"))
						l.add(new VolEncour("décollage",resultat.getString("idVol"),resultat.getString("DATEDEP"), resultat.getString("DATEARRIVER"), resultat.getString("IDAEROPORTDEP"), resultat.getString("IDAEROPORTARRIVER"), resultat.getInt("NBESCALE"),
								resultat.getInt("nbPassager"), resultat.getDouble("freVol"),resultat.getString("idCompagnie"), TypeVol.COMMERCIAL_regulier, resultat.getString("idAeronef"), resultat.getInt("idEquipage"),
								resultat.getString("HEUREDEPART"), resultat.getString("HEUREARRIVER"),resultat.getDouble("distance")));
					else
							if(resultat.getString("Typevol").equals("COMMERCIAL_OCCASIONNEL"))
								l.add(new VolEncour("décollage",resultat.getString("idVol"),resultat.getString("DATEDEP"), resultat.getString("DATEARRIVER"), resultat.getString("IDAEROPORTDEP"), resultat.getString("IDAEROPORTARRIVER"), resultat.getInt("NBESCALE"),
										resultat.getInt("nbPassager"), resultat.getDouble("freVol"),resultat.getString("idCompagnie"),TypeVol.COMMERCIAL_OCCASIONNEL, resultat.getString("idAeronef"), resultat.getInt("idEquipage"),
										resultat.getString("HEUREDEPART"), resultat.getString("HEUREARRIVER"),resultat.getDouble("distance")));
							else
								if(resultat.getString("Typevol").equals("NON_COMMERCIAL"))
								      l.add(new VolEncour("décollage",resultat.getString("idVol"),resultat.getString("DATEDEP"), resultat.getString("DATEARRIVER"), resultat.getString("IDAEROPORTDEP"), resultat.getString("IDAEROPORTARRIVER"), resultat.getInt("NBESCALE"),
											resultat.getInt("nbPassager"), resultat.getDouble("freVol"),resultat.getString("idCompagnie"),TypeVol.NON_COMMERCIAL, resultat.getString("idAeronef"), resultat.getInt("idEquipage"),
											resultat.getString("HEUREDEPART"), resultat.getString("HEUREARRIVER"),resultat.getDouble("distance")));
								else
									if(resultat.getString("Typevol").equals("MILITAIRE"))
										l.add(new VolEncour("décollage",resultat.getString("idVol"),resultat.getString("DATEDEP"), resultat.getString("DATEARRIVER"), resultat.getString("IDAEROPORTDEP"), resultat.getString("IDAEROPORTARRIVER"), resultat.getInt("NBESCALE"),
												resultat.getInt("nbPassager"), resultat.getDouble("freVol"),resultat.getString("idCompagnie"), TypeVol.MILITAIRE, resultat.getString("idAeronef"), resultat.getInt("idEquipage"),
												resultat.getString("HEUREDEPART"), resultat.getString("HEUREARRIVER"),resultat.getDouble("distance")));
									else
										if(resultat.getString("Typevol").equals("GOUVERNEMENTAL"))
											l.add(new VolEncour("décollage",resultat.getString("idVol"),resultat.getString("DATEDEP"), resultat.getString("DATEARRIVER"), resultat.getString("IDAEROPORTDEP"), resultat.getString("IDAEROPORTARRIVER"), resultat.getInt("NBESCALE"),
													resultat.getInt("nbPassager"), resultat.getDouble("freVol"),resultat.getString("idCompagnie"), TypeVol.GOUVERNEMENTAL, resultat.getString("idAeronef"), resultat.getInt("idEquipage"),
													resultat.getString("HEUREDEPART"), resultat.getString("HEUREARRIVER"),resultat.getDouble("distance")));					
				}
				requete.close();
      			cnx.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
			
				e.printStackTrace();
		}
			
			cnx = null;
			requete = null ;
			resultat = null ;
		
			cnx = ConnexionMySQL.connectDB();	
			sql = "SELECT * FROM `vol` WHERE HEUREDEPART > CURRENT_TIME +20";
			
			try {
				requete = cnx.prepareStatement(sql);
				resultat = requete.executeQuery();
				while(resultat.next()) {
					if(resultat.getString("Typevol").equals("COMMERCIAL_regulier"))
						l.add(new VolEncour("atterissage",resultat.getString("idVol"),resultat.getString("DATEDEP"), resultat.getString("DATEARRIVER"), resultat.getString("IDAEROPORTDEP"), resultat.getString("IDAEROPORTARRIVER"), resultat.getInt("NBESCALE"),
								resultat.getInt("nbPassager"), resultat.getDouble("freVol"),resultat.getString("idCompagnie"), TypeVol.COMMERCIAL_regulier, resultat.getString("idAeronef"), resultat.getInt("idEquipage"),
								resultat.getString("HEUREDEPART"), resultat.getString("HEUREARRIVER"),resultat.getDouble("distance")));
					else
							if(resultat.getString("Typevol").equals("COMMERCIAL_OCCASIONNEL"))
								l.add(new VolEncour("atterissage",resultat.getString("idVol"),resultat.getString("DATEDEP"), resultat.getString("DATEARRIVER"), resultat.getString("IDAEROPORTDEP"), resultat.getString("IDAEROPORTARRIVER"), resultat.getInt("NBESCALE"),
										resultat.getInt("nbPassager"), resultat.getDouble("freVol"),resultat.getString("idCompagnie"),TypeVol.COMMERCIAL_OCCASIONNEL, resultat.getString("idAeronef"), resultat.getInt("idEquipage"),
										resultat.getString("HEUREDEPART"), resultat.getString("HEUREARRIVER"),resultat.getDouble("distance")));
							else
								if(resultat.getString("Typevol").equals("NON_COMMERCIAL"))
								  l.add(new VolEncour("atterissage",resultat.getString("idVol"),resultat.getString("DATEDEP"), resultat.getString("DATEARRIVER"), resultat.getString("IDAEROPORTDEP"), resultat.getString("IDAEROPORTARRIVER"), resultat.getInt("NBESCALE"),
											resultat.getInt("nbPassager"), resultat.getDouble("freVol"),resultat.getString("idCompagnie"),TypeVol.NON_COMMERCIAL, resultat.getString("idAeronef"), resultat.getInt("idEquipage"),
											resultat.getString("HEUREDEPART"), resultat.getString("HEUREARRIVER"),resultat.getDouble("distance")));
								else
									if(resultat.getString("Typevol").equals("MILITAIRE"))
										l.add(new VolEncour("atterissage",resultat.getString("idVol"),resultat.getString("DATEDEP"), resultat.getString("DATEARRIVER"), resultat.getString("IDAEROPORTDEP"), resultat.getString("IDAEROPORTARRIVER"), resultat.getInt("NBESCALE"),
												resultat.getInt("nbPassager"), resultat.getDouble("freVol"),resultat.getString("idCompagnie"), TypeVol.MILITAIRE, resultat.getString("idAeronef"), resultat.getInt("idEquipage"),
												resultat.getString("HEUREDEPART"), resultat.getString("HEUREARRIVER"),resultat.getDouble("distance")));
									else
										if(resultat.getString("Typevol").equals("GOUVERNEMENTAL"))
											l.add(new VolEncour("atterissage",resultat.getString("idVol"),resultat.getString("DATEDEP"), resultat.getString("DATEARRIVER"), resultat.getString("IDAEROPORTDEP"), resultat.getString("IDAEROPORTARRIVER"), resultat.getInt("NBESCALE"),
													resultat.getInt("nbPassager"), resultat.getDouble("freVol"),resultat.getString("idCompagnie"), TypeVol.GOUVERNEMENTAL, resultat.getString("idAeronef"), resultat.getInt("idEquipage"),
													resultat.getString("HEUREDEPART"), resultat.getString("HEUREARRIVER"),resultat.getDouble("distance")));					
				}
				requete.close();
      			cnx.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
			
				e.printStackTrace();
		}
			return l;
		}
	  private int nbvolvompagnie(String compagnie,String date) {
		  int nb = 1 ;
				
				Connection cnx = null;
				PreparedStatement requete = null ;
				ResultSet resultat = null ;
			
				cnx = ConnexionMySQL.connectDB();	
				String sql = "SELECT COUNT(*) FROM vol WHERE idCompagnie ='"+compagnie+"' and dateDep ='"+date+"'";
				
				try {
					requete = cnx.prepareStatement(sql);
					resultat = requete.executeQuery();
					while(resultat.next()) {
						nb = nb + resultat.getInt("COUNT(*)");
					}
					requete.close();
	      			cnx.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
				return nb;

			}
	  /**
	   * fonction qui retourn la liste des vols
	   * @return ArrayList<Vol>
	   */
	  public static ArrayList<Vol> listeVol() {
		   Connection cnx = null;
		   	PreparedStatement requete = null ;
		   	ResultSet resultat = null ;
		   	ArrayList<Vol> listeVol = new ArrayList<Vol>();
			   
				cnx = ConnexionMySQL.connectDB();	
				String sql = "SELECT * FROM vol";

				try {
					requete = cnx.prepareStatement(sql);
					resultat = requete.executeQuery();
					while(resultat.next()) {
						if(resultat.getString("Typevol").equals("COMMERCIAL_regulier"))
							listeVol.add(new Vol(resultat.getString("idVol"),resultat.getString("DATEDEP"), resultat.getString("DATEARRIVER"), resultat.getString("IDAEROPORTDEP"), resultat.getString("IDAEROPORTARRIVER"), resultat.getInt("NBESCALE"),
									resultat.getInt("nbPassager"), resultat.getDouble("freVol"),resultat.getString("idCompagnie"), TypeVol.COMMERCIAL_regulier, resultat.getString("idAeronef"), resultat.getInt("idEquipage"),
									resultat.getString("HEUREDEPART"), resultat.getString("HEUREARRIVER"),resultat.getDouble("distance")));
						else
								if(resultat.getString("Typevol").equals("COMMERCIAL_OCCASIONNEL"))
									listeVol.add(new Vol(resultat.getString("idVol"),resultat.getString("DATEDEP"), resultat.getString("DATEARRIVER"), resultat.getString("IDAEROPORTDEP"), resultat.getString("IDAEROPORTARRIVER"), resultat.getInt("NBESCALE"),
											resultat.getInt("nbPassager"), resultat.getDouble("freVol"),resultat.getString("idCompagnie"),TypeVol.COMMERCIAL_OCCASIONNEL, resultat.getString("idAeronef"), resultat.getInt("idEquipage"),
											resultat.getString("HEUREDEPART"), resultat.getString("HEUREARRIVER"),resultat.getDouble("distance")));
								else
									if(resultat.getString("Typevol").equals("NON_COMMERCIAL"))
									  listeVol.add(new Vol(resultat.getString("idVol"),resultat.getString("DATEDEP"), resultat.getString("DATEARRIVER"), resultat.getString("IDAEROPORTDEP"), resultat.getString("IDAEROPORTARRIVER"), resultat.getInt("NBESCALE"),
												resultat.getInt("nbPassager"), resultat.getDouble("freVol"),resultat.getString("idCompagnie"),TypeVol.NON_COMMERCIAL, resultat.getString("idAeronef"), resultat.getInt("idEquipage"),
												resultat.getString("HEUREDEPART"), resultat.getString("HEUREARRIVER"),resultat.getDouble("distance")));
									else
										if(resultat.getString("Typevol").equals("MILITAIRE"))
											listeVol.add(new Vol(resultat.getString("idVol"),resultat.getString("DATEDEP"), resultat.getString("DATEARRIVER"), resultat.getString("IDAEROPORTDEP"), resultat.getString("IDAEROPORTARRIVER"), resultat.getInt("NBESCALE"),
													resultat.getInt("nbPassager"), resultat.getDouble("freVol"),resultat.getString("idCompagnie"), TypeVol.MILITAIRE, resultat.getString("idAeronef"), resultat.getInt("idEquipage"),
													resultat.getString("HEUREDEPART"), resultat.getString("HEUREARRIVER"),resultat.getDouble("distance")));
										else
											if(resultat.getString("Typevol").equals("GOUVERNEMENTAL"))
												listeVol.add(new Vol(resultat.getString("idVol"),resultat.getString("DATEDEP"), resultat.getString("DATEARRIVER"), resultat.getString("IDAEROPORTDEP"), resultat.getString("IDAEROPORTARRIVER"), resultat.getInt("NBESCALE"),
														resultat.getInt("nbPassager"), resultat.getDouble("freVol"),resultat.getString("idCompagnie"), TypeVol.GOUVERNEMENTAL, resultat.getString("idAeronef"), resultat.getInt("idEquipage"),
														resultat.getString("HEUREDEPART"), resultat.getString("HEUREARRIVER"),resultat.getDouble("distance")));					
					}
					requete.close();
	      			cnx.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return listeVol;
		   
	   }
	 
}
  
  
		

