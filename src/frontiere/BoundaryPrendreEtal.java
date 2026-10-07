package frontiere;

import controleur.ControlPrendreEtal;

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
		
	}
}
