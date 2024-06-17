package org.example.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CrimeListManagerImpl implements ListManager<String> {
    @Override
    public List<String> removeDuplicates(List<String> crimes) {
        Set<String> uniqueCrimes = new HashSet<>(crimes);
        return new ArrayList<>(uniqueCrimes);
    }
}
