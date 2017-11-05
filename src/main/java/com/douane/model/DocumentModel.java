package com.douane.model;

/**
 * Created by hasina on 10/31/17.
 */
import java.io.Serializable;

public class DocumentModel implements Serializable {
    int srNo;
    String documentName;
    String institute;



    byte[] byteArrayImage;
    boolean removable = Boolean.TRUE; // to mention whether the document can be
    // removed or not
    boolean uploaded = Boolean.FALSE; // flag to mention file uploaded status
    private String documentUploadedPath;// to capture uploaded path

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

    public String getDocumentUploadedPath() {
        return documentUploadedPath;
    }

    public void setDocumentUploadedPath(String documentUploadedPath) {
        this.documentUploadedPath = documentUploadedPath;
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

    public byte[] getByteArrayImage() {
        return byteArrayImage;
    }

    public void setByteArrayImage(byte[] byteArrayImage) {
        this.byteArrayImage = byteArrayImage;
    }
}
