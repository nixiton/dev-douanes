package come.douane.dao.operation;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import com.douane.entite.Agent;
import com.douane.entite.Materiel;
import com.douane.entite.OpAttribution;
import com.douane.entite.OpDettachement;
import com.douane.entite.OpEntree;
import com.douane.entite.OpSortie;
import com.douane.entite.Operation;

public class OperationDAOImpl implements IOperationDAO{
	
	@PersistenceContext
	private EntityManager em;
	
	public OperationDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Agent detacherMat(OpDettachement det) {
		// TODO Auto-generated method stub
		Agent ancienDet = det.getMat().getDetenteur();
		Materiel m = det.getMat();
		ancienDet.getMatdetenu().remove(m);
		em.merge(ancienDet);
		
		m.setDetenteur(null);
		em.merge(m);
		
		det.valider();
		em.merge(det);
		
		return ancienDet;
	}

	@Override
	public Materiel attribuerMat(OpAttribution attr) {
		// TODO Auto-generated method stub
		System.out.println("Attribution DAO begin");
		Materiel m = attr.getMat();
		//m.setCodification("codified"+new Date());
		m.generateCode();
		//m.setDetenteur(attr.getDetenteur());
		//matrepos.save(m);
		//em.persist(m);
		//em.merge(m);
		Agent detent = attr.getDetenteur();
		m.setDetenteur(detent);
		detent.getMatdetenu().add(m);
		//agentrepos.save(detent);
		em.merge(m);
		em.merge(detent);
		attr.valider();
		//oprepos.save(attr);
		em.merge(attr);
		return m;
	}

	@Override
	public List<Operation> getListOpByDate(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		//em.getTransaction().begin();
	       TypedQuery<Operation> query = em.createQuery("select o from Operation o "
	       		+ "where o.date>= :startDate AND o.date<= :endDate",Operation.class);
	       query.setParameter("startDate", startDate, TemporalType.DATE);
	       query.setParameter("endDate", endDate, TemporalType.DATE);
	       List<Operation> operations = query.getResultList();
	 
	     //  em.getTransaction().commit();
	 
	       return operations;
	}

	@Override
	public List<OpEntree> getListOpEntreeByByMaterielBDate(Materiel m, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		TypedQuery<OpEntree> query = em.createQuery("select oe from OpEntree oe "
	       		+ "where oe.date>= :startDate AND oe.date<= :endDate AND "
	       		+ "oe.mat = :mymat",OpEntree.class);
	       query.setParameter("startDate", startDate, TemporalType.DATE);
	       query.setParameter("endDate", endDate, TemporalType.DATE);
	       query.setParameter("mymat", m);
	       List<OpEntree> operations = query.getResultList();
		return operations;
	}

	@Override
	public List<OpSortie> getListOpSortieByByMaterielBDate(Materiel m, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		TypedQuery<OpSortie> query = em.createQuery("select os from OpSortie os "
	       		+ "where os.date>= :startDate AND os.date<= :endDate AND "
	       		+ "os.mat = :mymat",OpSortie.class);
	       query.setParameter("startDate", startDate, TemporalType.DATE);
	       query.setParameter("endDate", endDate, TemporalType.DATE);
	       query.setParameter("mymat", m);
	       List<OpSortie> operations = query.getResultList();
		return operations;
	}

}
