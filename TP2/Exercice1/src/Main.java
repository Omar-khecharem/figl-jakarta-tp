
public class Main {
    public static void main(String[] args) {
        Compte c = new Compte("C1", 500);
        try {
            c.deposer(200);
            c.retirer(100);
            c.retirer(1000);
        } catch (MontantInvalideException e) {
            System.out.println(e.getMessage());
        } catch (SoldeInsuffisantException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Solde:" + c.getSolde());
  
        }
    }
}