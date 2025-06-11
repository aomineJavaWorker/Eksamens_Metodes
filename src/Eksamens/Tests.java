package Eksamens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.swing.JOptionPane;

public class Tests {
	static class Atbilde {// Atbildes klase satur tekstu un informāciju, vai tā ir pareiza
        String teksts;
        boolean irPareiza;

        Atbilde(String teksts, boolean irPareiza) {
            this.teksts = teksts;
            this.irPareiza = irPareiza;
        }
    }
	static class Jautajums {// Jautājuma klase satur jautājuma tekstu atbilžu sarakstu un pareizās atbildes indeksu
        String teksts;
        ArrayList<Atbilde> atbildes;	
        int pareizaAtbilde;

        Jautajums(String teksts, String[] varianti, int pareizaisIndekss) {//Konstruktors
            this.teksts = teksts;
            this.atbildes = new ArrayList<>();
            for (int i = 0; i < varianti.length; i++) {
                atbildes.add(new Atbilde(varianti[i], i == pareizaisIndekss));
            }
        }
	}

	public static void main(String[] args) {
		
		ArrayList<Jautajums> jautajumi = new ArrayList<Jautajums>();//Saraksts ar jautājumiem
		
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
		
		Collections.shuffle(jautajumi);// Sajauc jautājumu secību
		int punkti = 0;
		String izv,izvD;
		int izvIndekss;
		int izvIndekssD;
            String[] darbibas = {"Uzsākt testu","Iziet no programmas"};
            izvD = (String) JOptionPane.showInputDialog(null,
        			"Izvelies darbību", "Izvele", JOptionPane.QUESTION_MESSAGE,
        			null, darbibas, darbibas[0]);
        			izvIndekssD = Arrays.asList(darbibas).indexOf(izvD);
        	switch(izvIndekssD) {
        	case 0:
        		for (Jautajums j : jautajumi) { // for each cikls
                    Collections.shuffle(j.atbildes); // Sajauc atbilžu secību

                    String[] opcijas = new String[j.atbildes.size()]; // Izveido masīvu ar atbilžu tekstiem
                    for (int i = 0; i < j.atbildes.size(); i++) {
                        opcijas[i] = j.atbildes.get(i).teksts; // aizpildam masīvu ar tekstu
                    }
            izv = (String) JOptionPane.showInputDialog(null,
        			j.teksts, "Izvele", JOptionPane.QUESTION_MESSAGE,
        			null, opcijas, opcijas[0]);// Parāda jautājumu ar atbilžu variantiem
            if (izv == null) {
                System.exit(0); //Ja izvēlās cancel vai krustiņu tad programma pārstaj darbību
            }
        			izvIndekss = Arrays.asList(opcijas).indexOf(izv);// Atrod izvēlētās atbildes indeksu
            if (izvIndekss >= 0 && j.atbildes.get(izvIndekss).irPareiza) {// Ja izvēlētā atbilde ir pareiza
                punkti += 2;
                JOptionPane.showMessageDialog(null, "Pareizi! +2 punkti");
            } else {
                punkti -= 1;//Ja nav(
                JOptionPane.showMessageDialog(null, "Nepareizi. -1 punkts");
            }
        }
		if(punkti<0) {
			JOptionPane.showMessageDialog(null, "Testa beigas. Jūsu rezultāts: " + punkti + " punkti.Jūs neko nezinat((");
			}else if(punkti>0 && punkti<=9) {
				JOptionPane.showMessageDialog(null, "Testa beigas. Jūsu rezultāts: " + punkti + " punkti. Vel ir jāpamācās");
			}else if(punkti>=10 && punkti<=13) {
				JOptionPane.showMessageDialog(null, "Testa beigas. Jūsu rezultāts: " + punkti + " punkti. Pietiekams rezultāts,bet ir jāceņšas labāk");
			}else if(punkti>=14 && punkti<20) {
				JOptionPane.showMessageDialog(null, "Testa beigas. Jūsu rezultāts: " + punkti + " punkti. Labs rezultāts");
			}else if(punkti==20) {
				JOptionPane.showMessageDialog(null, "Testa beigas. Jūsu rezultāts: " + punkti + " punkti. Izcils rezultāts!");
			}		
        	break;
        	case 1:
        		JOptionPane.showMessageDialog(null, "Programma ir pārtraukta");
        	break;
        	}
		
	}
}
