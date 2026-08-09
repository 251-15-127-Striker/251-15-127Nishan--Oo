/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.week13;

/**
 *
 * @author User
 */
import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.*;

class ParallelLetterFrequency {

    private String[] texts;

    ParallelLetterFrequency(String[] texts) {
        this.texts = texts;
    }

    Map<Character, Integer> countLetters() {

        Map<Character, Integer> result = new HashMap<>();

        ExecutorService executor =
                Executors.newFixedThreadPool(
                        Runtime.getRuntime().availableProcessors()
                );

        try {
            Future<Map<Character, Integer>>[] futures =
                    new Future[texts.length];

            for (int i = 0; i < texts.length; i++) {
                final String text = texts[i];

                futures[i] = executor.submit(() -> {
                    Map<Character, Integer> localMap = new HashMap<>();

                    for (char c : text.toLowerCase().toCharArray()) {
                        if (Character.isLetter(c)) {
                            localMap.put(
                                c,
                                localMap.getOrDefault(c, 0) + 1
                            );
                        }
                    }

                    return localMap;
                });
            }

            for (Future<Map<Character, Integer>> future : futures) {
                Map<Character, Integer> localMap = future.get();

                for (Map.Entry<Character, Integer> entry
                        : localMap.entrySet()) {

                    result.merge(
                        entry.getKey(),
                        entry.getValue(),
                        Integer::sum
                    );
                }
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            executor.shutdown();
        }

        return result;
    }
}
