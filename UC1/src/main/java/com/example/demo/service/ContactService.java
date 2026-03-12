package com.example.demo.service;

import java.util.List;
import com.example.demo.dto.ContactDTO;
import com.example.demo.entity.Contact;

public interface ContactService {

    String addContact(ContactDTO dto);      // UC1

    List<Contact> getAllContacts();         // UC2

    String editContact(String name, ContactDTO dto);  // UC3

    String deleteContact(String name);      // UC4
}