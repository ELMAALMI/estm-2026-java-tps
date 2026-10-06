package part2;

public class Livre {
    private String titre;
    private String auteur;
    private int isbn;
    private boolean emprunte;
    private static int nbLivres = 0;

    public Livre(String titre, String auteur, int isbn) {
        this.titre = titre;
        this.auteur = auteur;
        this.isbn = isbn;
        this.emprunte = false;
        nbLivres++;
    }

    public Livre() {
        this("Inconnu", "Inconnu", 0);
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public int getIsbn() {
        return isbn;
    }

    public boolean isEmprunte() {
        return emprunte;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setIsbn(int isbn) {
        if (isbn < 0) {
            return;
        }
        this.isbn = isbn;
    }

    public boolean emprunter() {
        if (emprunte) {
            System.out.println("Emprunt impossible : le livre est déjà emprunté.");
            return false;
        }
        emprunte = true;
        return true;
    }

    public boolean rendre() {
        if (!emprunte) {
            System.out.println("Retour impossible : le livre est déjà disponible.");
            return false;
        }
        emprunte = false;
        return true;
    }

    @Override
    public String toString() {
        String etat = emprunte ? "indisponible" : "disponible";
        return titre + " - " + auteur + " - ISBN " + isbn + " - " + etat;
    }

    public void afficherDetails() {
        System.out.println(toString());
    }

    public static int getNbLivres() {
        return nbLivres;
    }
}
