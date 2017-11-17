# Apple Siri Assignment

### Introduction

This document is a reference for the assignment.

Basically aiming concept search among a list. 


### Project

The Main Appplication checks all the concepts in the inputs.
Also, there are test cases, checking the actual amount of the existing concepts with expected amount.

### Technical 

Project is a standard **Java** application. 
Although the application is developed with 
Java 8 environment, it does not contain any specific Java 8 feature. 
Any of the 3rd party libraries aren't used.


Main project Application class is under 
```
src/com/apple/siri/assignment
```

Main Appplication class calls a test method and tests all the inputs.
You will find the results in the output.

Also, a test class is created under:
```
src/com/apple/siri/tests
```
This test method compares the expected count of concept
and existing one.

**Project has 2 module**
- ConceptEngine
- ConceptStorage

Both is under main Siri Assignment project directory.

ConceptStorage is a **Singleton** Repository to provide data. It initialize by 
reading data from **sample_concept.txt** in the main directory.

ConceptEngine is concept check engine. All the business is inside. 

### Complexity, Scalability, Reliability

Project is modular and if required, modules can easily be replaced.

Spliting and searching input concepts complexity is
```
O(N log(N))
```
But, checking the existing concept from concept list is
```
O(1)
```
Because, all the existing data concept list is in a **HashMap**. 

**Scalability:** There are 2 type of scalability.
- Vertical scalability: Adding more memory, CPU and Disk to a single cluster
- Horizontal scalability: Distributing the software into multiple custers. (e.g MapReduce, Storm, Spark)

**Reliability:** Project contains error handling. This provides reliability. 


