valores = {}
valores1 = ("a", "e", "i", "o", "u", "l", "n", "r", "s", "t")
print (valores1)
tablaValores = {("a", "e", "i", "o", "u", "l", "n", "r", "s", "t"): 1, ("d", "g"): 2,
                ("b, c, m, p"): 3, ("f", "h", "v", "w", "y"): 4, ("k",):5, ("j", "x"):8,
                ("q", "z"): 10}


palabra = input ("ingrese una palabra")

puntos = 0
for x in palabra:
    encontre = False
    for clave, valor in tablaValores.items():
        if encontre:
            break
        for letra in clave:
            if x == letra:
                puntos += valor
                encontre = True
                break




print (puntos)


