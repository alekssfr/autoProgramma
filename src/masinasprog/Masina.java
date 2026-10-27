package masinasprog;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Masina {
	int pasreizejaisAtrums;
	String modelis, marka, krasa;
	Random rand = new Random();
	
	public Masina(int pasreizejaisAtrums, String modelis, String marka, String krasa) {
		pasreizejaisAtrums = 0;
		this.modelis = modelis;
		this.marka = marka;
		this.krasa = krasa;
	}
	
	int pagNauda=0;
	int nauda=0;
	
	
	
	
	int paatrinat(int rekords) throws IOException {
		pasreizejaisAtrums+=10;
		
		Scanner lasa = new Scanner(new File("rekords.txt"));
		nauda = Integer.parseInt(lasa.nextLine());
		rekords = Integer.parseInt(lasa.nextLine());
		lasa.close();
		
		if(pasreizejaisAtrums>100) {
			if(rand.nextInt(5)+1==1) {

				if (pasreizejaisAtrums > 100) {
				    if (rand.nextInt(5) + 1 == 1) {

				        if (rekords < pasreizejaisAtrums) {
				            rekords = pasreizejaisAtrums;

				            JOptionPane.showMessageDialog(
				                null,
				                "Jums ir jauns ātruma rekords!",
				                "Jauns rekords",
				                JOptionPane.INFORMATION_MESSAGE
				            );
				        }

				        PrintWriter raksta = new PrintWriter(
				            new FileWriter("rekords.txt")
				        );

				        raksta.println(nauda);
				        raksta.println(rekords);
				        raksta.close();

				    }
				}
				JOptionPane.showMessageDialog(null, marka+" avarēja! Jūs braucāt par ātru."
						+ "\nJūsu ātrums - "+pasreizejaisAtrums+"\nJūsu rekords - "+rekords+
						"\nIegūtā nauda - $"+pagNauda+
						"\nKopā nauda - $"+nauda,
						"Mašīna avarēja", JOptionPane.WARNING_MESSAGE);
				pasreizejaisAtrums=0;
				
				pagNauda=0;

			}else {
				JOptionPane.showMessageDialog(null, (pasreizejaisAtrums-10)+" km/h --> "
						+pasreizejaisAtrums+" km/h\nJūsu ātrums pārsniedz 100km/h, braucat uzmanīgi!"
						, "Ātrums palielināts", JOptionPane.WARNING_MESSAGE);
				pagNauda+=100;
				nauda+=100;
				
			}
		} else {
			JOptionPane.showMessageDialog(null, (pasreizejaisAtrums-10)+" km/h --> "
					+pasreizejaisAtrums+" km/h", "Ātrums palielināts", JOptionPane.INFORMATION_MESSAGE);
			pagNauda+=10;
			nauda+=10;
		}
		
		return rekords;
	}
	
	void bremzet() {
		if(pasreizejaisAtrums==0) {
			JOptionPane.showMessageDialog(null, marka+" jau stāv. Nav iespējams bremzēt",
					"Nevar bremzēt", JOptionPane.WARNING_MESSAGE);
		}else {
		pasreizejaisAtrums-=10;
		JOptionPane.showMessageDialog(null, (pasreizejaisAtrums+10)+" km/h --> "
		+pasreizejaisAtrums+" km/h", "Ātrums palēlināts", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	void noparkoties() {
		if(pasreizejaisAtrums>10) {
			JOptionPane.showMessageDialog(null, marka+" ir par ātru, lai noparkotos!",
					"Nevar noparkoties", JOptionPane.WARNING_MESSAGE);
		}else {
			pasreizejaisAtrums=0;
			JOptionPane.showMessageDialog(null, marka+" ir noparkota!", "Mašīna noparkota",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	static void noteiktAtrumu() {
		
	}
	
	static void parkrasot() {
		
	}
}
