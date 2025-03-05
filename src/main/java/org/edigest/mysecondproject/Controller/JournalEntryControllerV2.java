package org.edigest.mysecondproject.Controller;

import org.edigest.mysecondproject.Entity.JournalEntry;
import org.edigest.mysecondproject.Entity.User;
import org.edigest.mysecondproject.Service.JournalEntryService;
import org.edigest.mysecondproject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;

    @Autowired
    private UserService userService;
    private String userName;

    @GetMapping("{userName}")
    public ResponseEntity<?> getAllJournalEntriesOfUser(@PathVariable String userName) {

        User user = userService.findByUserName(userName);
        List<JournalEntry> all = user.getJournalEntries();
        if (all != null && !all.isEmpty()) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("{userName}")
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry, @PathVariable String userName) {
        try {
            journalEntryService.saveEntry(myEntry, userName);
            return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("id/{MyId}")
    public JournalEntry getJournalEntryById(@PathVariable String MyId) {
        return journalEntryService.findById(MyId).orElse(null);
    }

    @DeleteMapping("id/{userName}/{MyId}")
    public boolean deleteJournalEntryById(@PathVariable String userName,String MyId) {

        journalEntryService.deleteById(MyId,userName);
        return true;
    }



//    @PutMapping("/id/{userName}/{Id}")
//    public ResponseEntity<?> updateJournalEntryById(@PathVariable String Id, @RequestBody JournalEntry newEntry,@PathVariable String userName) {
//      JournalEntry old = journalEntryService.findById(Id).orElse(null);
//      if(old != null){
//          old.setTitle(!newEntry.getTitle().equals("") ?newEntry.getTitle():old.getTitle());
//          old.setContent(newEntry.getContent() !=null && !newEntry.equals("")?newEntry.getContent():old.getContent());
//          journalEntryService.saveEntry(old);
//      }
//
//return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
}



