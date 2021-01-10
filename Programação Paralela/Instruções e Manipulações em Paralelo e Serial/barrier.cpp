#include<stdio.h>
#include<omp.h>

int main(){
	
	#pragma omp parallel
	{
		printf("\n novaTHR %d",omp_get_thread_num());
		
		#pragma omp barrier
		printf("\n espera %d",omp_get_thread_num());
		
	}

}

