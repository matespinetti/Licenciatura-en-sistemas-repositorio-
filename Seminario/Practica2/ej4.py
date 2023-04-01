evaluar = """ título: Experiences in Developing a Distributed Agent-based Modeling Toolkit with Python
resumen: Distributed agent-based modeling (ABM) on high-performance computing resources provides the promise of capturing unprecedented details of large-scale complex systems. However, the specialized knowledge required for developing such ABMs creates barriers to wider adoption and utilization. Here we present our experiences in developing an initial implementation of Repast4Py, a Python-based distributed ABM toolkit. We build on our experiences in developing ABM toolkits, including Repast for High Performance Computing (Repast HPC), to identify the key elements of a useful distributed ABM toolkit. We leverage the Numba, NumPy, and PyTorch packages and the Python C-API to create a scalable modeling system that can exploit the largest HPC resources and emerging computing architectures. """
evaluar = evaluar.split('\n')
evaluar[0] =evaluar[0].replace(" título: ", "")
evaluar [1] = evaluar[1].replace ("resumen: ", "")
oraciones = {"facil" : 0, "aceptable" : 0, "dificil" : 0, "muy dificil" : 0}

if (len(evaluar[0].split()) <= 10):
    titulo = "ok"
else:
    titulo = "largo"

for i in evaluar[1].split("."):
    if (len(i.split()) <= 12):
        oraciones["facil"] +=1
    elif (len(i.split()) <= 17):
        oraciones["aceptable"] +=1
    elif (len(i.split()) <= 25):
        oraciones["dificil"] +=1
    else:
        oraciones["muy dificil"] +=1


print (f"titulo: {titulo}")
for clave, valor in oraciones.items():
    print (clave, valor)






