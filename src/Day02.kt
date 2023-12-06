import java.lang.Integer.parseInt
import kotlin.system.exitProcess

fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    val input = readInput("Day02")

    println(findPossibleGames(input))
    println(findMinimumAmountOfCubes(input))
}

fun findMinimumAmountOfCubes(input: List<String>): Int{
    var sumOfPower = 0

    for((index, game)  in input.withIndex()) {
        var tempGame = ""
        var count = 0
        var num = 0
        var biggestGreen = 0
        var biggestRed = 0
        var biggestBlue = 0

        tempGame = game.replace("Game ${index + 1}: ", "")

        val colorArrayList = tempGame.split(", ", "; ")
        val colorArray = colorArrayList.toTypedArray()

        while (count < colorArray.size) {
            var trimmedColor = colorArray[count]
            when {
                trimmedColor.contains("green") -> {
                    try {
                        trimmedColor = trimmedColor.replace(" green", "")
                        num = trimmedColor.toInt()
                        if(num > biggestGreen){
                            biggestGreen = num
                        }
                    } catch (e: NumberFormatException) {
                        println("Error ${e.message}")
                    }

                }
                trimmedColor.contains("red") -> {
                    num = trimmedColor.replace(" red", "").toInt()
                    if(num > biggestRed){
                        biggestRed = num
                    }
                }
                trimmedColor.contains("blue") -> {
                    num = trimmedColor.replace(" blue", "").toInt()
                    if(num > biggestBlue){
                        biggestBlue = num
                    }
                }
            }
            count++
        }

        val numbersMultiplied = biggestGreen * biggestBlue * biggestRed
        sumOfPower += numbersMultiplied
    }


    return sumOfPower
}

fun findPossibleGames(input: List<String>): Int{
    var sumOfIds = 0
    for((index, game)  in input.withIndex()){
        var tempGame = ""
        var gameIsPossible = true
        var count = 0
        var num = 0
        tempGame = game.replace("Game ${index + 1 }: ", "" )
        val colorArrayList = tempGame.split(", ", "; ")
        val colorArray = colorArrayList.toTypedArray()

        while(gameIsPossible && count < colorArray.size){
            var color = colorArray[count]
            var trimmedColor = color
            when {
                trimmedColor.contains("green") ->{
                    try{
                        trimmedColor = trimmedColor.replace(" green", "")
                        num = trimmedColor.toInt()
                        if(num > 13){
                            gameIsPossible = false
                        }
                    }catch(e: NumberFormatException){
                        println("Error ${e.message}")
                    }

                }
                trimmedColor.contains("red") ->{
                    num = trimmedColor.replace(" red", "").toInt()
                    if(num > 12){
                        gameIsPossible = false
                    }
                }
                trimmedColor.contains("blue") ->{
                    num = trimmedColor.replace(" blue", "").toInt()
                    if(num > 14){
                        gameIsPossible = false
                    }
                }
            }
            count++
        }

        if(gameIsPossible){
            sumOfIds += (index + 1)
        }

    }
    
    return sumOfIds
}

