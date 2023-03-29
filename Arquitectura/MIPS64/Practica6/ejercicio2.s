.data
CONTROL: .word32 0x10000
DATA: .word32 0x10008
CERO: .asciiz "cero"
UNO: .asciiz "uno"
DOS: .asciiz "dos"
TRES: .asciiz "tres"
CUATRO: .asciiz "cuatro"
CINCO: .asciiz "cinco"
SEIS: .asciiz "seis"
SIETE: .asciiz "siete"
OCHO: .asciiz "ocho"
NUEVE: .asciiz "nueve"


.code
ld $s0, CONTROL ($zero)
ld $s1, DATA ($zero)
jal INGRESO
dadd $a0, $zero, $v0
jal MUESTRA
halt




INGRESO: daddi $t0, $zero, 8
loop: sd $t0, 0($s0)
ld $t1, 0($s1)
slti $t2, $t1, 10
beqz $t2, noEsUnDigito
slti $t2, $t1, 0
bnez $t2, noEsUnDigito
j esDig 
noEsUnDigito: j loop
esDig: dadd $v0, $zero, $t1 
jr $ra

MUESTRA: daddi $t0, $zero, 0
beqz $a0, esCero
daddi $t0, $t0, 1
beq $a0, $t0, esUno 
daddi $t0, $t0, 1
beq $a0, $t0, esDos
daddi $t0, $t0, 1
beq $a0, $t0, esTres 
daddi $t0, $t0, 1
beq $a0, $t0, esCuatro 
daddi $t0, $t0, 1
beq $a0, $t0, esCinco
daddi $t0, $t0, 1
beq $a0, $t0, esSeis
daddi $t0, $t0, 1
beq $a0, $t0, esSiete 
daddi $t0, $t0, 1
beq $a0, $t0, esOcho 
daddi $t0, $t0, 1
beq $a0, $t0, esNueve

esCero: daddi $t0, $zero, CERO
j mover
esUno: daddi $t0, $zero, UNO
j mover
esDos: daddi $t0, $zero, DOS
j mover
esTres: daddi $t0, $zero, TRES
j mover
esCuatro: daddi $t0, $zero, CUATRO
j mover
esCinco: daddi $t0, $zero, CINCO
j mover
esSeis: daddi $t0, $zero, SEIS
j mover
esSiete: daddi $t0, $zero, SIETE
j mover
esOcho: daddi $t0, $zero, OCHO
j mover
esNueve: daddi $t0, $zero, NUEVE

mover: sd $t0, 0($s1)
daddi $t0, $zero, 4
sd $t0, 0($s0)

jr $ra



