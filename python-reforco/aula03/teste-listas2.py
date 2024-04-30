#         0    1   2   3   4   5
lista1 = [10, 20, 30, 40, 50, 90]
print("Tamanho: ", len(lista1))

lista1.extend([110, 120, 130])
print("Lista 1: ", lista1)

lista1.insert(3, 35)
print("Lista 1: ", lista1)

lista1.remove( 90 )
print("Lista 1: ", lista1)

num = lista1.pop(1)
print("Foi retirado o numero: ", num)
print("Lista 1: ", lista1)