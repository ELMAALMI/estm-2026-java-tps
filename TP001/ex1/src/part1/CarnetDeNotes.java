package part1;

import java.util.Locale;
import java.util.Scanner;

public class CarnetDeNotes {
    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Nombre de notes : ");
        int nombreDeNotes = clavier.nextInt();
        double[] notes = new double[nombreDeNotes];

        for (int indice = 0; indice < nombreDeNotes; indice++) {
            System.out.print("Note " + (indice + 1) + " : ");
            double noteSaisie = clavier.nextDouble();
            while (!estValide(noteSaisie)) {
                System.out.print("Note invalide (0 à 20). Note " + (indice + 1) + " : ");
                noteSaisie = clavier.nextDouble();
            }
            notes[indice] = noteSaisie;
        }

        double moyenneObtenue = moyenne(notes);
        System.out.println("Nombre de notes : " + notes.length);
        System.out.println("Moyenne : " + moyenneObtenue);
        System.out.println("Meilleure note : " + meilleure(notes));
        System.out.println("Plus faible : " + plusFaible(notes));
        System.out.println("Mention : " + mention(moyenneObtenue));

        for (int indice = 0; indice < notes.length; indice++) {
            System.out.println("Note " + (indice + 1) + " | " + barre(notes[indice]));
        }

        clavier.close();
    }

    static boolean estValide(double note) {
        return note >= 0 && note <= 20;
    }

    static double moyenne(double[] notes) {
        double somme = 0;
        for (double note : notes) {
            somme += note;
        }
        return somme / notes.length;
    }

    static double meilleure(double[] notes) {
        double plusGrande = notes[0];
        for (int indice = 1; indice < notes.length; indice++) {
            if (notes[indice] > plusGrande) {
                plusGrande = notes[indice];
            }
        }
        return plusGrande;
    }

    static double plusFaible(double[] notes) {
        double plusPetite = notes[0];
        for (int indice = 1; indice < notes.length; indice++) {
            if (notes[indice] < plusPetite) {
                plusPetite = notes[indice];
            }
        }
        return plusPetite;
    }

    static String mention(double moyenne) {
        if (moyenne >= 16) {
            return "Excellent";
        }
        if (moyenne >= 14) {
            return "Bien";
        }
        if (moyenne >= 12) {
            return "Assez bien";
        }
        if (moyenne >= 10) {
            return "Passable";
        }
        return "Insuffisant";
    }

    static String barre(double note) {
        int nombreEtoiles = (int) note;
        String etoiles = "";
        for (int indice = 0; indice < nombreEtoiles; indice++) {
            etoiles += "*";
        }
        return etoiles;
    }
}
