package com.yuanhai.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @author yuanhai
 * @date 2020/12/20
 */
@Controller
@RequestMapping("/fileUpload")
public class FileUploadController {

    /**
     * 传统方式文件上传
     * @param request
     * @return
     * @throws Exception
     */
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

    /**
     * springmvc方式文件上传
     * 方法接收MultipartFile对象的名字，必须和前端表单的名字一样，所以这里对象名字是upload
     * @param upload
     * @param request
     * @return
     */
    @RequestMapping("/fileUpload2")
    public String fileUpload2(HttpServletRequest request,MultipartFile upload) throws IOException {
        System.out.println("springmvc方式的文件上传...");

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

        // 获取上传文件的名称
        String fileName = upload.getOriginalFilename();
        // 把文件名称设置成唯一值,uuid
        String uuid = UUID.randomUUID().toString().replace("-","");
        fileName = uuid+"_"+fileName;
        // 完成文件上传
        upload.transferTo(new File(path,fileName));

        return "success";
    }

    /**
     * springmvc，跨图片服务器方式文件上传
     * 方法接收MultipartFile对象的名字，必须和前端表单的名字一样，所以这里对象名字是upload
     * @param upload
     * @return
     */
    @RequestMapping("/fileUpload3")
    public String fileUpload3(MultipartFile upload) throws IOException {
        System.out.println("springmvc跨图片服务器方式的文件上传...");

        // 定义上传文件服务器的路径
        String path = "http://localhost:9090/fileupload_server_war_exploded/uploads/";

        // 获取上传文件的名称
        String fileName = upload.getOriginalFilename();
        // 把文件名称设置成唯一值,uuid
        String uuid = UUID.randomUUID().toString().replace("-","");
        fileName = uuid+"_"+fileName;

        // 完成文件上传，跨图片服务器的方式，把图片传到图片服务器上
        // 创建一个客户端的对象
        Client client = Client.create();
        // 和图片服务器进行连接
        WebResource webResource = client.resource(path + fileName);
        // 上传文件到图片服务器
        webResource.put(upload.getBytes());

        return "success";
    }


}
