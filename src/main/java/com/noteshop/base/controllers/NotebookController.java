package com.noteshop.base.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.noteshop.base.models.Notebook;
import com.noteshop.base.services.NotebookImplementation;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
@RequestMapping("/base")
public class NotebookController {
    private NotebookImplementation notebooks;

    public NotebookController(NotebookImplementation implementation){
        this.notebooks = implementation;
    }

    @GetMapping("/getnotebooks")
    public ArrayList<Notebook> getNotebooks() {
        return notebooks.getNotebooks();
    }
    
    @GetMapping("/getnotebook/{id}")
    public ResponseEntity<Notebook> getNotebook(@PathVariable(name="id") int id) {
        Notebook result =  notebooks.gNotebook(id);
        return result == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(result,HttpStatus.OK);
    }

    @PostMapping("/addnotebook")
    public ResponseEntity<HttpStatus> addNotebook(@RequestBody Notebook notebook) {
        return notebooks.addNotebook(notebook) ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    
    @DeleteMapping("/removenotebook")
    public ResponseEntity<HttpStatus> removeNotebook(@RequestBody Notebook notebook){
        notebooks.removeNotebook(notebook);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
