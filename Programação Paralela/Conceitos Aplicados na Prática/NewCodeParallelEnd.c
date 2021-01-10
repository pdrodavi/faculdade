#include<stdio.h>
#include <omp.h>

// adicionar openmp ao devc++
// Ferramentas> Opções do Compilador> Marque a opção 
// "Adicionar os seguintes comandos quando o compilador 
// é chamado"> na área de texto coloque "-fopenmp"

	// variáveis globais
	char userInput[200];
	int i = 0, qtdA = 0, qtdB = 0, qtdC = 0, qtdD = 0, 
	qtdE = 0, qtdF = 0, qtdG = 0, qtdH = 0, qtdI = 0, 
	qtdJ = 0, qtdK = 0, qtdL = 0, qtdM = 0, qtdN = 0, 
	qtdO = 0, qtdP = 0, qtdQ = 0, qtdR = 0, qtdS = 0, 
	qtdT = 0, qtdU = 0, qtdV = 0, qtdW = 0, qtdX = 0, 
	qtdY = 0, qtdZ = 0;
	

void saida01(char userInput[]){
	
	#pragma omp parallel
	{
		#pragma omp for
			for (i = 0; i < strlen(userInput); i++) {
			    if (userInput[i] == 'a' || userInput[i] == 'A') qtdA++;
			    if (userInput[i] == 'b' || userInput[i] == 'B') qtdB++;
				if (userInput[i] == 'c' || userInput[i] == 'C') qtdC++;
				if (userInput[i] == 'd' || userInput[i] == 'D') qtdD++;
				if (userInput[i] == 'e' || userInput[i] == 'E') qtdE++;
				if (userInput[i] == 'f' || userInput[i] == 'F') qtdF++;
				if (userInput[i] == 'g' || userInput[i] == 'G') qtdG++;
				if (userInput[i] == 'h' || userInput[i] == 'H') qtdH++;
				if (userInput[i] == 'i' || userInput[i] == 'I') qtdI++;
				if (userInput[i] == 'j' || userInput[i] == 'J') qtdJ++;
				if (userInput[i] == 'k' || userInput[i] == 'K') qtdK++;
				if (userInput[i] == 'l' || userInput[i] == 'L') qtdL++;
				if (userInput[i] == 'm' || userInput[i] == 'M') qtdM++;
				if (userInput[i] == 'n' || userInput[i] == 'N') qtdN++;
				if (userInput[i] == 'o' || userInput[i] == 'O') qtdO++;
				if (userInput[i] == 'p' || userInput[i] == 'P') qtdP++;
				if (userInput[i] == 'q' || userInput[i] == 'Q') qtdQ++;
				if (userInput[i] == 'r' || userInput[i] == 'R') qtdR++;
				if (userInput[i] == 's' || userInput[i] == 'S') qtdS++;
				if (userInput[i] == 't' || userInput[i] == 'T') qtdT++;
				if (userInput[i] == 'u' || userInput[i] == 'U') qtdU++;
				if (userInput[i] == 'v' || userInput[i] == 'V') qtdV++;
				if (userInput[i] == 'w' || userInput[i] == 'W') qtdW++;
				if (userInput[i] == 'x' || userInput[i] == 'X') qtdX++;
				if (userInput[i] == 'y' || userInput[i] == 'Y') qtdY++;
				if (userInput[i] == 'z' || userInput[i] == 'Z') qtdZ++;	                                                                                                                                                                                
			} // end for nowait
	} // end parallel
		
	printf("\n\nSaida 1:");
	
	#pragma omp parallel
	{
		#pragma omp sections
		{	
			#pragma omp section
			{
				if(qtdA != 0) printf("\nSua entrada tem %d 'A'" , qtdA);
			} // end
			 
			#pragma omp section
			{  
				if(qtdB != 0) printf("\nSua entrada tem %d 'B'" , qtdB);
			} // end
			
			#pragma omp section
			{
				if(qtdC != 0) printf("\nSua entrada tem %d 'C'" , qtdC);
			} // end
			
			#pragma omp section
			{
				if(qtdD != 0) printf("\nSua entrada tem %d 'D'" , qtdD);
			} // end
			
			#pragma omp section
			{
				if(qtdE != 0) printf("\nSua entrada tem %d 'E'" , qtdE);
			} // end
			
			#pragma omp section
			{
				if(qtdF != 0) printf("\nSua entrada tem %d 'F'" , qtdF);
			} // end
			
			#pragma omp section
			{
				if(qtdG != 0) printf("\nSua entrada tem %d 'G'" , qtdG);
			} // end
			
			#pragma omp section
			{
				if(qtdH != 0) printf("\nSua entrada tem %d 'H'" , qtdH);
			} // end
			
			#pragma omp section
			{
				if(qtdI != 0) printf("\nSua entrada tem %d 'I'" , qtdI);
			} // end
			
			#pragma omp section
			{
				if(qtdJ != 0) printf("\nSua entrada tem %d 'J'" , qtdJ);
			} // end
			
			#pragma omp section
			{
				if(qtdK != 0) printf("\nSua entrada tem %d 'K'" , qtdK);
			} // end
			
			#pragma omp section
			{
				if(qtdL != 0) printf("\nSua entrada tem %d 'L'" , qtdL);
			} // end
			
			#pragma omp section
			{
				if(qtdM != 0) printf("\nSua entrada tem %d 'M'" , qtdM);
			} // end
			
			#pragma omp section
			{
				if(qtdN != 0) printf("\nSua entrada tem %d 'N'" , qtdN);
			} // end
			
			#pragma omp section
			{
				if(qtdO != 0) printf("\nSua entrada tem %d 'O'" , qtdO);
			} // end
			
			#pragma omp section
			{
				if(qtdP != 0) printf("\nSua entrada tem %d 'P'" , qtdP);
			} // end
			
			#pragma omp section
			{
				if(qtdQ != 0) printf("\nSua entrada tem %d 'Q'" , qtdQ);
			} // end
			
			#pragma omp section
			{
				if(qtdR != 0) printf("\nSua entrada tem %d 'R'" , qtdR);
			} // end
			
			#pragma omp section
			{
				if(qtdS != 0) printf("\nSua entrada tem %d 'S'" , qtdS);
			} // end
			
			#pragma omp section
			{
				if(qtdT != 0) printf("\nSua entrada tem %d 'T'" , qtdT);
			} // end
			
			#pragma omp section
			{
				if(qtdU != 0) printf("\nSua entrada tem %d 'U'" , qtdU);
			} // end
			
			#pragma omp section
			{
				if(qtdV != 0) printf("\nSua entrada tem %d 'V'" , qtdV);
			} // end
			
			#pragma omp section
			{
				if(qtdW != 0) printf("\nSua entrada tem %d 'W'" , qtdW);
			} // end
			
			#pragma omp section
			{
				if(qtdX != 0) printf("\nSua entrada tem %d 'X'" , qtdX);
			} // end
			
			#pragma omp section
			{
				if(qtdY != 0) printf("\nSua entrada tem %d 'Y'" , qtdY);
			} // end
			
			#pragma omp section
			{
				if(qtdZ != 0) printf("\nSua entrada tem %d 'Z'" , qtdZ);
			} // end
			
		} // end sections
	} // end parallel
	
} // fim do método 01

