package com.spring.project.Repo.DAL;


import com.spring.project.Data.CarteBancaire;

public interface RepositoryCarteBancaireInterface {
	public void add(CarteBancaire obj);
    public CarteBancaire find(String id);
    public void delete(CarteBancaire obj);
    public void update(CarteBancaire obj);

}
