package com.tombari.observabilityspringboot.model;

public record Users(Integer id, String name, String company, String username, String email, String address, String zip, String state, String country, String phone) {
}
