#include <stdio.h>
#include <omp.h>

int main()
{
 #pragma omp parallel
 {
 	int ID = omp_get_thread_num();
 	printf("hello(%d)", ID);
 	printf("world(%d)\n", ID);
 	
 	#pragma omp master
 	{
 		printf("\n Aqui master excuta e slaves não\n");
	 }
 }
}
