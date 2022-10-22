package com.demo.nasabahapps.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "tb_nasabah")
public class Nasabah {

    @Id
    int id;
    String nama;
    String tempatLahir;
    String tanggalLahir;
    String alamat;
    int penghasilan;
    String jenisNasabah;
    int idCustomer;

    //
}
