.data
tabla: .word 3, 5, 0
cant: .word 0

.code
daddi $a0, $zero, tabla
daddi $sp, $zero, 0x400
jal contarImpares
sd $v1, cant ($zero)
halt


contarImpares: daddi $sp, $sp, -8
sd $ra, 0($sp)
daddi $v1, $zero, 0
loop: ld $a1, 0($a0)
beqz $a1, fin
jal es_impar
dadd $v1, $v1, $v0
daddi $a0, $a0, 8
j loop
fin: ld $ra, 0($sp)
daddi $sp, $sp, 8
jr $ra

es_impar: andi $v0, $a1, 1
jr $ra