#include<stdio.h>
#include<mpi.h>   //incluir chamada da lib

int main(int argc, char *argv[]){
	int size, myRank;
	
	//inicializa os processos
	MPI_Init(&argc, &argv);
	
	// determinar a quantidade de processos e o grupo
	// MPI_COMM_WORLD é o grupo padrão
  	MPI_Comm_size(MPI_COMM_WORLD, &size);
  	
  	// determinar a identificacao de cada processo
  	MPI_Comm_rank(MPI_COMM_WORLD, &myRank);
  	
  	printf("Sou o processo %d de um total de %d processos\n", myRank, size );
  	
	//fflush(stdout);
  	
	MPI_Finalize();
}
