package com.example.demo.controller;

import com.example.demo.request.CURDRequest;
import com.example.demo.response.CURDResponse;
import com.example.demo.service.CURDService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curd-app/v1")
public class CURDController {

    private static final Logger logger = LoggerFactory.getLogger(CURDController.class);

    @Autowired
    private CURDService curdService;

    @GetMapping()
    public ResponseEntity<List<CURDResponse>> getResources() {
        logger.info("Fetching Resources... ");
        return curdService.getResources();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CURDResponse> getResource(@PathVariable("id") Long id) {
        logger.info("Fetching resource with associated id : {}", id);
        return curdService.getResource(id);
    }

    @PostMapping("/create")
    public ResponseEntity<CURDResponse> createResource(@RequestBody CURDRequest curdRequest) {
        logger.info("Creating new resource with name: {}", curdRequest.name());
        return curdService.createResource(curdRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateResource(@PathVariable("id") Long id, @RequestBody CURDRequest curdRequest) {
        logger.info("Updating existing resource with name: {}", curdRequest.name());
        return curdService.updateResource(id, curdRequest);
    }

    @PatchMapping("/{id}")
    public ResponseEntity partialSave(@PathVariable("id") Long id, @RequestBody CURDRequest curdRequest) {
        logger.info("Performing partial update for resource with name: {}", curdRequest.name());
        return curdService.partialSave(id, curdRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteResource(@PathVariable("id") Long id) {
        logger.info("Deleting resource for id: ", id);
        return curdService.deleteResource(id);
    }
}
