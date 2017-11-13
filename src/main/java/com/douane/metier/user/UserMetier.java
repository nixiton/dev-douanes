package com.douane.metier.user;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedProperty;

import com.douane.entite.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.douane.repository.*;

import come.douane.dao.operation.IOperationDAO;

@Transactional
public class UserMetier implements IUserMetier{

	@Autowired
	private UserRepository userrepos;
	@Autowired
	private AgentRepository agentrepos;
	@Autowired
	private MaterielRepository matrepos;

	@Autowired
	private MaterielExRepository materielExRepository;

	@Autowired
	private MaterielNouvRepository materielNouvRepository;

	@Autowired
	private OpRepository oprepos;

	@Autowired
	private OpEntreeRepository opentreerepos;

	@Autowired
	private OpSortieRepository opsortierepos;

	@Autowired
	private OpAttrRepository opattrrepos;

	@Autowired
	private OpDettRepository opdettrepos;

	@Autowired
	private CodeArticleRepository codeartrepos;

	@Autowired
	private ArticleRepository artreops;

	@Autowired
	private OpEnArtRepository opentreeartrepos;

	@Autowired
	private OpSortArtRepository opsortieartrepos;

	@Autowired
	@ManagedProperty(value="#{operationdao}")
	private IOperationDAO operationdao;

	@Override
	public Useri addUser(Useri u) {
		// TODO Auto-generated method stub
		userrepos.save(u);
		return u;
	}

	@Override
	public List<Useri> listUser() {
		// TODO Auto-generated method stub
		return (List<Useri>)userrepos.findAll();
	}

	@Override
	public void remUser(Useri u) {
		// TODO Auto-generated method stub
		userrepos.delete(u);
	}

	@Override
	public Agent addAgent(Agent a) {
		// TODO Auto-generated method stub
		agentrepos.save(a);
		return a;
	}

	@Override
	public Agent addAgentUser(Agent a, Useri u) {
		// TODO Auto-generated method stub
		a.setRoleAgent(u);
		//u.addAgentToList(a);
		agentrepos.save(a);

		return a;
	}

	@Override
	public void remAgent(Agent a) {
		// TODO Auto-generated method stub
		System.out.println("remove agent "+a.getIm());
		agentrepos.delete(a.getIm());

	}

	@Override
	public List<Agent> findAgentByNom(String name) {
		// TODO Auto-generated method stub

		return agentrepos.findByNomAgentContainingIgnoreCase(name);
	}

	@Override
	public Agent findAgentByIm(Long im_agent) {
		// TODO Auto-generated method stub
		return agentrepos.findOne(im_agent);
	}

	//temporary
	@Override
	public List<Agent> findAllAgents() {
		// TODO Auto-generated method stub
		return (List<Agent>) agentrepos.findAll();
	}

	@Override
	public OpEntree reqEntrerMateriel(Materiel m, Agent dc) {
		// TODO Auto-generated method stub*
		m.setDc(dc);
		m = matrepos.save(m);
		/*MaterielEx ma= new MaterielEx();

		ma = matrepos.save(ma);*/
		//m = materielExRepository.save((MaterielEx) m);

		OpEntree entree = new OpEntree(new Date(), new Date(), dc.getIp(), dc, m);
		oprepos.save(entree);

		return entree;
	}

	@Override
	public OpSortie reqSortirMateriel(Materiel m, MotifSortie motif, Direction d, Service s, Bureau b, Agent oper) throws Exception {
		// TODO Auto-generated method stub
		if(m.getDetenteur()!=null) {
			throw new Exception("detenu");
		}
		OpSortie sortie = new OpSortie(new Date(), new Date(), oper.getIp(), oper, m, d, s, b, motif);
		oprepos.save(sortie);
		return sortie;
	}


	public Materiel entrerMateriel(OpEntree op) {
		Materiel m = op.getMat();
		m.setValidation(true);
		
		System.out.println("materiel m"+ m.getDc());
		matrepos.save(m);
		op.valider();
		op.generateNumEntree();
		oprepos.save(op);
		return m;
	}

