import java.util.regex.Matcher
import java.util.regex.Pattern

fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    val input = readInput("Day03")
    println(part1(input))

    findMachineParts(input)
    matrix(input)
}

fun matrix(input: List<String>){
    var rowSize = 132
    var columnSize = 140

}


















fun findMachineParts(input: List<String>){
    var lineOne = input[0]
    var lineTwo = input[1]
    var total = 0
    var numToCheck = ""
    var gettingNum = false
    println(lineOne.trim())
    println(lineTwo.trim())
    for((lineIndex, line) in input.withIndex()){

        //get character and character index
        for ((index, chr) in line.withIndex()) {
            if (chr.isDigit()) {
                numToCheck += chr
                gettingNum = true
            }
            if (gettingNum) {
                if (!chr.isDigit()) {
                    var checkNum = false
                    checkNum = if(lineIndex == 0){
                        findSymbols(numToCheck, line, input[1], (index - 1), true)
                    }else{
                        findSymbols(numToCheck, line, input[lineIndex + 1], (index - 1), false)
                    }
                    if (checkNum) {
                        total += numToCheck.toInt()
                    }
                    gettingNum = false
                }
            }
        }
    }
}

fun findSymbols(numToCheck: String, currLine:String, nextLine: String, indexOfLastChr: Int, firstLine:Boolean): Boolean{
    //123
    var result = false
    var numberSize = numToCheck.length
    val special: Pattern = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]")

    if(firstLine){
        when {
            special.matcher(currLine[indexOfLastChr + 1].toString()).find() ->{
                result = true
            }

            special.matcher(currLine[indexOfLastChr - numberSize].toString()).find() ->{
                result = true
            }

            special.matcher(nextLine[indexOfLastChr + 1].toString()).find() ->{
                result = true
            }

            special.matcher(nextLine[indexOfLastChr].toString()).find() ->{
                result = true
            }
        }


    }else{
        when {
            special.matcher(currLine[indexOfLastChr + 1].toString()).find() ->{
                result = true
            }

            special.matcher(currLine[indexOfLastChr - numberSize].toString()).find() ->{
                result = true
            }

            special.matcher(nextLine[indexOfLastChr + 1].toString()).find() ->{
                result = true
            }

            special.matcher(nextLine[indexOfLastChr].toString()).find() ->{
                result = true
            }
        }
    }

    return result

}


