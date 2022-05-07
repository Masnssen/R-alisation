package modele;

public interface StatistiqueGlob {
	
	public int getNbAeroneff (TypeAeronef t);
	public int getNbAtterissage(Compagnie comp);
	public int getNbDec(Compagnie comp);
	public double getMontant();
	public Piste[] getPisteDense() ;

}
