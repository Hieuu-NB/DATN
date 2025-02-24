
package com.example.reviewservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

//@Validated
@ConfigurationProperties(prefix = "application.security.rsa")
public record RSAKeyRecord(
         RSAPrivateKey rsaPrivateKey,
         RSAPublicKey rsaPublicKey
) {

}
