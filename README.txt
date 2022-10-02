Project 1: Modeling Deterministic Finite Automata

* Author: Steven Lineses, Drew Marshall
* Class: CS361 Section 002
* Semester: Fall 2022

## Overview

Use an existing Java framework to simulate a deterministic finite automata model. As well,
this project was a tool for us to practice using both interfaces and understanding how 
packages work in java frameworks. 

## Reflection

Write a brief (2-3 paragraph) reflection describing your experience with this 
project. Answer the following questions (but feel free to add other insights): 
- What worked well and what was a struggle?
- What concepts still aren't quite clear?
- What techniques did you use to make your code easy to debug and modify?
- What would you change about your design process?
- If you could go back in time, what would you tell yourself about doing this project?

##### Drew's Reflection
Like always the biggest struggle I faced was starting and knowing the foundation to 
begin writing actual code. I understand how DFA's work, however, I struggled conceptually
with creating code that represented that. As well, it took some steps to understand the 
different uses of each representation of a set and map. I had to talk to a friend who had
previously taken the class in order to understand how exactly DFA and DFAState should be 
set up in the program, and therefore how they would be used to represent an actual DFA.
Paired programming seemed to work well for Steven and I being open-minded and willing to 
help eachother where needed. Especially when one of us would struggle conceptually and 
the other could help explain it in order to proceed. 

Understanding packages in java is not something I would say I'm proficcient in, but I 
at least understand how they should work, and with more practice will become better 
aquainted with them. This did cause some issues with understanding how to compile and
test the program, but once I moved past that I relied on print statements to help me debug.
Being able to know where my code was getting was important to understand where it was breaking.
As well, using the debug tool in order to match expected values once I had a DFA drawn out 
was crucial to the debugging process and working through the set up of both the sets and 
maps that held the values. 

As for design process, this is something that, as I stated earlier, still struggle with as a 
programmer. It is a difficult process for me to translate an idea into a program. I think the key
thing I would like to work on is breaking down things into small parts that when put together
build up the concept of what I'm trying to program. For this specific program it would have been 
nice to not have to order states in the order they are received and rather just have them 
be output in some organized order such as alphabetically or numerically. This would allow us
to more easily relate this to how we actually think of DFA's and the sets containg the DFA's 
information. Finally, with most things school related I would tell myself to get it started 
as soon as I recieve the project and not procrastinate. That way if I have questions or am 
struggling with something I can ask for help/guidance. The sooner you start the sooner you 
find out what you need help with and therefore the sooner you can finish!

##### Steven' Reflection
Breaking the project into very small units of worked was effective. I put the steps
of each problem into comments and wrote code line by line underneath each comment.
Reading the entire project specification before starting the project was also wise.
I needed some clarification on DFAs that accept empty string only versus accepting
empty string as well as other strings in the alphabet. Also, working on this project
enforced the difference between a DFA that accepts the empty string versus the empty
language.

I created some helper methods for common tasks such as finding a state from the DFAs
existing state. Also, I used visual studio code and connected it to the onyx server
which allowed for full debugging suite. This way I was able to step through each
call stack one by one when an exception occured. Watching variables change as I stepped
through the code helped as well. In addition, I wrote a python script to encode
the project test cases to JFLAP files which I used to check if the input strings
were being accepted/rejected correctly.

I would probably try to use a data structure with faster retrieval based on a key
value. However, order was to be preserved so some looping through the states was
required. I would probably look for ways to break the functions into smaller,
more explicit helper methods instead of a few larger ones. If I could go back in
time, I would start the project earlier. This was pretty fun and there are some areas
of that code that could be optimized.

## Compiling and Using

To compile the program simply use a single command since the .java files are 
all in their ordered subfolders. Being in the root folder that shows this README,
and the two other subfolders 'fa' and 'tests' execute the following command to 
compile the program: 

`javac fa/dfa/DFADriver.java`

Once compiled, to run the program enter the command 
'java fa.dfa.DFADriver ***location of the test file***'. An example using p1tc1.txt
as the test file is shown below: 

`java fa.dfa.DFADriver ./tests/p1tc1.txt`

## Sources used

##### Drew's Sources
* https://www.w3schools.com/java/java_hashmap.asp
* https://docs.oracle.com/javase/8/docs/api/java/util/Set.html
* https://docs.oracle.com/javase/8/docs/api/java/util/Map.html
* https://www.youtube.com/watch?v=70qy6_gw1Hc&ab_channel=AlexLee
* https://stackoverflow.com/questions/37971533/is-it-possible-to-return-a-hashmap-object-in-java
* https://www.codebyamir.com/blog/how-to-use-a-map-in-java
* https://www.quora.com/What-is-the-return-type-of-HashMap-in-Java
* https://docs.oracle.com/javase/tutorial/collections/implementations/set.html#:~:text=There%20are%20three%20general%2Dpurpose,HashSet%20%2C%20TreeSet%20%2C%20and%20LinkedHashSet%20.
* https://www.codejava.net/java-core/collections/java-set-collection-tutorial-and-examples
* https://www.programiz.com/java-programming/set
* https://stackoverflow.com/questions/21177722/how-to-return-a-generic-map-from-a-method-in-java
* https://stackoverflow.com/questions/37485369/java-8-how-to-compare-all-elements-of-a-set

##### Steven's Sources
* https://www.geeksforgeeks.org/iterate-over-the-characters-of-a-string-in-java/
* https://www.oracle.com/technical-resources/articles/java/javadoc-tool.html
* https://www.geeksforgeeks.org/compare-two-strings-in-java/

As well, I had some friends who have taken the class before help walk me
through the set up to understand how the DFAState would work and how to frame 
it mentally in order for me to understand it.  

----------


