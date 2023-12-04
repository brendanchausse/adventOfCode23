import kotlin.system.exitProcess

fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    val input = readInput("Day01")
    part1(input).println()

    print(findCalibrationValue(input))

}

fun findCalibrationValue(input: List<String>): Int{

    var calibrationNumber = 0
    var numHolder = ""
    for(line in input){
        numHolder = makeNumString(line)
        if(numHolder.length == 1){
           val newNumber = (numHolder + numHolder).toInt()
            calibrationNumber += newNumber
        }else{
            val newNumber = (numHolder.substring(0,1) + numHolder.substring(numHolder.length-1)).toInt()
            calibrationNumber += newNumber
        }

    }

    return calibrationNumber
}

fun makeNumString(line: String): String {
    var numberString = ""
    for(chr in line){
        if(chr.isDigit()){
            numberString += chr
        }
    }
    return numberString
}
