package part2;

public class Bibliotheque {
    private Livre[] livres;
    private int nombreLivres;

    public Bibliotheque(int capacite) {
        livres = new Livre[capacite];
        nombreLivres = 0;
    }

    public boolean ajouterLivre(Livre livre) {
        if (nombreLivres >= livres.length) {
            return false;
        }
        livres[nombreLivres] = livre;
        nombreLivres++;
        return true;
    }

    public Livre rechercherParTitre(String titre) {
        for (int indice = 0; indice < nombreLivres; indice++) {
            if (livres[indice].getTitre().equals(titre)) {
                return livres[indice];
            }
        }
        return null;
    }

    public int nombreDisponibles() {
        int disponibles = 0;
        for (int indice = 0; indice < nombreLivres; indice++) {
            if (!livres[indice].isEmprunte()) {
                disponibles++;
            }
        }
        return disponibles;
    }

    public void afficherTout() {
        for (int indice = 0; indice < nombreLivres; indice++) {
            livres[indice].afficherDetails();
        }
    }
}
