package com.douane.dao.referentiel;

import java.util.List;

import com.douane.entite.Referentiel;

public interface IRefDAO {
	//public Referentiel addRef(Referentiel r);
	public List<Referentiel> listRef(Referentiel r);
	//public void delRef(Referentiel ref);
}
