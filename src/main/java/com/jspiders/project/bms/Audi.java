package com.jspiders.project.bms;

import com.jspiders.project.bms.main.Shows;
import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name="auditorium")
public class Audi extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="audi_name",nullable = false)
    private String name;

    @Column(name="seat_rows",nullable = false)
    private Integer seatRows;

    @Column(name="seat_columns",nullable = false)
    private Integer seatColumns;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id") // FK
    private Address address;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "audi_id") // FK
    private ArrayList<Shows> shows;




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeatRows() {
        return seatRows;
    }

    public void setSeatRows(Integer seatRows) {
        this.seatRows = seatRows;
    }

    public Integer getSeatColumns() {
        return seatColumns;
    }

    public void setSeatColumns(Integer seatColumns) {
        this.seatColumns = seatColumns;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ArrayList<Shows> getShows() {
        return shows;
    }

    public void setShows(ArrayList<Shows> shows) {
        this.shows = shows;
    }

    @Override
    public String toString() {
        return "Audi{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", seatRows=" + seatRows +
                ", seatColumns=" + seatColumns +
                ", address=" + address +
                '}';
    }
}
