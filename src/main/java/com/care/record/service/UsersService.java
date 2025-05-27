package com.care.record.service;

import com.care.record.domain.Users;
import com.care.record.repository.UsersRepository;

import java.util.List;
import java.util.Optional;

public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
    public Users save(Users users) {
        return usersRepository.save(users);
    }
    public Optional<Users> findByEmail(String email) {
        return usersRepository.findByEmail(email);
    }
    public List<Users> findAll() {
        return usersRepository.findAll();
    }
    public Optional<Users> findById(Long id) {
        return usersRepository.findById(id);
    }

    public void delete(Long users) {
        usersRepository.delete(users);
    }

}
