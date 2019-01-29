package com.draper.tuscany_core.model;


import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private long id;

    private long createAt;

    private long updateAt;

    private String name;

    private String phone;

    private String email;

    private String password;

}
