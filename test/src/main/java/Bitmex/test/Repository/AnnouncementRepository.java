package Bitmex.test.Repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Bitmex.test.Models.Announcement;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
    boolean existsById(Long id);
    List<Announcement> findByOrderByDateDesc();
    //List<Announcement> findByDate(Date date);
    List<Announcement> findByTitle(String title);
}