void saida02(int qtdA, int qtdE, int qtdI, int qtdO, int qtdU){
	
	printf("\n\nSaida 2:");
	
	#pragma omp parallel
	{
		#pragma omp sections
		{	
			#pragma omp section
			{
				if(qtdA != 0) printf("\nSua entrada tem a vogal A");
			} // end
			
			#pragma omp section
			{
				if(qtdE != 0) printf("\nSua entrada tem a vogal E");
			} // end
			
			#pragma omp section
			{
				if(qtdI != 0) printf("\nSua entrada tem a vogal I");
			} // end
			
			#pragma omp section
			{
				if(qtdO != 0) printf("\nSua entrada tem a vogal O");
			} // end
			
			#pragma omp section
			{
				if(qtdU != 0) printf("\nSua entrada tem a vogal U");
			} // end section
			
		} // end sections
	} //end parallel

} // fim do método 02

void saida03(int qtdA, int qtdE, int qtdI, int qtdO, int qtdU){
	
	printf("\n\nSaida 3:");
	
	#pragma omp parallel
	{
		#pragma omp sections
		{	
			#pragma omp section
			{
				if(qtdA != 0) printf("\nSua entrada tem %d 'A'" , qtdA);
			} // end
			
			#pragma omp section
			{
				if(qtdE != 0) printf("\nSua entrada tem %d 'E'" , qtdE);
			} // end
			
			#pragma omp section
			{
				if(qtdI != 0) printf("\nSua entrada tem %d 'I'" , qtdI);
			} // end
			
			#pragma omp section
			{
				if(qtdO != 0) printf("\nSua entrada tem %d 'O'" , qtdO);
			} // end
			
			#pragma omp section
			{
				if(qtdU != 0) printf("\nSua entrada tem %d 'U'" , qtdU);
			} // end section
			
		} // end sections
	} // end parallel
	
} // fim do método 03

