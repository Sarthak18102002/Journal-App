package org.edigest.mysecondproject.Service;

import org.edigest.mysecondproject.Entity.JournalEntry;
import org.edigest.mysecondproject.Entity.User;
import org.edigest.mysecondproject.Repository.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component

public class JournalEntryService {
    @Autowired
    private JournalEntryRepository journalEntryRepository;
    @Autowired
    private UserService userService;
    public void saveEntry(JournalEntry journalEntry, String userName)
    {
        User user = userService.findByUserName(userName);
            journalEntry.setDate(LocalDateTime.now());
           JournalEntry saved= journalEntryRepository.save(journalEntry);
           user.getJournalEntries().add(saved);
           userService.saveEntry(user);
        }
    public void saveEntry(JournalEntry journalEntry)
    {
       journalEntryRepository.save(journalEntry);
    }



    public List<JournalEntry> getAll() {
        return journalEntryRepository.findAll();
    }
    public Optional<JournalEntry> findById (String id) {
        return journalEntryRepository.findById(id);
    }

   public void deleteById(String id, String userName)
   {
       User user = userService.findByUserName(userName);
        user.getJournalEntries().removeIf(x -> x.getId().equals(id));
       userService.saveEntry(user);
        journalEntryRepository.deleteById(id);
   }


}
