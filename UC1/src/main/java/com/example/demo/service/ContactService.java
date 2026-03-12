package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ContactDTO;
import com.example.demo.entity.Contact;

public interface ContactService {

    Contact createContact(ContactDTO contactDTO);

    List<Contact> getAllContacts();

    Contact updateContact(Long id, ContactDTO contactDTO);

    void deleteContact(Long id);
}