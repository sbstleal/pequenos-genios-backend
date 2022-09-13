package com.pequenosgenios.pg.repositories;

import com.pequenosgenios.pg.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
