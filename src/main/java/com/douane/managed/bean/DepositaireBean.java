package com.douane.managed.bean;

import com.douane.entite.*;
import com.douane.exception.GetFieldName;
import com.douane.exception.NullPointerAttributeException;
import com.douane.metier.fournisseur.IFournisseurMetier;
import com.douane.metier.marque.IMarqueMetier;
import com.douane.metier.nomenclature.INomenclatureMetier;
import com.douane.metier.referent.IRefMetier;
import com.douane.metier.typeMateriel.ITypeMaterielMetier;
import com.douane.metier.user.IUserMetier;
import com.douane.model.DocumentModel;
import com.douane.model.DocumentModelSimple;
import com.douane.model.UploadedFileByte;
import com.douane.requesthttp.RequestFilter;
import org.apache.commons.io.FilenameUtils;
import org.primefaces.context.ApplicationContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.jws.WebParam;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by hasina on 10/29/17.
 */
@ManagedBean(name = "depositaireBean")
@Component
@PropertySource("classpath:config.properties")
public class DepositaireBean {

	@Autowired
	public Environment env;

	@Value("${fileupload.size}")
	private String fileupload;
	// @Autowired
	// ConfigurableApplicationContext context;

	private String fileUploadSize;

	private static final String SUCCESS = "success";
	private static final String ERROR = "error";

	@ManagedProperty(value = "#{typematerielmetier}")
	ITypeMaterielMetier typematerielmetier;

	@ManagedProperty(value = "#{nomenclaturemetier}")
	INomenclatureMetier nomenclaturemetier;

	@ManagedProperty(value = "#{marquemetier}")
	IMarqueMetier marquemetier;

	@ManagedProperty(value = "#{usermetier}")
	IUserMetier usermetierimpl;

	@ManagedProperty(value = "#{fournisseurmetier}")
	IFournisseurMetier fournisseurmetierimpl;

	/* attribute for file upload */
	private static final long serialVersionUID = 1L;

	private String name;
	private UploadedFile document;
	ArrayList<DocumentModel> documentList = new ArrayList<DocumentModel>();

	private Float unitPrice;

	private String reference;
	private String numSerie;
	private String carac;

	private String renseignement;
	private EtatMateriel etat;

	private Nomenclature typemateriel;
	private String nomencl;
	private Marque marq;

	private ModeAcquisition acquisition;

	private Financement financement;
	private Fournisseur fournisseur;
	private Float montantFac;
	private String refFacture;
	private String nombPerType;
	private String etatMatPresent;

	private String autre;

	private Part file;

	private byte[] byteDoc;

	private String documentPath;

	HashMap<UploadedFile, byte[]> HashMapFileByteContent = new HashMap<UploadedFile, byte[]>();

	HashMap<String, HashMap<UploadedFile, byte[]>> hashOfHashMapFIle = new HashMap<String, HashMap<UploadedFile, byte[]>>();

	private String caracteristique;

	// localisation
	private Bureau bureau;
	private Service service;
	private Direction direction;

	private List<Materiel> listMaterielexistant;
	private Materiel curentMateriel;
	private String nom;
	private String prenom;

	// Sortie Materiel
	private Bureau destination;
	private Direction destinationDirec;
	private Service destinationService;
	private MotifSortie motifSortie;

	private Agent detenteur;

	private Materiel materiel;
	// private Materiel materiel;

	private String listParamShouldNotBeNull = "";

	private ArrayList<UploadedFile> uploadedFiles = new ArrayList<UploadedFile>();
	private UploadedFile uploadedFile;

	public List<TypeMateriel> getListTypeMateriel() {
		return typematerielmetier.findAllTypeMateriel();
	}

	// get nomenclature
	public List<Nomenclature> getNomenclature() {
		return nomenclaturemetier.findAllNomenclatures();
	}

	// get marque
	public List<Marque> getMarque() {
		return marquemetier.findAllMarque();
	}

	// get list detenteur
	public List<Agent> getDetenteurs() {
		return usermetierimpl.findAllAgents();
	}

	public List<Fournisseur> getFOurnisseur() {
		return fournisseurmetierimpl.findAllFournisseur();
	}

	public Float getUnitPrice() {

		return (Float) RequestFilter.getSession().getAttribute("unitPrice");
	}

	public void setUnitPrice(Float unitPrice) {
		RequestFilter.getSession().setAttribute("unitPrice", unitPrice);
		this.unitPrice = unitPrice;
	}

	public ITypeMaterielMetier getTypematerielmetier() {
		return typematerielmetier;
	}

	public void setTypematerielmetier(ITypeMaterielMetier typematerielmetier) {
		this.typematerielmetier = typematerielmetier;
	}

