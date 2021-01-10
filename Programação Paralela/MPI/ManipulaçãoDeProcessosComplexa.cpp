#include<stdio.h>
#include<mpi.h>

int main(int argc, char *argv[]){
	int size, myRank;
	
	MPI_Status st;
	
	int vInicial, vModificado, total, nproc;
	
	//inicializa os processos
	MPI_Init(&argc, &argv);
	
	// determinar a quantidade de processos e o grupo
	// MPI_COMM_WORLD é o grupo padrão
  	MPI_Comm_size(MPI_COMM_WORLD, &size);
  	
  	// determinar a identificacao de cada processo
  	MPI_Comm_rank(MPI_COMM_WORLD, &myRank);
  	
  	printf("Sou o processo %d de um total de %d processos\n",myRank, size );
  	//fflush(stdout);
  	
  	if(myRank==0){
  		//processo mestre
		for(nproc=1; nproc < size; nproc++){
			vInicial = nproc * 10;
			
			//mensagem enviada, número de elementos enviados, tipo do dado, número do processo, rótulo, grupo do comunicador MPI 
			MPI_Send(&vInicial, 1, MPI_INT, nproc, 0, MPI_COMM_WORLD);
			
			printf("Mestre - Enviei %d para o proc %d \n", vInicial, nproc);
			//fflush(stdout);
		}

		total = 0;
		
		for(nproc=1; nproc < size; nproc++){
			MPI_Recv(&vModificado, 1, MPI_INT, nproc, 1, MPI_COMM_WORLD, &st);	
			
			total = total + vModificado;
		}
		
		printf("\n o total foi %d", total);
		
		
	}else{
	 	//processo escravo
	 	
	 	//valor recebido, número de elementos recebidos, tipo do dado, número do processo que enviou, rótulo, grupo do comunicador, status
	 	MPI_Recv(&vInicial, 1, MPI_INT, 0, 0, MPI_COMM_WORLD, &st);
	 	printf("Escravo %d - recebi %d do mestre \n", myRank, vInicial);
	 	//fflush(stdout);
	 	
	 	vModificado = vInicial * 10;
	 	
	 	//mandar a mensagem para o mestre - 0
	 	MPI_Send(&vModificado, 1, MPI_INT, 0, 1, MPI_COMM_WORLD);
		
	 	printf("Escravo %d - valor modificado %d enviado\n", myRank, vModificado);
	 	//fflush(stdout);			
	 	
	}
  	
	  MPI_Finalize();
}
