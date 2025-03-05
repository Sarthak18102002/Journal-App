package org.edigest.mysecondproject.Repository;

import org.bson.types.ObjectId;
import org.edigest.mysecondproject.Entity.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface JournalEntryRepository extends MongoRepository<JournalEntry , String > {

}