	public INomenclatureMetier getNomenclaturemetier() {
		return nomenclaturemetier;
	}

	public void setNomenclaturemetier(INomenclatureMetier nomenclaturemetier) {
		this.nomenclaturemetier = nomenclaturemetier;
	}

	public IMarqueMetier getMarquemetier() {
		return marquemetier;
	}

	public void setMarquemetier(IMarqueMetier marquemetier) {
		this.marquemetier = marquemetier;
	}

	public String getReference() {
		return (String) RequestFilter.getSession().getAttribute("reference");
	}

	public void setReference(String reference) {

		RequestFilter.getSession().setAttribute("reference", reference);
		this.reference = reference;
	}

	public String getNumSerie() {
		return (String) RequestFilter.getSession().getAttribute("numSerie");
	}

	public void setNumSerie(String numSerie) {

		RequestFilter.getSession().setAttribute("numSerie", numSerie);
		this.numSerie = numSerie;
	}

	public String getCarac() {
		return carac;
	}

	public void setCarac(String carac) {
		this.carac = carac;
	}

	public IUserMetier getUsermetierimpl() {
		return usermetierimpl;
	}

	public void setUsermetierimpl(IUserMetier usermetierimpl) {
		this.usermetierimpl = usermetierimpl;
	}

	public String getRenseignement() {
		return (String) RequestFilter.getSession().getAttribute("renseignement");
	}

	public void setRenseignement(String renseignement) {
		RequestFilter.getSession().setAttribute("renseignement", renseignement);

		this.renseignement = renseignement;
	}

	public EtatMateriel getEtat() {
		return (EtatMateriel) RequestFilter.getSession().getAttribute("etat");
	}

	public void setEtat(EtatMateriel etat) {

		RequestFilter.getSession().setAttribute("etat", etat);
		this.etat = etat;
	}

	public Nomenclature getTypemateriel() {
		return (Nomenclature) RequestFilter.getSession().getAttribute("typemateriel");
	}

	public void setTypemateriel(Nomenclature typemateriel) {
		RequestFilter.getSession().setAttribute("typemateriel", typemateriel);
		this.typemateriel = typemateriel;
	}

	public String getNomencl() {
		return nomencl;
	}

	public void setNomencl(String nomencl) {
		this.nomencl = nomencl;
	}

	public Marque getMarq() {
		return (Marque) RequestFilter.getSession().getAttribute("marq");

	}

	public void setMarq(Marque marq) {

		RequestFilter.getSession().setAttribute("marq", marq);
		this.marq = marq;
	}

	public ModeAcquisition getAcquisition() {
		return (ModeAcquisition) RequestFilter.getSession().getAttribute("acquisition");
	}

	public void setAcquisition(ModeAcquisition acquisition) {
		RequestFilter.getSession().setAttribute("acquisition", acquisition);
		this.acquisition = acquisition;
	}

	public Financement getFinancement() {
		return (Financement) RequestFilter.getSession().getAttribute("financement");
	}

	public void setFinancement(Financement financement) {
		RequestFilter.getSession().setAttribute("financement", financement);
		this.financement = financement;
	}

	public Fournisseur getFournisseur() {
		return (Fournisseur) RequestFilter.getSession().getAttribute("fournisseur");
	}

	public void setFournisseur(Fournisseur fournisseur) {

		RequestFilter.getSession().setAttribute("fournisseur", fournisseur);
		this.fournisseur = fournisseur;
	}

	public Float getMontantFac() {

		return (Float) RequestFilter.getSession().getAttribute("montantFac");
	}

	public void setMontantFac(Float montantFac) {
		RequestFilter.getSession().setAttribute("montantFac", montantFac);
		this.montantFac = montantFac;
	}

	public String getRefFacture() {
		return refFacture;
	}

	public void setRefFacture(String refFacture) {
		this.refFacture = refFacture;
	}

	public String getNombPerType() {
		return nombPerType;
	}

	public void setNombPerType(String nombPerType) {
		this.nombPerType = nombPerType;
	}

	public String getEtatMatPresent() {
		return etatMatPresent;
	}

	public void setEtatMatPresent(String etatMatPresent) {
		this.etatMatPresent = etatMatPresent;
	}

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	public IFournisseurMetier getFournisseurmetierimpl() {
		return fournisseurmetierimpl;
	}

	public void setFournisseurmetierimpl(IFournisseurMetier fournisseurmetierimpl) {
		this.fournisseurmetierimpl = fournisseurmetierimpl;
	}

