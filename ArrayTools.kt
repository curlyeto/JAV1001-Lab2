/*
    NAME: ERTUGRUL SAHIN , JOHN OLAYENI , LEVI MAXWELL
    STUDENT NUMBER : A00270022, A00260853 , A00263436
    DESCRIPTION :
    The caesar cipher function works as the first function in our program. Here the parameters have a value and a parameter value.Our function has an alphabet list and result list variables.
    In short, our function creates a new string value by throwing back each letter in the string value by the number coming from the parameter, in reverse of the alphabet order.

    Our second function is the arrayAvg function. This function collects all the elements of the integer list in the parameter.
    It divides the result by the number of the list. It returns us the average number of digits in the list as a double.

    Our third function is the arrayContains function, this function checks whether the value from the parameter is in the list from the parameter or not.
    If it's in it, it returns a false value if it's not true.

    Our fourth and final function is reverseList. This function returns the reverse of the list from the parameter. It returns the result to us as a list.

    NOTE : We used intellij as the code development environment.
    The ReadLine() method is used as readln() in this ide. It caused a lot of trouble if we used ReadLine().That's why we used readln().


 */

fun main(args: Array<String>) {
    // For the CaesarCipher algorithm, we determined a text and a number of steps to go back.
    println(caesarCipher("ABC",3))
    println(arrayAvg(listOf<Int>(1,2,3,4,5,6)))
    // We wrote the list and value values to the parameters for the function does the list meet the given value
    println(arrayContains(listOf<String>("Kotlin","Android","IOS","Swift"),"Kotlin"))
    // we didn't give function name reverse because kotlin has same name function
    println(reverseList(listOf<Int>(1,2,3,4,5,6)))
    println("\nTEST ALL FUNCTIONS")
    println("\n********************************************************************************")
    caesarCipherTester()
    println("\n********************************************************************************")
    arrayAvgTester()
    println("\n********************************************************************************")
    arrayContainsTester()
    println("\n********************************************************************************")
    reverseListTester()

}


fun caesarCipher(value: String, stepBackCount: Int): String {
    // We kept only the capital letters of the alphabet in the char list.
    // Because when the string is split, the equivalent of each letter is passed as char in programming.
    val alphabetList= arrayListOf<Char>('A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z');
    var chipherResult:String= "";
    // We took the value from the parameter into the foreach loop and reached each letter
    value.forEach {
        // we used a foreach loop in our alphabet list we defined
        alphabetList.forEachIndexed { alphabetIndex, alphabetItem ->
            // we checked if the first letter of the value from the parameter is in our alphabet list
            if (alphabetItem==it){
                // we checked if the incoming value is in our alphabet list
                // here we checked whether the index in the alphabet list is less than the number of going backs from the parameter

                // We did this because if the number it wants to go back to is 3, if our value contains the letters A,B or C,
                // we have implemented a different method so that the program does not give an error here.
                if(alphabetIndex <stepBackCount){
                    //If the situation in the above example is met, we subtract the index number from the last index number in our alphabet list, this gave us the index we want to reach,
                    // we added this index to our result string with the alphabet list
                    chipherResult+=alphabetList[(alphabetList.size-1)-alphabetIndex]
                }else{
                    // After the equality was achieved, we took the index of the letter from our alphabet list and subtracted how many digits we wanted to go back.
                    // We assigned the letter we obtained by calling the alphabet list with the number from this result.
                    chipherResult +=alphabetList[alphabetIndex-stepBackCount]
                }
            }
        }
    }

    return chipherResult;
}

fun arrayAvg(listOf: List<Int>):Double {
    // create a variable to collect the digits from the parameter
    var chipherResult:Int= 0;
    listOf.forEach {
        // We used foreach to reach each of the digits in the list from the parameter and added the digits to our result variable
        chipherResult+=it
    }
  // Our chipherResult variable contains the sum of all digits. With this value, we divided the number of elements in the list, which gave us the average number of the list.
    // The reason we use double here is that the result can be double
    return chipherResult.toDouble()/listOf.size
}

fun arrayContains(listOf: List<String>, value: String):Boolean {
    // We used the contains method, which checks whether the value from the parameter is in the list value from the parameter or not.
    return listOf.contains(value)
}

