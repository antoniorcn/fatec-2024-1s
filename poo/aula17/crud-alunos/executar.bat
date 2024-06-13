del .\classes\edu\curso\*.class
javac -cp .;.\*.jar -d classes edu/curso/*.java
java -cp .;.\classes;mariadb-java-client-3.3.3.jar edu.curso.AlunoBoundary