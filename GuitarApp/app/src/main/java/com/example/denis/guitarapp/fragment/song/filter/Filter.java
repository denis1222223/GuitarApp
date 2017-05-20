package com.example.denis.guitarapp.fragment.song.filter;

import java.util.List;

public interface Filter<T> {
    List<T> filter(List<T> list);
}
