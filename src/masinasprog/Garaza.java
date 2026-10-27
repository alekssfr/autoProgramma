package masinasprog;

import java.io.IOException;

import javax.swing.JOptionPane;

public class Garaza {

	public static void main(String[] args) throws IOException {
		
		String izvele;
		
		String[] darbibuSaraksts = {"Izveidot mašīnu", "Veikt mašīnas darbību", "Iziet"};
		
		Masina auto = null;
		int rekords=0;
		
		do {
			izvele = (String) JOptionPane.showInputDialog(null, "Izvēlies darbību", "Izvēles",
					JOptionPane.QUESTION_MESSAGE, null, darbibuSaraksts, darbibuSaraksts[0]);
			
			switch(izvele) {
			case "Izveidot mašīnu":
				int pasreizejaisAtrums=0;
				String marka = JOptionPane.showInputDialog(null, "Ievadi mašīnas marku",
						"Mašīnas modelis", JOptionPane.INFORMATION_MESSAGE);
				String modelis = JOptionPane.showInputDialog(null, "Ievadi mašīnas modeli",
						"Mašīnas modelis", JOptionPane.INFORMATION_MESSAGE);
				String krasa = JOptionPane.showInputDialog(null, "Ievadi mašīnas krāsu",
						"Mašīnas modelis", JOptionPane.INFORMATION_MESSAGE);
				
				auto = new Masina(pasreizejaisAtrums, modelis, marka, krasa);
				break;
			
			case "Veikt mašīnas darbību":
				if(auto == null) {
					JOptionPane.showMessageDialog(null, "Nav izveidota mašīna!", "Izveido mašīnu",
							JOptionPane.WARNING_MESSAGE);
					break;
				}
				String[] masinuDarbibas = {"Paātrināt mašīnu", "Bremzēt mašīnu", "Noparkot mašīnu",
						"Noteikt mašīnas ātrumu", "Pārkrāsot mašīnu", "Iziet"};
				String darbibuIzvele;
				do {
					darbibuIzvele = (String) JOptionPane.showInputDialog(null, "Izvēlies darbību", "Izvēles",
							JOptionPane.QUESTION_MESSAGE, null, masinuDarbibas, masinuDarbibas[0]);
					
					switch(darbibuIzvele) {
					case "Paātrināt mašīnu":
						rekords = auto.paatrinat(rekords);
						break;
						
					case "Noparkot mašīnu":
						auto.noparkoties();
						break;
						
					case "Bremzēt mašīnu":
						auto.bremzet();
						break;
					}
		
					
				}while(!darbibuIzvele.equals("Iziet"));
				
//			case "Atvērt veikalu":
//				
//				break;
				
				}
			}while(!izvele.equals("Iziet"));
		
	}

}
