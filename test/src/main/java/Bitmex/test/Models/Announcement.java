package Bitmex.test.Models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Announcement")
@AllArgsConstructor
public class Announcement {

    public Announcement() {
    }

    @Id
    @Getter @Setter @Column(name = "id", nullable = false)
    private Long id;

    @Getter @Setter @Column(name = "link", nullable = false)
    private String link;

    @Getter @Setter @Column(name = "title", nullable = false)
    private String title;

    @Getter @Setter @Column(name = "content", nullable = false)
    private String content;

    @Getter @Setter @Column(name = "date", nullable = false)
    private LocalDateTime date;

}
