package com.example.demo.service;

import com.example.demo.repository.CURDRepo;
import com.example.demo.request.CURDRequest;
import com.example.demo.response.CURDResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CURDServiceImpl implements CURDService {
    private CURDRepo curdRepo;

    public CURDServiceImpl(CURDRepo curdRepo){
        this.curdRepo = curdRepo;
    }

    @Override
    public ResponseEntity<List<CURDResponse>> getResources() {
        return null;
    }

    @Override
    public ResponseEntity<CURDResponse> getResource(long id) {
        return null;
    }

    @Override
    public ResponseEntity<CURDResponse> createResource(CURDRequest curdRequest) {
        return null;
    }

    @Override
    public ResponseEntity updateResource(CURDRequest curdRequest) {
        return null;
    }

    @Override
    public ResponseEntity partialSave(CURDRequest curdRequest) {
        return null;
    }

    @Override
    public ResponseEntity deleteResouorce(long id) {
        return null;
    }
}
