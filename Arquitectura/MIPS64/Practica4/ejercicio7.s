.data
TABLA: .word 1,2,5,4,3,2,5,6,7,5
X: .word 4
cant: .word 0
res: .word 0,0,0,0,0,0,0,0,0,0

.code
dadd $t0, $zero, $zero
daddi $t6, $zero, 1 
daddi $t7, $zero, 80
ld $t8, cant ($zero)
ld $t3, X($zero)
loop: beq $t0, $t7, fin
ld $t1, TABLA($t0)
slt $t4, $t3, $t1
beqz $t4, seguir
sd $t6, res($t0)
daddi $t8, $t8, 1
seguir: daddi $t0, $t0, 8
j loop
fin: halt




