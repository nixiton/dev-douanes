package com.douane.model;

import org.primefaces.model.UploadedFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by hasina on 11/2/17.
 */
public class UploadedFileByte implements UploadedFile {


    public UploadedFileByte(UploadedFile u)
    {

    }
    private byte[] byteDoc;

    public byte[] getByteDoc() {
        return byteDoc;
    }

    public void setByteDoc(byte[] byteDoc) {
        this.byteDoc = byteDoc;
    }

    @Override
    public String getFileName() {
        return null;
    }

    @Override
    public InputStream getInputstream() throws IOException {
        return null;
    }

    @Override
    public long getSize() {
        return 0;
    }

    @Override
    public byte[] getContents() {
        return new byte[0];
    }

    @Override
    public String getContentType() {
        return null;
    }

    @Override
    public void write(String s) throws Exception {

    }
}