fun reverseList(listOf: List<Int>): ArrayList<Int> {
    // We created a reverseList list for reversing the list from the parameter
    var reverseList = ArrayList<Int>()
    for (index in listOf.size-1 downTo 0){
        // We used foreach to make the list from the parameter go from top to bottom
        // and added the values we got to the list of reverseList
        reverseList.add(listOf[index])
    }
    return reverseList
}

fun caesarCipherTester() {
    // To test our caesar cipher method, we wrote 3 test data and test results
    val t1 = "ERTUGRUL"
    val r1 = "BOQRDORI"
    val t2 = "JOHN"
    val r2 = "GLEN"
    val t3 = "MAXWELL"
    val r3 = "JZUTBII"
    // we have added these values to the list
    val test = listOf(t1,t2,t3)
    val result = listOf(r1,r2,r3)
    // We used for each to access the data in our test list.
    for (i in test.indices){
        // We tested our first test data in the Caesar Cipher method, if the return value and the required result match,
        // the test was passed, otherwise the test remained, we printed it.
        if (caesarCipher(test[i],3) != result[i]){
            println("caesarCipherTester ${test[i]} result of function ${caesarCipher(test[i],3)} our result ${result[i]} failed")
        }else{
            println("caesarCipherTester ${test[i]} result of function ${caesarCipher(test[i],3)} our result ${result[i]} passed")
        }
    }
}


fun arrayAvgTester() {
    // To test our  arrayAvg method, we wrote 3 test data and test results
    val t1 = listOf<Int>(11,22,33)
    val r1 = 22.0
    val t2 = listOf<Int>(15,14,20)
    val r2 = 16.333333333333332
    val t3 = listOf<Int>(40,20,50,90)
    val r3 = 55.0
    // we have added these values to the list
    val test = listOf(t1,t2,t3)
    val result = listOf(r1,r2,r3)
    // We used for each to access the data in our test list.
    for (i in test.indices){
        // We tested our first test data in the arrayAvg method, if the return value and the required result match,
        // the test was passed, otherwise the test remained, we printed it.
        if (arrayAvg(test[i]) != result[i]){
            println("arrayAvgTester ${test[i]} result of function ${arrayAvg(test[i])} our result ${result[i]} failed")
        }else{
            println("arrayAvgTester ${test[i]} result of function ${arrayAvg(test[i])} our result ${result[i]} passed")
        }
    }
}

fun arrayContainsTester() {
    // To test our  arrayContains method, we wrote 3 test data and test results
    val defaultList = listOf<String>("Ertugrul","John","Maxwell","Is Ertugrul cute?")
    println("Default List $defaultList")
    val t1 = "Micheal"
    val r1 = false
    val t2 = "John"
    val r2 = true
    val t3 = "Is Ertugrul cute?"
    val r3 = false
    // we have added these values to the list
    val test = listOf(t1,t2,t3)
    val result = listOf(r1,r2,r3)
    // We used for each to access the data in our test list.
    for (i in test.indices){
        // We tested our first test data in the arrayContains method, if the return value and the required result match,
        // the test was passed, otherwise the test remained, we printed it.
        if (arrayContains(defaultList,test[i]) != result[i]){
            println("arrayContainsTester ${test[i]} result of function ${arrayContains(defaultList,test[i])} our result ${result[i]} failed")
        }else{
            println("arrayContainsTester ${test[i]} result of function ${arrayContains(defaultList,test[i])} our result ${result[i]} passed")
        }
    }
}

fun reverseListTester() {
    // To test our  reverseList method, we wrote 3 test data and test results
    val t1 = listOf<Int>(11,22,33)
    val r1 = listOf<Int>(33,22,11)
    val t2 = listOf(20,11,4,0,5)
    val r2 = listOf(5,0,4,11,20)
    val t3 = listOf(90)
    val r3 = listOf(90)
    // we have added these values to the list
    val test = listOf(t1,t2,t3)
    val result = listOf(r1,r2,r3)
    // We used for each to access the data in our test list.
    for (i in test.indices){
        // We tested our first test data in the reverseList method, if the return value and the required result match,
        // the test was passed, otherwise the test remained, we printed it.
        if (reverseList(test[i]) != result[i]){
            println("reverseTester ${test[i]} result of function ${reverseList(test[i])} our result ${result[i]} failed")
        }else{
            println("reverseTester ${test[i]} result of function ${reverseList(test[i])} our result ${result[i]} passed")
        }
    }
}






