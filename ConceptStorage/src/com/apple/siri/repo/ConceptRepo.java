package com.apple.siri.repo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Repository class for the concepts.
 * It gets data from sample_concept.txt
 */
public class ConceptRepo {

    private HashMap<String, String> conceptRepo;
    private static ConceptRepo instance;

    /**
     * Private Constructor for singleton object
     */
    private ConceptRepo(){

        conceptRepo = new HashMap<>();
        try {
            BufferedReader conceptReader = new BufferedReader(new FileReader("./sample_concept.txt"));
            String concept = conceptReader.readLine();

            while (concept != null){
                // In conceptRepo object, keys are lowerCase, values are original version.
                conceptRepo.putIfAbsent(concept.trim().toLowerCase(), concept.trim());
                concept = conceptReader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Instantiation of the ConceptRepo
     * @return ConceptRepo instance
     */
    public static ConceptRepo getInstance(){

        if (instance == null){
            // synchronize the threads accessing in the same time.
            synchronized (ConceptRepo.class) {
                instance = new ConceptRepo();
            }
        }
        return instance;
    }

    /**
     * Finds if the concept exists or not. If not, returns null
     * @param concept Word in the sentence
     * @return Concept if found, otherwise null.
     */
    public String findConceptOrNone(String concept){
        // Always check lowercase because keys are lowerCase in the repo.
        return conceptRepo.getOrDefault(concept.toLowerCase(), null);
    }
}
