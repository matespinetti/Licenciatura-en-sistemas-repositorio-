.data
CONTROL: .word32 0x10000
DATA: .word32 0x10008
MENSAJE1: .asciiz "Ingrese un numero en punto flotante"
MENSAJE2: .asciiz "Ingrese la potencia a elevar"
POT0: .double 1.0
.code
daddi $sp, $zero, 0x400
lwu $s0, CONTROL ($zero)
lwu $s1, DATA ($zero)
daddi $t0, $zero, MENSAJE1
sd $t0, 0($s1)
daddi $t0, $zero, 4
sd $t0, 0($s0)
daddi $t0, $zero, 8
sd $t0, 0($s0)
l.d f1, 0($s1)
daddi $t0, $zero, MENSAJE2
sd $t0, 0($s1)
daddi $t0, $zero, 4
sd $t0, 0($s0)
daddi $t0, $zero, 8
sd $t0, 0($s0)
ld $a1, 0($s1)
jal a_la_potencia
s.d f2, 0($s1)
daddi $t0, $zero, 3
sd $t0, 0($s0)
halt

a_la_potencia: daddi $sp, $sp, -8
sd $ra, 0($sp)
beqz $a1, expCero
l.d f2, POT0($zero)
loop: mul.d f2, f2, f1
daddi $a1, $a1, -1
bnez $a1, loop
j fin
expCero: l.d f2, POT0($zero)
fin: ld $ra, 0($sp)
daddi $sp, $sp, 8
jr $ra


