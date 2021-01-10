#include <stdio.h>
#include <omp.h>

void dobro(int x, int fixo){
	
	float saida;
	saida =  2 * x + fixo;
	printf("\nOUT: %f", saida);
}

int main()
{
	int A = 10; //uma cópia dessa variável é compartilhada entre as threads 
	
	//omp_set_num_threads(4);	
	#pragma omp parallel num_threads(4)
 	{
 		int ID = omp_get_thread_num();
		dobro(ID, A);	
 	}
 	return 0;
}


