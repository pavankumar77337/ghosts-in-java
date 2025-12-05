package com.jspiders.project.bms;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="movie_metadata")
public class movie_metadata extends BaseEntity{
   // movie--> movie_metadata = id,genere,format,rating,releaseDate
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "genere",nullable = false)
    private String genere; // comedy or horror

    @Column(name ="format",nullable = false)
    private String format; // 3D or 2D

    @Column(name = "rating",nullable = false)
    private Integer rating;

    @Column(name ="releasedate",nullable = false)
    private LocalDate releaseDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "movie_metadata{" +
                "id=" + id +
                ", genere='" + genere + '\'' +
                ", format='" + format + '\'' +
                ", rating=" + rating +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
