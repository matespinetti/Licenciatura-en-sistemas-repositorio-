.code
daddi $s0, $zero, 45
daddi $s1, $zero, 0
loop: daddi $s1, $s1, 1
daddi $s0, $s0, -1
bnez $s0, loop
halt