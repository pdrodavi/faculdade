#include<stdio.h>
#include<omp.h>

int main(){
	int i,n=10, a[n], b[n], c[n], d[n];
	
	#pragma omp for
	for(i=0;i < n;i++)
		a[i]= b[i] = 2*i;
	
	#pragma omp parallel
	{
		#pragma omp for nowait
		for (i = 0; i < n; i++){
			c[i] = a[i]+b[i];
			printf("\nC:%d - ind:%d", c[i], i);
		}
		
		#pragma omp for 
		for (i = 0; i < n; i++){
			d[i] = a[i]*b[i];
			printf("\nD:%d - ind:%d", d[i], i);
		}
	}
	
}
