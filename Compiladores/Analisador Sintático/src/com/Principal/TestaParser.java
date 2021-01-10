
package com.Principal;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import com.Auxiliares.AnalisadorLexico;
import com.Auxiliares.Parser;
import com.Erro.LexerException;

public class TestaParser {
	
  public static void main(String[] args) {
		
    System.out.println( "Analise Lexica: \n\n" );
	
    try {
		
      BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( new FileInputStream( "Exemplo.exp" ) ) );
		
      AnalisadorLexico analisadorLexico = new AnalisadorLexico( bufferedReader );
	  Parser parser = new Parser( analisadorLexico );

	  if ( parser.parse() ) {
		
	    System.out.println( "\n\n\n\n An�lise completa" );
	  
	  }	else {
		
	    System.err.println( "\n Erro sint�tico: " + parser.errorMessage() );
		
	  } 
	  
    }
	catch (LexerException e) {
			
	  System.err.println("Erro l�xico: " + e.getMessage());
		
	}
	
	catch (Exception e) {
			
	  System.out.println("Exce��o: " + e.getMessage());
		
	  e.printStackTrace();
		
	}

  }

}
