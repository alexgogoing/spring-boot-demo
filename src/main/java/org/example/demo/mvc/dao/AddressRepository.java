package org.example.demo.mvc.dao;

import org.example.demo.mvc.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    @Query(value = "SELECT * FROM address ORDER BY time DESC LIMIT 1", nativeQuery = true)
    List<Address> getLatestOne();
}