	@Override
	public Materiel sortirMateriel(OpSortie sortie) throws Exception{
		// TODO Auto-generated method stub

		Materiel m = sortie.getMat();
		if(m.getDetenteur()!=null) {
			throw new Exception("detenu");
		}
		m.setDirec(sortie.getDirec());
		m.setBureau(sortie.getBureau());
		m.setServ(sortie.getServ());
		matrepos.save(m);

		sortie.valider();
		sortie.generateNumSortie();
		oprepos.save(sortie);
		return m;
	}

	/*Old function
	@Override
	public Materiel attriuberMateriel(Long idMat, Long im) {
		// TODO Auto-generated method stub
		Materiel m = (Materiel) matrepos.findOne(idMat);
		Agent detenteur = (Agent) agentrepos.findOne(im);
		m.setDetenteur(detenteur);
		matrepos.save(m);
		return m;
	}*/

	@Override
	public Materiel attriuberMateriel(OpAttribution attr) {
		// TODO Auto-generated method stub
		/*System.out.println("Attribution begin");
		Materiel m = attr.getMat();
		m.setCodification("codified"+new Date());
		//m.setDetenteur(attr.getDetenteur());
		matrepos.save(m);
		Agent detent = attr.getDetenteur();
		detent.getMatdetenu().add(m);
		agentrepos.save(detent);
		attr.valider();
		oprepos.save(attr);*/
		//return m;
		return operationdao.attribuerMat(attr);
	}

	/*@Override
	public Materiel dettacherMateriel(Materiel m) {
		// TODO Auto-generated method stub
		m.setDetenteur(null);
		matrepos.save(m);
		return null;
	}*/

	@Override
	public void delMat(Materiel m) {
		// TODO Auto-generated method stub
		matrepos.delete(m);
	}


	/*
	 * Affichage
	 */
	@Override
	public void seeMat(Materiel m) {
		// TODO Auto-generated method stub
		ModeAcquisition ma=null;
		Financement fi=null;
		Fournisseur f=null;
		Float mont=0f;
		String refFact=null;

		if(m instanceof MaterielNouv){
			ma = ((MaterielNouv)m).getModAcq();
			fi = ((MaterielNouv)m).getFinancement();
			f = ((MaterielNouv)m).getFournisseur();
			mont = ((MaterielNouv)m).getMontant_facture();
			refFact = ((MaterielNouv)m).getRefFacture();
		}
		String detenteur ="aucun";
		if(m.getDetenteur()!=null) {
			detenteur = m.getDetenteur().getNomAgent();
		}
		System.out.println("MATERIEL:");
		System.out.println("--------");
		System.out.println("Type| Nomenclature| marque | pu| ref| numSerie | caract | detenteur | autre |"
				+ "|Etat | Mode Acqui | Financement | Montant | ref Fact | Fournisseur| :");
		System.out.println(m.getCaract()+"|"+m.getNomenMat()+"|"+ m.getMarque()+"|"+ m.getPu()+"|"+ m.getReference()+"|"+
				m.getNumSerie()+"|"+ "XX"+"|"+ detenteur+"|"+ m.getAutre()+"|"+m.getEtat()+"|"+ma+"|"+
				fi+"|"+mont+"|"+refFact+"|"+f);

	}

	@Override
	public void seeAgent(Agent a) {
		// TODO Auto-generated method stub
		System.out.println("");

	}

	@Override
	public OpAttribution reqAttribution(Materiel m, Agent oper, Agent detenteur) throws Exception {
		// TODO Auto-generated method stub
		if(!m.isValidation()) {
			throw new Exception("nonvalider");
		}
		OpAttribution attroper= new OpAttribution(new Date(), new Date(),oper.getIp(), oper, m, detenteur);
		oprepos.save(attroper);
		return attroper;
	}

