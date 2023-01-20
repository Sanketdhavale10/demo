package com.usercase.resource.controller;

import com.usercase.resource.model.Case;
import com.usercase.resource.model.Note;
import com.usercase.resource.services.caseService;
import com.usercase.resource.services.noteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public
class CaseResource {

    @Autowired
    caseService caseservice;

    @Autowired
    noteService noteservice;

    public CaseResource() {
    }

    @GetMapping("/cases/status/{status}")
    List<Case> getCasesWithStatus(@PathVariable Case.Status status) {
        // TODO: Query for cases with a specified status.
        return caseservice.findByStatus(status);
    }

    @GetMapping("/cases/user/{userId}")
    List<Case> getOpenCases(@PathVariable Integer userId) {
        // TODO: Query for cases with a userId;
        return caseservice.findByUserID(userId);
    }

    @GetMapping("/cases/user/{userId}/status/{status}")
    List<Case> getOpenCases(@PathVariable Integer userId, @PathVariable
    Case.Status status) {
        // TODO: Query for cases with a userId and status
        return caseservice.findByUserIDandStatus(userId,status);
    }

    @GetMapping("/case/{caseId}")
    Case getCase(@PathVariable Integer caseId) {
        // TODO: Get a case by ID
        return caseservice.findById(caseId);
    }

    @PostMapping(value = "/case/create", consumes = "application/json")
    Case createCase(@RequestBody Case toCreate) {
        // TODO: Create a case and any associated records (user, notes)
       // return caseService.save(toCreate);
        return caseservice.save(toCreate);
    }

    @PostMapping(value = "/case/{caseId}/addNote", consumes = "text/plain")
    Note addNote(@PathVariable Integer caseId, @RequestBody String detail) {
        // TODO: Create a note for the specified case
        return noteservice.save(caseId,detail);
    }
}