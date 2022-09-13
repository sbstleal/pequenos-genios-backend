package com.pequenosgenios.pg.services.impl;

import com.pequenosgenios.pg.domain.Class;
import com.pequenosgenios.pg.dto.ClassDTO;
import com.pequenosgenios.pg.repositories.ClassRepository;
import com.pequenosgenios.pg.services.Util;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClassService {
    private final ClassRepository classRepository;

    public ClassService(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    public ClassDTO insert(ClassDTO classDTO) {
        Class model = new Class(classDTO);
        model = this.classRepository.save(model);
        classDTO.setId(model.getId());
        return classDTO;
    }

    @Transactional(readOnly = true)
    public Page<ClassDTO> findAll(Pageable pageable) {
        return this.classRepository.findAll(pageable).map(ClassDTO::new);
    }

    @Transactional(readOnly = true)
    public ClassDTO findById(Long id) {
        return new ClassDTO(this.findModel(id));
    }

    @Transactional(rollbackFor = Exception.class)
    public ClassDTO update(Long id, ClassDTO classDTO) {
        ClassDTO fromDatabase =this.findById(id);
        Util.myCopyProperties(classDTO, fromDatabase);
        this.classRepository.save(new Class(fromDatabase));
        return classDTO;
    }

    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        this.classRepository.delete(this.findModel(id));
    }

    protected Class findModel(Long id) {
        return this.classRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("not found"));
    }

}
