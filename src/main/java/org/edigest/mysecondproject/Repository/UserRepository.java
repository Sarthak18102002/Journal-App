package org.edigest.mysecondproject.Repository;

import org.edigest.mysecondproject.Entity.JournalEntry;
import org.edigest.mysecondproject.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String>
{
    User findByUserName(String username);

}
