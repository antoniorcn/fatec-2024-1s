import numpy as np

matriz_a = np.array([[1, 3, 5], [7, 9, 11]])
matriz_b = np.array([[0, 2, 4], [6, 8, 10]])
dot = matriz_a * matriz_b
print("Matriz A: ", matriz_a)
print("Matriz B: ", matriz_b)
print("Dot: ", dot)

# mult = matriz_a @ matriz_b.transpose()
mult = np.matmul(matriz_a, matriz_b.transpose())
print("Matrix Multiplication: ", mult)
