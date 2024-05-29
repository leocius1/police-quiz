package org.example.services;

import org.example.models.Suspect;

import java.util.List;

public interface SuspectListManager extends ListManager {
    void deleteSuspectsWithoutImg(List<Suspect> suspects);
}
