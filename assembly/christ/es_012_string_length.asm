; yasm -f help
; yasm -f elf64 -g dwarf2 <file>
; gcc <exe> <object> (we use main label)


bufLen  equ 41                         ; the buffer length

     segment .data

msg1  db  "Please input a string: (no blans)", 0xa, 0x0
msg2  db  "The string length is: ", 0x0
newl  db  0xa, 0x0
xd    db  "%d", 0x0
xs    db  "%s", 0x0


     segment .bss

string  resb bufLen

     segment .text

extern printf
extern scanf
extern exit

global main

main:

     xor rax, rax                     ; printf msg1
     mov rdi, msg1
     call printf

     xor rax, rax                     ; scan string
     mov rdi, xs
     mov rsi, string
     call scanf

     mov rbx, string                  ; prepare the argument
     call strLen  
     push rax                         ; save rax                   

     xor rax, rax                     ; printf msg2
     mov rdi, msg2
     call printf

     pop rax
     mov rsi, rax                     ; print rax as an integer %d
     xor rax, rax                     
     mov rdi, xd
     call printf

     xor rax, rax                     ; printf newl
     mov rdi, newl
     call printf

     mov rax, 0
     mov rdi, 0
     call exit

; str_len receives a pointer to a string in rbx and return the length in rax

strLen:
     push rbx                        ; rbx will be used as a local variable
     xor  rax, rax                   ; length is 0 ... at the beginning
repeat: 
     cmp BYTE [rbx], 0x0             ; check the end of string
     je done                         ; jump with a 0 condition, see flag register!
     inc rax
     inc rbx
     jmp repeat                      ; an absolute jump
done:
     pop rbx
     ret
       




