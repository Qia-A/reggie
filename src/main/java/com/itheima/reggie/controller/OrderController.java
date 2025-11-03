package com.itheima.reggie.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.reggie.common.R;
import com.itheima.reggie.entity.Orders;
import com.itheima.reggie.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 订单
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 用户下单（小程序端）
     * @param orders
     * @return
     */
    @PostMapping("/submit")
    public R<String> submit(@RequestBody Orders orders){
        log.info("订单数据：{}",orders);
        orderService.submit(orders);
        return R.success("下单成功");
    }

    /**
     * 后台管理端 - 订单分页查询
     */
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize, String number, String beginTime, String endTime) {
        log.info("page = {}, pageSize = {}, number = {}, beginTime = {}, endTime = {}",
                page, pageSize, number, beginTime, endTime);

        Page<Orders> pageInfo = orderService.pageQuery(page, pageSize, number, beginTime, endTime);
        return R.success(pageInfo);
    }

    /**
     * 小程序端 - 用户订单分页（自己查看订单列表）
     */
    @GetMapping("/userPage")
    public R<Page> userPage(int page, int pageSize) {
        Page<Orders> pageInfo = orderService.userPage(page, pageSize);
        return R.success(pageInfo);
    }

    /**
     *  修改订单状态（派送、完成、取消）
     * @param orders
     * @return
     */
    @PutMapping
    public R<String> updateStatus(@RequestBody Orders orders) {
        log.info("修改订单状态：{}", orders);
        orderService.updateById(orders);
        return R.success("订单状态修改成功");
    }

    /**
     * 再来一单（小程序端）
     * 在个人中心的历史订单中点击再来一单
     */
    @PostMapping("/again")
    public R<String> again(@RequestBody Orders orders) {
        orderService.again(orders);
        return R.success("再来一单成功");
    }
}