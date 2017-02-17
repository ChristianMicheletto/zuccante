; yasm -f help
; yasm -f elf64 -g dwarf2 <file>
; gcc -o <exe> <object> (we use main label)


    segment .data

msg     db "Your name is:",  0xa, 0
newl      db 0xa, 0
hello   db "Hello: ", 0
input   db "%s", 0

    segment .bss

name    resb 12

    segment .text

extern printf
extern scanf
extern exit

global main
main:
     mov rax, 0
     mov rdi, msg
     call printf

     mov rax, 0
     mov rdi, input
     mov rsi, name
     call scanf

     mov rax, 0
     mov rdi, hello
     call printf

     mov rax, 0
     mov rdi, name
     call printf

     mov rax, 0
     mov rdi, newl
     call printf

     mov rax, 0
     mov rdi, 0
     call exit