void saida04(char userInput[]){
	
	// separar em métodos de arrays para nao ficar pesado
	
	printf("\n\nSaida 4:");
	
	int i = 0, j = 0, tmp;
	int valuesAlfa[26] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26}; 
	int arrayPartial[200];
	char arrayOrdered[200];
	
	// converte de string para inteiros
	for (i = 0; i < userInput[i] != 0; i++) {
		#pragma omp parallel
		{	
			#pragma omp sections
			{	
				#pragma omp section
				{
				if (userInput[i] == 'a' || userInput[i] == 'A') arrayPartial[i] = valuesAlfa[0];
				}
					
				#pragma omp section
				{
				if (userInput[i] == 'b' || userInput[i] == 'B') arrayPartial[i] = valuesAlfa[1];
				}
					
				#pragma omp section
				{
				if (userInput[i] == 'c' || userInput[i] == 'C') arrayPartial[i] = valuesAlfa[2];
				}
					
				#pragma omp section
				{
				if (userInput[i] == 'd' || userInput[i] == 'D') arrayPartial[i] = valuesAlfa[3];
				}
					
				#pragma omp section
				{
				if (userInput[i] == 'e' || userInput[i] == 'E') arrayPartial[i] = valuesAlfa[4];
				}
					
				#pragma omp section
				{
				if (userInput[i] == 'f' || userInput[i] == 'F') arrayPartial[i] = valuesAlfa[5];
				}
					
				#pragma omp section
				{
				if (userInput[i] == 'g' || userInput[i] == 'G') arrayPartial[i] = valuesAlfa[6];
				}
					
				#pragma omp section
				{
				if (userInput[i] == 'h' || userInput[i] == 'H') arrayPartial[i] = valuesAlfa[7];
				}
					
				#pragma omp section
				{
				if (userInput[i] == 'i' || userInput[i] == 'I') arrayPartial[i] = valuesAlfa[8];
				}
					
				#pragma omp section
				{
				if (userInput[i] == 'j' || userInput[i] == 'J') arrayPartial[i] = valuesAlfa[9];
				}
					
				#pragma omp section
				{
				if (userInput[i] == 'k' || userInput[i] == 'K') arrayPartial[i] = valuesAlfa[10];
				}
					
				#pragma omp section
				{
				if (userInput[i] == 'l' || userInput[i] == 'L') arrayPartial[i] = valuesAlfa[11];
				}
					
				#pragma omp section
				{
				if (userInput[i] == 'm' || userInput[i] == 'M') arrayPartial[i] = valuesAlfa[12];
				}
					
				#pragma omp section
				{
				if (userInput[i] == 'n' || userInput[i] == 'N') arrayPartial[i] = valuesAlfa[13];
				}
					
				#pragma omp section
				{
				if (userInput[i] == 'o' || userInput[i] == 'O') arrayPartial[i] = valuesAlfa[14];
				}
					
				#pragma omp section
				{
				if (userInput[i] == 'p' || userInput[i] == 'P') arrayPartial[i] = valuesAlfa[15];
				}
					
				#pragma omp section
				{
				if (userInput[i] == 'q' || userInput[i] == 'Q') arrayPartial[i] = valuesAlfa[16];
				}
					
				#pragma omp section
				{
				if (userInput[i] == 'r' || userInput[i] == 'R') arrayPartial[i] = valuesAlfa[17];
				}
					
				#pragma omp section
				{
				if (userInput[i] == 's' || userInput[i] == 'S') arrayPartial[i] = valuesAlfa[18];
				}
					
				#pragma omp section
				{
				if (userInput[i] == 't' || userInput[i] == 'T') arrayPartial[i] = valuesAlfa[19];
				}
					
				#pragma omp section
				{
				if (userInput[i] == 'u' || userInput[i] == 'U') arrayPartial[i] = valuesAlfa[20];
				}
					
				#pragma omp section
				{
				if (userInput[i] == 'v' || userInput[i] == 'V') arrayPartial[i] = valuesAlfa[21];
				}
					
				#pragma omp section
				{
				if (userInput[i] == 'w' || userInput[i] == 'W') arrayPartial[i] = valuesAlfa[22];
				}
					
				#pragma omp section
				{
				if (userInput[i] == 'x' || userInput[i] == 'X') arrayPartial[i] = valuesAlfa[23];
				}
					
				#pragma omp section
				{
				if (userInput[i] == 'y' || userInput[i] == 'Y') arrayPartial[i] = valuesAlfa[24];
				}
					
				#pragma omp section
				{
				if (userInput[i] == 'z' || userInput[i] == 'Z') arrayPartial[i] = valuesAlfa[25];
				}
					
			} // end sections
		} // end parallel
	} // fim do for
	

	// >>> OBS: SE FIZER UM FOR PARALELO EM QUALQUER UM DOS FORS DESSE MÉTODO ELE TRAVA O PROGRAMA <<<<<<
	// ordena o array de inteiros - insertion sort	 		
	for (i = 0; arrayPartial[i] != 0; i++) {
		j = i;
		while (j > 0 && arrayPartial[j - 1] > arrayPartial[j]) {
			tmp = arrayPartial[j];
			arrayPartial[j] = arrayPartial[j - 1];
			arrayPartial[j - 1] = tmp;
			j--;
		} 
	}
	
	
	// converte de inteiro para strings ordenadas	
	for (i = 0; arrayPartial[i] != 0; i++) {
		#pragma omp parallel
		{	
			#pragma omp sections
			{	
				#pragma omp section
				{
				if (arrayPartial[i] == 1) arrayOrdered[i] = 'a';
				}
				
				#pragma omp section
				{
				if (arrayPartial[i] == 2) arrayOrdered[i] = 'b';
				}
				
				#pragma omp section
				{
				if (arrayPartial[i] == 3) arrayOrdered[i] = 'c';
				}
				
				#pragma omp section
				{
				if (arrayPartial[i] == 4) arrayOrdered[i] = 'd';
				}
				
				#pragma omp section
				{
				if (arrayPartial[i] == 5) arrayOrdered[i] = 'e';
				}
				
				#pragma omp section
				{
				if (arrayPartial[i] == 6) arrayOrdered[i] = 'f';
				}
				
				#pragma omp section
				{
				if (arrayPartial[i] == 7) arrayOrdered[i] = 'g';
				}
				
				#pragma omp section
				{
				if (arrayPartial[i] == 8) arrayOrdered[i] = 'h';
				}
				
				#pragma omp section
				{
				if (arrayPartial[i] == 9) arrayOrdered[i] = 'i';
				}
				
				#pragma omp section
				{
				if (arrayPartial[i] == 10) arrayOrdered[i] = 'j';
				}
				
				#pragma omp section
				{
				if (arrayPartial[i] == 11) arrayOrdered[i] = 'k';
				}
				
				#pragma omp section
				{
				if (arrayPartial[i] == 12) arrayOrdered[i] = 'l';
				}
				
				#pragma omp section
				{
				if (arrayPartial[i] == 13) arrayOrdered[i] = 'm';
				}
				
				#pragma omp section
				{
				if (arrayPartial[i] == 14) arrayOrdered[i] = 'n';
				}
				
				#pragma omp section
				{
				if (arrayPartial[i] == 15) arrayOrdered[i] = 'o';
				}
				
				#pragma omp section
				{
				if (arrayPartial[i] == 16) arrayOrdered[i] = 'p';
				}
				
				#pragma omp section
				{
				if (arrayPartial[i] == 17) arrayOrdered[i] = 'q';
				}
				
				#pragma omp section
				{
				if (arrayPartial[i] == 18) arrayOrdered[i] = 'r';
				}
				
				#pragma omp section
				{
				if (arrayPartial[i] == 19) arrayOrdered[i] = 's';
				}
				
				#pragma omp section
				{
				if (arrayPartial[i] == 20) arrayOrdered[i] = 't';
				}
				
				#pragma omp section
				{
				if (arrayPartial[i] == 21) arrayOrdered[i] = 'u';
				}
				
				#pragma omp section
				{
				if (arrayPartial[i] == 22) arrayOrdered[i] = 'v';
				}
				
				#pragma omp section
				{
				if (arrayPartial[i] == 23) arrayOrdered[i] = 'w';
				}
				
				#pragma omp section
				{
				if (arrayPartial[i] == 24) arrayOrdered[i] = 'x';
				}
				
				#pragma omp section
				{
				if (arrayPartial[i] == 25) arrayOrdered[i] = 'y';
				}
				
				#pragma omp section
				{
				if (arrayPartial[i] == 26) arrayOrdered[i] = 'z';
				}
			
			} // end sections
		} // end parallel
	} // fim do for	
			
	printf("\nEntrada ordenada em ordem alfabetica: ");
    puts(arrayOrdered);
	
} // fim do método 04

