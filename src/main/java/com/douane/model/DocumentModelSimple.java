package com.douane.model;

/**
 * Created by hasina on 10/31/17.
 */
import java.io.Serializable;
import org.primefaces.model.UploadedFile;

public class DocumentModelSimple implements Serializable {
    int srNo;
    String documentName;
    String institute;
    boolean removable = Boolean.TRUE;
    boolean uploaded = Boolean.FALSE;
    private UploadedFile documentS;

    public void setDocumentS(UploadedFile documentS) {
        this.documentS = documentS;
    }

    public UploadedFile getDocumentS() {
        return documentS;
    }

    public boolean isRemovable() {
        return removable;
    }

    public void setRemovable(boolean removable) {
        this.removable = removable;
    }

    public String getInstitute() {
        return institute;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public boolean isUploaded() {
        return uploaded;
    }

    public void setUploaded(boolean uploaded) {
        this.uploaded = uploaded;
    }

    public int getSrNo() {
        return srNo;
    }

    public void setSrNo(int srNo) {
        this.srNo = srNo;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

}
