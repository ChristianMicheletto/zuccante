#include <sys/types.h>
#include <unistd.h>
#include <stdio.h>

#define MAX 25 /* maximum number of letters communicated */
int main (void){ 
    int fd[2]; /* provide file descriptor pointer array for pipe */
    /* within pipe:
     * fd[0] will be input end
     * fd[1] will be output end 
     */
     pid_t pid;
     char line[MAX]; /* character array (string) for reading */
     /* create pipe and check for an error */
     if (pipe(fd) < 0){ 
         perror("pipe error");
         exit (1);
        }
    if ((pid = fork()) < 0) /* apply fork and check for error */
{ perror ("error in fork");
exit(1);
}
if (0 == pid)
{ /* processing for child */
printf ("The child process is active.\n");
close (fd[1]); /* close output end, leaving input open */
read(fd[0], line, MAX);
printf ("The string received is ’%s’\n", line);
}
else
{ /* processing for parent */
printf ("The parent process is active.\n");
close (fd[0]); /* close input end, leaving output open */
write (fd[1], "Your parent is calling", 23);
/* print string and indicate byte length */
}
exit(0); /* quit by reporting no error */
}
