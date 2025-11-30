package com.cine.ClasesPrincipales;
import com.cine.Vista.Registros;
import com.cine.Vista.MenuPrincipal;
public class Main{
	public static void main(String args[]){
		int i=0;
		
		MenuPrincipal elMenu = new MenuPrincipal();
		while (i<2) {
		elMenu.menuInicio();
	    i++;	
	}
	}
}
