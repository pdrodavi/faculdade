#include<stdio.h>
#include<omp.h>

int main(){
	int i,id;
	
	omp_set_num_threads(4);
	#pragma omp parallel default(shared) private(id, i)
	{
		id = omp_get_thread_num();
		for(i=0;i <= 2;i++){
			printf("\n%d - %d ", id, i);
		}	
	}	
}
