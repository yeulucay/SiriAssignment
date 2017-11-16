# Apple Siri Assignment

### Introduction

This document is a reference for the assignment.

Basically aiming concept search among a list. 

### Technical 

Project is a standard **Java** application. 
Although the application is developed with 
Java 8 environment, it does not contain any specific Java 8 feature. 
Any of the 3rd party libraries aren't used.


### Project

Main project Application class is under 
```
src/com/apple/siri/assignment
```

Project has 2 module
- ConceptEngine
- ConceptStorage

This provides modularity and if required, modules can easily be replaced.

Both is under main Siri Assignment project directory.

ConceptStorage is a **Singleton** Repository to provide data. It initialize by 
reading data from **sample_concept.txt** in the main directory.

ConceptEngine is concept check engine. All the business is inside. 