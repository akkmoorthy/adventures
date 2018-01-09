Intent
Define a family of algorithms, encapsulate each one, and make them interchangeable. Strategy lets the algorithm vary independently from the clients that use it.
Capture the abstraction in an interface, bury implementation details in derived classes.

One of the dominant strategies of object-oriented design is the "open-closed principle".

Strategy Pattern:
Collections.sort(list)
Collections.sort(list, Collections.reverseOrder())
Collections.sort(list, EmpComparator)

java.util.Comparator#compare(), executed by among others Collections#sort().