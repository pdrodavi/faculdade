	#include <omp.h>
	#include <stdio.h>
	int main ( ){
	int i, n, N=10;
	float a[N], b[N], c[N];
	for (i=0; i<N; i++)
	   a[i]=b[i]=i*1.0;
	n=N;
	#pragma omp parallel shared (a,b,c,n) private (i)
	  {
	  	#pragma omp single
	  	{
	  		printf("\n somente uma vez!");
		}
	  	
	   #pragma omp sections 
	   {
	   	#pragma omp section
	   		for (i=0; i < n/2; i++)
	       		c[i]= (a[i]+b[i]) ;
		#pragma omp section
	   		for (i=n/2; i < n; i++)
	       		c[i]=a[i]+b[i];
	   }
	  }
	}

