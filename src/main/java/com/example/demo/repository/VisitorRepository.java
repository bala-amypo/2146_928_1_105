package com.example.demo.repository;

import com.example.demo.model.Visitor;
import java.util.*;

public interface VisitorRepository {
    Visitor save(Visitor v);
    Optional<Visitor> findById(Long id);
    List<Visitor> findAll();
}
