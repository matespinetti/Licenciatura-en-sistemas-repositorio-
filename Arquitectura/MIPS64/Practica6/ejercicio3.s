.data
CONTROL: .word32 0x10000
DATA: .word32 0x10008

.code
lwu $s0, CONTROL ($zero)
lwu $s1, DATA ($zero)
jal INGRESO
dadd $v1, $zero, $v0
jal INGRESO
jal RESULTADO
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


RESULTADO: dadd $s3, $v0, $v1
daddi $t1, $zero, 6
sd $t1, 0($s0)
daddi $t1, $t1, -5
sd $s3, 0 ($s1)
sd $t1, 0($s0)
jr $ra 