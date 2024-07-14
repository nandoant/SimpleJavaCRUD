package com.cubos.challenge.service;


import com.cubos.challenge.domain.model.Contributors;
import com.cubos.challenge.domain.model.dto.PercentageDTO;
import com.cubos.challenge.domain.repository.ContributorsRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContributorsService {

    private final ContributorsRepository contributorsRepository;

    public ContributorsService(ContributorsRepository contributorsRepository) {
        this.contributorsRepository = contributorsRepository;
    }

    @Transactional
    public Contributors create(Contributors contributor) {
        contributor.setId(null);
        return contributorsRepository.save(contributor);
    }

    public Contributors find(Long id) {
        Optional<Contributors> contributor = contributorsRepository.findById(id);
        if(contributor.isPresent()) {
            return contributor.get();
        }
        throw new RuntimeException();
    }

    @Transactional
    public Contributors update(Contributors contributor) {
        Contributors updatedContributor = this.find(contributor.getId());
        updatedContributor.setFirst_name(contributor.getFirst_name());
        updatedContributor.setLast_name(contributor.getLast_name());
        updatedContributor.setParticipation((contributor.getParticipation()));

        return this.contributorsRepository.save(updatedContributor);
    }


    public void delete(Long id) {
        Contributors contributor = this.find(id);
        this.contributorsRepository.delete(contributor);
    }

    public List<Contributors> getAll(){
        return this.contributorsRepository.findAll();
    }

    public List<PercentageDTO> getAllPercentages() {

        List<Contributors> contributors = this.getAll();
        long total;
        List<PercentageDTO> percentages = new ArrayList<>();

        total = contributors.stream().mapToLong(Contributors::getParticipation).sum();

        for(Contributors contributor : contributors) {
            BigDecimal percentage = new BigDecimal(contributor.getParticipation()).divide(new BigDecimal(total),
                    new MathContext(5));
            PercentageDTO data = new PercentageDTO(contributor.getId(), percentage);
            percentages.add(data);
        }

        return percentages;

    }



}
