.data
x: .double 9.13


.code
l.d f9, x($zero)
cvt.l.d f9, f9
mfc1 r5, f9
halt


