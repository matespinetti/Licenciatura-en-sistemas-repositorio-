.data
cadena: .asciiz "mAteo"
vocales: .asciiz "aeiouAEIOU"
res: .byte 0

.code
daddi $sp, $zero, 0x400
daddi $a1, $zero, cadena
jal contar_voc
sd $s0, res ($zero)
halt



contar_voc: daddi $s0, $zero, 0
daddi $sp, $sp, -8
sd $ra, 0($sp)
contar: lbu $a0, 0($a1)
beqz $a0, fin
jal es_vocal
beqz $v0, seguir
daddi $s0, $s0, 1
seguir: daddi $a1, $a1, 1
j contar

fin: ld $ra, 0($sp)
daddi $sp, $sp, 8
jr $ra

es_vocal: dadd $v0, $0, $0
 daddi $t0, $0, 0
 loop: lbu $t1, vocales($t0)
 beqz $t1, finVocal
 beq $a0, $t1, si_es_voc
 daddi $t0, $t0, 1
 j loop
 si_es_voc: daddi $v0, $0, 1
 finVocal: jr $ra
