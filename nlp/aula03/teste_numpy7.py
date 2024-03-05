import numpy as np

matriz = np.array([1, 3, 5, 7, 9, 11])
nova_matriz = matriz.reshape([2, 3]) 
print("Nova Matriz Reshape: ", nova_matriz)

matriz = np.array([[1, 3, 5], [7, 9, 11]])
nova_matriz = matriz.ravel() 
print("Nova Matriz Revel: ", nova_matriz)