void saida05(int qtdA, int qtdB, int qtdC, int qtdD, int qtdE, int qtdF, int qtdG, 
			int qtdH, int qtdI, int qtdJ, int qtdK, int qtdL, int qtdM, int qtdN, 
			int qtdO, int qtdP, int qtdQ, int qtdR, int qtdS, int qtdT, int qtdU, 
			int qtdV, int qtdW, int qtdX, int qtdY, int qtdZ){
				
	printf("\nSaida 5:");
	
	int somaTabela = 0;
	int aux = 0;
	
	#pragma omp parallel
	{
		#pragma omp sections
		{

			#pragma omp section
			{	
		    if(qtdA != 0) aux += 1;
			} // end
			
			#pragma omp section
			{
			if(qtdB != 0) aux += 2;
			} // end
			
			#pragma omp section
			{
			if(qtdC != 0) aux += 3;
			} // end
			
			#pragma omp section
			{
			if(qtdD != 0) aux += 4;
			} // end
			
			#pragma omp section
			{
			if(qtdE != 0) aux += 5;
			} // end
			
			#pragma omp section
			{
			if(qtdF != 0) aux += 6;
			} // end
			
			#pragma omp section
			{
			if(qtdG != 0) aux += 7;
			} // end
			
			#pragma omp section
			{
			if(qtdH != 0) aux += 8;
			} // end
			
			#pragma omp section
			{
			if(qtdI != 0) aux += 9;
			} // end
			
			#pragma omp section
			{
			if(qtdJ != 0) aux += 10;
			} // end
			
			#pragma omp section
			{
			if(qtdK != 0) aux += 11;
			} // end
			
			#pragma omp section
			{
			if(qtdL != 0) aux += 12;
			} // end
			
			#pragma omp section
			{
			if(qtdM != 0) aux += 13;
			} // end
			
			#pragma omp section
			{
			if(qtdN != 0) aux += 14;
			} // end
			
			#pragma omp section
			{
			if(qtdO != 0) aux += 15;
			} // end
			
			#pragma omp section
			{
			if(qtdP != 0) aux += 16;
			} // end
			
			#pragma omp section
			{
		    if(qtdQ != 0) aux += 17;
			} // end
			
			#pragma omp section
			{
		    if(qtdR != 0) aux += 18;
			} // end
			
			#pragma omp section
			{
		    if(qtdS != 0) aux += 19;
			} // end
			
			#pragma omp section
			{
		    if(qtdT != 0) aux += 20;
			} // end
			
			#pragma omp section
			{
		    if(qtdU != 0) aux += 21;
			} // end
			
			#pragma omp section
			{
		    if(qtdV != 0) aux += 22;
			} // end
			
			#pragma omp section
			{
		    if(qtdW != 0) aux += 23;
			} // end
			
			#pragma omp section
			{
		    if(qtdX != 0) aux += 24;
			} // end
			
			#pragma omp section
			{
			if(qtdY != 0) aux += 25;
			} // end
			
			#pragma omp section
			{
			if(qtdZ != 0) aux += 26;
			} // end
			
			#pragma omp section
			{
				#pragma omp critical
				{
					somaTabela =+ aux;  	
				} // end critical -- para a soma não se alterar em várias vezes que rodar por causa da região paralela
			} // end
			
		} // end sections
		
	} // end parallel
	
	printf("\nSoma das letras de sua entrada pela tabela: %d", somaTabela);
	
} // fim do método 05


int main(){
	
	omp_set_num_threads(10);
	
    printf("Digite a entrada:\n");
    //scanf("%[A-Z a-z]",userInput); 
    fgets(userInput, 199, stdin);
    
    // passa o array e ele mostra a quantidade de letras que contem na palavra
    saida01(userInput);
    
    // passa as variaveis das vogais e ele verifica quais vogais sua frase possui
    saida02(qtdA, qtdE, qtdI, qtdO, qtdU);	
	
	// 	passa as variáveis das vogais e ele mostra quantas vezes cada vogal se repete
	saida03(qtdA, qtdE, qtdI, qtdO, qtdU);
			
	// passa o array da frase e ele exibe a todas as letras em ordem alfabética		
	saida04(userInput);
	
	// atribui uma soma geral para frase de acordo com determinado valor de cada letra		
	saida05(qtdA, qtdB, qtdC, qtdD, qtdE, qtdF, qtdG, qtdH, qtdI, qtdJ, qtdK, qtdL, 
	qtdM, qtdN, qtdO, qtdP, qtdQ, qtdR, qtdS, qtdT, qtdU, qtdV, qtdW, qtdX, qtdY, qtdZ);
	
}
