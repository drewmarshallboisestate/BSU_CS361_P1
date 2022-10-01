****************
* Double-linked List (with Full Iterator Implementation)
* CS 221
* April 8, 2022
* Drew Marshall
**************** 

OVERVIEW:

 DoubeLinkedList creates a doubly linked list that implements
 IndexedUnsortedList. The program also creates an Iterator and
 listIterator to iterate through the list.


INCLUDED FILES:

 * IUDoubleLinkedList.java -  implents list for listTester.java
 * ListTester.java - source file; 
 * Node.java - creates nodes implented in IUDoubleLinkedList.java
 * README - this file


COMPILING AND RUNNING:

 To compile the program you can either javac each individual 
 .java file as such: javac IUDoubleLinkedList.java, or do it 
 all at once by typing the command javac *.java which will 
 take all the .java files and compile them.
 e.g. $ javac IUDoubleLinkedList.java 
 e.g. $ javac ListTester.java
 e.ge $ javac Node.java
 or
 e.g. $ javac *.java (compiles all .java files at once)

 Once compiled we will only need to run ListTester as it uses
 IUDoubleLinkedList to run all test/scenarios. To do this you 
 must use the command java ListTester.
 Give the command for compiling the program, the command
 for running the program, and any usage instructions the
 user needs.
 e.g. $ java ListTester

 Console output will list each scenario and the number of tests
 that specifc scenario passed, as well as, the toString which will
 print the list in a format as such [1, 2, 3]. 
 Once finished it will print the total amount of tests run, total
 passed, and total failed (both as percentages as well).


PROGRAM DESIGN AND IMPORTANT CONCEPTS:

 IUDoubleLinkedList creates a doubly linked list implementation 
 of an indexed-unsorted list. The program creates a node for each 
 element in the list, as well as, nodes that point to the next and 
 previous element in the list if possible, otherwise it will point 
 to null(empty). There is also a head and tail node to keep track of 
 the begging and end of the list respectively. The list allows several 
 different ways of adding and removing an element to/from the list. 

 The program implements both a normal iterator and a listIterator 
 that allow for traversal throughout the list. As well, the listIterator
 can be positioned at a desired index and begin traversal there. The 
 iterator allows for the list to have elements added, set, and removed.

 The IUDoubleLinkedList program creates the doubly linked list and all
 methods for the list implementation. It also creates the class for each
 iterator/listIterator and their respective methods as well. The Node class
 creates the nodes that the list uses to store each element and use to 
 reference the nodes before and after it. As well, it creates the head 
 and tail node that point at the first and last element in the list. 

 ListTester creates the basic lists we use to test our IUDoubleLinkedList
 functionality. ListTester creates several different scenarios of lists
 of different size that then test each method and iterator/listIterator
 method. ListTester allows us to know that IUDoubleLinkedList is functioning 
 properly and will function for any type of element, and any list size. 

 
TESTING:

 ListTester is responsible for testing IUDoubleLinkedList and all of 
 it's methods functionality, as well as, the iteraor/listIterator. 
 Therefore, in order to properly test each method I created all possible
 scenarios of different sizes, each creating a list by using a method 
 from IUDoubleLinkedList. 

 This project/these homeworks have forced me to become BEST FRIENDS with
 the debugger. After creating a scenario and all of the tests for each 
 different list size, I would start the debugger at the begging of the 
 tests and walk through each test ensuring they passed. However, many did
 not. For each method test that failed I would set the debugger at that 
 test creation and step into it until I reached the paticular method from
 IUDoubleLinkedList that was failing. Then I would continually have to check
 what the method was supposed to be doing and compare it to what was 
 actually occuring. This accounted for many long nights and early mornings
 of conintually stepping in and through a method until I found the error 
 and fixed it to work for all scenarios. 

 The most annoying part of debugging this project was having to step in
 several times for a single test becasue it would create the test, then 
 add the string, and then format the string, then create the scenario, and
 finally reach the method that was causing an error. Essentially, lots and 
 lots and lots of stepping in to the same test. 


DISCUSSION:
 
 The main error I encountered was just a little something called 
 'NullPointerException' (now my most hated exception). Many times I would
 forget to either remove a node or forget to point to the next/previous 
 node and this would cause the list to lose its place and the nodes to
 have a NullPointerException. In order to combat this I began creating all
 my possible lists on a whiteboard and drawing them out as a representation
 of what the method would do to the list. This allowed me to learn where my
 special occasions occured and how to properly prepare for these situations
 within the list. 

 As well, I would spend many hours at tutoring having them walk through
 each method with me in order to ensure they functioned properly and I 
 had thought through specific cases that would cause errors. Many times 
 just talking through the problem allowed me to see my own 'dumb' mistakes
 and have many 'ah ha!' moments. 

 To implement the listIterator I had to read and reread the documenation 
 of how it was to function in order to understand it. The concept of knowing 
 exactly where the iterator was in the list at a certain moment was difficult,
 but once I began drawing it out again I could see where it was/should be. 

 The listIterator methods for setting and adding was difficult to understand
 simply because of the fact they were dependent on where the iterator returned 
 from after it's last call, but several youTube videos helped me understand
 how to solve this problem.  
 
 
EXTRA CREDIT:

 I was instructed by the guys from tutoring to insert jokes here for potential
 extra credit! Therefore: 

 3 Errors walk into a bar. The barman says, “Normally I’d Throw you all out, 
 but tonight I’ll make an Exception.”

 To understand what recursion is, you must first understand recursion.

 “[“”hip””,””hip””]
  (hip hip array!)”

----------------------------------------------------------------------------