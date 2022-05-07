package model.comptoir;

import java.time.LocalDate;
import java.util.ArrayList;

public class CommandeClient extends Commande {
	
	private String client;
	
	private static ArrayList<CommandeClient> listeCommande = new ArrayList<CommandeClient>();
	
	public CommandeClient(String idCommande, LocalDate dateCommande) {
		super(idCommande, dateCommande);
	}

	public CommandeClient() {}

	public static ArrayList<CommandeClient> getListeCommande() {
		return listeCommande;
	}

	public static void setListeCommande(ArrayList<CommandeClient> listeCommande) {
		CommandeClient.listeCommande = listeCommande;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}
	
}
