#            0         1           2        3     4       5
# lista1 = ["preto", "amarela", "castanhos", 1.70, 69, "Alberto"]
# print("Peso: ", lista1[4])
# print("Nome: ", lista1[5])
    #                chave  :  valor
dicionario1 = {     "cabelo": "preto", 
                    "cor_pele": "amarela", 
                    "olhos": "castanhos",
                    "altura": 1.70,
                    "peso": 69,
                    "nome": "Alberto",
                    "nomemeio": "Silva",
                    "sobrenome": "Roberto"   }
print("Nome: ", dicionario1["nome"])
print("Altura: ", dicionario1["altura"])
# if "sobrenome" in dicionario1:
#    print("Sobrenome: ", dicionario1["sobrenome"])
print("Sobrenome: ", dicionario1.get("sobrenome", "não existe"))
print("Nome do meio: ", dicionario1.get("nomemeio", "não existe"))

dicionario1["nomepai"] = "Alberto"
dicionario1["tipo_sanguineo"] = "A+"
dicionario1["tipo_sanguineo"] = "B+"
print("Tipo sanguineo: ", dicionario1.get("tipo_sanguineo", "não localizado"))

conjunto_chaves = dicionario1.keys()
print("Chaves: ", conjunto_chaves)
print("Valores: ", dicionario1.values())
print("Items: ", dicionario1.items())

# dicionario2 = dicionario1
dicionario2 = dicionario1.copy()
dicionario1["tipo_sanguineo"] = "O-"

print("Dicionario 1: ", dicionario1)
print("Dicionario 2: ", dicionario2)