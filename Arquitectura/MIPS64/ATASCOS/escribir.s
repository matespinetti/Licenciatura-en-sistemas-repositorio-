.data
tabla: .word 1, 2, 3, 4, 5

.code
daddi r14, r0, 5
dadd r15, r0, r0
loop: daddi r14, r14, -1
sd r15, tabla (r15)
bnez r14, loop
daddi r15, r15, 8
halt