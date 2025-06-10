package Eksamens;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

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
		Collections.shuffle(jautajumi);

        int punkti = 0;

        for (Jautajums j : jautajumi) {
            Collections.shuffle(j.atbildes); // перемешиваем ответы

            String[] opcijas = new String[j.atbildes.size()];
            for (int i = 0; i < j.atbildes.size(); i++) {
                opcijas[i] = j.atbildes.get(i).teksts;
            }

            int atbildeIndekss = JOptionPane.showOptionDialog(
                null,
                j.teksts,
                "Izvēlies pareizo atbildi",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcijas,
                opcijas[0]
            );

            if (atbildeIndekss >= 0 && j.atbildes.get(atbildeIndekss).irPareiza) {
                punkti += 2;
                JOptionPane.showMessageDialog(null, "Pareizi! +2 punkti");
            } else {
                punkti -= 1;
                JOptionPane.showMessageDialog(null, "Nepareizi. -1 punkts");
            }
        }

        JOptionPane.showMessageDialog(null, "Testa beigas. Jūsu rezultāts: " + punkti + " punkti.");

		}
	}