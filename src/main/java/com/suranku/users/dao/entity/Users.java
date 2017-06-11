package com.suranku.users.dao.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users", schema = "ssntdc")
public class Users {

    @Id
    @Column(name = "user_id")
    @Getter
    @Setter
    private Integer userId;

    @Column(name = "login")
    @Getter
    @Setter
    private String login;

    @Column(name = "first_name")
    @Getter
    @Setter
    private String firstName;

    @Column(name = "last_name")
    @Getter
    @Setter
    private String lastName;

    @Column(name = "title")
    @Getter
    @Setter
    private String title;

    @Column(name = "organization")
    @Getter
    @Setter
    private String organization;

    @Column(name = "home_phone_num")
    @Getter
    @Setter
    private Integer homePhoneNum;

    @Column(name = "email1")
    @Getter
    @Setter
    private String email1;

    @Column(name = "email2")
    @Getter
    @Setter
    private String email2;

    @Column(name = "cell_phone_num")
    @Getter
    @Setter
    private Integer cellPhoneNum;

    @Column(name = "work_phone_num")
    @Getter
    @Setter
    private Integer workPhoneNum;

    @Column(name = "work_phon_ext")
    @Getter
    @Setter
    private Integer workPhoneExt;

    @Column(name = "address1")
    @Getter
    @Setter
    private String address1;

    @Column(name = "address2")
    @Getter
    @Setter
    private String address2;

    @Column(name = "zipcode")
    @Getter
    @Setter
    private Integer zipcode;

    @Column(name = "city")
    @Getter
    @Setter
    private String city;

    @Column(name = "state")
    @Getter
    @Setter
    private String state;

    @Column(name = "country")
    @Getter
    @Setter
    private String country;

    @Column(name = "active_flag")
    @Getter
    @Setter
    private String activeFlag;

    @Column(name = "program_id")
    @Getter
    @Setter
    private Integer programId;

    @Column(name = "created_by")
    @Getter
    @Setter
    private String createdBy;

    @Column(name = "created_tmst")
    @Getter
    @Setter
    private Timestamp createdTmst;

    @Column(name = "modified_by")
    @Getter
    @Setter
    private String modifiedBy;

    @Column(name = "modified_tmst")
    @Getter
    @Setter
    private Timestamp modifiedTmst;

}
