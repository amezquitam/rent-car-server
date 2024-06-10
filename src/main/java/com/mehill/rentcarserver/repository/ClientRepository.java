package com.mehill.rentcarserver.repository;

import com.mehill.rentcarserver.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
