package Bitmex.test.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Bitmex.test.Models.Announcement;
import Bitmex.test.Repository.AnnouncementRepository;

@Service
public class AnnouncementService {

    @Autowired
    private AnnouncementRepository announcementRepository;

    //Method for get all announcements
    public List<Announcement> getAllAnnouncements() {
        return announcementRepository.findAll();
    }

    //Method for filter by DESC
    public List<Announcement> getAnnouncementsOrderByDateDesc() {
        return announcementRepository.findByOrderByDateDesc();
    }

    //Method for get all announcements filter by ID
    public Optional<Announcement> findById(Long id){
        return announcementRepository.findById(id);
    }

    //Method for save all announcements recived from api
    public void saveAnnouncements(List<Announcement> announcements) {
        for (Announcement announcement : announcements) {
            if (!announcementRepository.existsById(announcement.getId())) {
                announcementRepository.save(announcement);
            } else {
                System.out.println("Announcements saved, no news announcements.");
            }
        }
    }

    //Method for check if announcements exist in db 
    public boolean announcementExists(Long id) {
        return announcementRepository.existsById(id);
    }

    //Method for delete announcements from db (test)
    public void deleteAnnouncement(Long id) {
        announcementRepository.deleteById(id); 
    }

    //Method for post new announcements (save in db)
    public void createAnnouncement(Announcement announcement) {
        announcementRepository.save(announcement);
    }

    //Method for update announcements
    public Announcement saveAnnouncement(Announcement announcement) {
        return announcementRepository.save(announcement);
    }

    //Method find by Title
    public List<Announcement> getByTitle(String title) {
        return announcementRepository.findByTitle(title);
    }

}
