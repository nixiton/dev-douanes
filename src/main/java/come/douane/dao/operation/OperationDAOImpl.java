package come.douane.dao.operation;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.douane.entite.Agent;
import com.douane.entite.Materiel;
import com.douane.entite.OpAttribution;
import com.douane.entite.OpDettachement;

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
		m.setCodification("codified"+new Date());
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

}
