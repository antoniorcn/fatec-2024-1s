temperatura = 35
frio = temperatura < 14  # False        # True or False
calor = temperatura > 28 # True         # True or False

chovendo = True

aula_matematica_segunda = True

#                      (True          True)    ==> True 
ir_faculdade = not (chovendo and aula_matematica_segunda) # False

#                   (False     True) ==> False
ir_faculdade = not (frio and chovendo) # True