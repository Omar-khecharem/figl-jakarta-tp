
public class Livre {
    private String titre;
    private boolean disponible;

    public Livre(String titre) {
        this.titre = titre;
        this.disponible = true;
    }

    public String getTitre() {
        return titre;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}