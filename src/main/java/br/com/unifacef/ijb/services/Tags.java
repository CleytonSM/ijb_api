package br.com.unifacef.ijb.services;

import br.com.unifacef.ijb.helpers.OptionalHelper;
import br.com.unifacef.ijb.mappers.TagsMapper;
import br.com.unifacef.ijb.models.dtos.TagsDTO;
import br.com.unifacef.ijb.models.entities.Tags;
import br.com.unifacef.ijb.repositories.TagsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagsService {
    @Autowired
    private TagsRepository tagsRepository;

    public Tags save(Tags tags) {
        return tagsRepository.save(tags);
    }

    public Tags getById(Integer id) {
        return OptionalHelper.getOptionalEntity(tagsRepository.findById(id));
    }

    @Transactional
    public TagsDTO createTags(TagsDTO tags) {
        Tags tags = TagsMapper.convertTagsDTOIntoTags(tags);

        return TagsMapper.convertTagsIntoTagsDTO(save(tags));
    }

    public List<TagsDTO> getAllTags() {
        return TagsMapper.convertListOfTagsIntoListOfTagsDTO(tagsRepository.findAll());
    }

    @Transactional
    public TagsDTO updateTags(TagsDTO tagsUpdate) {
        tags tags = getById(TagsUpdate.getId());
        updateRetrievedEntity(tagsUpdate, tags);

        return TagsMapper.convertTagsIntoTagsDTO(save(tags));
    }

    @Transactional
    public void deleteTags(Integr id) {
        if (tagsRepository.existsById(id)) {
            tagsRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Tag não encontrada");
        }
    }
}
