# Object Oriented Programming - LAB
The following instructions are to follow the lecture on Object Oriented Programming.  These should be done in a tool that allows for immediate compilation as some of the instructions will be to enter something that will break.  This is in order to see how the compiler enforces some of the language rules.   There will also be heavy use of the the `System.out.println()` method to see the results once the code compiles.

Keep in mind the instruction *can* be written in a plan text editor and then compiled on the command line using `javac` but the process will be much slower.

This lab will consist of writing code but (probably) will not end up with a fully functional system.  It may however, be used as the basis for a future project so it is imperative to be as complete as possible even though a fully functioning system may not be completed in the amount of time given for this lab.

Think about a design for a library management system.  Obviously the first type thing you think of is a book. But this is actually a *specific* type of item in a library.  A book is a type of *LibraryItem*, of which there can be many types.  A book is one type, but how about other types such as a *Periodicle* with further sub-types such as magazine or newspaper?

Before attacking the problem below, read the following web articles on Object Oriented Design and Programming:
* [OOP Basics with Java](https://www3.ntu.edu.sg/home/ehchua/programming/java/J3a_OOPBasics.html)
* [Java Tutorial: Object Oriented Programming Concepts](https://docs.oracle.com/javase/tutorial/java/concepts/index.html)
* [Inheritance vs. Composition](https://www.w3resource.com/java-tutorial/inheritance-composition-relationship.php)

Design a class hierarchy for the items in a libary.  Put these classes together in a package that is separate from the package that `main` is in.  The main method will represent a commond-line interface to a library system that will be implemented throughout the rest of this lab.

Some suggestions:
* `main` is in a `com.tts.oop` package.
* The library classes are in the `com.tts.oop.model` package.
* `LibraryItem` is a base class, two immediate derived classes are `Book` and `Periodical`.  Derived from `Book` are `ReferenceBook` and `GeneralBook`, and from `Periodical` are `Magazine` and `NewsPaper`.
* What other types can derive from `LibraryItem`?  Audio? Video?  And sub-types of them could be?
* What is common to all `LibraryItems`?  To `Book`?  Make sure the properties and methods are in their appropriate place, and overridden where necessary.

* A common line of thinking is this: If you find yourself defining the same property in many derived classes, this indicates the property *could* be defined in a base class.  The same with methods - if there is a similar method definition occurring in many child classes, or a definition that is only *slightly* different, this may be a base class method that can be overridden when necessary.

Write a class for a `CardHolder` to represent someone who joined the library and can check out items, reserve items, etc.

#### Interfaces
Some items may be reservable, and some may be loanable.  Create an interface for each of these and implement them in classes which fit the appropriate type.


#### Relationships
Create classes for Author and Publishing Company.  Code in relationships into each of the library items.  How will you handle that an item can have multiple authors?

#### Generics
How have generics been used so far?  Write a custom generic collection called `OverdueList` to manage a list of overdue items.  Create separate members in the `CardHolder` for a list of books, a list of periodicals, and a list of multimedia items that are overdue.

Refactor the `Loanable` interface to include a late charge.  Also, create an enumeration for how frequently late charges are added - Daily, Weekly, Bi-Weekly, Monthly, etc.  

#### Patterns
Read the following articles on design patterns:
* [Design Patterns in java](https://javabeginnerstutorial.com/design-patterns-in-java/)
* [Factory Design Pattern](https://www.tutorialspoint.com/design_pattern/factory_pattern.htm)
* [Publish-Subscribe](https://riptutorial.com/design-patterns/example/6498/publish-subscribe-in-java) 

Create a factory for Library Items.  How will you determine which item to create?  A lookup?  Enum? String?

Think about how you would implement a reservation notification system.  This sub-system would let users sign up for an alert if an item they were interested in was checked out and then became available.

