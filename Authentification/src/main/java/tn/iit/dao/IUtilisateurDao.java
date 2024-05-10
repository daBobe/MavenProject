package tn.iit.dao;

import java.util.List;

import tn.iit.glid23.auth.model.UtilisateurModel;

public interface IUtilisateurDao {
	UtilisateurModel getByLoginPdw(String email, String password);
	List<UtilisateurModel> findAll();
	void save(UtilisateurModel u);
}
