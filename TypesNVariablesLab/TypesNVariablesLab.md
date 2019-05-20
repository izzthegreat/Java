# Java Data Types and Variables - Additional Lab Statements  

This file contains the "interspersed" lab statements for the **Types and Variables** lesson.  The main lesson file will contain instructions such as "Addl Lab #2 here", and that means that in this file, lab #2 *could* be inserted at that point.  

The statements in this file, unlike the full-on lab, are meant to be executed during the lesson at the appropriate times, and flow together.  


### Lab Step #1
Create a new java project, and then create a new file.  If using Eclipse (or another IDE) make sure the new class has the `main()` method in it.  After making a file with `main()`, do the following:
* declare an int variable (firstInt) and assign it the value of 6.
* declare another int variable (secondInt) and assign it the value of 20.
* declare another int variable (thirdInt) and don't assign it any value.
* declare a float variable and assign it the value of 4.4f.
* declare a boolean value for `isCold` and set it to false.
* declare a double value and assign it using the "_" character for group separation.

print out the value of each variable using the `System.out.println` statement.


### Lab Step #2
* create a new value by adding firstInt to secondInt and print the result.
* create a new value by adding firstInt to thirdInt and print the result.
    - Oops - what problem do you have here?  How do you fix it?
* print the result of dividing firstInt into secondInt.  
* print the remainder when dividing firstInt into secondInt.
* create a new int and add firstInt to the remainder from the previous statement.
  - before printing, increment the value by 1;


### Lab Step #3
* declare and int varible x and assign it the value of 100;
* declare a boolean variable and assign it the value of comparing x to the value of 100.
    - Note the difference in the single and double equal signs.
* declare a variable y and assign it a value of 106.
* check and print the following conditions:
    - x greater than y
    - y greater than x
    - x greater than or equal to y-6

* Create a variable z and set it to 92.
* check and print the following conditions:
    - x is less than y and y is less than z
    - y is less than z and x is greater than or equal to y
    - z is greater than y + x or x - y is less than z
    
* prove that x less than y is equal to NOT x greater than y.


### Lab Step #4
* create an integer variable n and assign it 64
* prove that shifting n 1 bit right is equivalent to dividing by 2.
* prove that shifting n 1 bit left is equivalent to multipying by 2.
* change the value of n to a non-power-of-2 number, such as 40, and prove that the two previous statements are still valid.
* prove that shifting by 2 is equivalent to dividing/multipying by 4.
* change the value to an odd number and print the values to see what happens.



### Lab Step #5  

At the same level of `main()`, create a small void function such that your main class file is similar to:
```java
public class MainFile
{
    public static void main(String[] arg)
    {
        // statements not shown
    }

    public static void anotherMethod()
    {

    }
}
```
* With this lesson on forward, really thing about the names of the variables and functions and how best to apply naming standards and conventions.
* Declare an int variable inside of the `anotherMethod` method and assign it a value.  With the current code is it possible to reference that variable from inside `main()`?
* below the variable, create an `if` statement to test if the variable you just declared is greater than 1000.  If it is print "Big Value", if it is not print "Not a big value".
* Change the statement to use the variable in the output: (n + " is a Big value") or (n + " is not a big value")
* inside of the if block, create an integer variable and assign it the value of the previously declared integer divided by 2.
* inside of the if block, print that the newly declared variable is half a big variable.
* in the else block, print that the half value is definitely small.
    - Oops, is there a problem?  How can it befixed?  
* Call this method from the `main()` method to see its output.

### Lab Step #6
* In the `anotherMethod()`, change the primitive `int` to be a `Integer` variable.
* Instead of a hard-coded 1000, create an `Integer` variable to check agaist, but use the string value "1000" to create the `Integer`.
* Instead of using the greater than for comparison in the `if()`, use either the static `compare` method, or the instance `compartTo` method to perform the check in the `if()`.

   
      
         


### Lab Step #7
* create another static void method - `playWithStrings()`
* create a `String` variable to represent your first name and initialize it with a string literal.
* create a `String` variable to represent your last name and initialize it by using `new()` with your last name.
* Using the `concat()` method, print a greeting of "Hello firstName lastName"
* call the method from `main()` and inspect the results.
* change the println method to use the overloaded "+" operator to make the same output string.
* Create a new String variable `fullName` by combining the first and last with proper spacing.  This variable will be used for many of the following exercises.
* find and the following values:
    - what is the total length of the string?
    - index of the first 'o'
    - which letter is at position 7?
    - does the full name contain the word "son"?
    - what are the last 5 letters in the full name?
    - does the full name contain an apostrophie or dash?

* print the above values using format strings, in complete sentence form.  For example: 
    - "The total length of the String Tim Smith is 9".
    - "The String Tim Smith does not have an 'o'".
    - "The letter "t" is at position 7.  
    etc.


