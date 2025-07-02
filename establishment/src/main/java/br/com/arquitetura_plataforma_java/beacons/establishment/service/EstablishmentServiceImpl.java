package br.com.arquitetura_plataforma_java.beacons.establishment.service;

import DTO.EstablishmentDTO;
import br.com.arquitetura_plataforma_java.beacons.establishment.entity.EstablishmentEntity;
import br.com.arquitetura_plataforma_java.beacons.establishment.mapper.EstablishmentMapper;
import br.com.arquitetura_plataforma_java.beacons.establishment.repository.EstablishmentRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
class EstablishmentServiceImpl implements EstablishmentService {

    private final RestTemplate restTemplate;
    private final String iamUrl;
    private final EstablishmentRepository repository;
    private final EstablishmentMapper mapper;

    public EstablishmentServiceImpl(
            RestTemplate restTemplate,
            @Value("${iam.url}") String iamUrl,
            EstablishmentRepository repository,
            EstablishmentMapper mapper) {
        this.restTemplate = restTemplate;
        this.iamUrl = iamUrl;
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public String teste() {
        return "teste";
    }

    @Override
    public List<EstablishmentDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EstablishmentDTO findById(int id) {
        EstablishmentEntity entity = repository.findById(id);
        return mapper.toDTO(entity);
    }

    @Override
    public EstablishmentDTO create(EstablishmentDTO dto) {
        EstablishmentEntity entity = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public EstablishmentDTO update(int id, EstablishmentDTO dto) {
        EstablishmentEntity existing = repository.findById(id);
        existing.setNome(dto.getNome());
        existing.setEndereco(dto.getEndereco());
        return mapper.toDTO(repository.save(existing));
    }

    @Override
    public void delete(int id) {
        EstablishmentEntity existing = repository.findById(id);
        repository.delete(existing);
    }
}
