package org.example.services;

import org.example.models.Suspect;

import java.util.List;
import java.util.Map;

public interface SuspectManager extends ListManager<Suspect> {
    void deleteSuspectsWithoutImg(List<Suspect> suspects);
    Map<Suspect,Boolean> makeSuspectAndIsSuspectUsedAlreadyMap(List<Suspect> suspects);
}
