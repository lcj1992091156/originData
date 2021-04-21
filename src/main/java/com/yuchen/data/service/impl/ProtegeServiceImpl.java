package com.yuchen.data.service.impl;

import com.yuchen.data.mapper.neo4j.ProtegeMapper;
import com.yuchen.data.model.Protege;
import com.yuchen.data.request.ClassParamRequestEntity;
import com.yuchen.data.request.RelationshipParamRequestEntity;
import com.yuchen.data.service.ProtegeService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @author admin
 */
@Service
@Log4j2
public class ProtegeServiceImpl  implements ProtegeService {

    @Autowired
    private ProtegeMapper protegeMapper;
    @Override
    @Transactional(rollbackFor = Exception.class,value ="transactionManager2")
    public String addProtege(Protege protege) {
        UUID uuid = UUID.randomUUID();
        protege.setStrId(uuid.toString());
        int add = protegeMapper.add(protege);

        return uuid.toString();
    }

    @Override
    public Integer selectByIdCount(Integer id) {
        return protegeMapper.selectByIdCount(id);
    }

    @Override
    public int addRelationship(RelationshipParamRequestEntity RelationshipParamRequestEntity) {
        return protegeMapper.addRelationship(RelationshipParamRequestEntity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class,value ="transactionManager2")
    public Object addProtegeRelationShip(RelationshipParamRequestEntity entity) {
        Protege protege = entity.getProtege();
        if(protege==null){
            log.error("参数为空{}",1);
        }
        //关系节点

        Integer idCount = this.selectByIdCount(entity.getId());

        if(idCount==1){
            String uuid = this.addProtege(protege);
            RelationshipParamRequestEntity   paramRequestEntity=new RelationshipParamRequestEntity();
            paramRequestEntity.setId(entity.getId());
            paramRequestEntity.setTagId(uuid);
            //TODO 以后传值对象。
            paramRequestEntity.setRelationship(entity.getRelationship());
            int i = this.addRelationship(paramRequestEntity);
            return   i;
        }else{
            log.error("===============ID重复校验数据{}",entity.getId());
        }

        return null;
    }

    @Override
    public Object queryAll(ClassParamRequestEntity entity) {
        Boolean parentNode = entity.getParentNode();
        String name = entity.getName();
        if(name!=null&&!name.equals("")){
            entity.setName(".*"+entity.getName()+".*");
        }
        //默认true
        if(parentNode){
            return  protegeMapper.selectAll(entity);
        }
        return protegeMapper.selectAllSon(entity);
    }
}
