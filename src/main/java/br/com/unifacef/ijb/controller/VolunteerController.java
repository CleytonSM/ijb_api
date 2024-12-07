package br.com.unifacef.ijb.controller;

import br.com.unifacef.ijb.mappers.VolunteerMapper;
import br.com.unifacef.ijb.models.dtos.VolunteerDTO;
import br.com.unifacef.ijb.models.dtos.VolunteerRegisterDTO;
import br.com.unifacef.ijb.services.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/volunteers")
public class VolunteerController {

    @Autowired
    private VolunteerService volunteerService;

    @PostMapping
    public ResponseEntity<VolunteerDTO> inserir(@RequestBody VolunteerRegisterDTO volunteerRegisterDTO,
                                                @RequestParam String volunteerType) {
        try {
            VolunteerDTO createdVolunteer = VolunteerMapper.convertVolunteerIntoVolunteerDTO(
                    volunteerService.createVolunteer(volunteerRegisterDTO, volunteerType)
            );
            return ResponseEntity.ok(createdVolunteer);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<VolunteerDTO>> findAll() {
        List<VolunteerDTO> volunteers = volunteerService.findAll();
        return ResponseEntity.ok(volunteers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VolunteerDTO> consultaPorId(@PathVariable Integer id) {
        VolunteerDTO volunteer = volunteerService.findById(id);
        if (volunteer != null) {
            return ResponseEntity.ok(volunteer);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> remove(@PathVariable Integer id) {
        String response = volunteerService.remove(id);
        if (response.contains("removido")) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.status(404).body(response);
    }

    @DeleteMapping
    public ResponseEntity<String> removeAll() {
        String response = volunteerService.removeAll();
        return ResponseEntity.ok(response);
    }
}
