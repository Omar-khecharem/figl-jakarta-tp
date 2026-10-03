public class Compte {
	private String numero;
	private double solde;

	public Compte(String numero, double solde) {
		this.numero = numero;
		this.solde = solde;
	}

	public void deposer(double montant) throws MontantInvalideException {
		if (montant <= 0) {
			throw new MontantInvalideException("Le montant doit etre positif.");
		}

		solde += montant;
		System.out.println("Depot effectue : " + montant);
	}

	public void retirer(double montant) throws MontantInvalideException, SoldeInsuffisantException {
		if (montant <= 0) {
			throw new MontantInvalideException("Le montant doit etre positif");
		}

		if (montant > solde) {
			throw new SoldeInsuffisantException("Solde insuffisant");
		}

		solde -= montant;
		System.out.println("Retrait effectue:" + montant);
	}

	public double getSolde() {
		return solde;
	}
}