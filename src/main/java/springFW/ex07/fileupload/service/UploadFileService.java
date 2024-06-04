package springFw.ex07.fileupload.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springFw.ex07.fileupload.dao.IUploadFileRepository;
import springFw.ex07.fileupload.model.UploadFileVO;

@Service
public class UploadFileService implements IUploadFileService {

	@Autowired
	IUploadFileRepository uploadFileRepository;

	@Override
	public void uploadFile(UploadFileVO file) {
		int newFileId = uploadFileRepository.getMaxFileId() + 1;
		file.setFileId(newFileId);
		uploadFileRepository.uploadFile(file);
	}

	@Override
	public List<UploadFileVO> getFileList(String dir) {
		return uploadFileRepository.getFileList(dir);
	}

	@Override
	public List<UploadFileVO> getAllFileList() {
		return uploadFileRepository.getAllFileList();
	}

	@Override
	public List<UploadFileVO> getImageList(String dir) {
		return uploadFileRepository.getImageList(dir);
	}

	@Override
	public UploadFileVO getFile(int fileId) {
		return uploadFileRepository.getFile(fileId);
	}

	@Override
	public String getDirectoryName(int fileId) {
		return uploadFileRepository.getDirectoryName(fileId);
	}

	@Override
	@Transactional
	public void updateDirectory(int[] fileIds, String directoryName) {
		for(int fileId : fileIds) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("directoryName", directoryName);
			map.put("fileId", fileId);
			uploadFileRepository.updateDirectory(map);
		}
	}

	@Override
	public void deleteFile(int fileId) {
		uploadFileRepository.deleteFile(fileId);
	}

}