	@Override
	public OpEntree reqMatAModifier(OpEntree entree, String motif) throws Exception {
		// TODO Auto-generated method stub
		if(entree.getMat().isValidation()) {
			throw new Exception("dejavalider");
		}
		entree.amodifier(motif);
		oprepos.save(entree);
		return entree;
	}
	@Override
	public OpSortie reqSortirAModifier(OpSortie sort, String motif){
		// TODO Auto-generated method stub
		sort.amodifier(motif);
		oprepos.save(sort);
		return sort;
	}
	public OpEntree reqMatRefuser(OpEntree entree, String motif) throws Exception {
		// TODO Auto-generated method stub
		if(entree.getMat().isValidation()) {
			throw new Exception("dejavalider");
		}
		entree.arefuser(motif);
		oprepos.save(entree);
		return entree;
	}

	@Override
	public OpSortie reqSortirRefuser(OpSortie sortie, String string) {
		// TODO Auto-generated method stub
		sortie.arefuser(string);
		oprepos.save(sortie);
		return sortie;
	}

	@Override
	public OpAttribution reqAttrAModifier(OpAttribution attr, String motif) throws Exception {
		// TODO Auto-generated method stub
		if(attr.getMat().getDetenteur()!=null) {
			throw new Exception("detenu");
		}
		attr.amodifier(motif);
		oprepos.save(attr);
		return attr;
	}

	@Override
	public OpAttribution reqAttrRefuser(OpAttribution attr, String motif) throws Exception {
		// TODO Auto-generated method stub
		if(attr.getMat().getDetenteur()!=null) {
			throw new Exception("detenu");
		}
		attr.arefuser(motif);
		oprepos.save(attr);
		return attr;
	}

	@Override
	public OpDettachement reqDettachement(Materiel mat1, Agent oper, Agent dete) throws Exception {
		// TODO Auto-generated method stub
		if(mat1.getDetenteur()==null) {
			throw new Exception("aucun");
		}
		OpDettachement opdet = new OpDettachement(new Date(), new Date(), oper.getIp(), oper, mat1, dete);
		oprepos.save(opdet);
		return opdet;
	}

	@Override
	public Agent detacherMateriel(OpDettachement det) {
		// TODO Auto-generated method stub
		/*Agent ancienDet = det.getMat().getDetenteur();
		Materiel m = det.getMat();
		ancienDet.getMatdetenu().remove(m);
		agentrepos.save(ancienDet);
		det.valider();
		oprepos.save(det);

		return ancienDet;*/
		return operationdao.detacherMat(det);
	}

	@Override
	public OpDettachement reqDetRefuser(OpDettachement det, String string) {
		// TODO Auto-generated method stub
		det.arefuser(string);
		oprepos.save(det);
		return det;
	}

	public IOperationDAO getOperationdao() {
		return operationdao;
	}

	public void setOperationdao(IOperationDAO operationdao) {
		this.operationdao = operationdao;
	}

	/**
	 *
	 * GETTERS
	 */
	@Override
	public Materiel getMatById(Long idmat) {
		// TODO Auto-generated method stub
		return matrepos.findByIdMateriel(idmat);
	}

	@Override
	public List<Materiel> getListMatByDet(Agent detenteur) {
		// TODO Auto-generated method stub
		return matrepos.findByDetenteur(detenteur);
		//return null;
	}

	@Override
	public List<Operation> getListOp() {
		// TODO Auto-generated method stub
		return oprepos.findAll();
	}

	@Override
	public List<OpEntree> getListOpEntree() {
		// TODO Auto-generated method stub
		return opentreerepos.findAll();
	}

	@Override
	public List<OpSortie> getListOpSortie() {
		// TODO Auto-generated method stub
		return opsortierepos.findAll();
	}

	@Override
	public List<Operation> getListOpByOperator(Agent operator) {
		// TODO Auto-generated method stub
		return oprepos.findByOperateur(operator);
	}

	@Override
	public List<OpEntree> getListOpEntreeByOperator(Agent operator) {
		// TODO Auto-generated method stub
		return opentreerepos.findByOperateur(operator);
	}

	@Override
	public List<OpSortie> getListOpSortieByOperator(Agent operator) {
		// TODO Auto-generated method stub
		return opsortierepos.findByOperateur(operator);
	}

