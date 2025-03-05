package org.edigest.mysecondproject.Entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection="journal_entries")
@Data
@NoArgsConstructor
public class JournalEntry {

    @Setter
   @Id
    private String id;
    @Setter
    @Getter
    @NonNull
    private String title;
    @Setter
    @Getter
    private String content;
    private LocalDateTime date;

    public void setLocalDateTimeDate(LocalDateTime date) {
        this.date = date;
    }

}
