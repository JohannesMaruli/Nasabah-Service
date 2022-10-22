package com.demo.nasabahapps.service;

import com.demo.nasabahapps.model.Nasabah;
import com.demo.nasabahapps.repo.NasabahRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class NasabahServiceImpl implements NasabahService {

    @Autowired
    private NasabahRepo nsRepo;

    @Override
    public List<Nasabah> getAllNasabah() {
        return nsRepo.findAll();
    }

    @Override
    public void save(Nasabah ns) {
        Nasabah nsa = nsRepo.findByIdCustomer(ns.getIdCustomer());
        if (nsa == null) {
            Random ran = new Random();
            int genId = ran.nextInt(9999);
            ns.setId(genId);
            nsRepo.save(ns);
        }
    }

    @Override
    public void update(Nasabah ns) {
        Nasabah nsa = nsRepo.findNasabahById(ns.getId());
        nsa.setId(ns.getId());
        nsa.setNama(ns.getNama());
        nsa.setTempatLahir(ns.getTempatLahir());
        nsa.setTanggalLahir(ns.getTanggalLahir());
        nsa.setAlamat(ns.getAlamat());
        nsa.setPenghasilan(ns.getPenghasilan());
        nsa.setJenisNasabah(ns.getJenisNasabah());
        nsa.setIdCustomer(ns.getIdCustomer());
        nsRepo.save(nsa);
    }

    @Override
    public Nasabah getNasabahById(int id) {
        Optional<Nasabah> optional = nsRepo.findById(id);
        Nasabah ns = null;
        if (optional.isPresent()) {
            ns = optional.get();
        } else {
            throw new RuntimeException("Nasabah not found for id :: " + id);
        }
        return ns;
    }

    @Override
    public void deleteById(int id) {
        this.nsRepo.deleteById(id);
    }


}
