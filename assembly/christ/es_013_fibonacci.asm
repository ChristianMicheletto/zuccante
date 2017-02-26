; yasm -f help
; yasm -f elf64 -g dwarf2 <file>
; gcc <exe> <object> (we use main label)


buf_len  equ 41                         ; the buffer length

     segment .data

msg   db  "Please input a number for Fibonacci sequence:", 0xa, 0x0
newl  db  0xa, 0x0
xd    db  "%d", 0x0


     segment .bss

num   resb 2

     segment .text

extern printf
extern scanf
extern exit

global main

main:

     xor rax, rax                     ; printf msg
     mov rdi, msg
     call printf

     xor rax, rax                     ; scan num
     mov rdi, xd
     mov rsi, num
     call scanf

     xor rax, rax                     ; printf newl
     mov rdi, newl
     call printf

     mov rax, [num]                   ; fibonacci argument
     call fibonacci                   ; call fibonacci

     mov rsi, rax                     ; print rax as an integer %d
     xor rax, rax                     
     mov rdi, xd
     call printf

     xor rax, rax                     ; printf newl
     mov rdi, newl
     call printf

     mov rax, 0                       ; THE END
     mov rdi, 0
     call exit

; fibonacci input in eax, print sequence (rcx is also used)

fibonacci:
     cmp  rax, 1                      ; n<=2?
     jbe  fib                         ; yes (j <=)
     dec  rax                         ; n-1 -> rax
     push rax                         ; save rax  
     call fibonacci                   ; fib(n-1) -> rax
     xchg rax, [rsp]                  ; swap n-1 with fib(n-1) (the same as 0[rsp])
     dec  rax                         ; n-2 -> rax
     call fibonacci                   ; fib(n-2) -> rax
     pop  rcx                         ; fib(n-2) -> rcx
     add  rax, rcx                    ; fib(n-1)+fib(n-2) -> eax
     
fib:
     ret
