frase = "Hola soy mateo y hola"
frase = frase.split()
frase = [x.lower() for x in frase]
print (frase)
palabra = input ("Ingrese una palabra a buscar").lower()
print(frase.count(palabra))