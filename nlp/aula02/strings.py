txt = "Toda a abobora é abobora, ou laranja, ou verde"

pos = txt.find(",", 25)
print("Pos: ", pos)

novo_texto = ""
for p in range(0, pos):
    novo_texto = novo_texto + txt[p]
print(novo_texto)