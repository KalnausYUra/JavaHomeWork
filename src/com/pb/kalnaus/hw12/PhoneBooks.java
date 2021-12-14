package com.pb.kalnaus.hw12;


import java.time.LocalDate;
import java.util.Arrays;

public class PhoneBooks {
    private String f_I_O;
    private LocalDate b_Day;
    private int[] phones;
    private String address;
    private String date_edit;

    public PhoneBooks() {
    }

    public PhoneBooks(String f_I_O, LocalDate b_Day, int[] phones, String address, String date_edit) {
        this.f_I_O = f_I_O;
        this.b_Day = b_Day;
        this.phones = phones;
        this.address = address;
        this.date_edit = date_edit;
    }

    @Override
    public String toString() {
        return "\n" + " PhoneBooks{" +
                "f_I_O='" + f_I_O + '\'' +
                ", b_Day=" + b_Day +
                ", phones=" + Arrays.toString(phones) +
                ", address='" + address + '\'' +
                ", change time='" + date_edit + '\'' +
                '}';
    }


    public String getF_I_O() {
        return f_I_O;
    }

    public void setF_I_O(String f_I_O) {
        this.f_I_O = f_I_O;
    }

    public LocalDate getB_Day() {
        return b_Day;
    }

    public void setB_Day(LocalDate b_Day) {
        this.b_Day = b_Day;
    }

    public int[] getPhones() {
        return phones;
    }


    public void setPhones(int[] phones) {
        this.phones = phones;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate_edit() {
        return date_edit;
    }

    public void setDate_edit(String date_edit) {
        this.date_edit = date_edit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhoneBooks)) return false;

        PhoneBooks that = (PhoneBooks) o;

        if (getF_I_O() != null ? !getF_I_O().equals(that.getF_I_O()) : that.getF_I_O() != null) return false;
        if (getB_Day() != null ? !getB_Day().equals(that.getB_Day()) : that.getB_Day() != null) return false;
        if (!Arrays.equals(getPhones(), that.getPhones())) return false;
        if (getAddress() != null ? !getAddress().equals(that.getAddress()) : that.getAddress() != null) return false;
        return getDate_edit() != null ? getDate_edit().equals(that.getDate_edit()) : that.getDate_edit() == null;
    }

    @Override
    public int hashCode() {
        int result = getF_I_O() != null ? getF_I_O().hashCode() : 0;
        result = 31 * result + (getB_Day() != null ? getB_Day().hashCode() : 0);
        result = 31 * result + Arrays.hashCode(getPhones());
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        result = 31 * result + (getDate_edit() != null ? getDate_edit().hashCode() : 0);
        return result;
    }
}





