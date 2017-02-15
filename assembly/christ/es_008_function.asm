; yasm -f help
; yasm -f elf64 -g dwarf2 <file>
; gcc -o <exe> <object> (we use main label)


    segment .data

yourage db "How old are you: ", 0
willbe  db "You will be %d years old in ten years.", 0xa, 0
input   db "%d", 0

    segment .bss

age     resb 12

    segment .text

extern printf
extern scanf
extern exit

global main
main:
     mov rax, 0
     mov rdi, yourage
     call printf

     mov rax, 0
     mov rdi, input
     mov rsi, age
     call scanf

     mov r15, [age]
     add r15, 10
     mov [age], r15
     mov rax, 0
     mov rdi, willbe
     mov rsi, [age]
     call printf

     mov rax, 0
     mov rdi, 0
     call exit
