#include <stdio.h>
#include <unistd.h>

int pid = 0;

int main(int argc, char*argv[]){
    int pidt;
    pidt = fork();
    pid = getpid();
    if(pidt == 0){    
        printf("child has pid: %d\n", pid);  
    } else if(pidt > 0){  
        printf("parent has pid: %d\n", pid);  
    }
    printf("the END of porcess %d\n", pid);
    return 0;
}
