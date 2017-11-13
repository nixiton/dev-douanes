package come.douane.dao.operation;

import java.util.Date;
import java.util.List;

import com.douane.entite.Agent;
import com.douane.entite.Direction;
import com.douane.entite.Materiel;
import com.douane.entite.OpAttribution;
import com.douane.entite.OpDettachement;
import com.douane.entite.OpEntree;
import com.douane.entite.OpSortie;
import com.douane.entite.Operation;

public interface IOperationDAO {
	public Agent detacherMat(OpDettachement det);
	public Materiel attribuerMat(OpAttribution attr);
	
	public List<Operation> getListOpByDate(Date startDate, Date endDate , int maxresult);
	
	
	public List<OpEntree> getListOpEntreeOrderByDate(int maxresult);
	public List<OpSortie> getListOpSortieOrderByDate(int maxresult);
	public List<Operation> getListOperationOrderByDate(int maxresult);
	public List<OpAttribution> getListOpAttributionOrderByDate(int maxresult);
	public List<OpDettachement> getListOpDettachementOrderByDate(int maxresult);
	
	public List<OpEntree> getListOpEntreeByDirOrder(Direction dir, int maxresult);
	public List<OpSortie> getListOpSortieByDirOrder(Direction dir, int maxresult);
	public List<Operation> getListOperationByDirOrder(Direction dir, int maxresult);
	public List<OpAttribution> getListOpAttributionByDirOrder(Direction dir, int maxresult);
	public List<OpDettachement> getListOpDettachementByDirOrder(Direction dir, int maxresult);
	
	public List<OpEntree> getListOpEntreeByOperator(Agent operator, int maxresult);
	public List<OpSortie> getListOpSortieByOperator(Agent operator, int maxresult);
	public List<Operation> getListOperationByOperator(Agent operator, int maxresult);
	public List<OpAttribution> getListOpAttributionByOperator(Agent operator, int maxresult);
	public List<OpDettachement> getListOpDettachementByOperator(Agent operator, int maxresult);
	
	public List<OpEntree> getListOpEntreeByByMaterielBDate(Materiel m, Date startDate, Date endDate, int maxresult);
	public List<OpSortie> getListOpSortieByByMaterielBDate(Materiel m, Date startDate, Date endDate, int maxresult);
	
	

}
