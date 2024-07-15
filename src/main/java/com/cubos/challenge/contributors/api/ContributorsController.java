package com.cubos.challenge.contributors.api;

import com.cubos.challenge.contributors.service.ContributorsService;
import com.cubos.challenge.contributors.domain.Contributors;
import com.cubos.challenge.contributors.domain.dto.PercentageDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/contributors")
@Validated
public class ContributorsController {

    private final ContributorsService service;

    public ContributorsController(ContributorsService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Contributors> create(@Valid @RequestBody Contributors contributor){
        Contributors newContributor = this.service.create(contributor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newContributor.getId())
                .toUri();
        return ResponseEntity.created(uri).body(newContributor);
    }

    @GetMapping
    public ResponseEntity<List<Contributors>> findAll(){
        List<Contributors> allContributors = this.service.getAll();
        return ResponseEntity.ok().body(allContributors);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contributors>update(@PathVariable Long id, @Valid @RequestBody Contributors contributor){
        contributor.setId(id);
        Contributors updatedContributor = this.service.update(contributor);
        return ResponseEntity.ok().body(updatedContributor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contributors> findById(@PathVariable Long id) {
        Contributors contributor = this.service.find(id);
        return ResponseEntity.ok().body(contributor);
    }

    @GetMapping("/percentages")
    public ResponseEntity<List<PercentageDTO>> getAll() {
        List<PercentageDTO> percentages = this.service.getAllPercentages();
        return ResponseEntity.ok().body(percentages);
    }


    
}
