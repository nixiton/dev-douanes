package come.douane.dao.operation;

import com.douane.entite.Agent;
import com.douane.entite.Materiel;
import com.douane.entite.OpAttribution;
import com.douane.entite.OpDettachement;

public interface IOperationDAO {
	public Agent detacherMat(OpDettachement det);
	public Materiel attribuerMat(OpAttribution attr);
}
