.data
num: .word 14
tabla: .word 22, 5, 2, 5, 6, 15, 9, 17
cant: .word 8
res: .word 0

.code
ld $a0, num ($zero)
daddi $a1, $zero, tabla
ld $a2, cant ($zero)
jal cantMayores
sd $v0, res($zero)
halt


cantMayores: dadd $t0, $zero, $zero
dadd $v0, $zero, $zero 
loop: beqz $a2, terminar
ld $t1,  0($a1)
daddi $a2, $a2, -1
daddi $a1, $a1, 8
slt $t2, $a0, $t1
beqz $t2, loop
daddi $v0, $v0, 1
j loop
terminar: jr $ra



