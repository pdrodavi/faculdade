#include<stdio.h>
#include<unistd.h>
#include<sys/types.h>

int main(){

	int pid = fork();
	int count;
	int bug = 100000;
	int n;

	printf("Digite um numero: ");
	scanf("%d", &n);

	for(count=1; n<bug; count++){
	fork();
	printf("%d\n",(int)getpid());
	printf("%d\n",(int)getppid());
	bug = 100000*n;	

	}

	return(0);

}