	public ArrayList<UploadedFile> getUploadedFiles() {
		ArrayList<UploadedFile> uploadedfiles = (ArrayList<UploadedFile>) RequestFilter.getSession()
				.getAttribute("uploadedFiles");
		if (uploadedfiles != null)
			return uploadedfiles;
		return uploadedFiles;
	}

	public void setUploadedFiles(ArrayList<UploadedFile> uploadedFiles) {
		this.uploadedFiles = uploadedFiles;
	}

	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	/*---------------------method for uploading file--------------------------------*/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UploadedFile getDocument() {
		return document;
	}

	public void setDocument(UploadedFile document) {
		this.document = document;
	}

	public ArrayList<DocumentModel> getDocumentList() {
		// PropertyConf dbConfig = (PropertyConf) context.getBean("propertyConf");
		// System.out.println(dbConfig.getFileupload());
		// env = context.getEn;
		System.out.println(env.getProperty("fileupload.size"));
		System.out.println(fileupload);
		ArrayList<DocumentModel> documentlist = (ArrayList<DocumentModel>) RequestFilter.getSession()
				.getAttribute("documentList");
		if (documentlist != null) {
			this.setDocumentList(documentlist);
			return documentlist;
		}
		return documentList;
	}

	public void setDocumentList(ArrayList<DocumentModel> documentList) {
		this.documentList = documentList;
	}

	public DepositaireBean() {
		try {
			documentList = initialize();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ArrayList<DocumentModel> initialize() throws IOException {

		ArrayList<DocumentModel> list = new ArrayList<DocumentModel>();
		DocumentModel obj = new DocumentModel();
		obj.setSrNo(1);
		obj.setDocumentName("test filename1");
		obj.setRemovable(false);
		list.add(obj);
		obj = new DocumentModel();
		obj.setSrNo(2);
		obj.setDocumentName("test filename2");
		obj.setRemovable(false);
		list.add(obj);
		return list;
	}

	public String addNewDoc() throws IOException {

		ArrayList<DocumentModel> list = getDocumentList();
		System.out.println("list count= " + list.size() + list.get(list.size() - 1).getSrNo());
		DocumentModel obj = new DocumentModel();
		obj.setSrNo(list.get(list.size() - 1).getSrNo() + 1);
		obj.setDocumentName("Type Document Name here");
		obj.setInstitute("Type Institute here");
		list.add(obj);

		setDocumentList(list);

		return null;

	}

	public String removeRow(DocumentModel row) {
		documentList.remove(row);
		// updates serial no.
		int i = 0;
		for (DocumentModel fl : documentList) {

			i++;
			fl.setSrNo(i);
		}
		return null;
	}

	public String removeDoc(DocumentModel row) {

		System.out.println("filename to be removed " + row.getDocumentUploadedPath());
		// You can write logic to remove uploaded file from the device. not written
		// here.
		System.out.println(row.getDocumentName());
		row.setDocumentUploadedPath("");
		row.setUploaded(false);

		return null;
	}

	public String upload_image(FileUploadEvent e) throws IOException {
		RequestFilter.getSession().setAttribute("imageMat", e.getFile().getContents());
		return null;
	}

	public String uploadDoc_Advanced(FileUploadEvent e) throws IOException {

		DocumentModel docObj = (DocumentModel) e.getComponent().getAttributes().get("docObj");

		if (e.getFile().getContents() != null)
			docObj.setByteArrayImage(e.getFile().getContents());

		document = e.getFile();

		docObj.setUploaded(true);
		docObj.setDocumentUploadedPath("" + e.getFile().getFileName());

		ArrayList<DocumentModel> documentlist = (ArrayList<DocumentModel>) RequestFilter.getSession()
				.getAttribute("documentList");
		if (documentlist != null)
			this.setDocumentList(documentlist);

		documentList.set(documentList.indexOf(docObj), docObj);
		RequestFilter.getSession().setAttribute("documentList", documentList);
		System.out.println("File Uploaded");

		return null;
	}

	public String updatePage() throws IOException {

		ArrayList<DocumentModel> list = getDocumentList();

		int i = 0;

		StringBuffer resultTemp = new StringBuffer();

		for (DocumentModel fl : list) {

			i++;

			resultTemp.append(
					i + ". Document Name : " + fl.getDocumentName() + ", File Path: " + fl.getDocumentUploadedPath());
		}

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(resultTemp.toString()));

		// setResult(resultTemp.toString());

		return "success";

	}

	public String uploadFiles() throws IOException {
		String fileName = "";
		ArrayList<UploadedFileByte> uploadedfiles = (ArrayList<UploadedFileByte>) RequestFilter.getSession()
				.getAttribute("uploadedFiles");

		HashMap<String, HashMap<UploadedFile, byte[]>> hashOfhashmapfilebytecontent = (HashMap<String, HashMap<UploadedFile, byte[]>>) RequestFilter
				.getSession().getAttribute("hashmapFileBytecontent");
		ArrayList<String> filesTozip = new ArrayList<String>();

		for (DocumentModel d : documentList) {
			File file = new File("resources1");
			String absolutePath = file.getAbsolutePath();
			String filePath = absolutePath;
			String filePath2 = new File("test").getAbsolutePath();
			byte[] bytes = null;

			if (null != d) {
				bytes = d.getByteArrayImage();
				fileName = FilenameUtils.getName(d.getDocumentUploadedPath());
				System.out.println("file name" + fileName);
				BufferedOutputStream stream;
				stream = new BufferedOutputStream(new FileOutputStream(new File(filePath + fileName)));
				filesTozip.add(filePath + fileName);
				stream.write(bytes);
				stream.close();
			}
		}
		zipFiles(filesTozip);
		return SUCCESS;
	}

	public void zipFiles(List<String> files) {

		FileOutputStream fos = null;
		ZipOutputStream zipOut = null;
		FileInputStream fis = null;
		try {
			File file = new File("resourcessZip");
			String absolutePath = file.getAbsolutePath();

			RequestFilter.getSession().setAttribute("documentpath", absolutePath + "resourcessZip.zip");
			// eto miset an le documentpath
			fos = new FileOutputStream(absolutePath + "resourcessZip.zip");
			setDocumentPath(absolutePath + "resourcessZip.zip");
			zipOut = new ZipOutputStream(new BufferedOutputStream(fos));
			for (String filePath : files) {
				File input = new File(filePath);
				fis = new FileInputStream(input);
				ZipEntry ze = new ZipEntry(input.getName());
				System.out.println("Zipping the file: " + input.getName());
				zipOut.putNextEntry(ze);
				byte[] tmp = new byte[4 * 1024];
				int size = 0;
				while ((size = fis.read(tmp)) != -1) {
					zipOut.write(tmp, 0, size);
				}
				// zipOut.flush();
				fis.close();
			}
			zipOut.close();
			System.out.println("Done... Zipped the files...");
			RequestFilter.getSession().removeAttribute("documentList");
			RequestFilter.getSession().removeAttribute("documentpath");

			// response.setHeader("Refresh", "0; URL=http://your-current-page");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (fos != null)
					fos.close();
			} catch (Exception ex) {

			}
		}
	}

