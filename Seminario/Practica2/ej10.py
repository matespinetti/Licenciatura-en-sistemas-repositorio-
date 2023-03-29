nombres = ''' 'Agustin', 'Alan', 'Andrés', 'Ariadna', 'Bautista', 'CAROLINA', 'CESAR', Diego', 'Dolores', 'DYLAN', 'ELIANA', 'Emanuel', 'Fabián', 'Facundo', 'Francsica',
'FEDERICO', 'Fernanda', 'GONZALO', 'Gregorio', 'Ignacio', 'Jonathan', 'Joaquina', 'Jorge, 'JOSE', 'Javier', 'Joaquín' , 'Julian', 'Julieta', 'Luciana','LAUTARO', 'Leonel', 'Luisa'Luis', 'Marcos', 'María', 'MATEO', 'Matias', 'Nicolás', 'Nancy', 'Noelia', 'Pablo',
'Priscila', 'Sabrina', 'Tomás', 'Ulises', 'Yanina' '''
notas_1 = [81, 60, 72, 24, 15, 91, 12, 70, 29, 42, 16, 3, 35, 67, 10, 57, 11, 69, 12,
13, 86, 48, 65, 51, 41, 87, 43, 10, 87, 91, 15, 44, 85, 73, 37, 42, 95, 18,
74, 60, 9, 65, 93, 63, 74]

notas_2 = [30, 95, 28, 84, 84, 43, 66, 51, 4, 11, 58, 10, 13, 34, 96, 71, 86, 37, 64,
87, 14, 14, 49, 27, 55, 69, 77, 59, 57, 40, 96, 24, 30, 73, 95, 19, 47, 15, 12,
39, 15, 74, 33, 57, 10]

listaNombres = nombres.split(",")
def crearTodasNotas (l1, l2):
    todasNotas = set(notas_1 + notas_2)
    return todasNotas

def calcularPromedio (nombres, notas1, notas2):
    prom = {}
    for i,nombre in zip(range(len(nombres)),nombres):
        prom[nombre] = (notas1[i] + notas2[i]) / 2

    return prom


def promedioMasAlto (promedios) :
    return max(promedios, key= promedios.get)

def promedioMasBajo (promedios) :
    return min(promedios, key= promedios.get)



def promedioTotal (promedios):
    return sum(promedios.values()) / len(promedios)


dic1 = calcularPromedio(listaNombres, notas_1, notas_2)
print(promedioTotal(dic1))