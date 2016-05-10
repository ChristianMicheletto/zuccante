#include <stdio.h>
#include <unistd.h>

int num = 0;

int main(int argc, char*argv[]){
    int pidt;
    pidt = fork();
    printf("num is: %d\n", num);  
    if(pidt == 0){       /*child*/
        num = 1;
    } else if(pidt > 0){  /*parent*/
        num = 2;
    }
    printf("the porcess: %d\n", num);
    return 0;
}
