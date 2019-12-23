import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GeradorMegaSena {
	
	static Scanner input = new Scanner(System.in);
	
	private int capturaDezenas() {

		int dezenas =0;


        try {
        	System.out.print("Quantas dezenas?\n");
        	
        	dezenas = input.nextInt();
	        
        	while (dezenas<6 || dezenas >15 ) {
        		System.out.print("Valor deve estar entre 6 e 15!\n");
        		System.out.print("Quantas dezenas?\n");
        		dezenas = input.nextInt();
        	}
        	
	        	        			 
            }      
        catch (Exception e) {
        	System.out.print("Deve ser somente numeros, vou utiliza o padrao 6\n");     
        	return 6;
        }
        
        return dezenas;        
        

	}
	
	private int capturarJogos() {

		int jogos =0;
		
		try {
        	System.out.print("Quantos jogos?\n");
        	jogos = input.nextInt();
	        
	        while(jogos<1) {
	        	System.out.print("Deve ser maior 0\n");
	        	System.out.print("Quantos jogos?\n");
	        	jogos = input.nextInt();
	        }
			 
            }      
        catch (Exception e) {
        	System.out.print("Deve ser somente numeros, vou utilizar o padrao 1\n");
        	return 1;
        }
	  
		return jogos;
		
	}
	
	private String GeraDezenas(int dezenas) {
		String valorFinal = "";		
		int valor = 0;
		Random randomico = new Random();
		int[] resultado = new int[dezenas];

		for (int i= 0;i <dezenas;i++) {	
			
			while (valor == 0) {
				valor =  randomico.nextInt(60);
			}
			
		    
			while (valorFinal.contains(String.valueOf(valor))) {
				valor =  0;
				while (valor == 0) {
					valor =  randomico.nextInt(60);
				}
				
			}
			
			resultado[i] = valor;
			valorFinal = valorFinal.concat(String.valueOf(valor).concat(" "));
			
		}
		
		Arrays.sort(resultado);
			
	    valorFinal = "";
		
		for (int num : resultado) {
			valorFinal += String.valueOf(num).concat(" ");
		}

	    return valorFinal;		
		
	}
	
	public static void main(String args[]) {
		int jogos = 0;
		int dezenas =0;
		String resultadoFinal ="";
		GeradorMegaSena geradorMegaSena = new GeradorMegaSena();

		
		jogos = geradorMegaSena.capturarJogos();
		dezenas = geradorMegaSena.capturaDezenas();
		        
        
		for (int i= 0;i <jogos;i++) {
			
			resultadoFinal += geradorMegaSena.GeraDezenas(dezenas).concat("\n");
			
		}
		
		System.out.print("BOA SORTE, ESSES SAO SEUS NUMEROS:\n");
		System.out.print(resultadoFinal + "\n");		
		System.out.print("Jogar novamente? S/N\n");
		
		
        if (input.next().toUpperCase().contains("S")) {
        	GeradorMegaSena.main(null);
        }{
        	System.out.print("Caso ganhe, lembre de mim :)\n");
        	System.out.print("Até logo!\n");
        	System.exit(0);
        }

	}
	
	
}
