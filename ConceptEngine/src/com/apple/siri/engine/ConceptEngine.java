package com.apple.siri.engine;


import com.apple.siri.repo.ConceptRepo;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Concept Engine
 * Main operations for checking the existing concepts
 */
public class ConceptEngine implements ConceptOperation{

    private List<String> results;
    private String input;
    /**
     * ConceptEngine constructor
     * @param input Get string input.
     */
    public ConceptEngine(String input){

        this.results = new ArrayList<>();
        this.input = input;
    }

    /**
     * Checks if string input contains any of the concepts.
     * @return Containing concepts.
     */
    public List<String> checkConcepts(){

        // Accepts only characters, numbers and space
        Pattern p = Pattern.compile("[a-zA-Z0-9\\s]+");
        Matcher m = p.matcher(this.input);
        this.input = "";
        while(m.find()){
            this.input = this.input.concat(m.group());
        }

        String[] concepts = this.input.split("\\s+");
        Queue<String> conceptQueue = new LinkedList<>();
        Collections.addAll(conceptQueue, concepts);

        recursive(conceptQueue);
        return this.results;
    }

    /**
     * Recursively checks the concepts.
     * @param cq Queue of the concepts
     * @return Sub Queues each time.
     */
    private  Queue<String> recursive(Queue<String> cq){

        if(cq.isEmpty()){
            return null;
        }
        // First Item of the queue
        String headConcept = cq.poll();
        Queue<String> nextConcepts = new LinkedList<>(cq); // Copy of the other items

        String concept = ConceptRepo.getInstance().findConceptOrNone(headConcept.toLowerCase());
        if(concept != null){
            results.add(concept);
        }

        while(!nextConcepts.isEmpty()){
            headConcept = String.format("%s %s", headConcept, nextConcepts.poll());

            concept = ConceptRepo.getInstance().findConceptOrNone(headConcept.toLowerCase());
            if(concept != null){
                results.add(concept);
            }
        }
        // Recursive call.
        return recursive(cq);
    }
}
