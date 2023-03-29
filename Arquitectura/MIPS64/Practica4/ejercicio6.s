.data
a: .word 3
b: .word 3
c: .word 3
res: .word 0

.code
ld r1, a(r0)
ld r2, b(r0)
ld r3, c(r0)
daddi r6, r0, 0
xor r4, r1, r2
bnez r4, seguir
xor r5, r1, r3
bnez r5, noSonTres
daddi r6, r0, 3
j fin
noSonTres: daddi r6, r0, 2
j fin
seguir: xor r5, r2, r3
beqz r5, iguales
xor r5, r1, r3
beqz r5, iguales
j fin
iguales: daddi r6, r0, 2
fin: sd r6, res(r0)
halt




