#        0  1  2    3   4   5   6   7  8 
lista1 = [3, 7, 11, 13, 17, 19, 23, 29, 31]

lista2 = lista1
lista3 = lista1[::-1]
lista4 = lista1[::]
print("Lista1 :", lista1)
print("Lista2 :", lista2)
print("Lista3 :", lista3)
print("Lista4 :", lista4)
lista1[2] = 10
print("Lista1 :", lista1)
print("Lista2 :", lista2)
print("Lista3 :", lista3)
print("Lista4 :", lista4)

# print(lista1[4:7:2])
# print(lista1[8::-1])

# print(lista1[-1])

# print(lista1[::-1])