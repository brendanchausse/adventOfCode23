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
        var newLine = checkForSpelledWords(line)
        numHolder = makeNumString(newLine)

        calibrationNumber += if(numHolder.length == 1){
            val newNumber = (numHolder + numHolder).toInt()
            newNumber
        }else{
            val newNumber = (numHolder.substring(0,1) + numHolder.substring(numHolder.length-1)).toInt()
            newNumber
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

fun checkForSpelledWords(line: String): String{
    var tempLine = line
    val numsAsWords = arrayOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
    val replacementNums = arrayOf("1", "2", "3", "4", "5", "6", "7", "8", "9")

    for((index, value)  in numsAsWords.withIndex()){
        if(tempLine.contains(value)){
            tempLine = tempLine.replace(value, "${value.substring(0,1)} ${replacementNums[index]} ${value.substring(value.length-1)}" )
        }
    }
    return tempLine
}