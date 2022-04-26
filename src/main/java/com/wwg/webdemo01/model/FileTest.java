package com.wwg.webdemo01.model;

import com.wwg.webdemo01.util.FileFullUtil;
import lombok.extern.slf4j.Slf4j;



import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;

import java.io.*;

/**
 * <p></p>
 *
 * @author wangweiguang 2021/12/10 15:26
 */
@Slf4j
public class FileTest {


    public static void main(String[] args) {
        ByteArrayInputStream copyIns = null;
        try {
            String path = "C:\\Users\\Administrator\\Desktop\\working\\888.jpg";
            File file = new File(path);
            MultipartFile multipartFile = new FileTest().fileToMultipartFile(file);
            copyIns = new ByteArrayInputStream(multipartFile.getBytes());
            String s = FileFullUtil.md5(copyIns);

            System.out.println("=========="+s);
        } catch (IOException e) {
            log.error("校验异常{}", e);
        } finally {
            if (copyIns != null) {
                try {
                    copyIns.close();
                } catch (IOException e) {

                }
            }
        }
    }

    public MultipartFile fileToMultipartFile(File file) {
        FileItem fileItem = createFileItem(file);
        MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
        return multipartFile;
    }

    private static FileItem createFileItem(File file) {
        FileItemFactory factory = new DiskFileItemFactory(16, null);
        FileItem item = factory.createItem("textField", "text/plain", true, file.getName());
        int bytesRead = 0;
        byte[] buffer = new byte[8192];
        try {
            FileInputStream fis = new FileInputStream(file);
            OutputStream os = item.getOutputStream();
            while ((bytesRead = fis.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return item;
    }

}
