package org.example.springbootauthjwt.Controller;


import org.example.springbootauthjwt.Data.UsersData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SecureController {
    private final UsersData usersData;

    public SecureController(UsersData usersData) {
        this.usersData = usersData;
    }

    @GetMapping("/secure")
    public String secure(){
        return "This is a secure endpoint. You are authenticated" + usersData.getUserStore();

    }
}
