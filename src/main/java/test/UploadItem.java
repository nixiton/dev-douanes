package test;

import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class UploadItem {
	private String filename;
    private List<CommonsMultipartFile> fileData;
	public List<CommonsMultipartFile> getFileData() {
		return fileData;
	}
	public void setFileData(List<CommonsMultipartFile> fileData) {
		this.fileData = fileData;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public UploadItem(String filename) {
		this.filename = filename;
	}
}
