texto = "Ola este é um texto simples"

print("Texto Maiusculo: ", texto.upper() )

print("Texto Original: ", texto)

print("Texto Minusculo: ", texto.lower())

print("Texto Tamanho: ", len(texto))

pos = texto.find("t")

print("Letra t: ", pos)

pos = texto.find("t", 15)

print("Letra t: ", pos)