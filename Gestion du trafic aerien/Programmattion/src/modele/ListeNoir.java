package modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class ListeNoir {
	
	private ArrayList<Aeronef> listeAeronefs = new ArrayList<Aeronef>();

	/***
	 * Constructeur
	 */
	public ListeNoir() {
		inilistenoir();
    }
	/**
	 * getter de la liste d'aeroport
	 * @return ArrayList<Aeronef>
	 */
	public ArrayList<Aeronef> getListeAeronefs() {
		return listeAeronefs;
	}

	/**
	 * avoir la liste noir
	 */
	private void inilistenoir() {
		
		Connection cnx = null;
		PreparedStatement requete = null ;
		ResultSet resultat = null ;
	
		cnx = ConnexionMySQL.connectDB();	
		String sql = "SELECT aeronef.mat, aeronef.NOMCONST,aeronef.TYPEAERONEF,aeronef.CAPACITE,aeronef.IDCOMAGNIE,aeronef.FRETAERONEF,aeronef.POIDS FROM aeronef INNER JOIN ListeNoir ON ListeNoir.idAeroneff = MAT";
		
		try {
			requete = cnx.prepareStatement(sql);
			resultat = requete.executeQuery();
			while(resultat.next()) {
				if(resultat.getString("TYPEAERONEF").equals("SPORT"))
					this.listeAeronefs.add(new Aeronef(resultat.getString("MAT"),resultat.getString("NOMCONST"), resultat.getString("IDCOMAGNIE"), TypeAeronef.SPORT,resultat.getDouble("POIDS"), resultat.getInt("CAPACITE"), resultat.getDouble("FRETAERONEF")));
				else
					if(resultat.getString("TYPEAERONEF").equals("SERVICES_DIVERS"))
						this.listeAeronefs.add(new Aeronef(resultat.getString("MAT"),resultat.getString("NOMCONST"), resultat.getString("IDCOMAGNIE"), TypeAeronef.SERVICES_DIVERS,resultat.getDouble("POIDS"), resultat.getInt("CAPACITE"), resultat.getDouble("FRETAERONEF")));
					  else
			            	if(resultat.getString("TYPEAERONEF").toString().equals("USAGE_MILITAIRE"))
								this.listeAeronefs.add(new Aeronef(resultat.getString("MAT"),resultat.getString("NOMCONST"), resultat.getString("IDCOMAGNIE"), TypeAeronef.USAGE_MILITAIRE,resultat.getDouble("POIDS"), resultat.getInt("CAPACITE"), resultat.getDouble("FRETAERONEF")));			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		
			e.printStackTrace();
	}

}
	/**
	 * fonction pour ajouter un aeronef a la liste noir dans la base de donnée
	 * @param idaero
	 */
	public void addAeronef(String idaero ) {
		 Connection cnx = null;
	    	PreparedStatement requete = null ;
	    	ResultSet resultat = null ;
					
			cnx = ConnexionMySQL.connectDB();	
			String sql = "INSERT INTO ListeNoir VALUES(?)";
			
			try {
				requete = cnx.prepareStatement(sql);
				requete.setString(1,idaero);
				requete.execute();
				JOptionPane.showMessageDialog(null, "ajouter avec succes ");
				
			   
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				
				e1.printStackTrace();
			
		}
			
	}
	/**
	 * fonction pour modifier la liste noir
	 * @param idaero
	 */
	public void removeAeronef(String idaero ) {
			Connection cnx = null;
	    	PreparedStatement requete = null ;
	    	ResultSet resultat = null ;
		cnx = ConnexionMySQL.connectDB();	
		String sql = "DELETE FROM ListeNoir WHERE idAeroneff = '"+idaero+"'";
		
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
