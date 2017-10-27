package cn.skx.mavenSSM01.service;


import cn.skx.mavenSSM01.model.Vedio;

import java.util.List;

public interface VedioService {
    /**
     * 创建新电影
     * @param  vedio
     * */
    void creatVedio(Vedio vedio);

    /**
     * 更新电影
     * @param  vedio
     * */
    void updateVedio(Vedio vedio);

    /**
     * 根据主键删除电影
     * @param  id
     * */
    void  deleteVedio(int id);

    /**
     * 获取所有电影
     * @return
     * */
    List<Vedio> getAllVedio();

    /**
     * 根据id获得电影
     * @param id
     * @return vedio
     * */
    Vedio getVedioById(int id);
}
