// #include <stdio.h>
#include <unistd.h>
 
int main(){
  // printf("Hello world\n");
  const char msg[] = "Hello world";
  write( STDOUT_FILENO, msg, sizeof(msg) - 1);
  return 0;
}
