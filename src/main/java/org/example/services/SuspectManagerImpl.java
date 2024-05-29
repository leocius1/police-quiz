package org.example.services;

import org.example.models.Suspect;

import java.util.List;

public class SuspectManagerImpl implements SuspectListManager {
    @Override
    public void deleteSuspectsWithoutImg(List<Suspect> suspects) {
        suspects.removeIf(suspect -> suspect.getImgUrl() == null);
    }
}
