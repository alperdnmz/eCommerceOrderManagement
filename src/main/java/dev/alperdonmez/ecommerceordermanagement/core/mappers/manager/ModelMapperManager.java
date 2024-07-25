package dev.alperdonmez.ecommerceordermanagement.core.mappers.manager;

import dev.alperdonmez.ecommerceordermanagement.core.mappers.services.IModelMapperService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelMapperManager implements IModelMapperService {
    private ModelMapper modelMapper;

    @Override
    public ModelMapper forRequest(){
        this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.LOOSE);
        return this.modelMapper;
    }

    public ModelMapper forResponse(){
        this.modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.LOOSE);
        return this.modelMapper;
    }
}
