package com.pramudana.sam.edubanten.model;

/**
 * Created by abisayuti on 4/21/18.
 */

public class ModelCalon {
    private String id;
    private String gender;
    private String gender_wakil;
    private String job;
    private String job_wakil;
    private String nama_kepala_daerah;
    private String nama_wakil_kepala_daerah;
    private String partai_pendukung;
    private String provinsi;
    private String ttl;
    private String ttl_wakil;
    private String wilayah;

    public ModelCalon(String id, String gender, String gender_wakil, String job, String job_wakil,
                      String nama_kepala_daerah, String nama_wakil_kepala_daerah ,
                      String partai_pendukung, String provinsi, String ttl, String ttl_wakil,
                      String wilayah) {

        this.id = id;
        this.gender = gender;
        this.gender_wakil = gender_wakil;
        this.job = job;
        this.job_wakil = job_wakil;
        this.nama_kepala_daerah = nama_kepala_daerah;
        this.nama_wakil_kepala_daerah = nama_wakil_kepala_daerah;
        this.partai_pendukung = partai_pendukung;
        this.provinsi = provinsi;
        this.ttl = ttl;
        this.ttl_wakil = ttl_wakil;
        this.wilayah = wilayah;
    }

    public ModelCalon() {
        id="";
        gender="";
        gender_wakil="";
        job="";
        job_wakil="";
        nama_wakil_kepala_daerah="";
        nama_kepala_daerah="";
        partai_pendukung="";
        provinsi="";
        ttl="";
        ttl_wakil="";
        wilayah="";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender_wakil() {
        return gender_wakil;
    }

    public void setGender_wakil(String gender_wakil) {
        this.gender_wakil = gender_wakil;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getJob_wakil() {
        return job_wakil;
    }

    public void setJob_wakil(String job_wakil) {
        this.job_wakil = job_wakil;
    }

    public String getNama_kepala_daerah() {
        return nama_kepala_daerah;
    }

    public void setNama_kepala_daerah(String nama_kepala_daerah) {
        this.nama_kepala_daerah = nama_kepala_daerah;
    }

    public String getNama_wakil_kepala_daerah() {
        return nama_wakil_kepala_daerah;
    }

    public void setNama_wakil_kepala_daerah(String nama_wakil_kepala_daerah) {
        this.nama_wakil_kepala_daerah = nama_wakil_kepala_daerah;
    }

    public String getPartai_pendukung() {
        return partai_pendukung;
    }

    public void setPartai_pendukung(String partai_pendukung) {
        this.partai_pendukung = partai_pendukung;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public String getTtl_wakil() {
        return ttl_wakil;
    }

    public void setTtl_wakil(String ttl_wakil) {
        this.ttl_wakil = ttl_wakil;
    }

    public String getWilayah() {
        return wilayah;
    }

    public void setWilayah(String wilayah) {
        this.wilayah = wilayah;
    }


    }

