#include <stdio.h>
#include <unistd.h>

int pid = 0;

int main(int argc, char*argv[]){
    int pid;
    pid = fork();
    pid = getpid();
    printf("the PID porcess is: %d\n", pid);
    return 0;
}
