import numpy as np

zeros = np.zeros([3, 4, 2])
ones = np.ones_like(zeros)

print("Shape: ", ones.shape)
print("Ones: ", ones)

eye = np.eye(6, 3)
print("Eye: ", eye)