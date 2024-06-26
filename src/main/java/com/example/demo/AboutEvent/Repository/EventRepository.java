package com.example.demo.AboutEvent.Repository;
import com.example.demo.AboutEvent.Models.Event;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    // Additional custom queries can be defined here if needed
}