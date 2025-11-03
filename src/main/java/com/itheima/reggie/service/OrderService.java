package com.itheima.reggie.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itheima.reggie.entity.Orders;

public interface OrderService extends IService<Orders> {

    /**
     * 用户下单
     * @param orders
     */
    public void submit(Orders orders);

    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @param number
     * @param beginTime
     * @param endTime
     * @return
     */
    Page<Orders> pageQuery(int page, int pageSize, String number, String beginTime, String endTime);

    /**
     * 查询明细
     * @param page
     * @param pageSize
     * @return
     */
    Page<Orders> userPage(int page, int pageSize);

    /**
     * 再来一单
     * @param orders
     */
    void again(Orders orders);
}