	@Override
	public List<Operation> getListOpByDirection(Direction direction) {
		// TODO Auto-generated method stub
		return oprepos.findByDirection(direction);
	}

	@Override
	public List<OpEntree> getListOpEntreeByDirection(Direction direction) {
		// TODO Auto-generated method stub
		return opentreerepos.findByDirection(direction);
	}

	@Override
	public List<OpSortie> getListOpSortieByDirection(Direction direction) {
		// TODO Auto-generated method stub
		return opsortierepos.findByDirection(direction);
	}

	@Override
	public List<Materiel> getListMatByNom(Nomenclature nomenclature) {
		// TODO Auto-generated method stub
		return matrepos.findByNomenMat(nomenclature);
	}

	@Override
	public List<Materiel> getListMatByDirection(Direction direction) {
		// TODO Auto-generated method stub
		return matrepos.findByDirec(direction);
	}

	@Override
	public List<Materiel> getListMatByService(Service service) {
		// TODO Auto-generated method stub
		return matrepos.findByServ(service);
	}

	@Override
	public List<Materiel> getListMatByBureau(Bureau bureau) {
		// TODO Auto-generated method stub
		return matrepos.findByBureau(bureau);
	}

	@Override
	public List<Operation> getListOpBetween(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		int maxresult = 100;
		return operationdao.getListOpByDate(startDate, endDate, maxresult);
	}

	@Override
	public List<OpEntree> getListOpEntreeByMat(Materiel m) {
		// TODO Auto-generated method stub
		return opentreerepos.findByMat(m);
	}

	@Override
	public List<OpSortie> getListOpSortieByMat(Materiel m) {
		// TODO Auto-generated method stub
		return opsortierepos.findByMat(m);
	}

	@Override
	public List<OpEntree> getListOpEntreeByMatBDate(Materiel m, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return operationdao.getListOpEntreeByByMaterielBDate(m, startDate, endDate);
	}

	@Override
	public List<OpSortie> getListOpSortieByMatBDate(Materiel m, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return operationdao.getListOpSortieByByMaterielBDate(m, startDate, endDate);
	}

	@Override
	public List<Materiel> getListMat() {
		// TODO Auto-generated method stub
		return (List<Materiel>)matrepos.findAll();
	}

	@Override
	public List<MaterielEx> getListMatEx()
	{
		return (List<MaterielEx>) materielExRepository.findAll();
	}

	@Override
	public List<MaterielNouv> getListMatNouv()
	{
		return (List<MaterielNouv>) materielNouvRepository.findAll();
	}

	@Override
	public List<Materiel> getMatByValidation(boolean validation) {
		return matrepos.findByValidation(validation);
	}

	@Override
	public List<Materiel> getMatByDetenteurAndValidation(Agent detenteur, boolean validation) {
		return matrepos.findByDetenteurAndValidation(detenteur,validation);
	}

	@Override
	public List<Agent> listAgentByDirection(Direction direction) {
		// TODO Auto-generated method stub
		return agentrepos.findByDirection(direction);
	}

	@Override
	public List<OpAttribution> getListOpAttribution() {
		// TODO Auto-generated method stub
		return opattrrepos.findAll();
	}

	@Override
	public List<OpDettachement> getListOpDettachement() {
		// TODO Auto-generated method stub
		return opdettrepos.findAll();
	}

	@Override
	public List<OpAttribution> getListOpAttrByOperator(Agent operator) {
		// TODO Auto-generated method stub
		return opattrrepos.findByOperateur(operator);
	}

	@Override
	public List<OpDettachement> getListOpDettByOperatort(Agent operator) {
		// TODO Auto-generated method stub
		return opdettrepos.findByOperateur(operator);
	}

	@Override
	public List<OpAttribution> getListOpAttrByDirection(Direction direction) {
		// TODO Auto-generated method stub
		return opattrrepos.findByDirection(direction);
	}

	@Override
	public List<OpDettachement> getListOpDettByDirection(Direction direction) {
		// TODO Auto-generated method stub
		return opdettrepos.findByDirection(direction);
	}

