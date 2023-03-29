import string
texto = """
 El salario promedio de un hombre en Argentina es de $60.000, mientras que
el de una mujer es de $45.000. Además, las mujeres tienen menos
posibilidades de acceder a puestos de liderazgo en las empresas.
 """

mayusculas = {x for x in texto if x.isupper()}
minusculas = {x for x in texto if x.islower()}
noLetras = {x for x in texto if not x.isalpha()}
palabras = set(texto.lower().split())
print (mayusculas)
print (minusculas)
print(noLetras)
print (len(palabras))



