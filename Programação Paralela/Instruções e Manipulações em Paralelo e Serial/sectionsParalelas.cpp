#include <stdio.h>
#include <omp.h>

void soma_vetores(double *a, double *b, double *c, int n){
	for (int i = 0; i < n; i++){
		c[i] = a[i]+b[i];
		printf("\n Soma - ind:%d - valor: %f ", i, c[i]);
	}
} 
void subtrai_vetores(double *a, double *b, double *d, int n){
	for (int i = 0; i < n; i++){
		d[i] = a[i]-b[i];
		printf("\n SUB - ind:%d - valor: %f ", i, d[i]);
	}
}


int main(){	
	int n = 10;
	double a[n], b[n], c[n], d[n];
	for (int j=0; j<n; j++)
   		a[j]=b[j]=j*1.0;
	
	#pragma omp parallel 
	{
		#pragma omp sections
		{
		
			#pragma omp section
			{
				soma_vetores(a,b,c,n);
			}
				
			#pragma omp section
				subtrai_vetores(a,b,d,n);
		}
	}
}

