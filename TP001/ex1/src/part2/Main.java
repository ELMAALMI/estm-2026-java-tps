package part2;

public class Main {
    public static void main(String[] args) {
        Bibliotheque bibliotheque = new Bibliotheque(10);
        Livre germinal = new Livre("Germinal", "Zola", 123);
        Livre inconnu = new Livre();

        bibliotheque.ajouterLivre(germinal);
        bibliotheque.ajouterLivre(inconnu);
        germinal.emprunter();

        bibliotheque.afficherTout();
        System.out.println("Livres disponibles : " + bibliotheque.nombreDisponibles());
    }
}
