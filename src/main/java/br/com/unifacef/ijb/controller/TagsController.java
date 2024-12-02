package br.com.unifacef.ijb.controller;

import br.com.unifacef.ijb.mappers.TagsMapper;
import br.com.unifacef.ijb.models.dtos.TagsCreateDTO;
import br.com.unifacef.ijb.models.dtos.TagsDTO;
import br.com.unifacef.ijb.services.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dashboard/noticias")
public class TagsController {
    @Autowired
    private TagsService tagsService;

    @PostMapping
    public ResponseEntity<TagsDTO> createTag(TagsCreateDTO tagsCreateDTO){
        TagsDTO createdTag = tagsService.createTags(tagsCreateDTO);
        return ResponseEntity.ok(createdTag);
    }

    @GetMapping("/dashboard/noticias/{id}")
    public ResponseEntity<TagsDTO> getTagById(@PathVariable Integer id){
        TagsDTO tag = TagsMapper.convertTagsIntoTagsDTO(tagsService.getById(id));
        return ResponseEntity.ok(tag);
    }

    @GetMapping
    public ResponseEntity<Object> getAllTags(){
        List<TagsDTO> tags = tagsService.getAllTags();
        return ResponseEntity.ok(tags);
    }

    @PutMapping("/dashboard/noticias/{id}")
    public ResponseEntity<TagsDTO> updateTag(@PathVariable Integer id, TagsDTO tagsDTO){
        tagsDTO.setId(id);
        TagsDTO updatedTag = tagsService.updateTags(tagsDTO);
        return ResponseEntity.ok(updatedTag);
    }

    @DeleteMapping("/dashboard/noticias/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable Integer id){
        tagsService.deleteTags(id);
        return ResponseEntity.noContent().build();
    }
}