	@Override
	public List<OpAttribution> getListOpAttrByMat(Materiel m) {
		// TODO Auto-generated method stub
		return opattrrepos.findByMat(m);
	}

	@Override
	public List<OpDettachement> getListOpDettByMat(Materiel m) {
		// TODO Auto-generated method stub
		return opdettrepos.findByMat(m);
	}

	@Override
	public CodeArticle addCodeArticle(CodeArticle codeArticle) {
		// TODO Auto-generated method stub
		return codeartrepos.save(codeArticle);
	}

	@Override
	public void removeCodeArticle(CodeArticle codearticle) {
		// TODO Auto-generated method stub
		codeartrepos.delete(codearticle);
	}

	@Override
	public List<CodeArticle> listCodeArticle() {
		// TODO Auto-generated method stub
		return codeartrepos.findAll();
	}

	@Override
	public List<CodeArticle> listCodeArticleByTypeObj(TypeObjet typeObj) {
		// TODO Auto-generated method stub
		return codeartrepos.findByTypeObjet(typeObj);
	}

	@Override
	public OpEntreeArticle reqEntrerArticle(Article article, Agent dc) {
		// TODO Auto-generated method stub
		article.setDc(dc);
		artreops.save(article);

		OpEntreeArticle entreeart = new OpEntreeArticle(new Date(), new Date(), dc.getIp(), dc, article);
		opentreeartrepos.save(entreeart);
		return entreeart;

	}

	@Override
	public OpSortieArticle reqSortirArticle(Article article, Agent op, Agent destinataire) throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		if(!article.isValidation()) {
			throw new Exception("nonvalider");
		}
		OpSortieArticle opsortieart= new OpSortieArticle(new Date(), new Date(),op.getIp(), op, article, destinataire);
		opsortieartrepos.save(opsortieart);
		return opsortieart;
	}

	@Override
	public OpEntreeArticle reqArtAModifier(OpEntreeArticle entreeArt, String motif) throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		if(entreeArt.getArticle().isValidation()) {
			throw new Exception("dejavalider");
		}
		entreeArt.amodifier(motif);
		opentreeartrepos.save(entreeArt);
		return entreeArt;
	}

	@Override
	public OpSortieArticle reqSortirArtAModifier(OpSortieArticle sortArt, String motif) throws Exception{
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		if(sortArt.getArticle().isValidation()) {
			throw new Exception("dejavalider");
		}
		sortArt.amodifier(motif);
		opsortieartrepos.save(sortArt);
		return sortArt;
	}

	@Override
	public OpEntreeArticle reqArtRefuser(OpEntreeArticle entreeArt, String motif) throws Exception {
		// TODO Auto-generated method stub
		if(entreeArt.getArticle().isValidation()) {
			throw new Exception("dejavalider");
		}
		entreeArt.arefuser(motif);
		opentreeartrepos.save(entreeArt);
		return entreeArt;
	}

	@Override
	public OpSortieArticle reqSortirRefuser(OpSortieArticle sortArt, String motif) throws Exception {
		// TODO Auto-generated method stub
		if(sortArt.getArticle().isValidation()) {
			throw new Exception("dejavalider");
		}
		sortArt.arefuser(motif);
		opsortieartrepos.save(sortArt);
		return sortArt;
	}

	@Override
	public Article entrerArticle(OpEntreeArticle opentreeart) {
		// TODO Auto-generated method stub
		Article a = opentreeart.getArticle();
		a.setValidation(true);
		artreops.save(a);
		opentreeart.valider();
		opentreeartrepos.save(opentreeart);
		return a;
	}

	@Override
	public Article sortirArticle(OpSortieArticle sortieart) throws Exception {
		// TODO Auto-generated method stub
		Article a  = sortieart.getArticle();

		Agent beneficiaire = sortieart.getBeneficiaire();
		a.setBeneficiaire(beneficiaire);

		artreops.save(a);
		sortieart.valider();
		//oprepos.save(attr);
		opsortieartrepos.save(sortieart);
		return a;
	}



}
