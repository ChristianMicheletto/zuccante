#include <stdio.h>
#include <unistd.h>

int num = 0;

int main(int argc, char*argv[]){
    int pid;
    pid = fork();
    printf("num is: %d\n", num);  
    if(pid == 0){       /*child*/
        num = 1;
    } else if(pid > 0){  /*parent*/
        num = 2;
    }
    printf("the porcess: %d\n", num);
    return 0;
}
