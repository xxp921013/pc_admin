package com.xxp.pc_admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xxp.pc_admin.base.PageResult;
import com.xxp.pc_admin.dto.RoundDTO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.xxp.pc_admin.domain.Rounds;

import java.util.Date;
import java.util.List;

import com.xxp.pc_admin.domain.RoundsExample;
import com.xxp.pc_admin.dao.RoundsMapper;
import com.xxp.pc_admin.service.RoundsService;

@Service
public class RoundsServiceImpl implements RoundsService {

    @Resource
    private RoundsMapper roundsMapper;

    @Override
    public long countByExample(RoundsExample example) {
        return roundsMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(RoundsExample example) {
        return roundsMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Integer rid) {
        return roundsMapper.deleteByPrimaryKey(rid);
    }

    @Override
    public int insert(Rounds record) {
        return roundsMapper.insert(record);
    }

    @Override
    public int insertSelective(Rounds record) {
        return roundsMapper.insertSelective(record);
    }

    @Override
    public List<Rounds> selectByExample(RoundsExample example) {
        return roundsMapper.selectByExample(example);
    }

    @Override
    public Rounds selectByPrimaryKey(Integer rid) {
        return roundsMapper.selectByPrimaryKey(rid);
    }

    @Override
    public int updateByExampleSelective(Rounds record, RoundsExample example) {
        return roundsMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Rounds record, RoundsExample example) {
        return roundsMapper.updateByExample(record, example);
    }

    @Override
    public int updateByPrimaryKeySelective(Rounds record) {
        return roundsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Rounds record) {
        return roundsMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageResult getList(String creator, Integer articleId, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<RoundDTO> list = roundsMapper.getList(creator, articleId);
        list.parallelStream().forEach(roundDTO -> roundDTO.setCreateTime(new Date(roundDTO.getGmtCreate())));
        PageInfo<RoundDTO> roundDTOPageInfo = new PageInfo<>(list);
        return PageResult.success("查找回复成功!", list, (int) roundDTOPageInfo.getTotal());
    }

}
