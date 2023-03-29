.data
n1: .word 15
n2: .word 15
res: .word 0

.code
ld $t0, n1($zero)
ld $t1, n2($zero)
ld $t2, res($zero)
beqz $t0, fin
beqz $t1, fin
loop: dadd $t2, $t2, $t0
daddi $t1, $t1, -1
bnez $t1, loop
sd $t2, res($zero)

fin: halt

