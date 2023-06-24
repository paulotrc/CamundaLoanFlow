package br.paulotrc.svcserasa.transportlayers.mappers;

import br.paulotrc.svcserasa.entites.Serasa;
import br.paulotrc.svcserasa.transportlayers.dto.request.SerasaRequest;
import br.paulotrc.svcserasa.transportlayers.dto.response.SerasaResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface SerasaMapper {

    SerasaMapper INSTANCE = Mappers.getMapper(SerasaMapper.class);

    Serasa map(SerasaRequest serasaRequest);

    SerasaResponse mapResponse(Serasa serasa);

    default List<SerasaResponse> mapListResponse(List<Serasa> serasas){
        final List<SerasaResponse> serasaResponseList = new ArrayList<>();
        for (Serasa serasa:serasas) {
            SerasaResponse serasaResp = SerasaMapper.INSTANCE.mapResponse(serasa);
            serasaResponseList.add(serasaResp);
        }
        return serasaResponseList;
    }
}

