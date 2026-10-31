package com.example.demo.service;

import com.example.demo.Entity.CURDEntity;
import com.example.demo.exception.CURDMappingException;
import com.example.demo.exception.CURDResourceNotFound;
import com.example.demo.mapper.CURDMapper;
import com.example.demo.repository.CURDRepo;
import com.example.demo.request.CURDRequest;
import com.example.demo.response.CURDResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class CURDServiceImpl implements CURDService {
    private final CURDRepo curdRepo;
    @Autowired(required=true)
    private CURDMapper mapper;

    public CURDServiceImpl(CURDRepo curdRepo) {
        this.curdRepo = curdRepo;
    }

    @Override
    public ResponseEntity<List<CURDResponse>> getResources() {
        List<CURDEntity> results = Optional.of(curdRepo.findAll())
                .orElseThrow(() -> new CURDResourceNotFound("Data is not available"));

        List<CURDResponse> responses = Optional.of(mapper.toDtoList(results))
                .orElseThrow(() -> new CURDMappingException("An internal error occurred while processing data transformation"));

        return ResponseEntity.status(HttpStatus.OK).body(responses);
    }

    @Override
    public ResponseEntity<CURDResponse> getResource(Long id) {

        CURDEntity result = curdRepo.findById(id)
                .orElseThrow(() -> new CURDResourceNotFound("Resource not found"));

        CURDResponse response = Optional.of(mapper.toDto(result))
                .orElseThrow(() -> new CURDMappingException("An internal error occurred while processing data transformation"));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    @Transactional
    public ResponseEntity<CURDResponse> createResource(CURDRequest curdRequest) {
        CURDEntity record = Optional.of(mapper.toEntity(curdRequest))
                .orElseThrow(() -> new CURDMappingException("An internal error occurred while processing data transformation"));

        CURDEntity savedRecord = curdRepo.save(record);
        CURDResponse response = Optional.of(mapper.toDto(savedRecord))
                .orElseThrow(() -> new CURDMappingException("An internal error occurred while processing data transformation"));

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    @Transactional
    public ResponseEntity<CURDResponse> updateResource(Long id, CURDRequest curdRequest) {
        CURDEntity record = curdRepo.findById(id)
                .orElseThrow(() -> new CURDResourceNotFound("Requested resource not found"));
        CURDResponse response = Optional.of(mapper.toDto(record))
                .orElseThrow(() -> new CURDResourceNotFound("Requested resource not found"));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    @Transactional
    public ResponseEntity<CURDResponse> partialSave(Long id, CURDRequest curdRequest) {
        CURDEntity record = curdRepo.findById(id)
                .orElseThrow(() -> new CURDResourceNotFound("Requested resource not found"));
        CURDResponse response = Optional.of(mapper.toDto(record))
                .orElseThrow(() -> new CURDResourceNotFound("Requested resource not found"));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    @Transactional
    public ResponseEntity<?> deleteResource(Long id) {
        curdRepo.findById(id)
                .orElseThrow(() -> new CURDResourceNotFound("Requested resource not found"));
        curdRepo.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of(
                "message", "",
                "Id", id,
                "Status", HttpStatus.OK
                ));
    }
}
