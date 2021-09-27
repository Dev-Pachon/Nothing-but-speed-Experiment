import java.io.BufferedWriter
import java.io.File
import kotlin.random.Random
import kotlin.time.Duration
import kotlin.time.DurationUnit
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime


const val fileName = "data/data.csv"
const val sizeOne :Int = 500
const val sizeTwo :Int = 5000
const val sizeThree :Int = 10000
val file = File(fileName)

fun main() {
    file.bufferedWriter().use { out ->
        out.write("language,array_size,t_random_order,t_asc_order,t_des_order\n")
        for (i in 0 until 100) {
            sortAllByOrder(sizeOne,out)
            sortAllByOrder(sizeTwo,out)
            sortAllByOrder(sizeThree,out)
        }
    }
}

fun sortAllByOrder(size:Int, out:BufferedWriter){
    var arr = fillRandom(size)
    val time1 = sort(arr)
    arr = fillAscending(size)
    val time2 = sort(arr)
    arr = fillDescending(size)
    val time3 = sort(arr)
    out.write("Kotlin,$size,$time1,$time2,$time3\n")
}


fun fillRandom(size:Int): IntArray {
    return IntArray(size) { Random.nextInt(0, 100000) }
}

fun fillAscending(size:Int): IntArray {
    var array = fillRandom(size)
    array = array.sortedWith { i1, i2 -> i1.compareTo(i2) }.toIntArray()
    return array
}

fun fillDescending(size:Int): IntArray {
    var array = fillRandom(size)
    array = array.sortedWith { i1, i2 -> i2.compareTo(i1) }.toIntArray()
    return array
}

@OptIn(ExperimentalTime::class)
fun sort(arr: IntArray): Double {
    var temp: Int
    val elapsed :Duration = measureTime{
        //BubbleSort
        for(j in 0 until arr.size - 1){
            for (i in 0 until arr.size - 1) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i+1]
                    arr[i+1] = arr[i]
                    arr[i] = temp
                }
            }
        }
    }
    return elapsed.toDouble(DurationUnit.MILLISECONDS)
}