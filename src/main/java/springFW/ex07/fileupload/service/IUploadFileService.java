package springFw.ex07.fileupload.service;

import java.util.List;

import springFw.ex07.fileupload.model.UploadFileVO;

public interface IUploadFileService {

	void uploadFile(UploadFileVO file);

	List<UploadFileVO> getFileList(String dir);
	List<UploadFileVO> getAllFileList();
	List<UploadFileVO> getImageList(String dir);

	UploadFileVO getFile(int fileId);
	
	String getDirectoryName(int fileId);
	void updateDirectory(int[] fileIds, String directoryName);

	void deleteFile(int fileId);
}