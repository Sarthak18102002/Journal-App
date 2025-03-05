package org.edigest.mysecondproject.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection="users")
@Data
public class User {

    @Id
    private String id;
    @Indexed(unique=true)
    @NonNull
    private String userName;
    @NonNull
    private String password;

    @DBRef //You are creating a reference of journalEntries in the  users collection
    private List<JournalEntry> journalEntries=new ArrayList<>();
}
