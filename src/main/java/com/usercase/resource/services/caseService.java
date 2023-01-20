package com.usercase.resource.services;

import com.usercase.resource.dao.caseRepository;
import com.usercase.resource.handlers.RecordNotFoundException;
import com.usercase.resource.model.Case;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class caseService {

    @Autowired
    caseRepository caserepository;

    public Case save(Case cases){

        if(cases.getCaseId()== null) {
            cases = caserepository.save(cases);
            return cases;
        }else {
            Optional<Case> caseOptional = caserepository.findById(cases.getCaseId());

            if (caseOptional.isPresent()) {
                Case newEntity = caseOptional.get();
                newEntity.setDescription(cases.getDescription());
                newEntity.setNotes(cases.getNotes());
                newEntity.setStatus(cases.getStatus());
                newEntity.setTitle(cases.getTitle());
                newEntity.setSeverity(cases.getSeverity());
                newEntity.setUser(cases.getUser());
                newEntity = caserepository.save(newEntity);

                return newEntity;
            } else {
                throw new RecordNotFoundException("No Case record exist for given case id");
            }
        }

    }
    public List<Case> findAll() {
        List<Case> result = (List<Case>) caserepository.findAll();

        if (result.size() > 0) {
            return result;
        } else {
            return new ArrayList<Case>();
        }
    }
    public List<Case> findByStatus(Case.Status status ){

        return caserepository.findByStatus(status);

    }
    public List<Case> findByUserID(Integer userId ){

        return caserepository.findByUserId(userId);

    }
    public List<Case> findByUserIDandStatus(Integer userId,Case.Status status ){

        return caserepository.findByUserIdAndStatus(userId,status);

    }
    public Case findById(Integer caseid ){

        Optional<Case> list=  caserepository.findById(caseid);
        if (list.isPresent()) {
            return list.get();
        } else {
            throw new RecordNotFoundException("No case record exist for given id");
        }
    }

}
