package org.example.springbootauthjwt.Data;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Data
@Repository
public class UsersData {

    private final Map<String, String> userStore = new HashMap<>();

    public UsersData() {
    }
}
