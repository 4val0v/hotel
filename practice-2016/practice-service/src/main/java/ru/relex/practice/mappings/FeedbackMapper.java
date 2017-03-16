package ru.relex.practice.mappings;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import ru.relex.practice.dao.FacilityDao;
import ru.relex.practice.dao.FeedbackDao;
import ru.relex.practice.dto.FeedbackDTO;
import ru.relex.practice.model.Feedback;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class FeedbackMapper {

	@Autowired
	FeedbackDao feedbackDao;
	
    @Mapping(source = "id", target = "id")
    @Mapping(source = "theme", target = "theme")
    @Mapping(source = "message", target = "message")
    @Mapping(source = "email", target = "email")

    public abstract FeedbackDTO feedbackToDto(Feedback feedback);

    public abstract Feedback FeedbackDtoToFeedback(FeedbackDTO feedbackDTO);

    public abstract List<FeedbackDTO> feedbacksToDtos(Collection<Feedback> feedbacks);
}
