package models.fabricaRepositorio;

import java.io.File;
import java.util.Scanner;

public class FabricaRep {
	public static enum tipoBD{H2, ORACLE, POSTGRES}
	
	private FabricaRep.tipoBD getDBtype(){
		Scanner input = new Scanner(new File("conf.txt");
		String temp = input.nextLine();
		String[] temp2 = temp.split(':');
		if(temp2[0].equal("DATABASE"){
			switch(temp2[0]){
				case "H2":
					return this.tipoBD.H2;
					break;
				case "ORACLE":
					return this.tipoBD.ORACLE;
					break;
				case "POSTGRES":
					return this.tipoBD.POSTGRES;
					break;
			}	
		}else{
			throw new IllegalArgumentException("Configuração de database inválida");
		}
		
	}
	
	public static IFabricaRep criarFabricaRep(){
		IFabricaRep fabrica = null;
		
		FabricaRep.tipoBD opcao = getDBtype();
		
		switch(opcao){
			case H2:
				fabrica = new FabricaRepH2();
				break;
				
			case ORACLE:
				
				break;
		}
		
		return fabrica;
	}
}
