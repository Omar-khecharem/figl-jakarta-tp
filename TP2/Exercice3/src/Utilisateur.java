public class Utilisateur {
    private String login;
    private String password;
    private int tentatives = 0;
    private boolean bloque = false;

    public Utilisateur(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public void connecter(String login, String password)
            throws IdentifiantsInvalidesException, CompteBloqueException {

        if (bloque) {
            throw new CompteBloqueException("Compte bloque.");
        }

        if (this.login.equals(login) && this.password.equals(password)) {
            System.out.println("Connexion reussie !");
            tentatives = 0;
        } else {
            tentatives++;

            if (tentatives == 3) {
                bloque = true;
                throw new CompteBloqueException("Compte bloque apres 3 erreurs.");
            }

            throw new IdentifiantsInvalidesException(
                "Identifiants incorrects . Tentative " + tentatives + "/3"
            );
        }
    }
}