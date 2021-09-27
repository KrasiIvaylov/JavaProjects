# WorkShop-Exception-Handling
Exercise: Exceptions and Error Handling
This document defines the lab for "Java OOP" course @ Software University.

Problem 1.	Square Root
Write a program that reads an integer number and calculates and prints its square root. If the number is invalid, print "Invalid number". In all cases finally print "Good bye". Use try-catch-finally.

Problem 2.	Enter Numbers
Write a method printNumbers(int start, int end) that prints an integer numbers in a given range [start…end]. If an invalid number or a non-number text is entered, the method should throw an exception. Using this method write a program that enters start and end: 1 < start < end < 100. If the user enters an invalid number, make the user enter all of them again.

Problem 3.	Fixing
This program is throwing an ArrayIndexOutOfBoundsException. Using your skills, fix this problem using a try catch block.
 
Problem 4.	Valid Person
Define a simple class Person, which has the following fields: first name, last name and age. Validate the data in the setters, throw appropriate exceptions in case invalid data is entered.

Step 1. Create a Class Person
Create a class Person. The class should contain the following fields: first name (String), last name (String) 
and age (int).
All fields are required, meaning you should have one constructor accepting all three as parameters. For example:
 
Step 2. Add Getters and Setters and Validate the Data
Add a getters and setters for each of the fields. Perform validations in their setters to keep the state of the Person objects correct.
The first and last name cannot be null or empty strings. To check this, use the string.IsNullOrEmpty() method.
The age must be in the range [0 … 120].
If invalid data is entered, throw appropriate exceptions with descriptive messages. E.g., if an empty name is entered, an appropriate exception may be IllegalArgumentException.
Example for validating the first name (last name is analagous):
 

Example for validating the age:
 
Now the constructor should make use of the setters instead of modifying the private fields directly:
 
Step 3. Test the Person Class
In your main program, test whether your class behaves properly. Create several objects of type Person – one with valid data, one with an empty first name, one with null as last name, one with negative age and one with age > 120. Check whether executing the code results in errors, when bad data is provided. Test the invalid cases one by one by commenting out the other invalid lines of code (your program will stop executing when the first error is encountered).
 
Step 4. Add Try-Catch Blocks
To prevent the program from blowing up, surround the invalid lines in try-catch blocks. It’s a good practice to put different catch blocks for the different types of errors you anticipate the operation might throw. Print the message of the exception in the catch block.
Example:
 

Problem 5.	Custom Exception
Create InvalidPersonNameException class in the previous problem, which does not allow any special character or numeric value in a name of any of the students. To do that create Student class with name and email fields. When trying to create student with name "4havdar", throw your custom Exception class.





