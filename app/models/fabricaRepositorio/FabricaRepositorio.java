package models.fabricaRepositorio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class FabricaRepositorio {
	public static enum tipoBD{H2, ORACLE, POSTGRES}
	
	private static FabricaRepositorio.tipoBD getDBtype() throws FileNotFoundException{
		Scanner input = new Scanner(new File("conf.txt"));
		String temp = input.nextLine();
		String[] temp2 = temp.split(Pattern.quote("."));
		if(temp2[0].equals("DATABASE")){
			switch(temp2[1]){
				case "H2":
					return FabricaRepositorio.tipoBD.H2;
				case "ORACLE":
					return FabricaRepositorio.tipoBD.ORACLE;
				case "POSTGRES":
					return FabricaRepositorio.tipoBD.POSTGRES;
			}	
		}else{
			throw new IllegalArgumentException("Configuração de database inválida, the value passed was: " + temp2[0]);
		}
		return null;
		
	}
	
	public static IFabricaRepositorio criarFabricaRep() throws FileNotFoundException{
		IFabricaRepositorio fabrica = null;
		
		FabricaRepositorio.tipoBD opcao = getDBtype();
		
		switch(opcao){
			case H2:
				fabrica = new FabricaRepositorioH2();
				break;
				
			case ORACLE:
				
				break;
		}
		
		return fabrica;
	}
}
