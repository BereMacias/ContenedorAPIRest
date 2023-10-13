package com.example.helados.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.helados.entity.Helado;

public interface HeladoRepository extends JpaRepository<Helado, Long> {

}
