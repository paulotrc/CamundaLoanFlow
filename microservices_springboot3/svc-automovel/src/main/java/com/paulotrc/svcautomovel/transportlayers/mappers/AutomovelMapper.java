package com.paulotrc.svcautomovel.transportlayers.mappers;

import com.paulotrc.svcautomovel.entities.Automovel;
import com.paulotrc.svcautomovel.transportlayers.dto.request.AutomovelRequest;
import com.paulotrc.svcautomovel.transportlayers.dto.response.AutomovelResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface AutomovelMapper {

    AutomovelMapper INSTANCE = Mappers.getMapper(AutomovelMapper.class);

    Automovel map(AutomovelRequest automovelRequest);

    AutomovelResponse mapResponse(Automovel automovel);

    default List<AutomovelResponse> mapListResponse(List<Automovel> automovels){
        final List<AutomovelResponse> automovelResponseList = new ArrayList<>();
        for (Automovel automovel:automovels) {
            AutomovelResponse automovelResp = AutomovelMapper.INSTANCE.mapResponse(automovel);
            automovelResponseList.add(automovelResp);
        }
        return automovelResponseList;
    }
}

