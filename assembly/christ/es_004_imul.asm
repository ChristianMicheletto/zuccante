; yasm -f help
; yasm -f elf64 -g dwarf2 <file>
; gcc -o <exe> <object> (we use main label)

     segment .data
     
a    db 10
res  dq 0

     segment .bss

     segment .text
     global main

main:

     mov  rax, 20
     imul rax, [a]
     mov  rbx, 200
     imul rax, rbx
     mov  rdx, 0x0000000000000000
     mov  rax, 0x1000000000000000
     mov  rbx, 0x0000000000000100
     imul rbx
     mov  rdx, 0x0000000000000000
     mov  rax, 0x1000000000000000
     mov  rbx, 0x0000000000000100
     imul rax, rbx                  ; ahhhhhcheddolore
     
     mov rax,0				        ; normal, no error, return value
     ret				            ; return
       




