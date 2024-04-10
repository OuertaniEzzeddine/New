package com.example.demo.Users.Service;

import com.example.demo.Users.Models.Admin;

import java.util.List;

public interface AdminService {

    List<Admin> getAllAdmins();

    Admin getAdminById(Long id);

    Admin createAdmin(Admin admin);

    Admin updateAdmin(Long id, Admin admin);

    void deleteAdmin(Long id);
}
