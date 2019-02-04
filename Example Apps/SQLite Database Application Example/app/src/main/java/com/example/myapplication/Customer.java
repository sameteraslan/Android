package com.example.myapplication;

public class Customer {

    String customer_name, company_name, country, city, travel_dates, record_date, kind_of_room, guests, customer_phone, notes, month, hotel_name, booking_number;
    int exchange_rate, brutto, netto, company_commission, your_commission, id;

    public Customer(String customer_name, String company_name, String country, String city, String travel_dates, String record_date, String kind_of_room, String guests, String customer_phone, String notes, String month, String hotel_name, int exchange_rate, int brutto, int netto, int company_commission, int your_commission, String booking_number) {
        this.customer_name = customer_name;
        this.company_name = company_name;
        this.country = country;
        this.city = city;
        this.travel_dates = travel_dates;
        this.record_date = record_date;
        this.kind_of_room = kind_of_room;
        this.guests = guests;
        this.customer_phone = customer_phone;
        this.notes = notes;
        this.month = month;
        this.hotel_name = hotel_name;
        this.exchange_rate = exchange_rate;
        this.brutto = brutto;
        this.netto = netto;
        this.company_commission = company_commission;
        this.your_commission = your_commission;
        this.booking_number = booking_number;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getBooking_number() {
        return booking_number;
    }

    public void setBooking_number(String booking_number) {
        this.booking_number = booking_number;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(String customer_phone) {
        this.customer_phone = customer_phone;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTravel_dates() {
        return travel_dates;
    }

    public void setTravel_dates(String travel_dates) {
        this.travel_dates = travel_dates;
    }

    public String getRecord_date() {
        return record_date;
    }

    public void setRecord_date(String record_date) {
        this.record_date = record_date;
    }

    public String getKind_of_room() {
        return kind_of_room;
    }

    public void setKind_of_room(String kind_of_room) {
        this.kind_of_room = kind_of_room;
    }

    public String getGuests() {
        return guests;
    }

    public void setGuests(String guests) {
        this.guests = guests;
    }

    public int getExchange_rate() {
        return exchange_rate;
    }

    public void setExchange_rate(int exchange_rate) {
        this.exchange_rate = exchange_rate;
    }

    public int getBrutto() {
        return brutto;
    }

    public void setBrutto(int brutto) {
        this.brutto = brutto;
    }

    public int getNetto() {
        return netto;
    }

    public void setNetto(int netto) {
        this.netto = netto;
    }

    public int getCompany_commission() {
        return company_commission;
    }

    public void setCompany_commission(int company_commission) {
        this.company_commission = company_commission;
    }

    public int getYour_commission() {
        return your_commission;
    }

    public void setYour_commission(int your_commission) {
        this.your_commission = your_commission;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
