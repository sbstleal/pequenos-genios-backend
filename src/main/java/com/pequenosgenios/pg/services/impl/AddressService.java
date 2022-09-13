package com.pequenosgenios.pg.services.impl;

import com.pequenosgenios.pg.domain.Address;
import com.pequenosgenios.pg.dto.AddressDTO;
import com.pequenosgenios.pg.repositories.AddressRepository;
import com.pequenosgenios.pg.services.Util;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    public AddressDTO insert(AddressDTO addressDTO) {
        Address model = new Address(addressDTO);
        model = this.addressRepository.save(model);
        addressDTO.setId(model.getId());
        return addressDTO;
    }

    @Transactional(rollbackFor = Exception.class)
    public AddressDTO update(Long id, AddressDTO addressDTO) {
        AddressDTO fromDatabase = this.findById(id);
        Util.myCopyProperties(addressDTO, fromDatabase);
        this.addressRepository.save(new Address(fromDatabase));
        return addressDTO;
    }

    @Transactional(readOnly = true)
    public AddressDTO findById(Long id) {
        Address model = this.addressRepository
                .findById(id).orElseThrow(() -> new RuntimeException("not found"));
        return new AddressDTO(model);
    }

}
