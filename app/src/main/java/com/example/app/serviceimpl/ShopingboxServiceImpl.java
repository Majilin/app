package com.example.app.serviceimpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.app.model.Shopingbox;
import com.example.app.mapper.ShopingboxMapper;
import com.example.app.service.ShopingboxService;

import java.util.List;

@Service
public class ShopingboxServiceImpl implements ShopingboxService{

    @Resource
    private ShopingboxMapper shopingboxMapper;

    @Override
    public List<Shopingbox> getshopcarlist(Integer userid) {
        return shopingboxMapper.getshopcarlist(userid);
    }

    @Override
    public Shopingbox getshopcarBySid(Integer sid,Integer userid) {
        return shopingboxMapper.getshopcarBySid(sid,userid);
    }

    @Override
    public int deleteByPrimaryKey(Integer sid) {
        return shopingboxMapper.deleteByPrimaryKey(sid);
    }

    @Override
    public int insert(Shopingbox record) {
        return shopingboxMapper.insert(record);
    }

    @Override
    public int insertSelective(Shopingbox record) {
        return shopingboxMapper.insertSelective(record);
    }

    @Override
    public Shopingbox selectByPrimaryKey(Integer sid) {
        return shopingboxMapper.selectByPrimaryKey(sid);
    }

    @Override
    public int updateByPrimaryKeySelective(Shopingbox record) {
        return shopingboxMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Shopingbox record) {
        return shopingboxMapper.updateByPrimaryKey(record);
    }

}

