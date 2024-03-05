import numpy as np

matriz = np.array([1, 3, 5, 7, 9, 11, 13, 15, 17, 19])
nova_matriz = matriz.reshape([2, 5])
print("Matrix2_5: ", nova_matriz)

print("Matrix5_2 Tranposta: ", nova_matriz.transpose())

print("Matrix5_2 Reshape: ", nova_matriz.reshape([5, 2]))

# view1 = nova_matriz[:, -1].view()
view1 = nova_matriz[:, -1].copy()

nova_matriz[1, 2] = 19

print("Segunda Linha: ", nova_matriz[1])
print("Ultima Coluna: ", view1[:])

np.savez("matriz1.data", 
         nome_da_matriz=nova_matriz)