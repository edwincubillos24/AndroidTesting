package com.edwinacubillos.testingespresso

import org.junit.Assert.*
import org.junit.Test

class MyUtilsTest {
    @Test
    fun sumTest(){
        var nums = listOf<Int>(1,2,3)
        var output : Int = MyUtils.sum(nums)
        var expected : Int = 6
        assertEquals(expected,output)

        nums = listOf(4,5,6)
        var actualNumber : Int = MyUtils.sum(nums)
        expected = 15
        assertEquals(expected, actualNumber )
    }

    @Test
    fun averageTest(){
        var nums = listOf<Int>(1,2,3)
        var output : Float = MyUtils.average(nums)
        var expected : Float = 2.0F
        assertEquals(expected,output)
    }

    @Test
    fun numberExists(){
        var nums = listOf<Int>(1,2,3,4)
        var numToSearch : Boolean = MyUtils.numExists(nums, 4)
        var expectedOutput: Boolean = true
        assertEquals(expectedOutput, numToSearch)
    }

    @Test
    fun seatchTest(){
        var nums = listOf<Int>(1,2,3,4,5)
        var posNumberToSearch : Int = MyUtils.searchNumberGetPosition(nums,4)
        var expectedPosition: Int = 3
        assertEquals(expectedPosition,posNumberToSearch )
    }
}
