package com.project.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.lookify.models.Song;

@Repository
public interface LookifyRepository extends CrudRepository<Song, Long>{
//    // this method retrieves all the books from the database
//    List<Song> findAll();
//    // this method finds books with descriptions containing the search stringcopy
//    List<Song> findByDescriptionContaining(String search);
//    // this method counts how many titles contain a certain string
//    Long countByTitleContaining(String search);
//    // this method deletes a book that starts with a specific title
//    Long deleteByTitleStartingWith(String search);
}
