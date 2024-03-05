import numpy as np

matriz = np.array([1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23])
nova_matriz = matriz.reshape([3, 4])
print("Matriz3_4: ", nova_matriz)

soma_colunas = nova_matriz.sum(axis=1)
print("Total das linhas: ", soma_colunas)

soma_linhas = nova_matriz.sum(axis=0)
print("Total das colunas: ", soma_linhas)
