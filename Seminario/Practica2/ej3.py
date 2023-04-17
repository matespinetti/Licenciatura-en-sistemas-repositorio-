import string
jupyter_info = """ JupyterLab is a web-based interactive development
environment for Jupyter notebooks,
code, and data. JupyterLab is flexible: configure and arrange the user
interface to support a wide range
of workflows in data science, scientific computing, and machine learning.
JupyterLab is extensible and
modular: write plugins that add new components and integrate with existing
ones.
"""

textList = jupyter_info.split()
letra = input("Ingrese una letra para buscar")
while not(letra in string.ascii_letters):
    print ("Usted no ingreso una letra")
    letra = input("Ingrese una letra para buscar")

contienen = [x for x in textList if x.startswith(letra)]
for x in contienen:
    print(x)

print(contienen)