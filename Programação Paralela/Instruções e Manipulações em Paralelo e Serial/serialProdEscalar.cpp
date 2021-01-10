#include<stdio.h>
#include<omp.h>


long teste(){

  int i;
  int tamanhoVetor= 5;
  int vetorA[tamanhoVetor];
  int vetorB[tamanhoVetor];
  long soma = 0;

  for(i = 0; i < tamanhoVetor; i++){
    vetorA[i] = vetorB[i] = i+1;
  }
		#pragma omp for
	    for(i=0; i < tamanhoVetor; i++){
	      	soma = (vetorA[i] * vetorB[i]) + soma;
	    }

  printf("\n %li ", soma);
 	return soma;
}

int main(){
	long retorno;
	int j, saida = 0;
	for( j=0;j<200000;j++){
		retorno = teste();
			if(retorno != 55)
				saida = 1;
	}
	printf("\n%d", saida);	
}
