.data
x: .word 5
y: .word 3
a: .word 4

.code
ld $t0, x($zero)
ld $t1, y($zero)
ld $t2, a($zero)
loop: daddi $t2, $t2, -1
bnez $t2, loop
dadd $t0, $t0, $t1
halt

