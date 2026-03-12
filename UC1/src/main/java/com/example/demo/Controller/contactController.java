package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.ContactDTO;
import com.example.demo.entity.Contact;
import com.example.demo.service.ContactService;

@RestController
@RequestMapping("/contacts")
public class contactController {

    @Autowired
    ContactService service;

    // UC1
    @PostMapping("/add")
    public String addContact(@RequestBody ContactDTO dto) {
        return service.addContact(dto);
    }

    // UC2
    @GetMapping
    public List<Contact> getContacts() {
        return service.getAllContacts();
    }

    // UC3
    @PutMapping("/edit/{name}")
    public String editContact(@PathVariable String name,
                              @RequestBody ContactDTO dto) {
        return service.editContact(name, dto);
    }

    // UC4
    @DeleteMapping("/delete/{name}")
    public String deleteContact(@PathVariable String name) {
        return service.deleteContact(name);
    }
}