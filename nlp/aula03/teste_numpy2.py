import numpy as np

primos = np.array([1, 3, 5])

pares = np.array([2, 4, 6])

print("Primos: ", primos)
print("Pares: ", pares)

soma = primos + pares

print("Soma: ", soma)

print("Dim: ", soma.ndim)
print("Shape: ", soma.shape)
print("Type: ", soma.dtype)


