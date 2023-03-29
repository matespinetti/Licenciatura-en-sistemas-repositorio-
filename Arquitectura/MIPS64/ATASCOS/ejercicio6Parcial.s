.data
x: .double 9.31
CONTROL: .word32 0x10000
DATA: .word32 0x10008

.code
l.d f2, x($zero)
lwu $s0, CONTROL ($zero)
lwu $s1 ,DATA ($zero)
s.d f2, 0($s1)
daddi $t0, $zero, 3
sd $t0, 0($s0)
halt
