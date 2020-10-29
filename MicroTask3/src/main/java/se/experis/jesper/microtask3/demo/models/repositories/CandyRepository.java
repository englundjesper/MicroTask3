package se.experis.jesper.microtask3.demo.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.experis.jesper.microtask3.demo.models.Candy;

@Repository
public interface CandyRepository extends JpaRepository<Candy, Integer> {
}
