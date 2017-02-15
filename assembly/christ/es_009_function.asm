; yasm -f help
; yasm -f elf64 -g dwarf2 <file>
; gcc -o <exe> <object> (we use main label)


    segment .data

msg1    db "Insert first number: ", 0
msg2    db "Insert second number: ", 0
msg3    db "the sum is: ", 0
newl    db  0xa, 0
input   db "%d", 0

    segment .bss

n1     resb 2
n2     resb 2
n3     resb 2

    segment .text

extern printf
extern scanf
extern exit

global main
main:
     mov rax, 0
     mov rdi, msg1
     call printf

     mov rax, 0
     mov rdi, input
     mov rsi, n1
     call scanf

     mov rax, 0
     mov rdi, msg2
     call printf

     mov rax, 0
     mov rdi, input
     mov rsi, n2
     call scanf

     mov rbx, [n1]
     mov rcx, [n2]

     call sum

     add rax, 0x30              ; ass '0'
     mov [n3], rax

     mov rax, 0
     mov rdi, msg3
     call printf

     mov rax, 0
     mov rdi, n3
     call printf

     mov rax, 0
     mov rdi, newl
     call printf

     mov rax, 0
     mov rdi, 0
     call exit

sum: 
    mov rax, rbx
    add rax, rcx
    ret
