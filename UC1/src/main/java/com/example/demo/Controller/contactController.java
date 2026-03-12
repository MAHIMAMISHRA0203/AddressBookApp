package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ContactDTO;
import com.example.demo.entity.Contact;
import com.example.demo.service.ContactService;

@RestController
@RequestMapping("/contacts")
public class contactController {

    @Autowired
    private ContactService service;

    @PostMapping
    public Contact createContact(@RequestBody ContactDTO dto) {
        return service.createContact(dto);
    }

    @GetMapping
    public List<Contact> getContacts() {
        return service.getAllContacts();
    }
}
