.data
n: .word 15

.code
daddi r2, $zero, 2
loop: daddi r2, r2, -1
bnez r2, loop
halt
