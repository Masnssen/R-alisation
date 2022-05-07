package modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PisteDegager extends Piste {
	
	private int idpisteDegager;

	public PisteDegager(int idpisteDegager,int idPiste) {
		super(idPiste, initPiste(idPiste).getLongeur(),initPiste(idPiste).getAeroport().getIdAeroport());
		// TODO Auto-generated constructor stub
		this.idpisteDegager = idpisteDegager;
	}
	public PisteDegager(int idPiste) {
		super(idPiste, initPiste(idPiste).getLongeur(),initPiste(idPiste).getAeroport().getIdAeroport());
		// TODO Auto-generated constructor stub
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

	public int getIdpisteDegager() {
		return idpisteDegager;
	}
	
	public static ArrayList<PisteDegager> listePisteDegager_date_heure(String date,String heure){
		ArrayList<PisteDegager> listePistedeg = new ArrayList<PisteDegager>();
		ArrayList<PisteReserver> liste = new ArrayList<PisteReserver>();
		for (int i = 0; i < PisteReserver.listePisteReserver().size(); i++) {
			if (PisteReserver.listePisteReserver().get(i).getDate().equals(date) && PisteReserver.listePisteReserver().get(i).getHeure().equals(heure)) {
				liste.add(new PisteReserver(PisteReserver.listePisteReserver().get(i).getIdpisteReserver(),PisteReserver.listePisteReserver().get(i).getIdPiste(),
						PisteReserver.listePisteReserver().get(i).getDate(), PisteReserver.listePisteReserver().get(i).getHeure()));
			}
		}
		
		if (liste.size() == 0) {
			for (int i = 0; i < Piste.listePiste().size(); i++) {
				listePistedeg.add(new PisteDegager(Piste.listePiste().get(i).getIdPiste()));
			}
		}
		for (int i = 0; i < Piste.listePiste().size(); i++) {
			int j=0;
			while( j < liste.size()) {
			if (liste.get(j).getIdPiste() == Piste.listePiste().get(i).getIdPiste()) {
				j++;
			}else {
				
				listePistedeg.add(new PisteDegager(Piste.listePiste().get(i).getIdPiste()));
				j = liste.size();
			}
		}
		
		}
		return listePistedeg;	
	}
	public static ArrayList<PisteDegager> listePisteDegager_date(String date){
		ArrayList<PisteDegager> listePistedeg = new ArrayList<PisteDegager>();
		ArrayList<PisteReserver> liste = new ArrayList<PisteReserver>();
		for (int i = 0; i < PisteReserver.listePisteReserver().size(); i++) {
			if (PisteReserver.listePisteReserver().get(i).getDate().equals(date)) {
				liste.add(new PisteReserver(PisteReserver.listePisteReserver().get(i).getIdpisteReserver(),PisteReserver.listePisteReserver().get(i).getIdPiste(),
						PisteReserver.listePisteReserver().get(i).getDate(), PisteReserver.listePisteReserver().get(i).getHeure()));
			}
		}
		
		if (liste.size() == 0) {
			for (int i = 0; i < Piste.listePiste().size(); i++) {
				listePistedeg.add(new PisteDegager(Piste.listePiste().get(i).getIdPiste()));
			}
		}
		for (int i = 0; i < Piste.listePiste().size(); i++) {
			int j=0;
			while( j < liste.size()) {
			if (liste.get(j).getIdPiste() == Piste.listePiste().get(i).getIdPiste()) {
				j++;
			}else {
				
				listePistedeg.add(new PisteDegager(Piste.listePiste().get(i).getIdPiste()));
				j = liste.size();
			}
		}
		
		}
		return listePistedeg;	
	}
}
