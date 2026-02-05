def contar_palabras_unicas(texto):
    contador = {}

    # Pasamos todo a minúsculas
    texto = texto.lower()

    # Separamos por espacios
    palabras = texto.split()

    for palabra in palabras:
        if palabra in contador:
            contador[palabra] += 1
        else:
            contador[palabra] = 1

    return contador
