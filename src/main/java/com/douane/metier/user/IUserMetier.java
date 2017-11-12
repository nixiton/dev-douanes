package com.douane.metier.user;

import java.util.Date;
import java.util.List;

import com.douane.entite.*;
import com.douane.entite.Useri;

public interface IUserMetier {
	public Useri addUser(Useri u);

	public void remUser(Useri u);

	public Agent addAgent(Agent a);
	public void remAgent (Agent a);



	public Agent addAgentUser(Agent a, Useri u);

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
	public List<MaterielEx> getListMatEx();
	public List<MaterielNouv> getListMatNouv();
	public List<Materiel> getMatByValidation(boolean validation);
	public List<Materiel> getMatByDetenteurAndValidation(Agent detenteur,boolean validation);

	public List<Operation> getListOp();
	public List<OpEntree> getListOpEntree();
	public List<OpSortie> getListOpSortie();


	public List<OpAttribution> getListOpAttribution();
	public List<OpDettachement> getListOpDettachement();

	public List<Operation> getListOpByOperator(Agent operator);
	public List<OpEntree> getListOpEntreeByOperator(Agent operator);
	public List<OpSortie> getListOpSortieByOperator(Agent operator);

	public List<Operation> getListOpByDirection(Direction direction);
	public List<OpEntree> getListOpEntreeByDirection(Direction direction);
	public List<OpSortie> getListOpSortieByDirection(Direction direction);

	public List<OpAttribution> getListOpAttrByOperator(Agent operator);
	public List<OpDettachement> getListOpDettByOperatort(Agent operator);
	public List<OpAttribution> getListOpAttrByDirection(Direction direction);
	public List<OpDettachement> getListOpDettByDirection(Direction direction);


	public List<Operation> getListOpBetween(Date startDate, Date endDate);
	public List<OpEntree> getListOpEntreeByMat(Materiel m);
	public List<OpSortie> getListOpSortieByMat(Materiel m);

	public List<OpAttribution> getListOpAttrByMat(Materiel m);
	public List<OpDettachement> getListOpDettByMat(Materiel m);

	public List<OpEntree> getListOpEntreeByMatBDate(Materiel m, Date startDate, Date endDate);
	public List<OpSortie> getListOpSortieByMatBDate(Materiel m, Date startDate, Date endDate);


	public List<Useri> listUser();
	//temporary
	public List<Agent> findAllAgents();
	public List<Agent> findAgentByNom(String name);
	public List<Agent> listAgentByDirection(Direction direction);
	/**
	 * Affichage
	 */
	public void seeMat(Materiel m);
	public void seeAgent(Agent a);


	//FOR CA
	public CodeArticle addCodeArticle(CodeArticle codeArticle);
	public void removeCodeArticle(CodeArticle codearticle);
	public List<CodeArticle> listCodeArticle();
	public List<CodeArticle> listCodeArticleByTypeObj(TypeObjet typeObj);

	public OpEntreeArticle reqEntrerArticle(Article article, Agent dc);
	public OpSortieArticle reqSortirArticle(Article article, Agent op, Agent destinataire)throws Exception;


	public OpEntreeArticle reqArtAModifier(OpEntreeArticle entreeArt, String motif)throws Exception;
	public OpSortieArticle reqSortirArtAModifier(OpSortieArticle sortArt, String motif) throws Exception;
	public OpEntreeArticle reqArtRefuser(OpEntreeArticle entreeArt, String motif)throws Exception;
	public OpSortieArticle reqSortirRefuser(OpSortieArticle sortArt, String motif)throws Exception;



	public Article entrerArticle(OpEntreeArticle opentreeart);
	public Article sortirArticle(OpSortieArticle sortieart) throws Exception;








}
