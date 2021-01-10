#include <stdio.h>
#include <omp.h>

int main()
{	
	int n = 10;
	float a[n], b[n], c[n];
	for (int j=0; j<n; j++)
   		a[j]=b[j]=j*1.0;	

 #pragma omp parallel
 	{	
 
 	#pragma omp for 
			for (int i = 0; i < n; i++){
				c[i] = a[i]+b[i];
				printf("Thread %d executa a iteração %d do loop\n", omp_get_thread_num(),i);
		}
	}
}





