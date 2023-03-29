.data
a: .word 0
b: .word 0
c: .word 0
res: .word 0
control: .word32 0x10000
data: .word32 0x10008


.code
lwu $s0, control ($zero)
lwu $s1, data ($zero)
daddi $t0, $zero, 8
sd $t0, 0($s0)
ld $a0, 0($s1)
sd $t0, 0($s0)
ld $a1, 0($s1)
sd $t0, 0($s0)
ld $a2, 0($s1)
jal suma
sd $v0, res ($zero)
sd $v0, 0($s1)
daddi $t0, $zero, 6
sd $t0, 0($s0)
daddi $t0, $zero, 2
sd $t0, 0($s0)
halt 



suma: beqz $a2, esUno
dsub $t0, $a0, $a1
daddi $v0, $zero, 1
loop: dmul $v0, $v0, $t0
daddi $a2, $a2, -1
bnez $a2, loop
j fin
esUno: daddi $v0, $zero, 1
fin: jr $ra



