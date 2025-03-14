package DSA_EXAM_QNS;

import java.util.*;

public class Qn_12 {
    // Implement LFU caching

    class LFUCache {
        private final int capacity;
        private int minFrequency;
        private Map<Integer, Integer> keyToValue; // Stores key-value pairs
        private Map<Integer, Integer> keyToFrequency; // Stores key-frequency pairs
        private Map<Integer, LinkedHashSet<Integer>> frequencyToKeys; // Maps frequency to a set of keys

        public LFUCache(int capacity) {
            this.capacity = capacity;
            this.minFrequency = 0;
            this.keyToValue = new HashMap<>();
            this.keyToFrequency = new HashMap<>();
            this.frequencyToKeys = new HashMap<>();
        }

        public int get(int key) {
            if (!keyToValue.containsKey(key)) {
                return -1; // Key not found
            }
            // Update the frequency of the key
            int frequency = keyToFrequency.get(key);
            keyToFrequency.put(key, frequency + 1); // Increment frequency

            // Remove the key from the current frequency set
            frequencyToKeys.get(frequency).remove(key);
            if (frequencyToKeys.get(frequency).isEmpty()) {
                frequencyToKeys.remove(frequency);
                if (frequency == minFrequency) {
                    minFrequency++; // Update minFrequency if necessary
                }
            }

            // Add the key to the new frequency set
            frequencyToKeys.computeIfAbsent(frequency + 1, k -> new LinkedHashSet<>()).add(key);

            return keyToValue.get(key);
        }

        public void put(int key, int value) {
            if (capacity == 0) {
                return; // Edge case: no capacity
            }

            if (keyToValue.containsKey(key)) {
                // Update the value and increment frequency
                keyToValue.put(key, value);
                get(key); // Reuse get() to update frequency
                return;
            }

            if (keyToValue.size() >= capacity) {
                // Evict the least frequently used key
                LinkedHashSet<Integer> keysWithMinFrequency = frequencyToKeys.get(minFrequency);
                int keyToEvict = keysWithMinFrequency.iterator().next(); // Get the least recently used key
                keysWithMinFrequency.remove(keyToEvict);
                if (keysWithMinFrequency.isEmpty()) {
                    frequencyToKeys.remove(minFrequency);
                }
                keyToValue.remove(keyToEvict);
                keyToFrequency.remove(keyToEvict);
            }

            // Insert the new key-value pair
            keyToValue.put(key, value);
            keyToFrequency.put(key, 1);
            frequencyToKeys.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
            minFrequency = 1; // Reset minFrequency to 1 for the new key
        }
    }
}
