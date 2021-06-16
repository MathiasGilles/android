import com.example.mathias_gilles.R

fun main(args: Array<String>) {

    fun calcTVA() {
        val array = listOf(2.1, 5.5, 10.toDouble(), 20.toDouble())

        print("")
        val a = readLine()?.toDouble()


        for (item in array) {
            val calc = item / 100.toDouble()
            val result = calc * a!! + a
            println("TVA $item‰ : $result€")
        }
    }

    fun boucle1to100() {
        for (i in 1 until 101) {
            println(i)
            if (i == 100) {
                for (y in 100 downTo 0) println(y)
            }
        }
    }

    fun calcFactorialOfInteger(a: Int) {
        var result = 1
        for (i in 1..a) {
            result *= i
        }
        println(result)
    }

    fun checkIfIsPangramme(str: String) {
        var array = listOf<String>(
            "a",
            "b",
            "c",
            "d",
            "e",
            "f",
            "h",
            "i",
            "k",
            "l",
            "m",
            "n",
            "o",
            "p",
            "q",
            "r",
            "s",
            "t",
            "v",
            "x"
        )
        var arrayOfVerif = listOf<Any>()
        val strNoSpace = str.replace("\\s".toRegex(), "")
        strNoSpace.forEach { carac ->
            val crc = carac.lowercaseChar().toString()
            if (array.contains(crc)) {
                arrayOfVerif += true
            } else {
                arrayOfVerif += false
            }
        }

        println(!arrayOfVerif.contains(false))
    }

    val user = User("Mathias", "Gilles")

    val weather = Weather(3.10f, "Paris")
    val local = LocalWeather(13.0F, "Lyon")
    val local2 = LocalWeather(50F, "Marseille", 40)

    val listOfNumber = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    var result = 0
    for (nb in listOfNumber) {
        result += nb
    }

    //println(result)
    //println(listOfNumber.sum())
    //println(listOfNumber.sumOf { it * 2 })

    val list =
        listOf("bonjour", "le", "Monde", "je", "m'appelle", "Toto", "j'habite", "en", "Bretagne")

    //println(list.groupBy { it[0] })

    val array = arrayListOf(1, 42, 3, 26)

    for (elem in array) {
        if (elem != null) {
            //println(elem)
        }
    }

    //println(array)
    //println(array.sortDescending())

    val myMap = mapOf("A" to 1, "B" to 2, "C" to 3)

    //print(myMap)
    //print(myMap["E"])

    //if (user != null){return user.firstName} meme chose que user?.firstName

    //user?.apply ({
    //    method1()
    //    method2()
    //}) si user est pas vide tu fais method 1 et 2

    println(listOf(1, 2, 3, 4, 5).fold(0) { total, item -> total + item }) // Calcule la somme de toute la list de gauche a droite
    println(listOf(1, 2, 3, 4, 5).foldRight(0) { item, total -> total + item }) // Calcule la somme de toute la list de droite à gauche
    println(listOf(1, 2, 3, 4, 5).fold(1) { mul, item -> mul * item }) // multiplie chaque element de la liste entre eux de gauche à droite
    println(listOf(1, 2, 3, 4, 5).foldRight(1) { item, mul -> mul * item }) // multiplie chaque element de la liste entre eux de droite à gauche
    println(listOf(0, 1, 2, 3, 4, 5).foldIndexed(0) { index, total, item -> if (index % 2 == 0) (total + item) else total }) // get le nombre d'index si il y a plus de deux élément dans la list de gauche à droite
    println(listOf(0, 1, 2, 3, 4, 5).foldRightIndexed(0) { index, item, total -> if (index % 2 == 0) (total + item) else total }) // get le nombre d'index si il y a plus de deux élément dans la list de droite à gauche

}

open class Weather(temp: Float, lieu: String) {

    var temp: Float = temp
    var lieu: String = lieu
    private val constante: Int = 0

    override fun toString(): String {
        return "Temperature de '$lieu' : $temp)"
    }

    open fun isCold() {
        if (temp < constante) {
            println("It's cold out there")
        }
    }

    open fun isHot() {
        if (temp > 25) {
            println("It's hot out there")
        }
    }

}

class LocalWeather(temp: Float, lieu: String, hot: Int = 32) : Weather(temp, lieu) {

    var hot = hot
    override fun isHot() {
        if (temp > hot) {
            println("Local weather is hot")
        } else {
            println("Not hot enough")
        }
    }
}

open class User(firstName: String, lastName: String) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        return true
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }

    override fun toString(): String {
        return "User()"
    }

    companion object Cpm {
        fun hello() {
            println("Hello world")
        }
    }
}

enum class Color(val hexa: String) {
    red("OXFFF"), blue("OXFFF"), green("OXFFFF")
}