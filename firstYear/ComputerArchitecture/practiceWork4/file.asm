.model small
.stack 100h
.data
    array dw 15 DUP(0) ; Define an array of 15 words, initially filled with 0s

.code
main PROC
    mov ax, @data       ; Initialize data segment
    mov ds, ax

    ; Prepare our loop
    mov bx, 0           ; Initial position in the array
    mov cx, 0           ; Loop counter
    mov ax, 1           ; First element of the array

array_loop:
    ; Use ax and dx as temporary registers to hold the last two Fibonacci numbers
    mov [array + bx], ax  ; Store F(n) in the array
    add bx, 2             ; Move to the next position in the array (words)
    inc ax                ; next number in the sequence
    inc cx
    cmp cx, 15
    jne array_loop    ; Repeat if cx != 15

    mov ax, 4C00h       ; Terminate program
    int 21h
main ENDP
END main