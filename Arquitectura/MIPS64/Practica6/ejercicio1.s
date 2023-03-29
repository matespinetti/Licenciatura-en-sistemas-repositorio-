.data
CONTROL: .word32 0x10000
DATA: .word32 0x10008
TEXTO: .asciiz " "
.code
daddi $s4, $zero, 0x30
daddi $s5, $zero, 0
lwu $s1, CONTROL($zero) ; $s1 = dirección de CONTROL
lwu $s0, DATA($zero)
daddi $t0, $zero, 9
loop: sd $t0, 0($s1)
lbu $s3, 0($s0)
sb $s3, TEXTO ($s5)
daddi $s5, $s5, 1
bne $s4, $s3, loop
daddi $t0, $zero, TEXTO; $t0 = dirección del mensaje a mostrar
sd $t0, 0($s0) ; DATA recibe el puntero al comienzo del mensaje
daddi $t0, $zero, 6 ; $t0 = 6 -> función 6: limpiar pantalla alfanumérica
sd $t0, 0($s1) ; CONTROL recibe 6 y limpia la pantalla
daddi $t0, $zero, 4 ; $t0 = 4 -> función 4: salida de una cadena ASCII
sd $t0, 0($s1) ; CONTROL recibe 4 y produce la salida del mensaje
halt 