; yasm -f help
; yasm -f elf64 -g dwarf2 <file>
; gcc -o <exe> <object> (we use main label)

%include "macros.mac"

     segment .data

msg1 db "Input a String: ", 0
len1 equ $ - msg1
msg2 db "Input a Byte number: ", 0
len2 equ $ - msg2


     segment .bss

inStr  resb 8
inByte resb 1

     segment .text
     global main

main:

     putStr msg1, len1
     getStr inStr, 8 
     putStr msg2, len2
     getByte inByte 
                  
     mov rax,0				; normal, no error, return value
     ret				; return