package com.apple.siri.engine;


import java.util.List;

/**
 * Concept Operations
 * Operations related to existing Concepts.
 */
public interface ConceptOperation {

    /**
     * Checks if string input contains any of the concepts.
     * @return Containing concepts.
     */
    List<String> checkConcepts();
}
