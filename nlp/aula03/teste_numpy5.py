import numpy as np

matriz_zeros = np.zeros([5, 5])
print("Matriz Zeros: ", matriz_zeros)

matriz_ones = np.ones([5, 5])
print("Matriz Ones: ", matriz_ones)

matriz_random = np.random.random([5, 5]) * 1000
print("Matriz Random: ", matriz_random.astype(np.int32))

matriz_range1 = np.arange( 1, 10 )
print("Matriz Range1: ", matriz_range1)

matriz_range2 = np.arange( 10, 20 )
print("Matriz Range2: ", matriz_range2)

matriz_range3 = np.concatenate([matriz_range1, matriz_range2])
print("Matriz Range3: ", matriz_range3)

matriz_grid = np.mgrid[1:10:1, 1:5:1]
print("Matriz Grid: ", matriz_grid)

