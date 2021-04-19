package com.yuchen.data.service.impl;

import com.yuchen.data.mapper.neo4j.ProtegeMapper;
import com.yuchen.data.model.Protege;
import com.yuchen.data.request.RelationshipParamRequestEntity;
import com.yuchen.data.service.ProtegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author admin
 */
@Service
public class ProtegeServiceImpl  implements ProtegeService {
    @Autowired
    private ProtegeMapper protegeMapper;
    @Override
    public Object addProtege(Protege protege) {
        return protegeMapper.add(protege);
    }

    @Override
    public Integer selectByIdCount(String id) {
        return protegeMapper.selectByIdCount(id);
    }

    @Override
    public int addRelationship(RelationshipParamRequestEntity RelationshipParamRequestEntity) {
        return protegeMapper.addRelationship(RelationshipParamRequestEntity);
    }
}
