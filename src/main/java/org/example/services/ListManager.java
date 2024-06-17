package org.example.services;

import java.util.Comparator;
import java.util.List;

public interface ListManager<T> {
    List<T> removeDuplicates(List<T> list);
}
