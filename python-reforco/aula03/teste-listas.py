#         0   1   2   3   4
lista1 = [10, 20, 30, 40, 50] 
a = lista1[3]
print("Valor a: ", a)
b = a * 5
print("Valor de b: ", b)

lista1.append(90)
#           0    1   2   3   4   5
# lista1 = [10, 20, 30, 40, 50, 90] 

print("Lista1 na posicao 5: ", lista1[5])

lista2 = lista1[1:6:2]
print("Lista 2: ", lista2)
print("Elemento -1 da lista1 : ", lista1[-2])

lista3 = lista1[-1:-7:-1]
print("Lista3 : ", lista3)

lista4 = lista1[::-1]
print("Lista4 : ", lista4)