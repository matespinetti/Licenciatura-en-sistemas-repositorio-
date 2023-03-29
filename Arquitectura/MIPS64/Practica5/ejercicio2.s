.data
base: .double 5.85
altura: .double 13.47
divi: .double 2.0
res: .double 0

.code
l.d f1, base($zero)
l.d f2, altura ($zero)
l.d f4, divi ($zero)
nop
mul.d f3, f1, f2
div.d f3, f3, f4
cvt.l.d f5, f3
s.d f5, res($zero)

halt
