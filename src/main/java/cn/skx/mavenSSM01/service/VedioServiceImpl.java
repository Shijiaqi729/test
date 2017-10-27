package cn.skx.mavenSSM01.service;


import cn.skx.mavenSSM01.dao.VedioDAO;
import cn.skx.mavenSSM01.model.Vedio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
@Transactional
public class VedioServiceImpl implements VedioService {
    @Autowired
    private VedioDAO vedioDAO;


    public void creatVedio(Vedio vedio) {
        vedioDAO.insert(vedio);
    }

    public void updateVedio(Vedio vedio) {
        Example example = new Example(Vedio.class);
        example.createCriteria()
                .andEqualTo("id",vedio.getId());
        vedioDAO.updateByExample(vedio,example);
    }

    public void deleteVedio(int id) {
        Example example = new Example(Vedio.class);
        example.createCriteria()
                .andEqualTo("id",id);
        vedioDAO.deleteByExample(example);
    }

    public List<Vedio> getAllVedio() {
        return vedioDAO.selectAll();
    }

    public Vedio getVedioById(int id) {
        Vedio vedio = null;
        Example example = new Example(Vedio.class);
        example.createCriteria()
                .andEqualTo("id",id);
        List<Vedio> list = vedioDAO.selectByExample(example);
        if (list.size() != 0){
            vedio = list.get(0);
        }
        return vedio;
    }
}
