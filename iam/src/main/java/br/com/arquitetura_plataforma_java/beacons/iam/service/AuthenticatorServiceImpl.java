package br.com.arquitetura_plataforma_java.beacons.iam.service;

import org.springframework.stereotype.Service;

@Service
class AuthenticatorServiceImpl implements AuthenticatorService {

    @Override
    public String teste() {
        return "teste de acesso";
    }
}
