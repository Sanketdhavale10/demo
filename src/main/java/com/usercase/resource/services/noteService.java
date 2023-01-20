package com.usercase.resource.services;

import com.usercase.resource.dao.noteRepository;
import com.usercase.resource.handlers.RecordNotFoundException;

import com.usercase.resource.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class noteService {

    @Autowired
    noteRepository noterepository;

    public Note save(Integer caseId, String detail){

        Note note=new Note();
        note.setCaseId(caseId);
        note.setDetails(detail);

      return   noterepository.save(note);


    }


}
