#include<stdio.h>
#include<omp.h>

void escrever(){
	FILE * fp;
   	int i;
   
   	fp = fopen ("c:\\temp\\aula.txt","w");
 
   	for(i = 1; i <= 10;i++){
       fprintf (fp, "linha %d\n",i );
   	}
   	fclose (fp);
 }
 
 void ler(){
 	char ch;
   	FILE *fp;
  
   	fp = fopen("c:\\temp\\aula.txt", "r"); // modo leitura
   	while((ch = fgetc(fp)) != EOF)
      printf("%c", ch);
 
   fclose(fp);

 }

int main ()
{
	escrever();
	#pragma omp parallel
	{
		#pragma omp critical
		ler();	
	}
	
}
