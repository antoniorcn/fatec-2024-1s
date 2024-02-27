a = 10
a = a + 1
a += 1
print(f"A: {a}")

b = 37
b %= 5
print(f"B: {b}")


# Pertencimento

l1 = [3, 7, 9, 11, 13, 17, 19, 23, 29]
numero = int(input("Digite um numero"))
if numero in l1:
    print(f"O numero {numero} esta na lista")
else:
    print(f"Não existe o numero {numero} na lista")

