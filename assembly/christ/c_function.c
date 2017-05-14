#include <stdio.h>
#include <stdlib.h>

int main(){
	int i;
	void my_print(int k){
		printf("%d\n",k);
	}
	scanf("%d",&i);
	my_print(i);
	return 0;
}

// gcc -S -masm=intel c_function.c
