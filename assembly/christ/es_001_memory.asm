; nasm -hf
; nasm -f elf64 <source>
; ld -s -o <file_ex> <object>
; syscall



section .text                   

    global  _start              ;entry point. Use ld -e foo to override the default.
                                
                               
_start:

mov    rax, 60                  ;exit
mov    rdi, 0                   ;0
syscall     


section .data                    ;section declaration

msg  db      "Hello, world!", 0
a    dd 4
b    dw 4
c    db 4
d    dd 4,4
e    dd 4.4
f    times 10 dd 0

section .bss

var1: resb 4
var2: resd 1