package br.com.arquitetura_plataforma_java.beacons.iam.service;

import DTO.TokenDTO;

public interface AuthenticatorService {
    TokenDTO getToken();
}
