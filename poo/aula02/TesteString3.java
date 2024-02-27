public class TesteString3 { 

    public static void main(String [] args) { 
        StringBuffer numeros = new StringBuffer("");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) { 
            // numeros = numeros + i;
            numeros.append(i);
        }
        long end = System.currentTimeMillis();
        double diffSegundos = (end - start) / 1000;
        System.out.println("Numeros: " + numeros.toString());
        System.out.println("Segundos: " + diffSegundos);
    }

}