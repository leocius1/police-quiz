package org.example.services;

import org.example.models.Suspect;

import java.util.*;

public class SuspectManagerImpl implements SuspectManager {
    @Override
    public List<Suspect> removeDuplicates(List<Suspect> suspects) {
        Set<Suspect> uniqueSuspects = new HashSet<>(suspects);
        return new ArrayList<>(uniqueSuspects);
    }
    @Override
    public void deleteSuspectsWithoutImg(List<Suspect> suspects) {
        suspects.removeIf(suspect -> suspect.getImgUrl() == null);
    }

    @Override
    public Map<Suspect, Boolean> makeSuspectAndIsSuspectUsedAlreadyMap(List<Suspect> suspects) {
        Map<Suspect,Boolean> suspectsAndIsSuspectUsed = new HashMap<>();
        for (Suspect suspect : suspects)
            suspectsAndIsSuspectUsed.put(suspect,false);
        return suspectsAndIsSuspectUsed;
    }


}
