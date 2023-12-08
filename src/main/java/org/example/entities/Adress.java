package org.example.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Adress")
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "straatnaam", nullable = true, length = 100)

    private String straatnaam;

    @Column(name = "huisnummer", nullable = true)
    private Integer huisnummer;

    @Column(name = "wijk", nullable = true, length = 100)
    private String wijk;




    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Adress(Integer id, String straatnaam, Integer huisnummer, String wijk) {
        this.id = id;
        this.straatnaam = straatnaam;
        this.huisnummer = huisnummer;
        this.wijk = wijk;
    }

    public Adress(String straatnaam, Integer huisnummer, String wijk, User user) {
        this.straatnaam = straatnaam;
        this.huisnummer = huisnummer;
        this.wijk = wijk;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Adress() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStraatnaam() {
        return straatnaam;
    }

    public void setStraatnaam(String straatnaam) {
        this.straatnaam = straatnaam;
    }

    public Integer getHuisnummer() {
        return huisnummer;
    }

    public void setHuisnummer(Integer huisnummer) {
        this.huisnummer = huisnummer;
    }

    public String getWijk() {
        return wijk;
    }

    public void setWijk(String wijk) {
        this.wijk = wijk;
    }


    public String toString(){
        return this.straatnaam+" " + this.huisnummer+" in wijk " + this.wijk;

    }
}
