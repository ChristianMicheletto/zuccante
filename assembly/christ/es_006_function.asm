; yasm -f help
; yasm -f elf64 -g dwarf2 <file>
; gcc -o <exe> <object> (we use main label)

%include "macros.mac"

     segment .data

msg  db "Hello World", 0x0a, 0

     segment .bss

     segment .text
     global main
     extern printf

main:
    
     lea  rdi, [msg]
     xor  eax, eax     ; put 0 in eax 
     call printf       ; C printf
     
     xor  eax, eax     ; return 0
     ret
      

    
