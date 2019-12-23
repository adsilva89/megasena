package br.com.juvo.commons.utils;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GeradorMegaSena {
	
	static int aposta;
	
	public static void main(String args[]) {
		String valorFinal;
		int valor;
		Random randomico = new Random();
		Scanner input = new Scanner(System.in);

        System.out.print("Quantas dezenas?\n");
        
        try {
	        aposta = input.nextInt();
			
		        while (aposta >15) {
		        	
		            	System.out.print("Deve ser menor que 15!\n");
		                System.out.print("Quantas dezenas?\n");
		                aposta = input.nextInt();            
		        }
            }      
        catch (Exception e) {
        	System.out.print("Deve ser somente numeros\n");
        	GeradorMegaSena.main(null);

        }
        
		valorFinal = "";
		
	    int[] resultado = new int[aposta];

		for (int i= 0;i <aposta;i++) {	
			
			valor =  0;
			
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

		System.out.println(valorFinal);
		
		System.out.print("Jogar novamente? S/N\n");
        
        
        if (input.next().toUpperCase().contains("S")) {
        	GeradorMegaSena.main(null);
        }{
        	System.out.print("Caso ganhe, lembre de mim :)\n");
        }

	}
}
