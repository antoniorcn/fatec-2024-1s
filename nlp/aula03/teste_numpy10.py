import numpy as np

matriz = np.array([1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23])
nova_matriz = matriz.reshape([3, 4])
print("Matriz3_4: ", nova_matriz)

outra_matriz = nova_matriz * 0.5
print("OutraMatriz3_4: ", outra_matriz)

maiores_10 = nova_matriz > 10
print("Maiores10: ", maiores_10)

maiores_9= nova_matriz[nova_matriz >= 9]
print("Maiores9: ", maiores_9.reshape(4, 2))