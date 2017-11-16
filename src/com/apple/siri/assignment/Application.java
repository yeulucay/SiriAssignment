package com.apple.siri.assignment;


import com.apple.siri.engine.ConceptEngine;
import com.apple.siri.engine.ConceptOperation;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        testConcept("I would like some thai food");
        testConcept("Where can I find good sushi");
        testConcept("Find me a place that does tapas");
        testConcept("Which restaurants do East Asian food");
        testConcept("Which restaurants do West Indian food");
        testConcept("What is the weather like today");
    }

    private static void testConcept(String input){
        ConceptOperation engine = new ConceptEngine(input);
        List<String> results = engine.checkConcepts();
        System.out.println(String.format("%s | Matches %s",input, results));
    }
}
