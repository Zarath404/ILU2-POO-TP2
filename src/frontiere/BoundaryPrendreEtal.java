package frontiere;

import controleur.ControlPrendreEtal;
import villagegaulois.Village;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean connu = controlPrendreEtal.verifierIdentite(nomVendeur);
		if(!connu) { System.out.println("Jes suis désolé " + nomVendeur + " mais il faut être habitant ");
				   System.out.println("notre village pour commercer ici.\n");
		}
				 
	    else {
			System.out.println("Bonjour " + nomVendeur + ", je vais regarder si je peux vous trouver un étal.\n");
			boolean etalDsiponible = controlPrendreEtal.resteEtals();
			
			if(!etalDsiponible) System.out.println("Désolé, je n'ai plus d'étal disponible\n");
			else {
				installerVendeur(nomVendeur);
			}
	    }
	}
	
	private void installerVendeur(String nomVendeur) {
		System.out.println("Parfait, il reste un étal pour vous ! \nIl faudrait des renseignements :\n");
		String produit = Clavier.entrerChaine("Quel produit souhaitait vous vendre ?\n");
		int quantite = Clavier.entrerEntier("En quel quantite souhaitait vous en vendre ?\n");
		int numEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, quantite);
		if(numEtal != -1) System.out.println("Le vendeur " + nomVendeur + " s'est installé à l'étal numéro " + numEtal);
	}
}
