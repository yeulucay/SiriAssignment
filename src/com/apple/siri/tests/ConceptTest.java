package com.apple.siri.tests;

import static org.junit.Assert.assertEquals;

import com.apple.siri.engine.ConceptEngine;
import com.apple.siri.engine.ConceptOperation;
import org.junit.Test;

import java.util.List;

public class ConceptTest {

    /**
     * Test Method checks the existing concepts in the inputs.
     * Expected count checks
     */
    @Test
    public void testAllInputs(){

        List<String> result = testInput("I would like some thai food");
        assertEquals("Match", 1, result.size());

        result = testInput("Where can I find good sushi");
        assertEquals("Match", 1, result.size());

        result = testInput("Find me a place that does tapas");
        assertEquals("Match", 0, result.size());

        result = testInput("Which restaurants do East Asian food");
        assertEquals("Match", 1, result.size());

        result = testInput("Which restaurants do West Indian food");
        assertEquals("Match", 2, result.size());

        result = testInput("What is the weather like today");
        assertEquals("Match", 0, result.size());
    }

    /**
     * Checks existing concept from Engine
     * @param input
     * @return List of existing concepts
     */
    private List<String> testInput(String input){
        ConceptOperation engine = new ConceptEngine(input);
        return engine.checkConcepts();
    }
}
