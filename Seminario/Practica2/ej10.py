nombres = ''' 'Agustin', 'Alan', 'Andrés', 'Ariadna', 'Bautista', 'CAROLINA', 'CESAR',
'David','Diego', 'Dolores', 'DYLAN', 'ELIANA', 'Emanuel', 'Fabián', 'Facundo',
'Francsica', 'FEDERICO', 'Fernanda', 'GONZALO', 'Gregorio', 'Ignacio', 'Jonathan',
'Joaquina', 'Jorge','JOSE', 'Javier', 'Joaquín' , 'Julian', 'Julieta', 'Luciana',
'LAUTARO', 'Leonel', 'Luisa', 'Luis', 'Marcos', 'María', 'MATEO', 'Matias',
'Nicolás', 'Nancy', 'Noelia', 'Pablo', 'Priscila', 'Sabrina', 'Tomás', 'Ulises',
'Yanina' '''
notas_1 = [81, 60, 72, 24, 15, 91, 12, 70, 29, 42, 16, 3, 35, 67, 10, 57, 11, 69,
12, 77, 13, 86, 48, 65, 51, 41, 87, 43, 10, 87, 91, 15, 44,
85, 73, 37, 42, 95, 18, 7, 74, 60, 9, 65, 93, 63, 74]
notas_2 = [30, 95, 28, 84, 84, 43, 66, 51, 4, 11, 58, 10, 13, 34, 96, 71, 86, 37,
64, 13, 8, 87, 14, 14, 49, 27, 55, 69, 77, 59, 57, 40, 96, 24, 30, 73,
95, 19, 47, 15, 31, 39, 15, 74, 33, 57, 10]

listaNombres = nombres.replace('\'', '').replace('\n', '').replace(" ", "").split(",")
print(listaNombres)

def crearTodasNotas (listaNombres, notas1, notas2):
    alumnos = {}
    for i in range(len(listaNombres)):
        alumnos[listaNombres[i]] = (notas1[i], notas2[i])

    return alumnos


def calcularPromedio (notasAlumnos):
    prom = {}
    for clave, valor in notasAlumnos.items():
        prom[clave] = (valor[0] + valor[1])/2
    return prom

def promedioTotal (promedios):
    return sum(promedios.values()) / len(promedios)

def promedioMasAlto (promedios):
    return max(promedios, key= promedios.get)

def notaMasBaja (notasAlumnos) :
    return min(notasAlumnos, key=notasAlumnos.get)






alumnosNotas = crearTodasNotas(listaNombres, notas_1, notas_2)

print("Notas de los alumnos: ")
for clave, valor in alumnosNotas.items():
    print(f"alumno: {clave}. Nota1: {valor[0]}, Nota2: {valor[1]}")

print ("-" * 50)
print("Promedio de cada alumno: ")
promedioAlumnos = calcularPromedio(alumnosNotas)
for alumno, promedio in promedioAlumnos.items():
    print (f"Alumno: {alumno}, Promedio: {promedio}")


print("-" * 50)


print(f"El promedio general de curso es {promedioTotal(promedioAlumnos)}")
print(f"El estudiante con la nota promedio mas alta es {promedioMasAlto(promedioAlumnos)}")
print(f"El estudiante con la nota mas baja es {notaMasBaja(alumnosNotas)}")




