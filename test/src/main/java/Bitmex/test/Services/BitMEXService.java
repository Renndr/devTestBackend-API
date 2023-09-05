package Bitmex.test.Services;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import Bitmex.test.Models.Announcement;

@Service
public class BitMEXService {

    @Autowired
    private AnnouncementService announcementService;

    private static final String BITMEX_API_ANNOUNCEMENT = "https://www.bitmex.com/api/v1/announcement";

    private final RestTemplate restTemplate;

    public BitMEXService() {
        this.restTemplate = new RestTemplate();
    }

    //Method used for fetch api announcements
    public List<Announcement> fetchAnnouncements() {
        ResponseEntity<Announcement[]> response = restTemplate.getForEntity(BITMEX_API_ANNOUNCEMENT, Announcement[].class);

        if (response.getStatusCode().is2xxSuccessful()) {
            Announcement[] announcements = response.getBody();
            if (announcements != null) {
                return Arrays.asList(announcements);
            }
        }
        return Collections.emptyList();
    }

    //Scheduled method for save every minutes news announcements in db
    @Scheduled(fixedRate = 60000) // get data from api
    public void getAndSaveAnnouncements() {
        List<Announcement> announcements = fetchAnnouncements();
        announcementService.saveAnnouncements(announcements);
    }

}