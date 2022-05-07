package modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class Aeronef {
	
	protected String mat ;
	protected String nomConst ;
	protected Compagnie compagnie ;
	protected TypeAeronef typeAeronef ;
	protected double poids ;
	protected int capaciter ;
	protected double fret ;
	
	
	/**
	 * Constructeur
	 * 
	 * @param mat
	 * @param nomConst
	 * @param idcompagnie
	 * @param typeAeronef
	 * @param poids
	 * @param capaciter
	 * @param fret
	 */
	public Aeronef(String mat, String nomConst, String idcompagnie, TypeAeronef typeAeronef,
			double poids, int capaciter, double fret) {

		this.mat = mat;
		this.nomConst = nomConst;
		initCompagnie(idcompagnie);
		this.typeAeronef = typeAeronef;
		this.poids = poids;
		this.capaciter = capaciter;
		this.fret = fret;
	}
	/**
	 * avoir une compagnie grace a l'id que on utilisera dans le constructeur qui va etre rechercher dans la base de donnée
	 *
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}

	}
	/**
	 * getter de matricule	
	 * @return matricule
	 */
	public String getMat() {
		return mat;
	}
	/**
	 * getter du non constricteur
	 * @return non du contricteur
	 */
	public String getNomConst() {
		return nomConst;
	}
	/**
	 * getter de compagnie
	 * @return la compagnie
	 */
	public Compagnie getCompagnie() {
		return compagnie;
	}
	/**
	 * getter de type aeronef
	 * @return type aeronef
	 */
	public TypeAeronef getTypeAeronef() {
		return typeAeronef;
	}
	/***
	 * getter du poids
	 * @return le poids 
	 */
	public double getPoids() {
		return poids;
	}

	/**
	 * getter de capaciter
	 * @return la capaciter max
	 */
	public int getCapaciter() {
		return capaciter;
	}
	/**
	 * getter de fret
	 * @return frert de l aeronef
	 */
	public double getFret() {
		return fret;
	}
	
	/**
	 * fonctoin pour ajouter un aeronef a la base de donnée
	 */
	public void AjouterAeronef() {			

		    Connection cnx = null;
	    	PreparedStatement requete = null ;
	    	ResultSet resultat = null ;
					
			cnx = ConnexionMySQL.connectDB();	
			String sql = "INSERT INTO Aeronef (Mat,NOMCONST,TYPEAERONEF,CAPACITE,IDCOMAGNIE,FRETAERONEF,POIDS) VALUES(?,?,?,?,?,?,?)"; 
			try {
				requete = cnx.prepareStatement(sql);
				requete.setString(1,getMat().toString());
				requete.setString(2,getNomConst().toString());
				requete.setString(3,getTypeAeronef().toString());
				requete.setInt(4,getCapaciter());
				requete.setString(5,getCompagnie().getIdCompagnie().toString());
				requete.setDouble(6,getFret());
				requete.setDouble(7,getPoids());
				requete.execute();
				JOptionPane.showMessageDialog(null, "ajouter avec succes ");
				
			   
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				
				e1.printStackTrace();
			
		}
	 }
	/**
	 * fonction pour modifier un aeronef dans la base de donnée
	 */
	 public void Modifier() {
			
		    Connection cnx = null;
	    	PreparedStatement requete = null ;
	    	ResultSet resultat = null ;
			cnx = ConnexionMySQL.connectDB();	
			String sql = "UPDATE Aeronef SET Mat = ? , NOMCONST = ? ,TYPEAERONEF = ? ,CAPACITE = ?,IDCOMAGNIE = ? , FRETAERONEF = ? , POIDS = ? WHERE Mat = '"+getMat()+"'";
			
			try {
				requete = cnx.prepareStatement(sql);
				requete.setString(1,getMat().toString());
				requete.setString(2,getNomConst().toString());
				requete.setString(3,getTypeAeronef().toString());
				requete.setInt(4,getCapaciter());
				requete.setString(5,getCompagnie().getIdCompagnie().toString());
				requete.setDouble(6,getFret());
				requete.setDouble(7,getPoids());
				
				requete.execute();
				JOptionPane.showMessageDialog(null, "Modifier avec succes ");
				
			   
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				
				e1.printStackTrace();
			}		
		}
	 /**
	  * fonction pour supprimer un aeronef dans la base de donnée
	  */
	  public void Supprimer() {
			
		     Connection cnx = null;
	    	PreparedStatement requete = null ;
	    	ResultSet resultat = null ;
		cnx = ConnexionMySQL.connectDB();	
		String sql = "DELETE FROM Aeronef WHERE MAT = '"+getMat()+"'";
		
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
	   * 
	   * @return la liste d'aeronef que on a sauvgarder dans la base de donnée
	   */
	  public static ArrayList<Aeronef> listeAeronef() {
		  
		  Connection cnx = null;
		   	PreparedStatement requete = null ;
		   	ResultSet resultat = null ;
		   	ArrayList<Aeronef> listeAeronf = new ArrayList<Aeronef>();
			   
				cnx = ConnexionMySQL.connectDB();	
				String sql = "SELECT * FROM Aeronef";

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
	
}
