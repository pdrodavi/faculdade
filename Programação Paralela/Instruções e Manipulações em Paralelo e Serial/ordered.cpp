#include<stdio.h>
#include<omp.h>

int main(){
	
	int id,i;
	
	#pragma omp parallel 
	{
		
	#pragma omp for ordered
	for(i=0;i<10;i++)
	{
		#pragma omp oredered
		printf("\n%d - %d",i, omp_get_thread_num());
			
	}
	
	}
}
