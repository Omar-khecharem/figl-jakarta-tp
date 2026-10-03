import java.util.ArrayList;

public class Bibliotheque {
	private ArrayList<Livre> livres = new ArrayList<>();

	public void ajouterLivre(Livre livre) {
		livres.add(livre);
	}

	public void emprunter(String titre) throws LivreIntrouvableException, LivreIndisponibleException {

		for (Livre livre : livres) {
			if (livre.getTitre().equalsIgnoreCase(titre)) {
				if (!livre.isDisponible()) {
					throw new LivreIndisponibleException("Le livre est deja emprunte");
				}

				livre.setDisponible(false);
				System.out.println("Emprunt effectue:" + titre);
				return;
			}
		}

		throw new LivreIntrouvableException("Livre introuvable:" + titre);
	}

	public void retourner(String titre) throws LivreIntrouvableException {

		for (Livre livre : livres) {
			if (livre.getTitre().equalsIgnoreCase(titre)) {
				livre.setDisponible(true);
				System.out.println("Livre retourne:" + titre);
				return;
			}
		}

		throw new LivreIntrouvableException("Livre introuvable:" + titre);
	}
}