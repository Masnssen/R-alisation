package modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

public class Redevance {
	
	protected int idRedevance ;
	protected Vol vol;
	protected double prix;
	protected boolean payer ;
	protected String datePayement;
	protected Compagnie compagnie;
	protected Redevance(int idRedevance, double prixx, boolean payer, String datePayement,
			String idcompagnie,String idVol) {
		super();
		this.idRedevance = idRedevance;
		this.prix = prixx;
		this.payer = payer;
		this.datePayement = datePayement;
		initCompagnie(idcompagnie) ;
		initVol(idVol);
	}
	public Redevance(String idVol, double prixx, boolean payer, String datePayement, String idcompagnie) {
		super();
		this.prix = prixx;
		this.payer = payer;
		this.datePayement = datePayement;
		initCompagnie(idcompagnie) ;
		initVol(idVol);
	}
	public Redevance(String idVol, boolean payer, String idcompagnie) {
		super();
		this.prix = calcul();
		this.payer = payer;
		initCompagnie(idcompagnie) ;
		initVol(idVol);
	}
	
	 public void initVol(String idVol) {
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
				requete.close();
				cnx.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	 }
	 }
	 
	 public void initCompagnie(String idcompagnie) {
			
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
	 
	public int getIdRedevance() {
		return idRedevance;
	}
	public Vol getVol() {
		return vol;
	}
	
	public boolean isPayer() {
		return payer;
	}
	public String getDatePayement() {
		return datePayement;
	}
	public Compagnie getCompagnie() {
		return compagnie;
	}
	
	
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public void setPayer(boolean payer) {
		this.payer = payer;
	}
	public boolean gratuit() {
		if (vol.getTypeVol().toString().equals("HUMANITAIRE")|| vol.getFretVol()<2) {
			return true;
		}
		
		return false;		
	}
	public boolean reduction() {
		if ( vol.getFretVol()>2 && vol.getFretVol()<6) {
			return true;
		}
		
		return false;		
	}
	private double calcul() {
		
		double p = (double)((getVol().getDistance()*getVol().getFretVol())*17)/100;
		return p;
	}
    public void ajouter(){
    	Connection cnx = null;
    	PreparedStatement requete = null ;
    	ResultSet resultat = null ;
    	
		cnx = ConnexionMySQL.connectDB();	
		String sql = "INSERT INTO Redevance (idVol,prix,compagnie,payer) VALUES(?,?,?,?)";
		
		try {
			requete = cnx.prepareStatement(sql);
			requete.setString(1,getVol().getIdvol());
		   requete.setDouble(2, ((getVol().getDistance()*getVol().getFretVol())*17)/100);
			requete.setString(3,getCompagnie().getIdCompagnie());
			requete.setBoolean(4,isPayer());
			
			requete.execute();
			JOptionPane.showMessageDialog(null, "ajouter avec succes ");
			requete.close();
			cnx.close();
		   
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			
			e1.printStackTrace();
		}		
	}
    public static ArrayList<Redevance> listeRedevance() {
 	   Connection cnx = null;
 	   	PreparedStatement requete = null ;
 	   	ResultSet resultat = null ;
 	   	ArrayList<Redevance> listeRedevance = new ArrayList<Redevance>();
 		   
 			cnx = ConnexionMySQL.connectDB();	
 			String sql = "SELECT * FROM Redevance order by compagnie";

 			try {
 				requete = cnx.prepareStatement(sql);
 				resultat = requete.executeQuery();
 				while(resultat.next()) {
 					if(resultat.getString("payer").equals("1")) {
 						listeRedevance.add(new Redevance(resultat.getInt("idRedevance"),
 							resultat.getDouble("prix"),true,resultat.getString("datePayement"),
 							resultat.getString("compagnie"),resultat.getString("idvol")));
 					}else {
 						listeRedevance.add(new Redevance(resultat.getInt("idRedevance"),
 	 							resultat.getDouble("prix"),false,resultat.getString("datePayement"),
 	 							resultat.getString("compagnie"),resultat.getString("idvol")));
 					}
 				}
 				requete.close();
 				cnx.close();
 			} catch (SQLException e) {
 				// TODO Auto-generated catch block
 				e.printStackTrace();
 			}
 	return listeRedevance;
 	   
    }
    public static ArrayList<Redevance> listeRedevanceCompagnieNonPayer(String idcompagnie) {
  	   Connection cnx = null;
  	   	PreparedStatement requete = null ;
  	   	ResultSet resultat = null ;
  	   	ArrayList<Redevance> listeRedevance = new ArrayList<Redevance>();
  			cnx = ConnexionMySQL.connectDB();	
  			String sql = "SELECT * FROM Redevance where compagnie ='"+idcompagnie+"'and "
  					+ "payer = 0";

  			try {
  				requete = cnx.prepareStatement(sql);
  				resultat = requete.executeQuery();
  				while(resultat.next()) {
  					if(resultat.getString("payer").equals("0")) {
  						listeRedevance.add(new Redevance(resultat.getInt("idRedevance"),
  							resultat.getDouble("prix"),false,resultat.getString("datePayement"),
  							resultat.getString("compagnie"),resultat.getString("idvol")));
  					}
  				}
  				requete.close();
  				cnx.close();
  			} catch (SQLException e) {
  				// TODO Auto-generated catch block
  				e.printStackTrace();
  			}
  	return listeRedevance;
  	   
     }
    public static ArrayList<Redevance> listeRedevanceCompagniePayer(String idcompagnie) {
   	   Connection cnx = null;
   	   	PreparedStatement requete = null ;
   	   	ResultSet resultat = null ;
   	   	ArrayList<Redevance> listeRedevance = new ArrayList<Redevance>();
   			cnx = ConnexionMySQL.connectDB();	
   			String sql = "SELECT * FROM Redevance where compagnie ='"+idcompagnie+"' and"
   					+ "payer =1";

   			try {
   				requete = cnx.prepareStatement(sql);
   				resultat = requete.executeQuery();
   				while(resultat.next()) {
   					if(resultat.getString("payer").equals("1")) {
   						listeRedevance.add(new Redevance(resultat.getInt("idRedevance"),
   							resultat.getDouble("prix"),true,resultat.getString("datePayement"),
   							resultat.getString("compagnie"),resultat.getString("idvol")));
   					}
   				}
   				requete.close();
   				cnx.close();
   			} catch (SQLException e) {
   				// TODO Auto-generated catch block
   				e.printStackTrace();
   			}
   	return listeRedevance;
   	   
      }
    public static void Payer(String idcompagnie) {
    	Connection cnx = null;
    	PreparedStatement requete = null ;
    	ResultSet resultat = null ;
    	 String format ="yyyy-MM-dd";
         SimpleDateFormat simpleDateFormat= new SimpleDateFormat(format);
         Date date = new Date();
    	
    	cnx = ConnexionMySQL.connectDB();	
		String sql = "update redevance set payer = 1 ,datePayement ='"+simpleDateFormat.format(date)+"' where compagnie ='"+idcompagnie+"'"; 
		
		try {
			requete = cnx.prepareStatement(sql);
			requete.execute();
			JOptionPane.showMessageDialog(null, "avec succes ");
			
			requete.close();
			cnx.close();
			
		   
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			
			e1.printStackTrace();
		}
    	   
       }
    public static double getMontantCompagnie(String idcompagnie) {
		// TODO Auto-generated method stub
		double total = 0; 
		Connection cnx = null;
	   	PreparedStatement requete = null ;
	   	ResultSet resultat = null ;
	   			   
			cnx = ConnexionMySQL.connectDB();	
			String sql = "SELECT SUM(prix) AS prix_total FROM redevance where compagnie ='"+idcompagnie+"'"
					+ "and payer = 0";

			try {
				requete = cnx.prepareStatement(sql);
				resultat = requete.executeQuery();
				while(resultat.next()) {
					total = resultat.getDouble("prix_total");				        		
	 
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return total;
	}
}
