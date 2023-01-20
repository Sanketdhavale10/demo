package com.usercase.resource.Services;


import com.usercase.resource.dao.caseRepository;
import com.usercase.resource.model.Case;
import com.usercase.resource.model.Note;
import com.usercase.resource.model.User;
import com.usercase.resource.services.caseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class serviceTests {

    @InjectMocks
    caseService service;

    @Mock
    caseRepository dao;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllCases()
    {
        List<Case> list = new ArrayList<Case>();
      //  String title, String description, Integer severity, Case.Status status, User user, List< Note > notes
        Case caseOne = new Case("Case1","casedesc1",1,Case.Status.OPEN);
        Case caseTwo = new Case("Case2","casedesc2",2,Case.Status.OPEN);
        Case caseThree = new Case("Case3","casedesc3",1,Case.Status.CLOSED);

        list.add(caseOne);
        list.add(caseTwo);
        list.add(caseThree);

        when(dao.findAll()).thenReturn(list);

        //test
        List<Case> empList = service.findAll();

        assertEquals(3, empList.size());
        verify(dao, times(1)).findAll();
    }

    @Test
    void testCreateOrSaveEmployee()
    {
        Case newcase =  new Case("Case1","casedesc1",1,Case.Status.OPEN);

        service.save(newcase);

        verify(dao, times(1)).save(newcase);
    }


}
