package com.softserve.academy.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int roomNumber;
    @ManyToOne
    private Hotel hotel;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "room_user", joinColumns = @JoinColumn(name = "id_room"), inverseJoinColumns = @JoinColumn(name = "id_user"))
    private List<User> users = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomNumber=" + roomNumber +
                ", hotel=" + hotel.getName() +
//                ", users=" + users +
                '}';
    }
}
