package de.heimbrodt.opal

class UserData(name: String) {
    val userName = name
    var caloriesBurnt = 0
    var caloriesTaken = 0
    var level = 1

    public fun addCaloriesBurnt(input: Int, type: SportType) {
        if(type == SportType.Jogging) {
            this.caloriesBurnt += input*9
        }

    }
    public fun checkLevel() {
        if(caloriesBurnt > 145*level) {
            level++
        }
    }
}