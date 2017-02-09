; yasm -f help
; yasm -f elf64 -g dwarf2 <file>
; gcc <exe> <object> (we use main label)

     segment .data

     segment .bss

     segment .text
     global main

main:

     mov rax,0				; normal, no error, return value
     ret				; return
       




