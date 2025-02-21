package edu.nenu.tliaswebserver.service.impl;

import edu.nenu.tliaswebserver.mapper.DeptLogMapper;
import edu.nenu.tliaswebserver.mapper.DeptMapper;
import edu.nenu.tliaswebserver.pojo.DeptLog;
import edu.nenu.tliaswebserver.service.DeptLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class DeptLogServiceImpl implements DeptLogService {

    @Autowired
    private DeptLogMapper deptLogMapper;

    /**
     *新建事物 不和上边合并 无论操作是否成功都要记录日志
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void insert(DeptLog deptLog) {
        deptLog.setCreateTime(LocalDateTime.now());
        deptLogMapper.insert(deptLog);
    }
}
