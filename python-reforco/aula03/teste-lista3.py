#           0          1          2         3         4       5
nomes = ["Alfredo", "Roberto", "Carlos", "Camila", "Lara", "Carlos"]
nomes.append("João")
n = "Carlos"

try:
    pos = nomes.index(n, 3)
    print(n + " encontra-se na lista na posição: ", pos)
except: 
    print(n + " não encontra-se na lista")

print("Pesquisa concluida")