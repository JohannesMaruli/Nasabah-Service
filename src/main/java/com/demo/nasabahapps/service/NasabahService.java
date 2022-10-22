package com.demo.nasabahapps.service;

import com.demo.nasabahapps.model.Nasabah;

import java.util.List;

public interface NasabahService {

    List<Nasabah> getAllNasabah();

    void save(Nasabah ns);

    void update(Nasabah ns);

    Nasabah getNasabahById(int id);

    void deleteById(int id);

}
