package modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class Statistique implements StatistiqueGlob {
	
	public Statistique() {
		
	}
	
	  public static ArrayList<VolEncour> listeDecollage(){
			 
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
			return l;
	  }
	  public static ArrayList<VolEncour> listeAtterrissage(){
		  Connection cnx = null;
			PreparedStatement requete = null ;
			ResultSet resultat = null ;
			ArrayList<VolEncour> l = new ArrayList<VolEncour>();
		
			cnx = ConnexionMySQL.connectDB();	
			String sql = "SELECT * FROM `vol` WHERE HEUREDEPART > CURRENT_TIME +20";
			
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
	  public static ArrayList<Utilisateur> listeUtilisateur() {
		   Connection cnx = null;
		   	PreparedStatement requete = null ;
		   	ResultSet resultat = null ;
		   	ArrayList<Utilisateur> listeUtilisateur = new ArrayList<Utilisateur>();
			   
				cnx = ConnexionMySQL.connectDB();	
				String sql = "SELECT * FROM utilisateur";

				try {
					requete = cnx.prepareStatement(sql);
					resultat = requete.executeQuery();
					while(resultat.next()) {
						
						if(resultat.getString("Poste").equals("CONTROLEUR_AERIEN"))
						      listeUtilisateur.add(new Utilisateur(Integer.parseInt(resultat.getString("IDUTILISATEUR")),resultat.getString("PSEUDO"),resultat.getString("MOTDEPASSE"),resultat.getString("NOM"), resultat.getString("PRENOM"), Poste.CONTROLEUR_AERIEN)) ;
						else
							if(resultat.getString("Poste").equals("INGENIEUR_PREPARATEUR_DE_VOL"))
							      listeUtilisateur.add(new Utilisateur(Integer.parseInt(resultat.getString("IDUTILISATEUR")),resultat.getString("PSEUDO"),resultat.getString("MOTDEPASSE"),resultat.getString("NOM"), resultat.getString("PRENOM"),Poste.INGENIEUR_PREPARATEUR_DE_VOL)) ;		
							else 
								if(resultat.getString("Poste").equals("COORDINATEUR_DE_VOL"))
								      listeUtilisateur.add(new Utilisateur(Integer.parseInt(resultat.getString("IDUTILISATEUR")),resultat.getString("PSEUDO"),resultat.getString("MOTDEPASSE"),resultat.getString("NOM"), resultat.getString("PRENOM"),Poste.COORDINATEUR_DE_VOL)) ;		
								else 
									if(resultat.getString("Poste").equals("RESPONSABLE_D_EXPLOITATION_AEROPORTUAIRE"))
									      listeUtilisateur.add(new Utilisateur(Integer.parseInt(resultat.getString("IDUTILISATEUR")),resultat.getString("PSEUDO"),resultat.getString("MOTDEPASSE"),resultat.getString("NOM"), resultat.getString("PRENOM"),Poste.RESPONSABLE_D_EXPLOITATION_AEROPORTUAIRE));  		
									else
										if(resultat.getString("Poste").equals("INGENIEUR_OPERATION_DE_VOL"))
										      listeUtilisateur.add(new Utilisateur(Integer.parseInt(resultat.getString("IDUTILISATEUR")),resultat.getString("PSEUDO"),resultat.getString("MOTDEPASSE"),resultat.getString("NOM"), resultat.getString("PRENOM"),Poste.INGENIEUR_OPERATION_DE_VOL)) ; 		

										else
											if(resultat.getString("Poste").equals("INGENIEUR_SECURITE_AERIEN"))
											      listeUtilisateur.add(new Utilisateur(Integer.parseInt(resultat.getString("IDUTILISATEUR")),resultat.getString("PSEUDO"),resultat.getString("MOTDEPASSE"),resultat.getString("NOM"), resultat.getString("PRENOM"), Poste.INGENIEUR_SECURITE_AERIEN));  		
												else
													if(resultat.getString("Poste").equals("ANALYSTE_DE_VOL"))
													      listeUtilisateur.add(new Utilisateur(Integer.parseInt(resultat.getString("IDUTILISATEUR")),resultat.getString("PSEUDO"),resultat.getString("MOTDEPASSE"),resultat.getString("NOM"), resultat.getString("PRENOM"),Poste.ANALYSTE_DE_VOL))  ;		
													else
		                                               if(resultat.getString("Poste").equals("ADMINISTRATEUR"))
		                     						      listeUtilisateur.add(new Utilisateur(Integer.parseInt(resultat.getString("IDUTILISATEUR")),resultat.getString("PSEUDO"),resultat.getString("MOTDEPASSE"),resultat.getString("NOM"), resultat.getString("PRENOM"), Poste.ADMINISTRATEUR));  		
		 
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return listeUtilisateur;
		   
	   }
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
	  public Piste[] getPisteDense() {
		
		  Piste[] pistes = new Piste[5];
		  
		   Connection cnx = null;
		   	PreparedStatement requete = null ;
		   	ResultSet resultat = null ;
		   	int i = 0;
				cnx = ConnexionMySQL.connectDB();	
				String sql = "select idpiste from demandevol group by idpiste order by count(*) desc limit 5";

				try {
					requete = cnx.prepareStatement(sql);
					resultat = requete.executeQuery();
					while(resultat.next()) {
						pistes[i] = new Piste(resultat.getInt("idpiste"));			        		
								i++;

					}
					requete.close();
					cnx.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return pistes;
		  
	  }
	  @Override
		public int getNbAeroneff(TypeAeronef t) {
			// TODO Auto-generated method stub
		  Connection cnx = null;
	    	PreparedStatement requete = null ;
	    	ResultSet resultat = null ;
	    	int nbr=0;
			
			
			cnx = ConnexionMySQL.connectDB();	
			String sql = "SELECT COUNT(*) FROM Aeronef WHERE TYPEAERONEF = '"+t.toString()+"'";

			try {
				requete = cnx.prepareStatement(sql);
				resultat = requete.executeQuery();
				while(resultat.next()) {
					 nbr = resultat.getInt("COUNT(*)");			
									
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return nbr;
		}
	@Override
	public int getNbAtterissage(Compagnie comp) {
		// TODO Auto-generated method stub
		int sum = 0 ;
		for (int i = 0; i < DemandeVol.listedemande().size(); i++) {
			if (DemandeVol.listedemande().get(i).getVol().getCompagnie().getIdCompagnie().equals(comp.getIdCompagnie()) &&
					DemandeVol.listedemande().get(i).getAccorder().equals("true") &&
					DemandeVol.listedemande().get(i).getType().equals("ATEERISSAGE")) {
				sum++;				
			}			
		}
		return sum;
	}
	public int getNbDec(Compagnie comp) {
		int sum = 0 ;
		for (int i = 0; i < DemandeVol.listedemande().size(); i++) {
			if (DemandeVol.listedemande().get(i).getVol().getCompagnie().getIdCompagnie().equals(comp.getIdCompagnie()) &&
					DemandeVol.listedemande().get(i).getAccorder().equals("true") &&
					DemandeVol.listedemande().get(i).getType().equals("DECOLLAGE")) {
				sum++;				
			}			
		}
		return sum;
	}
	@Override
	public double getMontant() {
		// TODO Auto-generated method stub
		double total = 0; 
		Connection cnx = null;
	   	PreparedStatement requete = null ;
	   	ResultSet resultat = null ;
	   			   
			cnx = ConnexionMySQL.connectDB();	
			String sql = "SELECT SUM(prix) AS prix_total FROM redevance";

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
	  public Compagnie getCompagnieImposé() {
			Compagnie compagnie = new Compagnie();	  
		   Connection cnx = null;
		   	PreparedStatement requete = null ;
		   	ResultSet resultat = null ;
		   	int i = 0;
				cnx = ConnexionMySQL.connectDB();	
				String sql = "select idcompagnie from vol group by idcompagnie order by count(*) desc limit 1";

				try {
					requete = cnx.prepareStatement(sql);
					resultat = requete.executeQuery();
					while(resultat.next()) {
						compagnie = new Compagnie(resultat.getString("idcompagnie"));						
					}
					requete.close();
					cnx.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return compagnie;
		  
	  }
	  

}
