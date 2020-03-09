package com.yang.edu.controller;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;


@Controller
public class BannerimgController {

	@RequestMapping("/testCode")
	public String test(){
		return "add";
	}
	

	/**
	 * 添加轮播图
	 * @return
	 */
	@RequestMapping("/addBannerimg")
	@ResponseBody
	public int addBannerimg(
			@RequestParam(value ="affixFileT", required = false) MultipartFile picFiles,HttpServletRequest request) {
		int n = 0;
		// 文件名，
		String fileName = null;		
		if (!picFiles.isEmpty()) {
			// 文件上传后所保存的位置
			String path = request.getSession().getServletContext().getRealPath("statics"+File.separator+"uploadImages"+File.separator+"indexBannerImg"); 
			// 获取上传文件的名字
			String oldFileName = picFiles.getOriginalFilename();//获取文件的原名字
			// 获取所上传文件的文件类型（即：文件的后缀名）
			String prefix=FilenameUtils.getExtension(oldFileName);//原文件后缀     
			// 设置文件可上传大小最大值
			int filesize = 5000000;
			
			// 判断所上传文件的大小是否超过最大值
	        if(picFiles.getSize() >  filesize){//上传大小不得超过 500k
            	request.setAttribute("uploadPicError", " * 上传大小不得超过 500k");
            	//超过大小不允许跳转，直接返回以前的视图页面
	        	return -1;
            }else if(prefix.equalsIgnoreCase("jpg") || prefix.equalsIgnoreCase("png") 
            		|| prefix.equalsIgnoreCase("gif")||prefix.equalsIgnoreCase("jpeg")){//上传图片格式不正确
            	fileName="indexBannerImg_"+System.currentTimeMillis()+"."+prefix;
                File targetFile = new File(path, fileName);  
                if(!targetFile.exists()){  
                    targetFile.mkdirs();  
                }  
                //保存  
                try {  
                	picFiles.transferTo(targetFile);  
                } catch (Exception e) {  
                    e.printStackTrace();  
                    request.setAttribute("uploadPicError", " * 上传失败！");
                    return -2;
                }  
            }else{
            	request.setAttribute("uploadPicError", " * 上传图片格式不正确");
            	return -3;
            }
	        
	        //将变更后的图片 名 赋值给 teacherHeadImg
		}

		return n;
	}
}
