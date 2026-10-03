import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Utilisateur utilisateur = new Utilisateur("admin", "abc");

        while (true) {
            System.out.print("Login : ");
            String login = sc.nextLine();

            System.out.print("Mot de passe : ");
            String password = sc.nextLine();

            try {
                utilisateur.connecter(login, password);
                break;
            } catch (IdentifiantsInvalidesException e) {
                System.out.println("Erreur : " + e.getMessage());
            } catch (CompteBloqueException e) {
                System.out.println(e.getMessage());
                break;
            }
        }

        sc.close();
    }
}