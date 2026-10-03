public class Main {
    public static void main(String[] args) {
        Bibliotheque b = new Bibliotheque();

        b.ajouterLivre(new Livre("Java"));
		b.ajouterLivre(new Livre("Python"));

        try {
            b.emprunter("Java");
            b.emprunter("Java");
        } catch (LivreIntrouvableException e) {
            System.out.println(e.getMessage());
        } catch (LivreIndisponibleException e) {
            System.out.println(e.getMessage());
        }

        try {
            b.retourner("Java");
            b.emprunter("Java");
        } catch (LivreIntrouvableException e) {
            System.out.println(e.getMessage());
        } catch (LivreIndisponibleException e) {
            System.out.println(e.getMessage());
        }
    }
}