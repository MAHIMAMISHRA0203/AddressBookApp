package com.example.demo;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.dto.ContactDTO;
import com.example.demo.service.ContactService;

@Component
public class Uc1Application implements CommandLineRunner {

    @Autowired
    ContactService service;

    public void run(String... args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("1. Add Contact");
        System.out.println("2. Delete Contact");

        int choice = sc.nextInt();
        sc.nextLine();

        if(choice == 1) {

            ContactDTO dto = new ContactDTO();

            System.out.println("First Name:");
            dto.firstName = sc.nextLine();

            System.out.println("Last Name:");
            dto.lastName = sc.nextLine();

            System.out.println("Address:");
            dto.address = sc.nextLine();

            System.out.println("City:");
            dto.city = sc.nextLine();

            System.out.println("State:");
            dto.state = sc.nextLine();

            System.out.println("Zip:");
            dto.zip = sc.nextLine();

            System.out.println("Phone:");
            dto.phoneNumber = sc.nextLine();

            System.out.println("Email:");
            dto.email = sc.nextLine();

            System.out.println(service.addContact(dto));
        }

        if(choice == 2) {

            System.out.println("Enter name to delete:");
            String name = sc.nextLine();

            System.out.println(service.deleteContact(name));
        }

        sc.close();
    }
}