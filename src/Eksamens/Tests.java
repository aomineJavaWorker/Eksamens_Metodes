package Eksamens;

import java.util.ArrayList;

public class Tests {
	
	static class Atbilde {
        String teksts;
        boolean irPareiza;

        Atbilde(String teksts, boolean irPareiza) {
            this.teksts = teksts;
            this.irPareiza = irPareiza;
        }
    }
	static class Jautajums {
        String teksts;
        ArrayList<Atbilde> atbildes;	
        int pareizaAtbilde;

        Jautajums(String teksts, String[] varianti, int pareizaisIndekss) {
            this.teksts = teksts;
            this.atbildes = new ArrayList<>();
            for (int i = 0; i < varianti.length; i++) {
                atbildes.add(new Atbilde(varianti[i], i == pareizaisIndekss));
            }
        }
	}

	public static void main(String[] args) {
		ArrayList<Jautajums> jautajumi = new ArrayList<Jautajums>();
		jautajumi.add(new Jautajums("Kas ir metode Java valodā?",new String[]{"Mainīgais", "Cipars", 
				"Koda bloks, ko var izsaukt", "Datu tips"},2));
		jautajumi.add(new Jautajums("Kā sauc nodotus datus metodei?",new String[] {"Metodei nevar nodot datus","Objekts",
				"Funkcijas","Parametri"},3));
		jautajumi.add(new Jautajums("Kur ir jābut deklarētai metodei?",new String[] {"Klases ietveros","Ārpus visām klasēm",
				"Mainīgā iekšienē","Faila nosaukumā"},0));
		jautajumi.add(new Jautajums("Cik ir piekļuves modifikātori?",new String[] {"4","2",
				"5","3"},0));
		jautajumi.add(new Jautajums("Kurš piekļuves modifikātors ir pieejams no jebkuras vietas?",new String[] {"Private","Public",
				"Default","Protected"},1));
		jautajumi.add(new Jautajums("Kuram piekļuves modifikātoram nevar piekļūt no citas klases,bet tikai no deklarētās ?",new String[] {"Private","Public",
				"Default","Protected"},0));
		jautajumi.add(new Jautajums("Ja piekļuves modifikatoru nenorāda, tas tiek automātiski iestatīts uz...?",new String[] {"Private","Public",
				"Default","Protected"},2));
		jautajumi.add(new Jautajums("Kam pieder statiskā metode?",new String[] {"Klasei","klases objektam",
				"Konstruktoram","Interfeisam"},0));
		jautajumi.add(new Jautajums("Kur tiek norādīti parametri?",new String[] {"Pēc klases deklarācijas","Komentārā virs metodes",
				"pēc metodes nosaukuma, iekavās","Faila beigās"},2));
		jautajumi.add(new Jautajums("Statisko metodi var izsaukt, neveidojot klases ...?",new String[] {"Konstruktoru","Mainīgo",
				"objekta metodi, iekavās","instanci"},3));
		
		
		
		
		
		
		

	}

}
