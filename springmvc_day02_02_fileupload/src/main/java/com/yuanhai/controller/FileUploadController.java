package com.yuanhai.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * @author yuanhai
 * @date 2020/12/20
 */
@Controller
@RequestMapping("/fileUpload")
public class FileUploadController {

    @RequestMapping("/fileUpload1")
    public String fileUpload1(HttpServletRequest request) throws Exception {
        System.out.println("fileUpload1 run...");

        // 使用fileupload组件完成文件上传
        // 文件上传的位置
        System.out.println("getContextPath : "+request.getSession().getServletContext().getContextPath());
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        // 判断该路径是否存在
        File file =new File(path);
        if(!file.exists()){
            // 创建该文件夹
            file.mkdirs();
        }
        // 解析request对象，从而获取到上传的文件项
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        // 解析request
        List<FileItem> fileItemList = servletFileUpload.parseRequest(request);
        // 遍历
        for(FileItem item : fileItemList){
            // 判断当前的item是否是一个上传文件的选项
            if(item.isFormField()){
                // 为true说明该项是个普通的表单项

            }else{
                // 说明是一个上传文件项
                // 获取到上传文件的名称
                String fileName = item.getName();
                // 把文件名称设置成唯一值,uuid
                String uuid = UUID.randomUUID().toString().replace("-","");
                fileName = uuid+"_"+fileName;
                // 后台完成文件上传
                item.write(new File(path,fileName));
                // 删除临时文件
                item.delete();
            }
        }

        return "success";
    }


}
