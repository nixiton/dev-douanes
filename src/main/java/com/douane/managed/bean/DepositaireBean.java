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
import com.douane.requesthttp.RequestFilter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hasina on 10/29/17.
 */
@ManagedBean(name="depositaireBean")
public class DepositaireBean {

    private static final String SUCCESS = "success";
    private static final String ERROR   = "error";

    @ManagedProperty(value="#{typematerielmetier}")
    ITypeMaterielMetier typematerielmetier;

    @ManagedProperty(value="#{nomenclaturemetier}")
    INomenclatureMetier nomenclaturemetier;

    @ManagedProperty(value="#{marquemetier}")
    IMarqueMetier marquemetier;



    @ManagedProperty(value="#{usermetier}")
    IUserMetier usermetierimpl;

    @ManagedProperty(value="#{fournisseurmetier}")
    IFournisseurMetier fournisseurmetierimpl;

    private Float unitPrice;
    private String reference;
    private String numSerie;
    private String carac;
    private String renseignement;
    private EtatMateriel     etat;
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
    private String caracteristique;
    
    //localisation
    private Bureau bureau;
    private Service service;
    private Direction direction;
    
    private List<Materiel> listMaterielexistant;
    private Materiel curentMateriel;
    private String nom;
    private String prenom;
    
    //Sortie Materiel
    private Bureau destination;
    private Direction destinationDirec;
    private Service destinationService;
    private MotifSortie motifSortie;
    private Agent detenteur;
    
    private Materiel materiel;
    //private Materiel materiel;

    /*
    Sélection du mode d’acquisition : Achats-dons-excédent-dotation
        Financement : RPI/ Gasynet/ Fasad/Crédit DGD
        Bailleur/Partenaires + champ libre
            -Montant sur facture
        -Référence facture
            - Fournisseur – Liste déroulante Référentiel
        Nombre par type
        Sélection de l’état au moment de la réception (Neuf/En état de marche/Réparable/hors service)
        Attachement des pièces justificatives (PV, facture, bon de livraison, Ordre de sortie  …)
        Insertion photo du matériel
        Transfert au GAC après pré validation
        Mise à jour du journal (automatique) après validation du GAC*/

    private String listParamShouldNotBeNull = "";
    //list materiel, nomenclature,marque
    //get list materiel
    public List<TypeMateriel>  getListTypeMateriel()
    {
        return typematerielmetier.findAllTypeMateriel();
    }

    //get nomenclature
    public List<Nomenclature> getNomenclature()
    {
        return nomenclaturemetier.findAllNomenclatures();
    }

    //get marque
    public List<Marque> getMarque()
    {
        return marquemetier.findAllMarque();
    }

    //get list detenteur
    public List<Agent> getDetenteurs()
    {
        return usermetierimpl.findAllAgents();
    }

    //get list fournisseur
    public List<Fournisseur> getFOurnisseur()
    {
        return fournisseurmetierimpl.findAllFournisseur();
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
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
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
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
        return renseignement;
    }

    public void setRenseignement(String renseignement) {
        this.renseignement = renseignement;
    }

    public EtatMateriel getEtat() {
        return etat;
    }

    public void setEtat(EtatMateriel etat) {
        this.etat = etat;
    }


    public String getNomencl() {
        return nomencl;
    }

    public void setNomencl(String nomencl) {
        this.nomencl = nomencl;
    }

    public Marque getMarq() {
        return marq;
    }

    public void setMarq(Marque marq) {
        this.marq = marq;
    }

    public ModeAcquisition getAcquisition() {
        return acquisition;
    }

    public void setAcquisition(ModeAcquisition acquisition) {
        this.acquisition = acquisition;
    }

    public Financement getFinancement() {
        return financement;
    }

    public void setFinancement(Financement financement) {
        this.financement = financement;
    }


    public Float getMontantFac() {
        return montantFac;
    }

