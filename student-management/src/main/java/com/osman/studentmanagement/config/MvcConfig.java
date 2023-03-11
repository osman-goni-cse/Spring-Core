//package com.osman.studentmanagement.config;
//
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//public class MvcConfig implements WebMvcConfigurer {
//
//    private static final String UPLOAD_DIR = "./uploads/";
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/uploads/**")
//                .addResourceLocations("file:" + UPLOAD_DIR + "/");
//    }
//}
