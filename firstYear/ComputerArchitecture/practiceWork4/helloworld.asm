model small
.data
msg db 'Hello world!', '$'
.code
main proc
; set data segment
mov ax, @data
mov ds, ax
; print message
mov ah, 9h
lea dx, msg ; Directly reference msg
int 21h
; exit
mov ah, 4ch
int 21h
main endp
end main
.bss
; reserve 64 bytes for buffer
buffer resb 64
; reserve 128