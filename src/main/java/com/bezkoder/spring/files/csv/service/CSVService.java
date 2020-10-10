package com.bezkoder.spring.files.csv.service;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.files.csv.helper.CSVHelper;
import com.bezkoder.spring.files.csv.model.Tutorial;
import com.bezkoder.spring.files.csv.repository.TutorialRepository;

@Service
public class CSVService {

  @Autowired
  TutorialRepository repository;
  
  public ByteArrayInputStream load() {
    List<Tutorial> tutorials = repository.findAll();

    ByteArrayInputStream in = CSVHelper.tutorialsToCSV(tutorials);
    return in;
  }
}
