package com.example.newmodernhouse.repository;

import com.example.newmodernhouse.models.Bot;
import com.example.newmodernhouse.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BotRepository extends JpaRepository<Bot, Long> {

}
