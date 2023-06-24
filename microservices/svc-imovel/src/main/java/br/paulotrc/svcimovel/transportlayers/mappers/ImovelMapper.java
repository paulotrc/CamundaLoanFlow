package br.paulotrc.svcimovel.transportlayers.mappers;

import br.paulotrc.svcimovel.entites.Imovel;
import br.paulotrc.svcimovel.transportlayers.dto.request.ImovelRequest;
import br.paulotrc.svcimovel.transportlayers.dto.response.ImovelResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface ImovelMapper {

    ImovelMapper INSTANCE = Mappers.getMapper(ImovelMapper.class);

    Imovel map(ImovelRequest imovelRequest);

    ImovelResponse mapResponse(Imovel imovel);

    default List<ImovelResponse> mapListResponse(List<Imovel> imovels){
        final List<ImovelResponse> imovelResponseList = new ArrayList<>();
        for (Imovel imovel:imovels) {
            ImovelResponse imovelResp = ImovelMapper.INSTANCE.mapResponse(imovel);
            imovelResponseList.add(imovelResp);
        }
        return imovelResponseList;
    }
}

