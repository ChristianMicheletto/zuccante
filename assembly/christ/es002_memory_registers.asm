; yasm -hf
; yasm -f elf64 -g dwarf2 <file>
; gcc <exe> <object> (we use main label)



segment .text                   

    global  main          
                                
main:

mov    rax, 100
mov    eax, 100
mov    rbx, 0xfab1fab1fab1fab1
mov    rax, a

segment .data                   ;section declaration

a      dd 4





