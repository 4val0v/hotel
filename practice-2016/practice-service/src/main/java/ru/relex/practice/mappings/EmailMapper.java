package ru.relex.practice.mappings;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import ru.relex.practice.dto.EmailDTO;
import ru.relex.practice.model.Email;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class EmailMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "email", target = "email")

    public abstract EmailDTO emailToDto(Email email);

    public abstract Email emailDtoToEmail(EmailDTO emailDTO);

    public abstract List<EmailDTO> emailsToDtos(Collection<Email> emails);
}
