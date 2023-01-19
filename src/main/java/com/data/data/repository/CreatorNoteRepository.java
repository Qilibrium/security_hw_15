package com.data.data.repository;

import com.data.data.note.NoteSecurity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreatorNoteRepository extends JpaRepository<NoteSecurity, Long> {
    NoteSecurity findByName(String name);
}
