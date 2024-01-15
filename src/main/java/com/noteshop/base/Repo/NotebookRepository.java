package com.noteshop.base.Repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.noteshop.base.models.Notebook;

@Repository
public interface NotebookRepository extends CrudRepository<Notebook, Integer>{
    
}
