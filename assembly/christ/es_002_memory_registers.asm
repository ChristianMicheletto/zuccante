; yasm -f HELP
; yasm -f elf64 -g dwarf2 <file>
; gcc -o <exe> <object> (we use main label)

     segment .data

a    db 4
b    db 10

     segment .text
     global main

main:

     mov rax, 199
     mov rbx, 100
     mov rax, 0xfafafafafafafafa
     mov ax, [a]
     mov rax,0				; normal, no error, return value
     ret				; return
       




