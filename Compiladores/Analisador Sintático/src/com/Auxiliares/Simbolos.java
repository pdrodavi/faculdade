
package com.Auxiliares;

public class Simbolos {

  public static boolean isLetra(int caractere) {
	  
    return Character.isLetter(caractere) && caractere != '_';
    
  }
  
  public static boolean isLetraouDigito(int caractere) {
	  
    return Character.isLetterOrDigit(caractere) && caractere != '_';
    
  }

}
