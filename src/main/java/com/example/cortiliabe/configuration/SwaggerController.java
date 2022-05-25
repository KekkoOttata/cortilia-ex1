package com.example.cortiliabe.configuration;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/swagger/cortilia")
public class SwaggerController {

    @RequestMapping("")
    public void apiDocumentation(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }
}