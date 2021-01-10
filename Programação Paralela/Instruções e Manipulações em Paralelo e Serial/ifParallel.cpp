#include<stdio.h>
#include<omp.h>

int main(){
	int id,i;
	int qtde_thr;
	qtde_thr = omp_get_thread_num();
	omp_set_num_threads(4);
	#pragma omp parallel private(i,id)
	{
		id = omp_get_thread_num();
		//printf("\n%d - %d ", id, omp_get_num_threads());
		for(i=0; i<2;i++)
			printf("\n executou o for da thread %d", id);
		
		printf("\nTotal:%d - Id:%d ", omp_get_num_threads(), id);
	}	
}
