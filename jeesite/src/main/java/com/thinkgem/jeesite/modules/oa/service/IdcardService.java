package com.thinkgem.jeesite.modules.oa.service;

import com.thinkgem.jeesite.common.service.BaseService;
import com.thinkgem.jeesite.modules.oa.dao.IdcardDao;
import com.thinkgem.jeesite.modules.oa.entity.Idcard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 身份识别service
 */
@Service
@Transactional(readOnly = true)
public class IdcardService  extends BaseService {

    @Autowired
    private IdcardDao idcardDao;

    @Transactional(readOnly = false)
    public void save(Idcard card) {
        idcardDao.insert(card);
    }
}
