package org.example.services;

import java.util.List;

public class CrimeListManagerImpl implements CrimeListManager {
    @Override
    public void removeRepeatedCrimes(List<String> crimes) {
       for (int i = 0; i < crimes.size(); i++) {
           for (int j = i+1; j < crimes.size(); j++) {
               if (crimes.get(i).equals(crimes.get(j))) {
                   crimes.remove(crimes.get(i));
               }
           }
       }
    }
}
