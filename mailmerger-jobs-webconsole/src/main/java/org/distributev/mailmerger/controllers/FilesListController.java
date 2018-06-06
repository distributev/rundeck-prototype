package org.distributev.mailmerger.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FilesListController {

    @PostMapping("/upload")
    @ResponseStatus(HttpStatus.OK)
    public void uploadFile(@RequestParam MultipartFile file) {

    }

    @GetMapping("/")
    public String handleRequest() {
        return "index";
    }
}