	public byte[] getByteDoc() {
		return this.byteDoc;
	}

	public void setByteDoc(byte[] byteDoc) {
		this.byteDoc = byteDoc;
	}

	public String getAutre() {
		return (String) RequestFilter.getSession().getAttribute("autre");
	}

	public void setAutre(String autre) {
		RequestFilter.getSession().setAttribute("autre", autre);
		this.autre = autre;
	}

	public String getCaracteristique() {
		return caracteristique;
	}

	public void setCaracteristique(String caracteristique) {
		this.caracteristique = caracteristique;
	}

	public Bureau getBureau() {
		RequestFilter.getSession().getAttribute("bureau");
		return bureau;
	}

	public void setBureau(Bureau bureau) {
		RequestFilter.getSession().setAttribute("bureau", bureau);
		this.bureau = bureau;
	}

	public Service getService() {

		return (Service) RequestFilter.getSession().getAttribute("service");
	}

	public void setService(Service service) {
		RequestFilter.getSession().setAttribute("service", service);
		this.service = service;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public List<Materiel> getListMaterielexistant() {
		return usermetierimpl.getListMat();	
	}

	public void setListMaterielexistant(List<Materiel> listMaterielexistant) {
		this.listMaterielexistant = listMaterielexistant;
	}

	public Materiel getCurentMateriel() {
		return curentMateriel;
	}

	public void setCurentMateriel(Materiel curentMateriel) {
		this.curentMateriel = curentMateriel;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Bureau getDestination() {
		return destination;
	}

	public void setDestination(Bureau destination) {
		this.destination = destination;
	}

	public Direction getDestinationDirec() {
		return destinationDirec;
	}

	public void setDestinationDirec(Direction destinationDirec) {
		this.destinationDirec = destinationDirec;
	}

	public Service getDestinationService() {
		return destinationService;
	}

	public void setDestinationService(Service destinationService) {
		this.destinationService = destinationService;
	}

	public MotifSortie getMotifSortie() {
		return motifSortie;
	}

	public void setMotifSortie(MotifSortie motifSortie) {
		this.motifSortie = motifSortie;
	}

	public Agent getDetenteur() {
		return this.detenteur;
	}

	public void setDetenteur(Agent detenteur) {
		this.detenteur = detenteur;
	}

	public Materiel getMateriel() {
		return materiel;
	}

	public void setMateriel(Materiel materiel) {
		this.materiel = materiel;
	}

	public void onTypeMaterielChange() {
		this.setNombPerType(this.getTypemateriel().getNomenclature());
	}

	public void onDetenteurChange() {
		this.setNom(getDetenteur().getNomAgent());
		this.setPrenom(getDetenteur().getPrenomAgent());
	}

	public void onMaterielChange() {
		this.setMarq(this.getMateriel().getMarque());
		this.setReference(this.getMateriel().getReference());
		this.setNumSerie(this.getMateriel().getNumSerie());
	}

	public String addMateriel() {
		Agent agent = (Agent) RequestFilter.getSession().getAttribute("agent");
		// agent.setIp()
		MaterielEx m = new MaterielEx();
		m.setAutre(getAutre());
		m.setBureau(getBureau());
		m.setAutre(getAutre());
		// m.setDirec(getDirection());
		m.setDirec(agent.getDirection());
		m.setDocumentPath("default");
		m.setEtat(getEtat());
		m.setMarque(getMarq());
		m.setNomenMat(getTypemateriel());
		m.setNumSerie(getNumSerie());
		m.setPu(getUnitPrice());
		m.setReference(getReference());
		m.setRenseignement(getRenseignement());
		m.setServ(getService());

		// m.setCaract(caract);
		// m.setCategorie(categorie);
		m.setImage((byte[]) RequestFilter.getSession().getAttribute("imageMat"));
		// m.setDocumentPath(documentPath);

		// set Operation requete entrer materiel existant
		OpEntree opentree = usermetierimpl.reqEntrerMateriel(m, agent);
		// set Operation valider automatique car ne necessite pas de validation GAC
		usermetierimpl.entrerMateriel(opentree);

		return SUCCESS;
	}

	public String addPriseEncharge() {
		Agent agent = (Agent) RequestFilter.getSession().getAttribute("agent");
		// agent.setIp()

		MaterielNouv m = new MaterielNouv();

		m.setAutre(getAutre());

		m.setBureau(getBureau());
		// m.setDirec(getDirection());
		m.setDirec(agent.getDirection());

		m.setEtat(getEtat());

		m.setMarque(getMarq());

		m.setNomenMat(getTypemateriel());

		m.setNumSerie(getNumSerie());

		m.setPu(getUnitPrice());

		m.setReference(getReference());

		m.setRenseignement(getRenseignement());

		m.setServ(getService());

		// m.setCaract(caract);
		// m.setCategorie(categorie);

		m.setImage((byte[]) RequestFilter.getSession().getAttribute("imageMat"));

		m.setDocumentPath((String) RequestFilter.getSession().getAttribute("documentpath"));

		// proprietes propre aux materiels nouveaux

		m.setFinancement(getFinancement());

		m.setFournisseur(getFournisseur());

		m.setModAcq(getAcquisition());

		m.setMontant_facture(getMontantFac());

		// m.setRefFacture(refFacture);

		// set Operation requete entrer materiel nouveau
		OpEntree opEntree = usermetierimpl.reqEntrerMateriel(m, agent);
		return SUCCESS;
	}

	public String addAttribution() {
		Agent agent = (Agent) RequestFilter.getSession().getAttribute("agent");
		// agent.setIp()
		OpAttribution opAt = null;

		try {
			// getCurrent Materiel ve?????
			opAt = usermetierimpl.reqAttribution(getMateriel(), agent, getDetenteur());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

		}
		return SUCCESS;
	}

	public String addDetachement() {
		Agent agent = (Agent) RequestFilter.getSession().getAttribute("agent");
		// agent.setIp()
		OpDettachement opDet = null;
		try {
			// getCurrent Materiel ve?????
			opDet = usermetierimpl.reqDettachement(this.getMateriel(), agent, getDetenteur());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		return SUCCESS;

	}

	public String addDecharge() {
		Agent agent = (Agent) RequestFilter.getSession().getAttribute("agent");
		// agent.setIp()
		OpSortie opSort = null;
		try {
			opSort = usermetierimpl.reqSortirMateriel(this.getMateriel(), this.getMotifSortie(),
					this.getDestinationDirec(), this.getDestinationService(), this.getDestination(), agent);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		return SUCCESS;

	}

	public String getDocumentPath() {
		return documentPath;
	}

	public void setDocumentPath(String documentPath) {
		this.documentPath = documentPath;
	}
}																														