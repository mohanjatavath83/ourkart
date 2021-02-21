package com.ourkart.model;

import javax.persistence.Entity;

@Entity
public class EmployeeModel extends UserModel{

    double salary;
    boolean isManager;
}
