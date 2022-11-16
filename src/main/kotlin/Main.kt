fun main(args: Array<String>) {
    val str = "hello"


//    val sol = Solution().romanToInt("III")
    println(str.substring(0))
    println(Solution().isValid("))"))

// Lambdas are code blocks enclosed in curly braces.
    /*  items.fold(0) {
          // When a lambda has parameters, they go first, followed by '->'
              acc: Int, i: Int ->
          print("acc = $acc, i = $i, ")
          val result = acc + i
          println("result = $result")
          // The last expression in a lambda is considered the return value:
          result
      }*/
    /*   val joinedToString = items.fold("init") { acc, i: Int ->
           print("hey1 $i")
           "x"

       }
       println(joinedToString)*/
}

class Solution {

    fun runTwoSum() {

        val arr: IntArray = intArrayOf(3, 2, 4)


        val aw = Solution().twoSum(arr, 6)

        if (aw.isEmpty()) {
            print("its null")
        } else
            println(aw[0].toString() + "  ${aw[1]}")

    }

    fun twoSum(nums: IntArray, target: Int): IntArray {
        nums.forEachIndexed { index, _ ->
            run {
//                print(index)

                for (inner in (index + 1) until nums.size) {

                    if (nums[index] + nums[inner] == target) {

                        return intArrayOf(index, inner)
                    }

                }

//                print(index)
            }

        }

        return IntArray(0)
    }


    fun isPalindrome(x: Int): Boolean {
        var list: MutableList<Int> = mutableListOf()
        println("${x.toString() == x.toString().reversed()},")
        return true
    }


    fun romanToInt(s: String): Int {
        var sum = 0


        do {

//            str["string"]=s
            val str = getLastChar(s)
            sum = str["number"] as Int
            print(str["string"])
//            s = str["string"]
        } while (str["string"] != "")

        return sum
    }


    fun getLastChar(str: String): Map<String, Any> {
        val map = mutableMapOf<String, Any>()
        when (str.toString()[str.length - 2].toString() + str.toString()[str.length - 1].toString()) {
            "IV" -> {
                map["string"] = str.substring(0, str.length - 2)
                map["number"] = 4
            }

            "IX" -> {
                map["string"] = str.substring(0, str.length - 2)
                map["number"] = 9

            }

            "XL" -> {
                map["string"] = str.substring(0, str.length - 2)
                map["number"] = 40
            }

            "XC" -> {
                map["string"] = str.substring(0, str.length - 2)
                map["number"] = 90
            }

            "CD" -> {
                map["string"] = str.substring(0, str.length - 2)
                map["number"] = 400
            }

            "CM" -> {
                map["string"] = str.substring(0, str.length - 2)
                map["number"] = 900
            }

            else -> {
                when (str.toString().get(str.length - 1)) {
                    'I' -> {
                        map["string"] = str.substring(0, str.length - 1)
                        map["number"] = 1

                    }

                    'V' -> {
                        map["string"] = str.substring(0, str.length - 1)
                        map["number"] = 5
                    }

                    'X' -> {
                        map["string"] = str.substring(0, str.length - 1)
                        map["number"] = 10
                    }

                    'L' -> {
                        map["string"] = str.substring(0, str.length - 1)
                        map["number"] = 50
                    }

                    'C' -> {
                        map["string"] = str.substring(0, str.length - 1)
                        map["number"] = 100
                    }

                    'M' -> {
                        map["string"] = str.substring(0, str.length - 1)
                        map["number"] = 500
                    }

                    'D' -> {
                        map["string"] = str.substring(0, str.length - 1)
                        map["number"] = 1000
                    }

                    else -> {

                        map["string"] = str.substring(0, str.length - 1)
                        map["number"] = 0
                    }

                }

            }


        }
        return map

    }


    fun isValid(s: String): Boolean {
        var boolean = true
        if (s.length % 2 == 0) {

            /*
            * iterate all chars
            * if
            * */
            val opens = ArrayDeque<Char>()
            val ends = ArrayDeque<Char>()

            s.forEach { c ->
                run {
                    when (c) {
                        '}', '{', ')', '(', '[', ']' -> {
                            print("passed1")
                            when (c) {

                                '(', '{', '[' -> {
                                    print("passed2")
                                    opens.addLast(c)
                                }

                                '}' -> {
                                    if (opens.isEmpty()|| opens.last() != '{') {

                                        boolean = false
                                        return false

                                    } else {

                                        if (opens.size != 0) opens.removeLast()
                                    }
                                }

                                ')' -> {
                                    if (opens.isEmpty() || opens.last() != '(') {
                                        boolean = false
                                        return false
                                    } else {
                                        if (opens.size != 0) opens.removeLast()
                                    }


                                }

                                ']' -> {
                                    print("closed")
                                    if (opens.isEmpty() || opens.last() != '[') {
                                        boolean = false
                                        return false

                                    } else {
                                        if (opens.size != 0) opens.removeLast()
                                    }


                                }

                                else -> {

                                    boolean = false
                                    return false
                                }


                            }
                        }

                        else -> {
                            boolean = false
                            return false
                        }

                    }


                }
            }

            if (opens.isNotEmpty())
                return false

        } else
            boolean = false

        return boolean
    }

}