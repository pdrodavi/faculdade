#include<stdio.h>
#include<omp.h>

int main(){	
	
	int n=50, i, a[n], b[n], c[n];
	#pragma omp for
	for(i=0;i < n;i++)
		a[i]= b[i] = 2*i;
	
	
	#pragma omp parallel
	{
		
		#pragma omp for schedule(static,)
		for (i = 0; i < n; i++){
			c[i] = a[i]+b[i];
			printf("Thread %d executa a iteração %d do loop\n", omp_get_thread_num(), i);
		}
	}
	
}
