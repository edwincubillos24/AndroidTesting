package com.edwinacubillos.testingespresso

class MyUtils {

    companion object {
        public fun sum (numbers: List<Int>): Int {
            var summation: Int = 0
            for (num: Int in numbers){
                summation += num
            }
            return summation
        }

        public fun average(numbers: List<Int>): Float{
            var average : Float = 0.0F
            average = sum(numbers).toFloat()
            average = average / numbers.size
            return average
        }

        public fun numExists(numbers: List<Int>, numberToSearchFor: Int) : Boolean {
            for (num : Int in numbers){
                if (num == numberToSearchFor){
                    return true
                }
            }
            return false
        }

        public fun searchNumberGetPosition(numbers: List<Int>, numberToSearchFor: Int) : Int {
            for (i : Int in 0..numbers.size){
                if (numberToSearchFor == numbers.get(i)){
                    return i
                }
            }
            return -1
        }
    }
}