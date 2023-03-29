.data
cadena: .asciiz "adbdcdedfdgdhdid" 
car: .asciiz "d"  
cant: .word 0 

.code
dadd $t0, $zero, $zero
lbu $t1, car($zero)
dadd $t3, $zero, $zero
loop: lbu $t2, cadena($t0)
beqz $t2, esCero
bne $t1, $t2, distintos
daddi $t3, $t3, 1
distintos: daddi $t0, $t0, 1
j loop

esCero: sd $t3, cant($zero)
halt