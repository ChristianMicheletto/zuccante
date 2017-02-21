; yasm -f help
; yasm -f elf64 -g dwarf2 <file>
; gcc -o <exe> <object> (we use main label)

%include "cmacros.mac"

    segment .data

msgi    db "Input a number: ", 0
msgo    db "You have just inserted:", 0xa, 0
input   db "%d", 0
newl    db  0xa, 0

    segment .bss

num     resb 1

    segment .text

global main

main:
     print msgi
     scan input, num
     print msgo
     print input, num
     print newl
     return0
