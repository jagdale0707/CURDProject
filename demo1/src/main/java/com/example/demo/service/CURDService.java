package com.example.demo.service;

import com.example.demo.request.CURDRequest;
import com.example.demo.response.CURDResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CURDService {
    ResponseEntity<List<CURDResponse>> getResources();

    ResponseEntity<CURDResponse> getResource(long id);

    ResponseEntity<CURDResponse> createResource(CURDRequest curdRequest);

    ResponseEntity updateResource(CURDRequest curdRequest);

    ResponseEntity partialSave(CURDRequest curdRequest);

    ResponseEntity deleteResouorce(long id);
}
