package Bitmex.test.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Bitmex.test.Models.Announcement;
import Bitmex.test.Services.AnnouncementService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/announcement")
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;
    
    //API GET all announcements
    @GetMapping("")
    public ResponseEntity<List<Announcement>> getAllAnnouncement() {
        List<Announcement> announcement = announcementService.getAllAnnouncements();
        return ResponseEntity.ok(announcement);
    }

    //API GET announcements by id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Announcement>> getAnnouncementById(@PathVariable Long id) {
        Optional<Announcement> announcement = announcementService.findById(id);

        if (announcement != null) {
            return ResponseEntity.ok(announcement);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Method only for test purposes
    @DeleteMapping("/{id}")
    public void deleteAnnouncement(@PathVariable Long id) {
        announcementService.deleteAnnouncement(id);
    }

    //API Update announcements
    @PutMapping("/{id}")
    public ResponseEntity<Announcement> updateAnnouncement(@PathVariable Long id, @RequestBody Announcement updatedAnnouncement) {
        Optional<Announcement> existingAnnouncementOptional = announcementService.findById(id);
    
        if (existingAnnouncementOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
    
        Announcement existingAnnouncement = existingAnnouncementOptional.get();
    
        //Update
        existingAnnouncement.setTitle(updatedAnnouncement.getTitle());
        existingAnnouncement.setContent(updatedAnnouncement.getContent());
        
        //Save
        Announcement updated = announcementService.saveAnnouncement(existingAnnouncement);
    
        return ResponseEntity.ok(updated);
    }

    //API create announcements
    @PostMapping("")
    public void createAnnouncement(@RequestBody Announcement announcement) {
        announcementService.createAnnouncement(announcement);
    }

    //API filter by DESC announcements
    @GetMapping("/sorted-by-date")
    public ResponseEntity<List<Announcement>> getAnnouncementsSortedByDateDesc() {
        List<Announcement> announcements = announcementService.getAnnouncementsOrderByDateDesc();
        return ResponseEntity.ok(announcements);
    }

    //API filter by TITLE -- filter-by-title?title=title
     @GetMapping("/filter-by-title")
    public ResponseEntity<List<Announcement>> filterAnnouncementsByTitle(@RequestParam String title) {
        List<Announcement> filteredAnnouncements = announcementService.getByTitle(title);
        return ResponseEntity.ok(filteredAnnouncements);
    }

    //API filter by DATE
}
