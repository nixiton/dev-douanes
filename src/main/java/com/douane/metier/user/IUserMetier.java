package com.douane.metier.user;

import java.util.Date;
import java.util.List;

import com.douane.entite.Agent;
import com.douane.entite.Bureau;
import com.douane.entite.Direction;
import com.douane.entite.OpAttribution;
import com.douane.entite.OpDettachement;
import com.douane.entite.OpEntree;
import com.douane.entite.OpSortie;
import com.douane.entite.Operation;
import com.douane.entite.Service;
import com.douane.entite.Materiel;
import com.douane.entite.MaterielNouv;
import com.douane.entite.MotifSortie;
import com.douane.entite.Nomenclature;
import com.douane.entite.Useri;
import com.douane.entite.Useri;

public interface IUserMetier {
	public Useri addUser(Useri u);
	public List<Useri> listUser();
	public void remUser(Useri u);
	
	public Agent addAgent(Agent a);
	public void remAgent (Agent a);
	
	//temporary
	public List<Agent> findAllAgents();
	
	public Agent addAgentUser(Agent a, Useri u);
	public List<Agent> findAgentByNom(String name);
	public Agent findAgentByIm (Long im_agent);
	
	//les requetes
	public OpEntree reqEntrerMateriel(Materiel m, Agent dc);
	public OpSortie reqSortirMateriel(Materiel m, MotifSortie motif, Direction d, Service s, Bureau b, Agent op)throws Exception;
	
	public OpAttribution reqAttribution(Materiel m, Agent oper, Agent detenteur) throws Exception;
	
	public OpDettachement reqDettachement(Materiel mat1, Agent agent2, Agent agent1)throws Exception;
	//les validations
	
	public Materiel entrerMateriel(OpEntree op);
	public Materiel sortirMateriel(OpSortie sortie) throws Exception;
	
	
	public OpEntree reqMatAModifier(OpEntree entree, String motif)throws Exception;
	public OpSortie reqSortirAModifier(OpSortie sort, String motif);
	public OpEntree reqMatRefuser(OpEntree entree, String string)throws Exception;
	public OpSortie reqSortirRefuser(OpSortie sortie, String string);
	
	public Agent detacherMateriel(OpDettachement det);
	public OpDettachement reqDetRefuser(OpDettachement det, String string);
	
	
	//public Materiel attriuberMateriel (Long idMat, Long im);
	//public Materiel attriuberMateriel (Materiel m, Agent d);
	public Materiel attriuberMateriel(OpAttribution attr);
	public OpAttribution reqAttrAModifier(OpAttribution attr, String motif)throws Exception;
	public OpAttribution reqAttrRefuser(OpAttribution attr, String motif)throws Exception;
	
	
	//public Materiel dettacherMateriel (Materiel m);
	public void delMat(Materiel m);
	
	
	/*
	 * GETTERS
	 * 
	 */
	public Materiel getMatById(Long idmat);
	public List<Materiel> getListMatByDet(Agent detenteur);
	public List<Materiel> getListMatByNom(Nomenclature nomenclature);
	public List<Materiel> getListMatByDirection(Direction direction);
	public List<Materiel> getListMatByService(Service service);
	public List<Materiel> getListMatByBureau(Bureau bureau);
	public List<Materiel> getListMat();
	
	public List<Operation> getListOp();
	public List<OpEntree> getListOpEntree();
	public List<OpSortie> getListOpSortie();
	
	public List<Operation> getListOpByOperator(Agent operator);
	public List<OpEntree> getListOpEntreeByOperator(Agent operator);
	public List<OpSortie> getListOpSortieByOperator(Agent operator);
	public List<Operation> getListOpByDirection(Direction direction);
	public List<OpEntree> getListOpEntreeByDirection(Direction direction);
	public List<OpSortie> getListOpSortieByDirection(Direction direction);
	
	public List<Operation> getListOpBetween(Date startDate, Date endDate);
	public List<OpEntree> getListOpEntreeByMat(Materiel m);
	public List<OpSortie> getListOpSortieByMat(Materiel m);
	
	public List<OpEntree> getListOpEntreeByMatBDate(Materiel m, Date startDate, Date endDate);
	public List<OpSortie> getListOpSortieByMatBDate(Materiel m, Date startDate, Date endDate);
	/**
	 * Affichage
	 */
	public void seeMat(Materiel m);
	public void seeAgent(Agent a);
	
	
	
	
		
	
	 
}
