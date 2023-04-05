package com.dbydc.zero2one.payment.controller;

import com.dbydc.zero2one.common.utils.ResponseData;
import com.dbydc.zero2one.payment.entity.Payment;
import com.dbydc.zero2one.payment.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;

/**
 * 支付服务 Controller业务类
 * @author 大白有点菜
 * @className PaymentController
 * @date 2023-03-31
 * @description
 * @since 1.0
 **/
@RestController
@RequestMapping("payment")
public class PaymentController {

    @Autowired
    private IPaymentService paymentService;

    /**
     * 通过订单号获取数据
     * @param orderNum 订单号
     * @return
     */
    @GetMapping("/queryByOrderNum/{orderNum}")
    public ResponseData queryByOrderNum(@PathVariable String orderNum) {
        return paymentService.getByOrderNum(orderNum);
    }

    /**
     * 通过主键ID获取数据
     * @param id 主键ID
     * @return
     */
    @GetMapping("/queryById/{id}")
    public ResponseData queryById(@PathVariable Long id) {
        return paymentService.getById(id);
    }

    /**
     * 新增
     * @param payment 支付服务实体对象
     * @return
     */
    @PostMapping("/add")
    public ResponseData add(@RequestBody @Validated Payment payment) {
        return paymentService.add(payment);
    }

    /**
     * 通过订单号删除数据
     * @param orderNum 订单号
     * @return
     */
    @GetMapping("/deleteByOrderNum/{orderNum}")
    public ResponseData deleteByOrderNum(@PathVariable String orderNum) {
        return paymentService.deleteByOrderNum(orderNum);
    }

    /**
     * 通过主键ID删除数据
     * @param id 主键ID
     * @return
     */
    @GetMapping("/deleteById/{id}")
    public ResponseData deleteById(@PathVariable Long id) {
        return paymentService.deleteById(id);
    }

    /**
     * Feign - 通过订单号获取数据（Configuration配置类）
     * @param orderNum 订单号
     * @return
     */
    @GetMapping("/feign/queryByOrderNum/{orderNum}")
    public ResponseData queryFeignByOrderNum(@PathVariable("orderNum") String orderNum) {
        long time = 2L;
        //暂停指定秒钟
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return paymentService.getByOrderNum(orderNum);
    }

    /**
     * Feign - 通过订单号获取数据（application.yml）
     * @param orderNum 订单号
     * @return
     */
    @GetMapping("/feign/query/{orderNum}")
    public ResponseData queryFeign(@PathVariable("orderNum") String orderNum) {
        long time = 6L;
        //暂停指定秒钟
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return paymentService.getByOrderNum(orderNum);
    }

    /**
     * Feign - 演示ReadTimeout超时
     * @return
     */
    @GetMapping(value = "/feign/timeout")
    public String paymentFeignTimeOut() {
//        long time = 59L;
        long time = 2L;
        //暂停指定秒钟
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String msg = new StringBuilder().append("【大白有点菜】等到花儿也谢了，总共等待：").append(time).append(" 秒").toString();
        System.out.println(msg);
        return msg;
    }

    /**
     * Feign - 演示契约（Contract）配置
     * @return
     */
    @GetMapping(value = "/feign/contract/{id}")
    public String paymentFeignContract(@PathVariable("id") int id) {
        return "大白有点菜" + id + "啊";
    }

    /**
     * Feign - 演示请求拦截器（RequestInterceptor）
     * @return
     */
//    @GetMapping(value = "/feign/interceptor", produces = "text/html;charset=UTF-8")
    @GetMapping(value = "/feign/interceptor")
    public String paymentFeignInterceptor() {
        return new StringJoiner(",", "‘(*>﹏<*)′", "‘(*>﹏<*)′")
                .add("大白有点菜被拦截了呀").toString();
    }

    /**
     * Feign - 演示Fallback
     * @return
     */
    @GetMapping(value = "/feign/fallback")
    public String paymentFeignFallback() {
        return "演示Fallback";
    }
}
