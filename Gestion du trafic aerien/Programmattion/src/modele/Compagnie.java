package modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class Compagnie implements  StatistiqueCom{
	
	
	protected String idCompagnie ;
	protected String nomCompagnie ;
	protected String site ;
	protected String email ;
	protected String numTel ;
		
	/**
	 * Contructeur
	 */
	public Compagnie() {
	}
	/**
	 * Contructeur
	 * @param id
	 * @param nomCompagnie
	 * @param site
	 * @param email
	 * @param numTel
	 */
	public Compagnie(String id,String nomCompagnie, String site, String email, String numTel) {
		this.idCompagnie = id ;
		this.nomCompagnie = nomCompagnie;
		this.site = site;
		this.email = email;
		this.numTel = numTel;
	}
	/**
	 * Contructeur
	 * @param id
	 */
	public Compagnie(String id) {
			
			Connection cnx = null;
			PreparedStatement requete = null ;
			ResultSet resultat = null ;
		
			cnx = ConnexionMySQL.connectDB();	
			String sql = "SELECT * FROM Compagnie WHERE IDCOMPAGNIE = '"+id+"'";
			
			try {
				requete = cnx.prepareStatement(sql);
				resultat = requete.executeQuery();
				while(resultat.next()) {
					this.idCompagnie = id ;
					this.nomCompagnie = resultat.getString("NOMCOMPAGNIE");
					this.site = resultat.getString("site");
					this.email = resultat.getString("email");
					this.numTel = resultat.getString("NUMTEL");
				}
				requete.close();
	  			cnx.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}

		}
	/**
	 * getter du nom de la compagnie
	 * @return String
	 */
	public String getNomCompagnie() {
		return nomCompagnie;
	}
	/**
	 * getter du site de la compagnie
	 * @return Strings
	 */
	public String getSite() {
		return site;
	}
	/**
	 * getter du numéro de telephone de la compagnie
	 * @return
	 */
	public String getNumTel() {
		return numTel;
	}
	/**
	 * getter de l'id de la compagnie
	 * @return String
	 */
	public String getIdCompagnie() {
		return idCompagnie;
	}
	/**
	 * getter de l'email de la compagnie
	 * @return Stirng
	 */
	 public String getEmail() {
		return email;
	}
	 /**
	  * fonction pour ajouter une compagie a la base de donnée
	  */
	public void AjouterCompagnie() {
			
	    	Connection cnx = null;
	    	PreparedStatement requete = null ;
	    	ResultSet resultat = null ;
	    	
			cnx = ConnexionMySQL.connectDB();	
			String sql = "INSERT INTO COMPAGNIE (IDCOMPAGNIE,NOMCOMPAGNIE,SITE,EMAIL,NUMTEL) VALUES(?,?,?,?,?)";
			
			try {
				requete = cnx.prepareStatement(sql);
				requete.setString(1,getIdCompagnie().toString());
				requete.setString(2,getNomCompagnie().toString());
				requete.setString(3,getSite().toString());
				requete.setString(4,getEmail().toString());
				requete.setInt(5,Integer.parseInt(getNumTel().toString()));
				requete.execute();
				JOptionPane.showMessageDialog(null, "ajouter avec succes ");
				
			   
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				
				e1.printStackTrace();
			}		
			
	    }
	/**
	 * fonction pour modifier une compagnie a la base de donnée
	 */
	    public void Modifier() {
	    	
	    	Connection cnx = null;
	    	PreparedStatement requete = null ;
	    	ResultSet resultat = null ;
	    		
			cnx = ConnexionMySQL.connectDB();	
			String sql = "UPDATE COMPAGNIE SET IDCOMPAGNIE = ? , NOMCOMPAGNIE = ? , SITE = ?, EMAIL = ? , NUMTEL = ? WHERE IDCOMPAGNIE = '"+getIdCompagnie()+"'";
			
			try {
				requete = cnx.prepareStatement(sql);
				requete.setString(1,getIdCompagnie().toString());
				requete.setString(2,getNomCompagnie().toString());
				requete.setString(3,getSite().toString());
				requete.setString(4,getEmail().toString());
				requete.setInt(5,Integer.parseInt(getNumTel().toString()));
				requete.execute();
				JOptionPane.showMessageDialog(null, "Modifier avec succes ");
				
			   
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				
				e1.printStackTrace();
			}		
		}
	    /**
	     * fonction pour supprimer une compagnie de la base de donnée
	     */
	    public void Supprimer() {
			
	    	Connection cnx = null;
	    	PreparedStatement requete = null ;
	    	ResultSet resultat = null ;
	    	
	    	cnx = ConnexionMySQL.connectDB();	
			String sql = "DELETE FROM COMPAGNIE WHERE IDCOMPAGNIE = '"+getIdCompagnie()+"'";
			
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
	     * fonction qui retourne la liste des compagnie 
	     * @return ArrayList<Compagnie>
	     */
	    public static ArrayList<Compagnie> listeCompagnie() {
	 	   Connection cnx = null;
	 	   	PreparedStatement requete = null ;
	 	   	ResultSet resultat = null ;
	 	   	ArrayList<Compagnie> listeCompagnie = new ArrayList<Compagnie>();
	 		   
	 			cnx = ConnexionMySQL.connectDB();	
	 			String sql = "SELECT * FROM COMPAGNIE";

	 			try {
	 				requete = cnx.prepareStatement(sql);
	 				resultat = requete.executeQuery();
	 				while(resultat.next()) {
	 												
	 					listeCompagnie.add(new Compagnie(resultat.getString("IDCOMPAGNIE"), resultat.getString("NOMCOMPAGNIE"), resultat.getString("SITE"), resultat.getString("EMAIL"),resultat.getString("NUMTEL")));	 	 
	 				}
	 			} catch (SQLException e) {
	 				// TODO Auto-generated catch block
	 				e.printStackTrace();
	 			}
	 	return listeCompagnie;
	 	   
	    }
	    /**
	     * fonction qui retourn la liste d'aeronef d'une compagnie
	     * @param compagnie
	     * @return ArrayList<Aeronef>
	     */
	    public static ArrayList<Aeronef> listeAeronef(Compagnie compagnie){
	    	Connection cnx = null;
		   	PreparedStatement requete = null ;
		   	ResultSet resultat = null ;
		   	ArrayList<Aeronef> listeAeronf = new ArrayList<Aeronef>();
			   
				cnx = ConnexionMySQL.connectDB();	
				String sql = "SELECT * FROM Aeronef where IDCOMAGNIE'"+compagnie.getIdCompagnie()+"'";

				try {
					requete = cnx.prepareStatement(sql);
					resultat = requete.executeQuery();
					while(resultat.next()) {
						if(resultat.getString("TYPEAERONEF").equals("SPORT"))
							listeAeronf.add(new Aeronef(resultat.getString("Mat"), resultat.getString("NOMCONST"),resultat.getString("IDCOMAGNIE"),TypeAeronef.SPORT ,Double.parseDouble(resultat.getString("POIDS")), Integer.parseInt(resultat.getString("CAPACITE")), Double.parseDouble(resultat.getString("FRETAERONEF"))));
						else
							if(resultat.getString("TYPEAERONEF").equals("SERVICES_DIVERS"))
								listeAeronf.add(new Aeronef(resultat.getString("Mat"), resultat.getString("NOMCONST"),resultat.getString("IDCOMAGNIE"),TypeAeronef.SERVICES_DIVERS,Double.parseDouble(resultat.getString("POIDS")),Integer.parseInt(resultat.getString("CAPACITE")),Double.parseDouble(resultat.getString("FRETAERONEF"))));
							else
					            	if(resultat.getString("TYPEAERONEF").equals("USAGE_MILITAIRE"))
										listeAeronf.add(new Aeronef(resultat.getString("Mat"), resultat.getString("NOMCONST"),resultat.getString("IDCOMAGNIE"),TypeAeronef.USAGE_MILITAIRE ,Double.parseDouble(resultat.getString("POIDS")), Integer.parseInt(resultat.getString("CAPACITE")), Double.parseDouble(resultat.getString("FRETAERONEF"))));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		  
		return listeAeronf;
	    	
	    }
	    /**
	     * fonction qui retourne la liste des vol d'une compagnie
	     * @param compagnie
	     * @return ArrayList<Vol>
	     */
	    public static ArrayList<Vol> listeVol(Compagnie compagnie){
	    	
	    	 Connection cnx = null;
			   	PreparedStatement requete = null ;
			   	ResultSet resultat = null ;
			   	ArrayList<Vol> listeVol = new ArrayList<Vol>();
				   
					cnx = ConnexionMySQL.connectDB();	
					String sql = "SELECT * FROM vol where idCompagnie ='"+compagnie.getIdCompagnie()+"'";

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
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			return listeVol;
	    	
	    }

	    /**
	     * fonction qui retourn les dette de la compaginie
	     */
		@Override
		public double getDette() {
			// TODO Auto-generated method stub
			double dette = 0; 
			Connection cnx = null;
		   	PreparedStatement requete = null ;
		   	ResultSet resultat = null ;
		   			   
				cnx = ConnexionMySQL.connectDB();	
				String sql = "SELECT SUM(prix) AS prix_total FROM redevance WHERE compagnie = '"+getIdCompagnie()+"'";

				try {
					requete = cnx.prepareStatement(sql);
					resultat = requete.executeQuery();
					while(resultat.next()) {
						dette = resultat.getDouble("prix_total");				        		
		 
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return dette;
		}

		/**
		 * fonction qui retourn la liste des redevance de la compagnie
		 */
		@Override
		public ArrayList<Redevance> getRedevanceNom() {
			// TODO Auto-generated method stub
			Connection cnx = null;
		   	PreparedStatement requete = null ;
		   	ResultSet resultat = null ;
		   	ArrayList<Redevance> listeRedevance = new ArrayList<Redevance>();
			   
				cnx = ConnexionMySQL.connectDB();	
				String sql = "SELECT * FROM Redevance where payer = 'false' and compagnie = '"+getIdCompagnie()+"'";

				try {
					requete = cnx.prepareStatement(sql);
					resultat = requete.executeQuery();
					while(resultat.next()) {
						
					listeRedevance.add(new Redevance(resultat.getInt("idRedevance"),resultat.getDouble("prix"),resultat.getBoolean("payer"),resultat.getString("datePayement"),resultat.getString("compagnie"), resultat.getString("idVol")));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return listeRedevance;	
		}
		/**
		 * fonction qui retourn la somme des redevance de la compagnie
		 */
		@Override
		public double getTotalRed() {
			// TODO Auto-generated method stub
			Connection cnx = null;
		   	PreparedStatement requete = null ;
		   	ResultSet resultat = null ;
		   	double sum = 0;
			   
				cnx = ConnexionMySQL.connectDB();	
				String sql = "SELECT SUM(prix) from Redevance";

				try {
					requete = cnx.prepareStatement(sql);
					resultat = requete.executeQuery();
					while(resultat.next()){
						sum = resultat.getDouble("SUM(prix)");
					}
				
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			return sum;
		}
	   
}
