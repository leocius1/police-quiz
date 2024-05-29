package org.example.services;

import java.util.List;

public interface CrimeListManager extends ListManager {
    void removeRepeatedCrimes(List<String> crimes);
}
