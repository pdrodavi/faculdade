
package com.Auxiliares;

import java.io.IOException;
import com.Erro.LexerException;

public class Parser {

  // Atributos

  private AnalisadorLexico analisadorLexico;
  private Token token;
  private String mensagemErro = "";

  public Parser(AnalisadorLexico analisadorLexico) {
	
    this.analisadorLexico = analisadorLexico;
	
  }

  public boolean parse() throws IOException, LexerException {
	
    boolean resultado;

    token = analisadorLexico.pegarProximoToken();

    resultado = LE();

    if ( resultado && token.getTipo() != Token.EOF ) {
	
      System.err.println( "\n Fim de arquivo esperado, token = " + token );
		
      resultado = false;
		
    }

    if ( !resultado ) {
	
      mensagemErro = "Token não esperado: " + token;
    
    }
    
    return resultado;
	
  }

  public String errorMessage() {
	
    return mensagemErro;
	
  }

  private boolean LE() throws IOException, LexerException {
	  
    boolean resultado;
	
    System.out.print( "LE[ " );
    
    if( !RE() ) {
    
      return false; 
    
    }
    
    if( match( Token.LOG, Token.AND ) || match( Token.LOG, Token.OR ) ) {
    	
      resultado = LE();
      
    } else {
    	
      System.out.print( " €" );
      
      resultado = true;
      
    }
    
    System.out.print( " ]le" );
    
    return resultado;
		
  }

  private boolean RE() throws IOException, LexerException {
	    
    boolean resultado;
	
    System.out.print( "RE[ " );
    
    if( !AE() ) {
    	
      return false;
      
    }
    
    if( match( Token.RELOP, Token.GT ) || match( Token.RELOP, Token.GE ) || match( Token.RELOP, Token.LT ) 
     || match( Token.RELOP, Token.LE ) || match( Token.RELOP , Token.EQ ) ) {
    	
      resultado = RE();
        
    } else {
    	
      System.out.print( " €" );
    	 
      resultado = true;
      
    }
    
    System.out.print( " ]re" );
    
    return resultado;
		
  }

  private boolean AE() throws IOException, LexerException {
	    
    boolean resultado;
    
    System.out.print( "AE[ " );
    
    if( !ME() ) {
    	
      return false;
      
    }
    
    if( match( Token.OP, Token.AD ) || match( Token.OP, Token.SUB ) ) {
    	
      resultado = AE();
      
    } else {
    	
      System.out.print( " €" );
    	 
      resultado = true;
      
    }
	
    System.out.print( " ]ae" );
    
    return resultado;
	    
  }

  private boolean ME() throws IOException, LexerException {

    boolean resultado;
	
    System.out.print( "ME[ " );
    
    if( !UE() ) {
    	
      return false;
      
    }
    
    if( match( Token.OP, Token.MUL ) || match( Token.OP, Token.DIV ) ) {
    	
      resultado = ME();
      
    } else {
    
      System.out.print( " €" );
    	 
      resultado = true;
      
    }
    
    System.out.print( " ]me " );
    
    return resultado;

  }

  private boolean UE() throws IOException, LexerException {

    boolean resultado;
    
    System.out.print( "UE[ " );
    
    if( match( Token.PONTUACAO, Token.AP ) ) {
    	
      resultado = LE() && match( Token.PONTUACAO, Token.FP );
      
    } else if( match( Token.ID ) || match( Token.LITERALNUMERICO )) { //como faríamos para ele aceitar literal numérico?
    	      
      resultado = true;
      
    } else if( match( Token.OP, Token.AD ) || match( Token.OP, Token.SUB ) || match( Token.LOG, Token.NOT ) ) {
    	
      resultado = UE();
      
    } else {
    	
      resultado = false;
      
    }
    
    System.out.print( " ]ue " );
    
    return resultado;
    
  }

  private boolean match(int tipoToken) throws IOException, LexerException {

    boolean resultado;
    
    if ( token.getTipo() == tipoToken ) {
           
      if( tipoToken == Token.ID ) {
    	  
        System.out.print( "Id" );
    	  
      }
      
      if( tipoToken == Token.LITERALNUMERICO ) {
    	  
        System.out.print( token.getValor() );
    	  
      }
      
      
      token = analisadorLexico.pegarProximoToken();
      
      resultado = true;
		
    }else {
	    	
      resultado = false;
    
    }
    
    return resultado;
	
  }
  
  private boolean match(int tipoToken, int valorToken) throws IOException, LexerException {
		
    boolean resultado;
	    
    if ( token.getTipo() == tipoToken  && (Integer)token.getValor() == valorToken )  {
	
      switch( tipoToken ) {
      
        case Token.LOG: {
      
          if( valorToken == Token.AND ) {
        	
            System.out.print( " && " );
          
          } else {
        	
            System.out.print( " || " );
            
          }
      
        }break;
        
        case Token.OP : {
      
          switch (valorToken) {
	
            case Token.AD: System.out.print( "+ " );	
		         break;
        
            case Token.SUB: System.out.print( "-" );	
		        break;

            case Token.DIV: System.out.print( "/" );	
		         break;

            case Token.MUL: System.out.print( "*" );	
		         break;

          }
          
        }break;
        
        case Token.PONTUACAO: {
    
          if( valorToken == Token.AP ) {
        	  
            System.out.print( "( " );  
          
          } else if( valorToken == Token.FP) {
        	
            System.out.print( ") " ); 
          
          }
          
        }break;
      
        case Token.RELOP : {
            
          switch (valorToken) {
  	
            case Token.GT: System.out.print( " > " );	
  		          break;
          
            case Token.GE: System.out.print( " >= " );	
  		         break;

            case Token.LT: System.out.print( " < " );	
  		          break;

            case Token.LE: System.out.print( " <= " );	
  		          break;
  		          
            case Token.EQ: System.out.print( " == " );	
	          break;
      

          }
          
        }break;

      }
      
      token = analisadorLexico.pegarProximoToken();
      
	  resultado = true;
		
    } else {
	  
      resultado = false;
    
    }
	
    return resultado;
	
  }

}
