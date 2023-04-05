package com.dbydc.zero2one.payment.controller;

import com.dbydc.zero2one.common.enums.ResponseCodeEnum;
import com.dbydc.zero2one.common.utils.ResponseData;
import com.dbydc.zero2one.payment.entity.Payment;
import com.dbydc.zero2one.payment.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
        Payment payment = paymentService.getByOrderNum(orderNum);
        return payment == null ? ResponseData.success(ResponseCodeEnum.NULL_DATA.getCode())
                : ResponseData.success(ResponseCodeEnum.SUCCESS.getCode(), payment);
    }

    /**
     * 通过主键ID获取数据
     * @param id 主键ID
     * @return
     */
    @GetMapping("/queryById/{id}")
    public ResponseData queryById(@PathVariable Long id) {
        Payment payment = paymentService.getById(id);
        return payment == null ? ResponseData.success(ResponseCodeEnum.NULL_DATA.getCode())
                : ResponseData.success(ResponseCodeEnum.SUCCESS.getCode(), payment);
    }

    /**
     * 新增
     * @param payment 支付服务实体对象
     * @return
     */
    @PostMapping("/add")
    public ResponseData add(@RequestBody @Validated Payment payment) {
        int addResult = paymentService.add(payment);
        return addResult > 0 ? ResponseData.success(ResponseCodeEnum.SUCCESS.getCode(), null, "新增数据成功")
                : ResponseData.error(ResponseCodeEnum.ERROR.getCode(), "新增数据失败");
    }

    /**
     * 通过订单号删除数据
     * @param orderNum 订单号
     * @return
     */
    @GetMapping("/deleteByOrderNum/{orderNum}")
    public ResponseData deleteByOrderNum(@PathVariable String orderNum) {
        int deleteResult = paymentService.deleteByOrderNum(orderNum);
        return deleteResult > 0 ? ResponseData.success(ResponseCodeEnum.SUCCESS.getCode(), null, "删除数据成功")
                : ResponseData.error(ResponseCodeEnum.ERROR.getCode(), "删除数据失败");
    }

    /**
     * 通过主键ID删除数据
     * @param id 主键ID
     * @return
     */
    @GetMapping("/deleteById/{id}")
    public ResponseData deleteById(@PathVariable Long id) {
        int deleteResult = paymentService.deleteById(id);
        return deleteResult > 0 ? ResponseData.success(ResponseCodeEnum.SUCCESS.getCode(), null, "删除数据成功")
                : ResponseData.error(ResponseCodeEnum.ERROR.getCode(), "删除数据失败");
    }
}
