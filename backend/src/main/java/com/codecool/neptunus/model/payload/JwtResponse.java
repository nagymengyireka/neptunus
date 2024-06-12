package com.codecool.neptunus.model.payload;

import java.util.List;

public record JwtResponse(String jwt, String username, List<String> roles) {
}
