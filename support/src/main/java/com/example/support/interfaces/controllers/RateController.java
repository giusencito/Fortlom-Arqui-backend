package com.example.support.interfaces.controllers;
import com.example.support.domain.rateAgreegate.entity.Rate;
import com.example.support.domain.rateAgreegate.service.RateService;
import com.example.support.interfaces.dto.Rate.CreateRateResource;
import com.example.support.interfaces.dto.Rate.RateResource;
import com.example.support.interfaces.mapping.entity.RateMapper;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
@RequestMapping("/api/v1/supportservice")
public class RateController {

    @Autowired
    private RateService rateService;

    @Autowired
    private RateMapper mapper;

    @Autowired
    private ModelMapper mapping;


    @GetMapping("/rates")
    public Page<RateResource> getAllrates(Pageable pageable) {
        return mapper.modelListToPage(rateService.getAllRates(), pageable);
    }
    @GetMapping("/rates/{rateId}")
    public ResponseEntity<RateResource> getRateById(@PathVariable Long rateId) {

        return ResponseEntity.ok(mapper.toResource(rateService.getRateById(rateId)));

    }
    @GetMapping("/artists/{artistId}/rates")
    public ResponseEntity<Page<RateResource>> getRateByartistId(@PathVariable Long usersId,Pageable pageable) {

        return ResponseEntity.ok(mapper.modelListToPage(rateService.getRateByartistId(usersId), pageable));
    }
    @GetMapping("/artists/{artistId}/fanatics/{fanaticid}/rates")
    public ResponseEntity<Page<RateResource>> getRateByartistIdandfanaticId(@PathVariable Long artistId,@PathVariable Long fanaticid,Pageable pageable) {

        return ResponseEntity.ok(mapper.modelListToPage(rateService.findByArtistidAndFanaticid(artistId,fanaticid), pageable));
    }
    @GetMapping("/fanatics/{fanaticId}/rates")
    public ResponseEntity<Page<RateResource>> getRateByfanaticId(@PathVariable Long fanaticId,Pageable pageable) {

        return ResponseEntity.ok(mapper.modelListToPage(rateService.getRateByfanaticId(fanaticId), pageable));
    }
    @PostMapping("/artists/{artistId}/fanatics/{fanaticId}/rates")
    public ResponseEntity<RateResource> createRate(@PathVariable Long artistId,@PathVariable Long fanaticId,@RequestBody CreateRateResource request) {
        Rate rate = mapping.map(request, Rate.class);
        return ResponseEntity.ok(mapping.map(rateService.createRate(artistId, fanaticId,rate), RateResource.class));
    }
    @GetMapping("/check/{artistoid}/{fanaticid}/rates")
    public boolean existbyartistoidandfanaticid(@PathVariable("artistoid") Long artistoid,@PathVariable("fanaticid") Long fanaticid){
        return rateService.existsByArtistidAndFanaticid(artistoid,fanaticid);
    }
    @DeleteMapping("/rates/{rateId}")
    public ResponseEntity<?> delete(@PathVariable Long rateId) {
        return rateService.delete(rateId);
    }

    @PutMapping("/update/{rateId}")
    public RateResource updateRate(@PathVariable Long rateId,@RequestBody CreateRateResource request) {
        return mapper.toResource(rateService.update(rateId,mapper.toModel(request)));
    }

}
