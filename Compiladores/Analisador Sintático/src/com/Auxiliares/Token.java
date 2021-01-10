
package com.Auxiliares;

public class Token {
	
  // Constantes para tipos de token
	
  public static final int CHAR = 0;
  public static final int ELSE = 1;
  public static final int FALSE = 2;
  public static final int IF = 3;
  public static final int INT = 4;
  public static final int MAIN = 5;
  public static final int OUT = 6;
  public static final int PRINTF = 7;
  public static final int RETURN = 8;
  public static final int STATIC  = 9;
  public static final int VOID = 10;
  public static final int WHILE = 11;
  public static final int ID = 12;
  public static final int LITERALNUMERICO = 13;
  public static final int AT = 14;
  public static final int OP = 15;
  public static final int LOG = 16;
  public static final int RELOP = 17;
  public static final int LITERALSTRING  = 18;
  public static final int LITERALCHAR = 19;
  public static final int PONTUACAO = 20;

  
  // Valor fim de Arquivo
  
  public static final int EOF   = 100;

  // Valores para tokens RELOP

  public static final int LT = 1;
  public static final int LE = 2;
  public static final int GT = 3;
  public static final int GE = 4;
  public static final int EQ = 5;
  public static final int NE = 6;

  // Valores para tokens AUX

  public static final int ATR = 1;
  
  // Valores para tokens OP

  public static final int AD = 1;
  public static final int SUB = 2;
  public static final int DIV = 3;
  public static final int MUL = 4;
  
  // Valores para tokens LOG

  public static final int AND = 1;
  public static final int OR = 2;
  public static final int NOT = 3;

  // Valores para tokens PONTUACAO
	
  public static final int AP = 1;
  public static final int FP = 2;
  public static final int AC = 3;
  public static final int FC = 4;
  public static final int PV = 5;
  public static final int VG = 6;

  
  // Atributos
  
  private int tipo;
  private Object valor;

  // Construtores

  public Token(int tipo, Object valor) {
		
    this.tipo = tipo;
    this.valor = valor;
  
  }

  public Token(int tipo) {
		
    this( tipo, null );
  
  }

  // Métodos para criar tokens

  public static Token EOF() {
	
    return new Token(EOF);
	
  }
  
  public int getTipo() {
	  
    return this.tipo;
    
  }

  public Object getValor() {
	  
    return this.valor;
	
  }

  public String toString()  {
	 
    String valorString = "-";

    switch( tipo ) {
   
      case RELOP: valorString = tipoRelop( (Integer) valor);
          		   break;
    
      case AT: valorString = "ATR";
               break;
     
      case OP: valorString = tipoOP( (Integer) valor );
     		   break;
     
      case LOG: valorString = tipoLog( (Integer) valor );  
	            break;  
	
      case PONTUACAO: valorString = tipoPontuacao( (Integer) valor );  
                      break;  
     
      default: {
	
	    if( valor != null ) {
		 
	      valorString = valor.toString().trim();
	   	  
	    }
	 
      }
	
    } 
   
    return "<" + tipoString() + ", " + valorString + ">";

  }

  private String tipoString() {
	 
    String resultado = "Erro";
	
      switch ( tipo ) {
   
	    case CHAR: resultado = "char";
			       break;
	
	    case ELSE: resultado = "else";
			       break;
		
	    case FALSE: resultado = "falso";
				    break;
	 
	    case IF: resultado = "if";
	             break;

	    case INT: resultado = "int";
				  break;

	    case MAIN: resultado = "main";
				   break;
	
	    case OUT: resultado = "out";
			      break;			
	  
	    case PRINTF: resultado = "printf";
	                 break;			

	    case RETURN: resultado = "return";
	    	         break;			

	    case STATIC: resultado = "static";
	                  break;			

	    case VOID: resultado = "void";
	  			   break;	
	  
	    case WHILE: resultado = "while";
	                break;			

	    case ID: resultado = "id";
	             break;			

	    case LITERALNUMERICO: resultado = "literalNumerico";
	    		              break;			

	    case LITERALSTRING: resultado = "literalString";
					        break;
	
	    case LITERALCHAR: resultado = "literalChar";
				          break;
	
	    case AT: resultado = "at";
	    		 break;			

	    case OP: resultado = "op";
	    	     break;		

	    case LOG: resultado = "log";
	    	      break;	
	   
	    case RELOP: resultado = "relop";
	    		    break;			

	    case PONTUACAO: resultado = "pontuação";
	    	        break;			

      }
	
      return resultado;

  }

  private String tipoRelop(Integer tipo1) {
		
    String resultado = "Erro";
	
    switch ( tipo1.intValue() ) {
		
      case LT: resultado = "LT";
			   break;
	
      case LE: resultado = "LE";
			   break;
	
      case GT: resultado = "GT";
			   break;
	
      case GE: resultado = "GE";
			   break;

      case EQ: resultado = "EQ";
			   break;
	
      case NE: resultado = "NE";
			   break;			

    }
	
    return resultado;

  }	
 
  private String tipoOP(Integer tipo1) {
	 
    String resultado = "Erro";
   
    switch ( tipo1.intValue() ) {
	
      case AD: resultado = "+";
			   break;
	
      case SUB: resultado = "-";
			    break;
	
      case MUL: resultado = "*";
			    break;
	
      case DIV: resultado = "/";
			    break;

    }

    return resultado;

  }

  private String tipoLog(Integer tipo1) {
	 
    String resultado = "Erro";

    switch ( tipo1.intValue() ) {

      case AND: resultado = "&&";
		    	break;
	
      case OR: resultado = "||";
			   break;

      case NOT: resultado = "!";
			    break;

   }

    return resultado;

  }
 
  private String tipoPontuacao(Integer valor2) {

    String resultado = "Erro";
	
    switch ( valor2.intValue() ) {
		
	  case AP: resultado = "(";
		       break;
	
	  case FP: resultado = ")";
			   break;
		
	  case AC: resultado = "{";
			   break;
		
	  case FC: resultado = "}";
			   break;

	  case PV: resultado = ";";
	           break;

	  case VG: resultado = ",";
	           break;

    }

    return resultado;

  }

}
