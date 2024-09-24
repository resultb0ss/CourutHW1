import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch

suspend fun main() = coroutineScope {
    var persons: List<Person> = listOf(
        Person("Виктор", 26),
        Person("Даниил", 43),
        Person("Сергей", 23),
        Person("Олег", 33),
        Person("Павел", 22),
        Person("Екатерина", 34),
        Person("Елена", 45),
        Person("Марина", 32)
    )

    var numbers = listOf(1,23,34,54,65,45,67,45,78,89)

    var weather: List<Weather> = listOf(
        Weather("Москва","Дождливо", 23),
        Weather("Владимир","Пасмурно", 24),
        Weather("Пятигорск","Солнечно", 33),
        Weather("Саратов","Солнечно", 33),
        Weather("Волгоград","Пасмурно", 25),
        Weather("Казань","Дождливо", 26),
        Weather("Уфа","Солнечно", 27),
    )

    println("Данные загружены")
    val task = listOf(launch { downloadInfo(persons) },launch { downloadInfo(weather) },launch { downloadInfo(numbers) })
    task.joinAll()
    println("Программа завершена")

}

suspend fun <T> downloadInfo(listInfo: List<T>){
    for (i in listInfo){
        delay(1000L)
        println(i)
    }
}

class Person(var name: String, var age: Int){
    override fun toString(): String {
        return "Имя: $name, Возраст: $age"
    }
}
class Weather(var city: String, var description: String, var temp: Int){

    override fun toString(): String {
        return "Город: $city, Погода: $description, Температура воздуха: $temp"
    }
}

