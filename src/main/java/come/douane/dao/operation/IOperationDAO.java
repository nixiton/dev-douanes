package come.douane.dao.operation;

import java.util.Date;
import java.util.List;

import com.douane.entite.Agent;
import com.douane.entite.Materiel;
import com.douane.entite.OpAttribution;
import com.douane.entite.OpDettachement;
import com.douane.entite.OpEntree;
import com.douane.entite.OpSortie;
import com.douane.entite.Operation;

public interface IOperationDAO {
	public Agent detacherMat(OpDettachement det);
	public Materiel attribuerMat(OpAttribution attr);
	public List<Operation> getListOpByDate(Date startDate, Date endDate );
	
	public List<OpEntree> getListOpEntreeByByMaterielBDate(Materiel m, Date startDate, Date endDate);
	public List<OpSortie> getListOpSortieByByMaterielBDate(Materiel m, Date startDate, Date endDate);
}
