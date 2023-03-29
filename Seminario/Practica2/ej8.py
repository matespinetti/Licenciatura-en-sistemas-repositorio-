from collections import Counter
frase = input ("Ingrese una frase")
frase = dict(Counter(frase.replace(" ", "")))
print(frase)
noEs = False
for key in frase:
    if frase[key] > 1:
        noEs = True

if noEs:
    print ("no es un heterograma")
else:
    print ("es un heterograma")


