.data
CONTROL: .word32 0x10000
DATA: .word32 0x10008
CLAVE: .asciiz "onic"
CLAVEI: .asciiz " "
SI: .asciiz "BIENVENIDO"
NO: .asciiz "ERROR"

.code
lwu $s0, CONTROL ($zero)
lwu $s1, DATA ($zero)
daddi $a0, $zero, CLAVEI
daddi $s2, $zero, 4
loop: jal INGRESO
daddi $s2, $s2, -1
daddi $a0, $a0, 1
bnez $s2, loop
daddi $a0, $a0, -4
daddi $a1, $zero, CLAVE
jal COMPARACION
dadd $a0, $zero, $v0
jal MUESTRA
halt

INGRESO: daddi $t1, $zero, 9
sd $t1, 0 ($s0)
ld $t1, 0($s1)
sb $t1, 0($a0)
jr $ra

COMPARACION: daddi $t2, $zero, 4
loopc: ld $t0, 0($a0)
ld $t1, 0($a1)
bne $t0, $t1, DISTINTOS
daddi $a0, $a0, 1
daddi $a1, $a1, 1
daddi $t2, $t2, -1
bnez $t2, loopc
daddi $v0, $zero, 1
j FIN
DISTINTOS: daddi $v0, $zero, 0
FIN: jr $ra


MUESTRA: daddi $t1, $zero, 6
sd $t1, 0($s0)
beqz $a0, error 
daddi $t1, $zero, SI
sd $t1, 0($s1)
j imprimir
error: daddi $t1, $zero, NO
sd $t1, 0 ($s1)
imprimir: daddi $t1, $zero, 4
sd $t1, 0 ($s0)

jr $ra






