package dev.alperdonmez.ecommerceordermanagement.core.mappers.services;

import org.modelmapper.ModelMapper;

public interface IModelMapperService {
    ModelMapper forRequest();
    ModelMapper forResponse();
}
