package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.TagsCreateDTO;
import br.com.unifacef.ijb.models.dtos.TagsDTO;
import br.com.unifacef.ijb.models.entities.Tags;

import java.util.ArrayList;
import java.util.List;

public class TagsMapper {

    public static Tags convertTagsCreateDTOIntoTags(
            TagsCreateDTO tagsCreate) {
        return new Tags(
                tagsCreate.getLabelName(),
                tagsCreate.getColorHexadecimal()
        );
    }

    public static TagsDTO convertTagsIntoTagsDTO(Tags tags) {
        return new TagsDTO(
                tags.getId(),
                tags.getLabelName(),
                tags.getColorHexadecimal()
        );
    }

    public static List<TagsDTO> convertListOfTagsIntoListOfTagsDTO(
            List<Tags> tags) {
        List<TagsDTO> tagsDTOs = new ArrayList<>();

        for (Tags tag : tags) {
            tagsDTOs.add(convertTagsIntoTagsDTO(tag));
        }

        return tagsDTOs;
    }

    public static void updateTags(TagsDTO tagsUpdate, Tags tags) {
        tags.setLabelName(tagsUpdate.getLabelName());
        tags.setColorHexadecimal(tagsUpdate.getColorHexadecimal());
    }

    public static Tags convertTagsDTOIntoTags(TagsDTO tagsDTO) {
        return new Tags(
                tagsDTO.getLabelName(),
                tagsDTO.getColorHexadecimal()
        );
    }

}

