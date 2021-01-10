
package com.Erro;

public class LexerException extends Exception {
	
  private static final long serialVersionUID = 1L;

  // Construtores
  
  public LexerException() {
	
    super( "Erro !!!" );
    
  }

  public LexerException(String mensagem) {
		
    super( mensagem );
    
  }

}
