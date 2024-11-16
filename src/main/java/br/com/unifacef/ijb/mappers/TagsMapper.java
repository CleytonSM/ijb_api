package br.com.unifacef.ijb.mappers;

import br.com.unifacef.ijb.models.dtos.TagsDTO;
import br.com.unifacef.ijb.models.entities.Tags;

public class TagsMapper {
    public static Tags convertTagsDTOIntoTags(TagsDTO tagsDTO){
        return new Tags();
    }

    public static TagsDTO convertTagsIntoTagsDTO(Tags tags){
        return new TagsDTO(tags.getId(),
                           tags.getTagName(),
                           tags.getHexColor());
    }

    public static List<TagsDTO> convertListOfTagsIntoListOfTagsDTO(List<Tags> tags) {
        List<TagsDTO> tagsDTOs = new ArrayList<>();

        for (Tags tags : tags) {
            tagsDTOs.add(convertTagsIntoTagsDTO(tags));
        }

        return tagsDTOs;
    }

    public static void updateTags(TagsDTO tagsUpdate, Tags tags) {
        tags.setTagName(tagsUpdate.getTagName());
        tags.setHexColor(tagsUpdate.getHexColor());
    }


}
