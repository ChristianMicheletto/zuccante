#include <stdlib.h>
#include <unistd.h>

int main(int argc, char *argv[]){
    const char msg[] = "Hello World!";
    // man syscall
    // write to standard output
    syscall(1, STDOUT_FILENO, msg, sizeof(msg)-1);
    // return 0
    // exit(0);
    syscall(60, 1);
    
    }
