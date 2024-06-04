package springFw.ex07.fileupload.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.slf4j.Slf4j;
import springFw.ex07.fileupload.model.UploadFileVO;
import springFw.ex07.fileupload.service.IUploadFileService;

@Slf4j
@Controller
@RequestMapping("/upload")
public class UploadFileController {
	
	@Autowired
	IUploadFileService uploadService;
	
	@RequestMapping("list")
	public String getFileList(Model model) {
		List<UploadFileVO> list = uploadService.getAllFileList();
		model.addAttribute("fileList", list);
		
		return "list";
	}
	
	@RequestMapping("gallery")
	public String getImageList(@RequestParam(value="dir", required=false, defaultValue="/images") String dir, Model model) {
		List<UploadFileVO> list = uploadService.getImageList(dir);
		model.addAttribute("fileList", list);
		
		return "list";
	}
	
	@RequestMapping("list/{dir}")
	public String getFileListByDir(@PathVariable String dir, Model model) {
		List<UploadFileVO> list = uploadService.getFileList("/"+dir);
		model.addAttribute("fileList", list);
		
		return "list";
	}
	
	@RequestMapping(value="new", method=RequestMethod.GET)
	public String uploadFile(Model model) {
		return "form";
	}
	
	@RequestMapping(value="new", method=RequestMethod.POST)
	public String uploadFile(@RequestParam(value="dir", required=false, defaultValue="/") 
	String dir, MultipartFile file, RedirectAttributes redirectAttrs, Model model) {
		log.debug(file.getOriginalFilename());
		
		try {
			UploadFileVO newFile = new UploadFileVO();
			
			newFile.setDirectoryName(dir);
			newFile.setFileName(file.getOriginalFilename());
			newFile.setFileSize(file.getSize());
			newFile.setFileContentType(file.getContentType());
			newFile.setFileData(file.getBytes());
			
			uploadService.uploadFile(newFile);
		} catch(Exception e) {
			log.error(e.getMessage());
			redirectAttrs.addFlashAttribute("message", e.getMessage());
		}
		
		return "redirect:/upload/list";
	}
	
	@RequestMapping("/file/{fileId}")
	public ResponseEntity<byte[]> getBinaryFile(@PathVariable int fileId) {
		UploadFileVO file = uploadService.getFile(fileId);
		
		if (file != null) {
			log.debug("getFile: "+file.toString());
			HttpHeaders headers = new HttpHeaders();
			
			String[] mytypes = file.getFileContentType().split("/");
			
			headers.setContentType(new MediaType(mytypes[0], mytypes[1]));
			headers.setContentLength(file.getFileSize());
			headers.setContentDispositionFormData("attachment", file.getFileName());
			
			return new ResponseEntity<byte[]>(file.getFileData(), headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping("/delete/{fileId}")
	public String deleteFile(@PathVariable int fileId) {
		uploadService.deleteFile(fileId);
		
		return "redirect:/upload/list";
	}
	
	@RequestMapping("/updateDir")
	public String updateDirectory(@RequestParam int[] fileIds, @RequestParam String directoryName) {
		uploadService.updateDirectory(fileIds, directoryName);
		return "redirect:/upload/list";
	}
	
}
