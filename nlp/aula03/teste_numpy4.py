import numpy as np
matriz1_4 = np.array([[ 5, 7, 9, 10 ]])
print(matriz1_4)
print("Dim: ", matriz1_4.ndim)
print("Shape: ", matriz1_4.shape)


matriz4_1 = np.array([
    [5], [7], [9], [10]
])
print(matriz4_1)
print("Dim: ", matriz4_1.ndim)
print("Shape: ", matriz4_1.shape)

resultado = np.matmul(matriz4_1, matriz1_4)
print("Resultado 4x4: ", resultado)

resultado = np.matmul(matriz1_4, matriz4_1)
print("Resultado 1x1:", resultado)