#include<stdio.h>
#include<omp.h>


int teste(){

  int j,i, tam=5;
  int vetorA[tam];
  int vetorB[tam];
  int soma = 1;
  int somaGeral = 0;

  for(j = 0; j < tam; j++){
    vetorA[j] = vetorB[j] = j+1;
  }
	    #pragma omp parallel for reduction(*:soma)
	    for(i=0; i < tam; i++){
	      	soma = (vetorA[i] * vetorB[i]) + soma;
	      	printf("\n parcial: %d", soma);
	      	//printf(" %d - Thread %d executa a iteracao %d do loop\n", omp_get_num_threads(), omp_get_thread_num(),i);
	    }
 
  	printf("\n SOMA: %d", soma);

return soma;
}

int main(){
	int j, retorno, saida = 0;
	for( j=0;j<1;j++){
		retorno = teste();
			if(retorno != 55)
				saida = 1;
	}
	printf("\n%d", saida);	
}
