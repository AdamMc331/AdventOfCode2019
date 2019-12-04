package dayone

fun main() {
    partOne()
    partTwo()
}

private fun partOne() {
    val totalFuel = DayOneInput
        .lines()
        .map(String::toLong)
        .map(::calculateFuel)
        .sum()

    println("Total fuel for part one: $totalFuel")
}

private fun partTwo() {
    val totalFuel = DayOneInput
        .lines()
        .map(String::toLong)
        .map(::calculateFuelRecursively)
        .sum()

    println("Total fuel for part two: $totalFuel")
}

private fun calculateFuel(mass: Long): Long {
    return (mass / 3) - 2
}

private fun calculateFuelRecursively(mass: Long): Long {
    val currentFuel = calculateFuel(mass)
    return if (currentFuel <= 0) {
        0
    } else {
        currentFuel + calculateFuelRecursively(currentFuel)
    }
}