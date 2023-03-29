.data
cadena1: .asciiz "hola"
cadena2: .asciiz "hola"
posicion: .byte 0

.code
daddi $a0, $zero, cadena1
daddi $a1, $zero, cadena2 
jal subrut
sd $v0, posicion ($zero)
halt

subrut: daddi $t2, $zero, 1
loop: lbu $t0, 0($a0)
beqz $t0, esCero
lbu $t1, 0($a1)
bne $t0, $t1, difieren
daddi $a0, $a0, 1
daddi $a1, $a1, 1
daddi $t2, $t2, 1
j loop
esCero: daddi $v0, $zero, -1
j final
difieren: dadd $v0, $zero, $t2
final: jr $ra
