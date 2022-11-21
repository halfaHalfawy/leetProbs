fun main(args: Array<String>) {
    val str = "hello"
    val sol: Solution = Solution()
//    print(Solution().removeElement(intArrayOf(3, 2, 2, 3), 2))
    print(sol.countDigitOne(1000))
//    val sol = Solution().romanToInt("III")


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
    fun isAnagram(s: String?, t: String?): Boolean {
        val leng = s!!.length
        val firs = s[0]

        t!!.forEachIndexed() { i, ch ->
            run {
                if (ch == firs) {

                }

            }
        }
        return true;
    }


    fun countDigitOne(n: Int): Int {
        return getSous(n)

    }

    fun getHuns(n: Int): Int {
        var tens = 0
        var huns = n / 100
        if (n > 1000) {
            tens = getTens(n % 100)
            tens += 140
            tens += (20 * ((n - 200) / 100))
            tens+=2
        } else
            if (huns == 1000) {
                tens = getTens(n % 100)
                tens += 140
                tens += (20 * ((n - 200) / 100))
                tens += 3
            } else
                if (huns >= 2) {
                    tens = getTens(n % 100)
                    tens += 140
                    tens += (20 * ((n - 200) / 100))
                } else {
                    tens += getTens(n)
                }
        return tens

    }

    fun getSous(n: Int): Int {
        var count = 0
        var sou = n / 1000

        if (sou >= 2) {
            count = getHuns(n % 1000)
            count += 1300
            count += 300 * (sou - 2)

        } else {
            count = getHuns(n)

        }
        return count
    }

    fun getTens(n: Int): Int {
        var counter = 0
        for (i in 0..n) {

            counter += getOnes(i)
            /*  if (i.toString().contains("11") || i.toString().contains("101")) {
                  counter += 2
              } else
                  if (i.toString().contains("1")) counter++*/
        }


//        counter = getOnes(n)
        return counter
        /*
        *
        *
        * */
    }

    fun getOnes(n: Int): Int {
        var counter = 0
        for (c in n.toString()) {
            if (c == '1') {
                counter++
            }
        }
        return counter
    }

    fun removeElement(nums: IntArray?, myval: Int): Int {
        var newList: List<Int>? = null
        var right = nums!!.size - 1
        nums!!.forEachIndexed { i, v ->
            run {
                if (v == myval) {
                    newList = nums.drop(i)
//                    val

                }

            }
        }
        print(newList)
        return nums.size


    }

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
                                    if (opens.isEmpty() || opens.last() != '{') {

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


    fun maxArea(height: IntArray): Int {

        val myset: MutableSet<Int> = hashSetOf()


        height.forEachIndexed { indexa, ia ->
            run {
                height.forEachIndexed { index, i ->
                    run {

                        myset.add(Math.abs((index + 1) - (indexa + 1)) * Math.min(i, ia))
                    }

                }
            }


        }
        return myset.max() ?: 0


    }

}