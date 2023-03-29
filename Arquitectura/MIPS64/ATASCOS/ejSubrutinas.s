.data
result: .word 0
.text
daddi r4, r0, 10
daddi r5, r0, 20
dadd r2, r4, r5 # subrutina “sumar”
sd r2, result(r0)
halt

