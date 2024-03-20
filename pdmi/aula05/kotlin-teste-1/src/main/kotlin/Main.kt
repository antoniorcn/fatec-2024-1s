// class Aluno {
//   private var id : Long = 0;
//   private var ra : String = "00000";

//   constructor (id: Long, ra: String) {
//     this.id = id;
//     this.ra = ra;
//   }

//   constructor () {

//   }

//   fun getId() : Long {
//     return this.id;
//   }
//   fun setId(id : Long) {
//     this.id = id;
//   }
// }

data class Aluno( val id : Long = 0L,
                  var ra : String = "",
                  var nome : String = "",
                  var idade: Int = 0)

fun fazAlgo() {
    var x =  20;
    print("Fazendo algo")
    fazAlgo()
}

fun fazendoOutraCoisa() {
    var y = 30;
    print("Fazendo outra coisa")
}

fun main() {
    var a = 10;
    print("Ola mundo")
    fazAlgo()
    fazendoOutraCoisa()

}