package com.allst.scala.array

/**
 *
  */
object RemoveDuplicatesBySortArray {
    def main(args: Array[String]): Unit = {
        println("Hei Scala ~")
        var nums = Array(123, 234, 345)

        val len = arrLength()
        println(len)
    }

    def arrLength(nums: Int*) : Int = {
        if (nums.isEmpty) {
            return 0
        }
        var left = 0
        for (right <- 1 until nums.length) {
            if (nums(left + 1) != nums(right)) {
                nums(left)
            }
        }
        return left + 1
    }
}
