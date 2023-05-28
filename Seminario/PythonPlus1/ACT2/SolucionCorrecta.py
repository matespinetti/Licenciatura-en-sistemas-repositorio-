import csv
import json
from random import randrange

import clases


def obtengo_datos():
    opcion = randrange(2)
    print(opcion)
    if opcion == 0:
        archi = open("datos.json", "r")
        Datos = json.load(archi)
        archi.close()
    elif opcion == 1:
        archi = open("datos.csv", "r")
        csvreader = csv.reader(archi, delimiter=',')
        linea1 = next(csvreader)
        linea2 = next(csvreader)
        Datos = dict(zip(linea1, linea2))
        archi.close()
    else:
        Datos = {}
    return Datos


Datos = obtengo_datos()

lista = []
banda = clases.Banda(Datos['nombre'])
try:
    for i in range(Datos["cant_integrantes"]):
        elem = input(f"Ingresá un integrante de la banda  {Datos['nombre']}")
        lista.append(elem)
    banda.agregar_integrante(lista)
    print(banda)
except TypeError as exc:
    print(exc)
finally:

    print("FIN DEL PROGRAMA")
