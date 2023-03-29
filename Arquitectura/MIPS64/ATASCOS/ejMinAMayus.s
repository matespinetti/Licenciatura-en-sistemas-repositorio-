.data
cadena: .asciiz "mateo"
CONTROL: .word32 0x10000
DATA: .word32 0x10008
.text
; La pila comienza en el tope de la memoria de datos
DADDI $sp, $zero, 0x400
; Guarda como primer argumento para upcaseStr
DADDI $a0, $zero, cadena
JAL upcaseStr
lwu $s0, CONTROL ($zero)
lwu $s1, DATA ($zero)
daddi $t0, $zero, cadena
sd $t0, 0($s1)
daddi $t0, $zero, 4
sd $t0, 0($s0)
HALT
upcaseStr: DADDI $sp, $sp, -16 ; Reserva lugar en la pila -> 2 x 8
SD $ra, 0($sp)
SD $s0, 8($sp)
DADD $s0, $a0, $zero ; copia la dirección de inicio de la cadena
upcaseStrLOOP: LBU $a0, 0($s0) ; recupera el car actual como argumento para upcase
BEQ $a0, $zero, upcaseStrFIN ; Si es el fin de la cadena, termina
JAL upcase
SB $v0, 0($s0) ; Guarda el carácter procesado en la cadena
DADDI $s0, $s0, 1 ; avanza al siguiente caracter
J upcaseStrLOOP
upcaseStrFIN: LD $ra, 0($sp)
LD $s0, 8($sp)
DADDI $sp, $sp, 16
JR $ra

upcase: DADD $v0, $a0, $zero
SLTI $t0, $v0, 0x61 ; compara con ‘a’ minúscula
BNEZ $t0, salir ; no es un carácter en minúscula
SLTI $t0, $v0, 0x7B ; compara con el car sig a 'z' minúscula (z=7AH)
BEQZ $t0, salir ; no es un carácter en minúscula
DADDI $v0, $v0, -0x20 ; pasa el carácter a mayúscula
salir: JR $ra ; retorna al programa principal
