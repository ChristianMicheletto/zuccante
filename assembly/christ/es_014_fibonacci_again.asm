; yasm -f help
; yasm -f elf64 -g dwarf2 <file>
; gcc  -o exe> <object> (we use main label)

     segment .data

msg1   db  "Please enter a positive number (>1):", 0xa, 0x0
msg21  db  "The largest Fibonacci number less than or equal to ", 0x0
msg22  db  " is ", 0x0

newl  db  0xa, 0x0
xd    db  "%d", 0x0


     segment .bss

num  resb 4

     segment .text

extern printf
extern scanf
extern exit

global main

main:

     xor rax, rax                     ; printf msg1
     mov rdi, msg1
     call printf

     xor rax, rax                     ; scanf %d num
     mov rdi, xd                      
     mov rsi, num
     call scanf

     xor rax, rax                     ; printf newl
     mov rdi, newl
     call printf

     mov rdx, [num]                   ; fibonacci argument rdx <- [num]
     call fibonacci                   ; call fibonacci
     push rax                         ; save output
     push rdx                         ; save input (in C it may be used)
     
     xor rax, rax                     ; printf msg21 
     mov rdi, msg21
     call printf

     pop rdx                          ; restore input
     xor rax, rax                     ; printf %d rdx
     mov rdi, xd
     mov rsi, rdx
     call printf

     xor rax, rax                     ; printf msg22
     mov rdi, msg22
     call printf

     pop rax                          ; restore output
     mov rsi, rax                     ; printf %d rax
     xor rax, rax                     
     mov rdi, xd
     call printf
                 
     xor rax, rax                     ; printf newl
     mov rdi, newl
     call printf

     mov rax, 0                       ; THE END
     mov rdi, 0
     call exit

; fibonacci input in rdx, output in rax

fibonacci:
%define FIB_LO   QWORD [rbp-8]        ; first local variable  LOWER fibonacci number
%define FIB_HI   QWORD [rbp-16]       ; second local variable HIGHER fibonacci number
     enter 16,0                       ; FIB_LO + FIB_HI (8+8) set the size o the frame

     ;push rbp
     ;mov rbp, rsp
     ;sub rsp, 16

     push rbx                         ; save rbx
     mov FIB_LO, 1                    ; FIB_LO <- 1
     mov FIB_HI, 1                    ; FIB_HI <- 1
fib_loop:                             ; a sort of while loop
     mov rbx, FIB_LO
     mov rax, FIB_HI
     add rbx, rax
     mov FIB_LO, rax                  ; next step
     mov FIB_HI, rbx
     cmp rbx, rdx                     ; compare with input number
     jle fib_loop
     pop rbx                          ; restore rbx
     leave                            ; release the frame
     ret                              ; in rax the output
