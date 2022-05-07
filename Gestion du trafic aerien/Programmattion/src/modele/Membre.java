package modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class Membre {
	
	protected int idMembre ;
	protected String nomMembre ;
	protected int nbHeure ;	
	
	/**
	 * Constructeur
	 * @param nomMembre
	 * @param nbHeure
	 */
	public Membre(String nomMembre, int nbHeure) {
			super();
			this.nomMembre = nomMembre;
			this.nbHeure = nbHeure;
		}

	/**
	 * Constructeur
	 * @param idMembre
	 * @param nomMembre
	 * @param nbHeure
	 */
	public Membre(int idMembre, String nomMembre, int nbHeure) {
			super();
			this.idMembre = idMembre;
			this.nomMembre = nomMembre;
			this.nbHeure = nbHeure;
			}

	/**
	 * getter du non du memebre
	 * @return String
	 */
		public String getNomMembre() {
			return nomMembre;
		}
		/**
		 * getter du nombre d heure 		
		 * @return int
		 */
		public int getNbHeure() {
			return nbHeure;
		}
		/**
		 * getter id memebre
		 * @return int
		 */
		public int getIdMembre() {
			return idMembre;
		}
		/**
		 * fonction pour ajouter un membre a la base de donnée
		 */
		 public  void AjouterMembre() {			

			    Connection cnx = null;
		    	PreparedStatement requete = null ;
		    	ResultSet resultat = null ;
						
				cnx = ConnexionMySQL.connectDB();	
				String sql = "INSERT INTO MEMBRE (NOMMEMBRE,NBHEUREVOL) VALUES(?,?)";
				
				try {
					requete = cnx.prepareStatement(sql);
					requete.setString(1,getNomMembre().toString());
					requete.setInt(2,getNbHeure());
					

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
				String sql = "UPDATE MEMBRE SET NOMMEMBRE = ? , NBHEUREVOL = ?  WHERE IDMEMBRE = "+getIdMembre();
				
				try {
					requete = cnx.prepareStatement(sql);
					requete.setString(1,getNomMembre().toString());
					requete.setInt(2,getNbHeure());
					
					JOptionPane.showMessageDialog(null, "Modifier avec succes ");
					
				   
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					
					e1.printStackTrace();
				}		
			}
		 /**
		  * fonction pour supprimer un membre de la base de donnée
		  */
		  public void Supprimer() {
				
			     Connection cnx = null;
		    	PreparedStatement requete = null ;
		    	ResultSet resultat = null ;
			cnx = ConnexionMySQL.connectDB();	
			String sql = "DELETE FROM MEMBRE WHERE IDMEMBRE = "+getIdMembre();
			
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
