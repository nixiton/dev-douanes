package test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.douane.entite.*;
import com.douane.metier.motifDecharge.MotifDechargeMetier;
import com.douane.metier.referentiel.IRefMetier;
import com.douane.metier.user.IUserMetier;

public class TestMetier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		System.out.println("BEGIN");
		
		IRefMetier metier = (IRefMetier) context.getBean("refmetier");
		/*
		Nomenclature table = new Nomenclature("Chaise de table", "005");
		Nomenclature stylo = new Nomenclature("Stylo à bille", "006");
		
		ModeAcquisition sera = new ModeAcquisition("Don");
		ModeAcquisition com = new ModeAcquisition("Communiquant");
		
		MotifDecharge affectation = new MotifDecharge("Affectation");
		
		metier.addRef(table);
		metier.addRef(sera);
		metier.addRef(affectation);
		metier.addRef(com);
		
		metier.removeRef(stylo);
		metier.removeRef(table);
		List<Referentiel> lesnomens = metier.listRef(new ModeAcquisition());
		
		ModeAcquisition nom = null;
		for(int i=0; i<lesnomens.size(); i++){
			//System.out.println(lesnomens.get(i).getDesignation());
			nom = (ModeAcquisition) lesnomens.get(i);
			System.out.println(nom.getDesignation());
		}
		
		
		*/
		
		IUserMetier usermetier = (IUserMetier) context.getBean("usermetier");
		
		Useri role1 = new Useri("Un utilisateur qui peut tout faire", "GAC");
		Useri role2 = new Useri("Un utilisateur normal", "Agent");
		
		usermetier.addUser(role1);
		usermetier.addUser(role2);
		
		//usermetier.remUser(role1);
		
		/*List<User> lesusers = (List<User>) usermetier.listUser();
		for(int i=0; i<lesusers.size(); i++){
			//System.out.println(lesnomens.get(i).getDesignation());
			System.out.println(lesusers.get(i).getRole());
		}*/
		
		Agent agent1 = new Agent(2252L, "RAKOTONANDRA", "Zazo");
		Agent agent2 = new Agent(2244L, "RASAMY", "Natacha", role2);
		//metier.addRef(new Poste("Depositaire"), )
		Poste dep = new Poste("Depositaire");
		metier.addRefWithoutOper(dep);
		//agent1.setPosteny(dep);
		//agent2.setPosteny(dep);
		agent1.setPassword("123456");
		agent2.setPassword("123456");
		
		usermetier.addAgentUser(agent1, null);
		usermetier.addAgent(agent2);
		
		/*List<Agent> lesagents = usermetier.findAllAgents();
		
		for(int i=0; i<lesagents.size(); i++){
			//System.out.println(lesnomens.get(i).getDesignation());
			System.out.println(lesagents.get(i).getPrenomAgent());
		}
		
		//usermetier.remAgent(agent2);
		
		//lesagents = usermetier.findAgentByNom("Ra");
		List<Agent> lesagentss = usermetier.findAllAgents();
		lesagentss = usermetier.findAgentByNom("mY");
		for(int i=0; i<lesagentss.size(); i++){
			//System.out.println(lesnomens.get(i).getDesignation());
			System.out.println("lesagents:"+lesagentss.get(i).getPrenomAgent());
		}*/
		
		//System.out.println("findbyone:"+ usermetier.findAgentByIm(agent1.getIm()).getNomAgent());
		Nomenclature nm = new Nomenclature("Jus", "001");
		CategorieMat categ = new CategorieMat("Matériel Informatique");
		Poste poste = new Poste("Informaticien");
		
		EtatMateriel etat = new EtatMateriel("Neuf");
		TypeMateriel caract = new TypeMateriel("Bureau");
		
		Nomenclature nm1 = new Nomenclature("BAS", "002");
		EtatMateriel etat1 = new EtatMateriel("Old");
		TypeMateriel caract1 = new TypeMateriel("KAKA");
		ModeAcquisition modAcq = new ModeAcquisition("MAet");
		Financement financement = new Financement("DON");
		Fournisseur fournisseur = new Fournisseur("Vitsika");
		
		Marque marq = new Marque("sinoa");
		Marque marq1 = new Marque("vita malagasy");
		
		Direction statistique = new Direction("Direction Informatique et système","105");
		Direction compta = new Direction("Comptabilité","154");
		
		Localite tana = new Localite("Antananarivo");
		Localite fianara = new Localite("Fianarantsoa");
		
		Service dev = new Service("Developpeut", "12");
		Bureau bureau = new Bureau("Bureau des grands","124");
		MotifSortie motifsortie = new MotifSortie("Deplacer");
		
		
		List<Referentiel> listeRef= new ArrayList<Referentiel>();
		
		listeRef.add(nm);
		listeRef.add(etat);
		listeRef.add(caract);
		
		listeRef.add(nm1);
		listeRef.add(etat1);
		listeRef.add(caract1);
		listeRef.add(modAcq);
		listeRef.add(financement);
		listeRef.add(fournisseur);
		listeRef.add(marq);
		listeRef.add(marq1);
		
		listeRef.add(statistique);
		listeRef.add(compta);
		
		listeRef.add(tana);
		//listeRef.add(fianara);
		listeRef.add(dev);
		//listeRef.add(bureau);
		
		
		
		metier.saveRefs(listeRef,agent2);
		//to test add one and only one refrentiel (designation refrenetiel on database)
		metier.addRef(bureau, agent1);
		metier.addRef(categ, agent1);
		metier.addRef(poste, agent1);
		metier.addRef(fianara, agent2);
		metier.addRef(motifsortie, agent1);
		
		FournisseurDetail teamtic = new FournisseurDetail("TeamTic Mada", "122455210", "112222445", "Moi", "Ankatso", "Bien");
		metier.addFournisseur(teamtic, agent1);
		
		
		//MaterielEx mat = new MaterielEx(1000.0f, "ref0101", "numserie0101", "autre",null, nm	, etat, caract, agent1, agent2,marq1);
		//usermetier.entrerMateriel(mat, agent1);
		
		
		MaterielNouv mat1 = new MaterielNouv(154.25f, "Ma reference", "NumeroSerie1234", "",
				nm1 , etat1, caract1, agent2, modAcq, financement, fournisseur, 
			200.25f,"0012", null, marq);
		mat1.setDirec(compta);
		mat1.setServ(dev);
		mat1.setCategorie(categ);
		//mat1.setDetenteur(null);
		//usermetier.entrerMateriel(mat1, agent2);
		//usermetier.delMat(mat);
		
		usermetier.seeMat(mat1);
		
		//entrer materiel mais encore à  valider
		OpEntree entree = usermetier.reqEntrerMateriel(mat1, agent2);
		//Validation entrer materiel
		Materiel m = usermetier.entrerMateriel(entree);
		/*//Require modification pour validation
		try {
			entree = usermetier.reqMatAModifier(entree, "Tsy ampy kely");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		//Refuser
		try {
			entree = usermetier.reqMatRefuser(entree, "Tsy izy mintsn");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		*/
		
		//requete attribution de materiel
		OpAttribution attribution = null;
		try {
			attribution = usermetier.reqAttribution(m, agent2, agent1);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		if(attribution!=null) {
			//Validation attribution
			m = usermetier.attriuberMateriel(attribution);
			/*
			//Amodifier attribution
			try {
				attribution = usermetier.reqAttrAModifier(attribution, "Tsy ilay olona");				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
			
			//Arefuser attribution
			try {
				attribution = usermetier.reqAttrRefuser(attribution, "Mandainga");				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
			*/
		}
		System.out.println("after attribution");
		if(m==null) {
			System.out.println("Mater detenu null");
		}
		for(Materiel ma : m.getDetenteur().getMatdetenu()) {
			System.out.println(ma.getIdMateriel());
		}
		
		
		//requete dettachement de materiel
				OpDettachement det = null;
				try {
					det = usermetier.reqDettachement(m, agent2, m.getDetenteur());
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				
				if(det!=null) {
					//Validation dettachement
					Agent ancien = usermetier.detacherMateriel(det);
					System.out.println("after dettachement");
					for(Materiel ma : ancien.getMatdetenu()) {
						System.out.println(ma.getIdMateriel());
					}
					
					/*
					//Amodifier dettachement
					try {
						det = usermetier.reqDettAModifier(det, "Tsy izy ilay materiels");				
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println(e.getMessage());
					}
					*//*
					//Arefuser attribution
					try {
						det = usermetier.reqDetRefuser(det, "Mandainga");				
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println(e.getMessage());
					}*/
					
				}
			// Sortie de materiel
			OpSortie sortie = null;
			try {
				sortie = usermetier.reqSortirMateriel(m, motifsortie, statistique, dev, bureau, agent1);
			}
			catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
			 
			//Validation sortir materiel
			try {
				Materiel ms = usermetier.sortirMateriel(sortie);
			}
			catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
			//
			//Require modification pour validation
			//sortie = usermetier.reqSortirAModifier(sortie, "Tsy ampy kely");
			//Refuser
			//sortie = usermetier.reqSortirRefuser(sortie, "Tsy izy mintsn");
		
	}

}
