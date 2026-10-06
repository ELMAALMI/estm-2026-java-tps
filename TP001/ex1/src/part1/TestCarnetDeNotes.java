package part1;

class TestCarnetDeNotes {
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
        double[] notes = { 10, 15, 12.5 };
        tester("CA2 estValide(-1)", CarnetDeNotes.estValide(-1), false);
        tester("CA2 estValide(20)", CarnetDeNotes.estValide(20), true);
        tester("CA2 estValide(20.5)", CarnetDeNotes.estValide(20.5), false);
        tester("CA4 moyenne", CarnetDeNotes.moyenne(notes), 12.5);
        tester("CA5 meilleure", CarnetDeNotes.meilleure(notes), 15.0);
        tester("CA5 plusFaible", CarnetDeNotes.plusFaible(notes), 10.0);
        tester("CA6 mention(9.99)", CarnetDeNotes.mention(9.99), "Insuffisant");
        tester("CA6 mention(10)", CarnetDeNotes.mention(10), "Passable");
        tester("CA6 mention(12)", CarnetDeNotes.mention(12), "Assez bien");
        tester("CA6 mention(14)", CarnetDeNotes.mention(14), "Bien");
        tester("CA6 mention(16)", CarnetDeNotes.mention(16), "Excellent");
        tester("CA7 barre(12.5)", CarnetDeNotes.barre(12.5), "************");
        tester("CA7 barre(0)", CarnetDeNotes.barre(0), "");
        System.out.println(reussis + " test(s) réussi(s), " + echoues + " échec(s)");
    }
}
