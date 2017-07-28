package com.antivirus.dto;

/**
 * Created by User on 7/28/2017.
 */
public class RegionDTO {

    private int id;
    private String name;

    public RegionDTO() {
    }

    public RegionDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RegionDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
