package com.osman.studentmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class FileUploadController {
    private static final String UPLOAD_DIR = "src/main/resources/static/uploads/";
    private static List<String> fileNames = new ArrayList<>();

    @GetMapping("/upload")
    public String uploadFile() {
        return "upload_form";
    }
    @PostMapping("/upload")
    public String showUploadedFile(@RequestParam("file")MultipartFile file,
                                    Model model) {

        if (file.isEmpty()) {
            model.addAttribute("message", "File is empty");
            return "upload_form";
        }

        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        try {
            String fileName = file.getOriginalFilename();
            String filePath = UPLOAD_DIR + fileName;
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_DIR + file.getOriginalFilename());
            System.out.println("Path: " + path);
            Files.write(path, bytes);
//            File dest = new File(filePath);
//            file.transferTo(dest);
            fileNames.add(fileName);
            model.addAttribute("message", "File uploaded successfully");
        } catch (Exception e) {
            model.addAttribute("message", "File upload failed: " + e.getMessage());
        }

        return "redirect:/show_uploaded_file";
    }
    @GetMapping("/show_uploaded_file")
    public String displayImages(Model model) throws IOException {
//        List<String> fileNames = FileUploadController.getFileNames();
//        System.out.println(fileNames);
        List<String> files = Files.walk(Paths.get(UPLOAD_DIR))
                .filter(Files::isRegularFile)
                .map(Path::getFileName)
                .map(Path::toString)
                .collect(Collectors.toList());
        System.out.println(files);
        model.addAttribute("files", files);
//        model.addAttribute("fileNames", fileNames);
        return "show_uploaded_file";
    }

    public static List<String> getFileNames() {
        return fileNames;
    }

}
