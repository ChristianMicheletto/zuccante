; nasm -hf
; nasm -f elf64 hello_64.asm AND we obtain object module
; ld -s -o hello hello_64.o AND we obtain executable
; syscall



section .text                   ;section declaration

                                ;we must export the entry point to the ELF linker or
    global  _start              ;loader. They conventionally recognize _start as their
                                ;entry point. Use ld -e foo to override the default.

_start:

   

section .data                   ;section declaration

a    dd 4
b    db 4.4
c    times 10 dd 0
d    db 3
e    dw 1, 2
f    db "helo world", 0

section .bss                   ;section

g    resd 10 






