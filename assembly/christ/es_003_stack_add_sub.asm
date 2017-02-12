; yasm -f help
; yasm -f elf64 -g dwarf2 <file>
; gcc -o <exe> <object> (we use main label)

    segment .data

a   dq 100
b   dq 200
sum dq 0

    segment .text
    global main

main:

    push rbp                      	; push (save) base pointer
    mov rsp, rbp		      	; update base pointer 
    sub rsp, 16
    mov rax, 9
    add [a], rax
    mov rax, [b]
    add rax, 10
    add rax, [a]
    mov [sum], rax

    leave
    mov rax,0                           ; normal, no error, return value			       
    ret				        ; return
       




