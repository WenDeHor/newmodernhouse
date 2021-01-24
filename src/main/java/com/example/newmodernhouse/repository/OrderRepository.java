package com.example.newmodernhouse.repository;

import com.example.newmodernhouse.models.Order;
import com.example.newmodernhouse.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public  interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllById(Long idUser);
//  List<Order> findAll(Optional<User> oneByEmail);
}
