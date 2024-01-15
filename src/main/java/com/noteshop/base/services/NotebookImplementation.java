package com.noteshop.base.services;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.noteshop.base.Repo.NotebookRepository;
import com.noteshop.base.models.Notebook;

@Component
public class NotebookImplementation implements INotebook{
    private NotebookRepository notebooks;

    public NotebookImplementation(NotebookRepository repository){
        this.notebooks = repository;
    }

    @Override
    public ArrayList<Notebook> getNotebooks() {
        return (ArrayList<Notebook>) notebooks.findAll();
    }

    @Override
    public boolean addNotebook(Notebook notebook) {
        if(notebook == null){
            return false;
        }
        Notebook result = notebooks.save(notebook);
        return result != null;
    }

    @Override
    public void removeNotebook(Notebook notebook) {
        if(notebook != null){
            notebooks.delete(notebook);
        }
    }

    @Override
    public Notebook gNotebook(Integer id) {
        if(id == null){
            return null;
        }
        return notebooks.findById(id).get();
    }
    
}
