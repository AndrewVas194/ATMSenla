package org.example.repository;

import org.example.entity.Card;
import java.util.List;

public interface CardRepository {
    List<Card> findAllCards();
}
