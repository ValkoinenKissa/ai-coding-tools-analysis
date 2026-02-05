"""
Escribe una función en Python llamada contar_palabras_unicas que reciba una cadena de texto y devuelva un
diccionario donde las claves sean las palabras únicas del texto y los valores sean la cantidad de veces que
aparece cada palabra. Ignora diferencias entre mayúsculas y minúsculas. No uses librerías externas
"""

def contar_palabras_unicas(texto):
    # Convertir todo el texto a minúsculas
    texto = texto.lower()

    # Separar el texto en palabras
    palabras = texto.split()

    # Crear diccionario para contar las palabras
    conteo = {}

    # Contar cada palabra
    for palabra in palabras:
        if palabra in conteo:
            conteo[palabra] += 1
        else:
            conteo[palabra] = 1

    return conteo