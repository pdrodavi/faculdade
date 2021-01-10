#include<stdio.h>
#include<omp.h>

int main(){
	
	int id,i,tam;
	int v[tam], w[tam], k[tam];
	
	
	#pragma omp parallel
	{
		tam = omp_get_num_threads();
		id = omp_get_thread_num();
		v[id] = id*(2);
		w[id] = id*(3);
		
		#pragma omp flush(v)
		
		#pragma omp for
		for (i = 0; i < tam; i++){
			k[i]= v[i]+w[i];
			printf("\n valor:%d - ind:%d", k[i], i);
		}
	}
	

		

}
