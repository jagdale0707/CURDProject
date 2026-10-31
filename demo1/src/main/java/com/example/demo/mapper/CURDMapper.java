package com.example.demo.mapper;

import com.example.demo.Entity.CURDEntity;
import com.example.demo.request.CURDRequest;
import com.example.demo.response.CURDResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CURDMapper {
    CURDResponse toDto(CURDEntity curdEntity);
    CURDEntity toEntity(CURDRequest curdRequest);
    List<CURDResponse> toDtoList(List<CURDEntity> curdEntity);
}