    public void setMontantFac(Float montantFac) {
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

    public List<Materiel> getListMaterielexistant() {
        Agent agent = (Agent)RequestFilter.getSession().getAttribute("agent");
        //return usermetierimpl.getListMatByDirection(agent.getDirection());
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
    
    public IFournisseurMetier getFournisseurmetierimpl() {
        return fournisseurmetierimpl;
    }

    public void setFournisseurmetierimpl(IFournisseurMetier fournisseurmetierimpl) {
        this.fournisseurmetierimpl = fournisseurmetierimpl;
    }

    public String getAutre() {
        return autre;
    }

    public void setAutre(String autre) {
        this.autre = autre;
    }

    public Nomenclature getTypemateriel() {
        return typemateriel;
    }

    public void setTypemateriel(Nomenclature typemateriel) {
        this.typemateriel = typemateriel;
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
    

    public Agent getDetenteur() {
        return detenteur;
    }
    
    public void setDetenteur(Agent detenteur) {
        this.detenteur = detenteur;
    }
    
    public MotifSortie getMotifSortie() {
        return motifSortie;
    }

    public void setMotifSortie(MotifSortie motifSortie) {
        this.motifSortie = motifSortie;
    }

    public Materiel getMateriel() {
        return materiel;
    }

    public void setMateriel(Materiel materiel) {
        this.materiel = materiel;
    }

    public Bureau getDestination() {
        return destination;
    }

    public void setDestination(Bureau destination) {
        this.destination = destination;
    }
    public Service getDestinationService() {
        return destinationService;
    }

    public void setDestinationService(Service destinationService) {
        this.destinationService = destinationService;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public Bureau getBureau() {
        return bureau;
    }

    public void setBureau(Bureau bureau) {
        this.bureau = bureau;
    }

    public Direction getDestinationDirec() {
        return destinationDirec;
    }

    public void setDestinationDirec(Direction destinationDirec) {
        this.destinationDirec = destinationDirec;
    }

    public String getCaracteristique() {
        return caracteristique;
    }

    public void setCaracteristique(String caracteristique) {
        this.caracteristique = caracteristique;
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
        Agent agent = (Agent)RequestFilter.getSession().getAttribute("agent");
        //agent.setIp()
        MaterielEx m = new MaterielEx();
        m.setAutre(getAutre());
        m.setBureau(getBureau());
        m.setAutre(getAutre());
        //m.setDirec(getDirection());
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
        
        //m.setCaract(caract);
        //m.setCategorie(categorie);
        //m.setImage(image);
        //m.setDocumentPath(documentPath);
        
        //set Operation requete entrer materiel existant
        OpEntree opentree = usermetierimpl.reqEntrerMateriel(m, agent);
        //set Operation valider automatique car ne necessite pas de validation GAC
        usermetierimpl.entrerMateriel(opentree);
        
        return SUCCESS;
    }
    
    public String addPriseEncharge() {
        Agent agent = (Agent)RequestFilter.getSession().getAttribute("agent");
        //agent.setIp()
        MaterielNouv m = new MaterielNouv();
        m.setAutre(getAutre());
        m.setBureau(getBureau());
        m.setAutre(getAutre());
        //m.setDirec(getDirection());
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
        
        //m.setCaract(caract);
        //m.setCategorie(categorie);
        //m.setImage(image);
        //m.setDocumentPath(documentPath);
        
        // proprietes propre aux materiels nouveaux
        m.setFinancement(getFinancement());
        m.setFournisseur(getFournisseur());
        m.setModAcq(getAcquisition());
        m.setMontant_facture(getMontantFac());
        
        //m.setRefFacture(refFacture);
        
        //set Operation requete entrer materiel nouveau
        OpEntree opEntree = usermetierimpl.reqEntrerMateriel(m, agent);
        return SUCCESS;
    }
    
    public String addAttribution() {
        Agent agent = (Agent)RequestFilter.getSession().getAttribute("agent");
        //agent.setIp()
        OpAttribution opAt= null;
        try {
            //getCurrent Materiel ve?????
             opAt=usermetierimpl.reqAttribution(getMateriel(), agent, getDetenteur());
        }catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        return SUCCESS;
    }
    
    public String addDetachement() {
        Agent agent = (Agent)RequestFilter.getSession().getAttribute("agent");
        //agent.setIp()
        OpDettachement opDet = null;
        try {
            //getCurrent Materiel ve?????
            opDet =usermetierimpl.reqDettachement(this.getMateriel(), agent, getDetenteur());
        }catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        
        
        return SUCCESS;
    }
    
    public String addDecharge() {
        Agent agent = (Agent)RequestFilter.getSession().getAttribute("agent");
        //agent.setIp()
        OpSortie opSort= null;
        try {
            opSort =usermetierimpl.reqSortirMateriel(this.getMateriel(), this.getMotifSortie(), 
                    this.getDestinationDirec(), this.getDestinationService(), this.getDestination(), agent);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }
        return SUCCESS;
    }
    
    ///OLD FUNCTION
    //insert unit price
    public String insertMaterielEx()
    {
        //set unit price for type materiel

        //list typemateriel, nomencl,marq
        if(typemateriel==null || getTypemateriel().equals(""))
            listParamShouldNotBeNull = listParamShouldNotBeNull+"typemateriel ";
        if(nomencl==null || getNomencl().equals(""))
            listParamShouldNotBeNull = listParamShouldNotBeNull+"nomenclature ";
        if(marq==null || getNomencl().equals(""))
            listParamShouldNotBeNull = listParamShouldNotBeNull+"numero de serie ";
        if(unitPrice==null || getUnitPrice().equals(""))
            listParamShouldNotBeNull = listParamShouldNotBeNull+"unitPrice ";
        if(reference==null || getReference().equals(""))
            listParamShouldNotBeNull = listParamShouldNotBeNull+"reference ";
        if(numSerie==null || getNumSerie().equals(""))
            listParamShouldNotBeNull = listParamShouldNotBeNull+"numero de serie ";
        if(carac==null || getCarac().equals(""))
            listParamShouldNotBeNull = listParamShouldNotBeNull+"carateristiques ";
        if(etat==null || getEtat().equals(""))
            listParamShouldNotBeNull = listParamShouldNotBeNull+"etat ";

        if(!listParamShouldNotBeNull.equals(""))
            throw new NullPointerAttributeException(listParamShouldNotBeNull+"should not be empty ");


        return SUCCESS;
    }

    public String insertNouvMat()
    {
        /*
        Sélection sur une liste déroulante du type de matériels
        Affichage automatique de la nomenclature
        Sélection sur une liste déroulante de la marque
        Insertion de la référence
        Insertion du numéro de série (matériels informatiques)
        Insertion des caractéristiques 
        Sélection du mode d’acquisition : Achats-dons-excédent-dotation
        Financement : RPI/ Gasynet/ Fasad/Crédit DGD
        Bailleur/Partenaires + champ libre
            -Montant sur facture
        -Référence facture
            - Fournisseur – Liste déroulante Référentiel
        Nombre par type
        Sélection de l’état au moment de la réception (Neuf/En état de marche/Réparable/hors service)
        Attachement des pièces justificatives (PV, facture, bon de livraison, Ordre de sortie  …)
        Insertion photo du matériel
        Transfert au GAC après pré validation
        Mise à jour du journal (automatique) après validation du GAC
*/
        if(typemateriel==null || getTypemateriel().equals(""))
            listParamShouldNotBeNull = listParamShouldNotBeNull+"typemateriel ";
        if(nomencl==null || getNomencl().equals(""))
            listParamShouldNotBeNull = listParamShouldNotBeNull+"nomenclature ";
        if(marq==null || getNomencl().equals(""))
            listParamShouldNotBeNull = listParamShouldNotBeNull+"numero de serie ";
        if(reference==null || getReference().equals(""))
            listParamShouldNotBeNull = listParamShouldNotBeNull+"reference ";
        if(numSerie==null || getNumSerie().equals(""))
            listParamShouldNotBeNull = listParamShouldNotBeNull+"numero de serie ";
        if(carac==null || getCarac().equals(""))
            listParamShouldNotBeNull = listParamShouldNotBeNull+"carateristiques ";

        /*File file = new File("C:\\mavan-hibernate-image-mysql.gif");
        byte[] bFile = new byte[(int) file.length()];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            //convert file into array of bytes
            fileInputStream.read(bFile);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Avatar avatar = new Avatar();
        avatar.setImage(bFile);*/

        return SUCCESS;
    }
    
}