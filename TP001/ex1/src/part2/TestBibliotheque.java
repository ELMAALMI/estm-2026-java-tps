package part2;

public class TestBibliotheque {
    static int reussis = 0, echoues = 0;

    // Compare le résultat obtenu au résultat attendu et affiche le verdict.
    static void tester(String nom, Object obtenu, Object attendu) {
        if (String.valueOf(obtenu).equals(String.valueOf(attendu))) {
            reussis++;
            System.out.println("[OK] " + nom);
        } else {
            echoues++;
            System.out.println("[ECHEC] " + nom);
            System.out.println(" obtenu : " + obtenu + " | attendu : " + attendu);
        }
    }

    public static void main(String[] args) {
        int avant = Livre.getNbLivres();
        Livre l1 = new Livre("Germinal", "Zola", 123);
        Livre l0 = new Livre();
        tester("CA2 titre", l1.getTitre(), "Germinal");
        tester("CA2 isbn", l1.getIsbn(), 123);
        tester("CA2 disponible", l1.isEmprunte(), false);
        tester("CA3 defaut", l0.getTitre() + "/" + l0.getIsbn(), "Inconnu/0");
        l1.setIsbn(-5);
        tester("CA4 isbn negatif refuse", l1.getIsbn(), 123);
        tester("CA5 premier emprunt", l1.emprunter(), true);
        tester("CA5 second emprunt", l1.emprunter(), false);
        tester("CA6 retour", l1.rendre(), true);
        tester("CA6 second retour", l1.rendre(), false);
        tester("CA7 toString", l1, "Germinal - Zola - ISBN 123 - disponible");
        tester("CA8 compteur", Livre.getNbLivres() - avant, 2);
        Bibliotheque b = new Bibliotheque(1);
        tester("CA9 ajout", b.ajouterLivre(l1), true);
        tester("CA9 bibliotheque pleine", b.ajouterLivre(l0), false);
        tester("CA9 recherche", b.rechercherParTitre("Germinal"), l1);
        tester("CA9 titre absent", b.rechercherParTitre("Nana"), null);
        tester("CA9 disponibles", b.nombreDisponibles(), 1);

        Livre horla = new Livre("Le Horla", "Maupassant", 0);
        tester("ISBN egal a 0", horla.getIsbn(), 0);

        Bibliotheque vide = new Bibliotheque(5);
        tester("recherche bibliotheque vide", vide.rechercherParTitre("Germinal"), null);

        l1.emprunter();
        tester("disponibles apres emprunt", b.nombreDisponibles(), 0);

        System.out.println(reussis + " test(s) réussi(s), " + echoues + " échec(s)");
    }
}
