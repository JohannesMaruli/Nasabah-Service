package com.demo.nasabahapps.repo;

import com.demo.nasabahapps.model.Nasabah;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NasabahRepo extends JpaRepository<Nasabah, Integer> {

    Nasabah findByIdCustomer(int idCustomer);

    Nasabah findNasabahById(int id);


}
