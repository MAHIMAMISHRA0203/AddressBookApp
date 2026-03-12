package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ContactDTO;
import com.example.demo.entity.Contact;
import com.example.demo.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepository repository;

    // UC1 Add Contact
    public String addContact(ContactDTO dto) {

        Contact contact = new Contact(
                dto.firstName,
                dto.lastName,
                dto.address,
                dto.city,
                dto.state,
                dto.zip,
                dto.phoneNumber,
                dto.email
        );

        repository.save(contact);

        return "Contact Added Successfully";
    }

    // UC2 View Contacts
    public List<Contact> getAllContacts() {
        return repository.findAll();
    }

    // UC3 Edit Contact
    public String editContact(String name, ContactDTO dto) {

        Optional<Contact> optional = repository.findByFirstName(name);

        if(optional.isPresent()) {

            Contact contact = optional.get();

            contact.setLastName(dto.lastName);
            contact.setAddress(dto.address);
            contact.setCity(dto.city);
            contact.setState(dto.state);
            contact.setZip(dto.zip);
            contact.setPhoneNumber(dto.phoneNumber);
            contact.setEmail(dto.email);

            repository.save(contact);

            return "Contact Updated Successfully";
        }

        return "Contact Not Found";
    }

    // UC4 Delete Contact
    public String deleteContact(String name) {

        Optional<Contact> optional = repository.findByFirstName(name);

        if(optional.isPresent()) {

            repository.delete(optional.get());
            return "Contact Deleted Successfully";
        }

        return "Contact Not Found";
    }
}