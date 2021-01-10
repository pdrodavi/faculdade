#include<stdio.h>
#include<omp.h>

int teste(){
 	int i;
  	int tamanhoVetor=5;
 	int vetorA[tamanhoVetor];
  	int vetorB[tamanhoVetor];
	int somaGeral = 0;
  
  	for(i = 0; i < tamanhoVetor; i++)
    	vetorA[i] = vetorB[i] = i+1;

	
  	#pragma omp parallel shared(somaGeral) private(i)
	{
		int soma = 0;
		#pragma omp for 
    	for(i=0; i < tamanhoVetor; i++){
      		soma += (vetorA[i] * vetorB[i]);
      		//printf("%d - Thread %d executa a iteracao %d do loop\n", omp_get_num_threads(), omp_get_thread_num(),i);
    	}
    	#pragma omp critical
    	somaGeral += soma;
    	printf("\n %d - %d ", soma, somaGeral);
  	}
  	//printf("\nTOTAL: %d", somaGeral);
  	return somaGeral;
  	

}

int main(){
	int j, retorno, saida = 0;
	for( j=0;j<100;j++){
		retorno = teste();
			if(retorno != 55)
				saida = 1;
	}
	printf("\n%d", saida);	
}
