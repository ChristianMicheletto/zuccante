	.file	"hello_64.c"
	.intel_syntax noprefix
	.text
	.globl	main
	.type	main, @function
main:
.LFB2:
	.cfi_startproc
	push	rbp
	.cfi_def_cfa_offset 16
	.cfi_offset 6, -16
	mov	rbp, rsp
	.cfi_def_cfa_register 6
	sub	rsp, 48
	mov	DWORD PTR [rbp-36], edi
	mov	QWORD PTR [rbp-48], rsi
	mov	rax, QWORD PTR fs:40
	mov	QWORD PTR [rbp-8], rax
	xor	eax, eax
	movabs	rax, 8022916924116329800
	mov	QWORD PTR [rbp-32], rax
	mov	DWORD PTR [rbp-24], 560229490
	mov	BYTE PTR [rbp-20], 0
	lea	rax, [rbp-32]
	mov	ecx, 12
	mov	rdx, rax
	mov	esi, 1
	mov	edi, 1
	mov	eax, 0
	call	syscall
	mov	esi, 1
	mov	edi, 60
	mov	eax, 0
	call	syscall
	mov	eax, 0
	mov	rdx, QWORD PTR [rbp-8]
	xor	rdx, QWORD PTR fs:40
	je	.L3
	call	__stack_chk_fail
.L3:
	leave
	.cfi_def_cfa 7, 8
	ret
	.cfi_endproc
.LFE2:
	.size	main, .-main
	.ident	"GCC: (Ubuntu 5.4.0-6ubuntu1~16.04.4) 5.4.0 20160609"
	.section	.note.GNU-stack,"",@progbits
