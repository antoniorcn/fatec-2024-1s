import numpy as np

# matriz1 = np.array(
#     [  [2, 4],
#        [6, 8],
#        [10, 12]  ]
# )

lista3d = [
    [ [1, 2], [3, 4], [5, 6] ],
    [ [7, 8], [9, 10], [11, 12] ],
    [ [13, 14], [15, 16], [17, 18] ]
] 

matriz3d = np.array( lista3d, np.float64 )

print("Dim: ", matriz3d.ndim)
print("Shape: ", matriz3d.shape)
print("Type: ", matriz3d.dtype)