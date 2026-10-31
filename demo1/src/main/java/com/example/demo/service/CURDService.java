package com.example.demo.service;

import com.example.demo.request.CURDRequest;
import com.example.demo.response.CURDResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CURDService {
    ResponseEntity<List<CURDResponse>> getResources();

    ResponseEntity<CURDResponse> getResource(Long id);

    ResponseEntity<CURDResponse> createResource(CURDRequest curdRequest);

    ResponseEntity<CURDResponse> updateResource(Long id, CURDRequest curdRequest);

    ResponseEntity<CURDResponse> partialSave(Long id, CURDRequest curdRequest);

    ResponseEntity<?> deleteResource(Long id);
}
