package daytwo

fun main() {
    // partOne()
    partTwo()
}

private fun partOne() {
    val inputItems = DAY_TWO_INPUT
        .split(",")
        .map(String::toInt)
        .toMutableList()

    val outputItems = runCalculation(inputItems)
    println("Position 0 for part one: ${outputItems[0]}")
}

fun partTwo() {
    val inputItems = DAY_TWO_INPUT
        .split(",")
        .map(String::toInt)
        .toMutableList()

    val expectedOutput = 19690720

    // Changing the first number adds 216000
    // Changing the second number adds 1

    // value at 1, 1 = 682645
    // Difference = 19690720 - 682645 = 19008075

    // 19008075 / 216000 = 88
    // 19008075 % 216000 = 75

    inputItems[1] = 89
    inputItems[2] = 76

    val outputItems = runCalculation(inputItems)
    println("Position 0 for part two: ${outputItems[0]}")
}

private fun runCalculation(inputItems: MutableList<Int>): List<Int> {
    var opCodePosition = 0
    var opCode: Int = inputItems[0]

    while (opCode != HALT_OP_CODE) {
        val firstItemIndex = inputItems[opCodePosition + 1]
        val secondItemIndex = inputItems[opCodePosition + 2]
        val firstItem = inputItems[firstItemIndex]
        val secondItem = inputItems[secondItemIndex]
        val newValue = when (opCode) {
            ADD_OP_CODE -> firstItem + secondItem
            MULTIPLY_OP_CODE -> firstItem * secondItem
            else -> throw IllegalArgumentException("Invalid op code: $opCode")
        }

        val placement = inputItems[opCodePosition + 3]
        inputItems[placement] = newValue

        opCodePosition += 4
        opCode = inputItems[opCodePosition]
    }

    return inputItems.toList()
}

const val ADD_OP_CODE = 1
const val MULTIPLY_OP_CODE = 2
const val HALT_OP_CODE = 99