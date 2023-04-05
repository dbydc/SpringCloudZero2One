package com.dbydc.zero2one.payment.service.impl;

import com.dbydc.zero2one.common.enums.OperateStatusEnum;
import com.dbydc.zero2one.common.enums.ResponseCodeEnum;
import com.dbydc.zero2one.common.utils.ResponseData;
import com.dbydc.zero2one.payment.dao.PaymentDao;
import com.dbydc.zero2one.payment.entity.Payment;
import com.dbydc.zero2one.payment.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 支付服务 Service实现类
 * @author 大白有点菜
 * @className PaymentServiceImpl
 * @date 2023-03-31
 * @description
 * @since 1.0
 **/
@Service
public class PaymentServiceImpl implements IPaymentService {

    /**
     * 写法一：Spring的注解。将对象交由Spring去管理，官方不推荐这种写法。
     */
    //@Autowired
    //private PaymentDao paymentDao;

    //private PaymentDao paymentDao;
    /**
     * 写法二：Spring的注解。Setter方式注入对象，官方推荐这种写法。
     * @param paymentDao
     */
    //@Autowired
    //public void setPaymentDao(PaymentDao paymentDao) {
        //this.paymentDao = paymentDao;
    //}

    /**
     * 写法三：Java的注解。全称javax.annotation.Resource,它属于JSR-250规范的一个注解，包含Jakarta EE（J2EE）中。
     */
    @Resource
    private PaymentDao paymentDao;

    /**
     * 通过订单号获取数据
     * @param orderNum 订单号
     * @return
     */
    @Override
    public ResponseData getByOrderNum(String orderNum) {
        Payment payment = paymentDao.getByOrderNum(orderNum);
        return payment == null ? ResponseData.success(ResponseCodeEnum.NULL_DATA.getCode())
                : ResponseData.success(ResponseCodeEnum.SUCCESS.getCode(), payment);
    }

    /**
     * 通过主键ID获取数据
     * @param id 主键ID
     * @return
     */
    @Override
    public ResponseData getById(Long id) {
        Payment payment = paymentDao.getById(id);
        return payment == null ? ResponseData.success(ResponseCodeEnum.NULL_DATA.getCode())
                : ResponseData.success(ResponseCodeEnum.SUCCESS.getCode(), payment);
    }

    /**
     * 新增
     * @param payment 支付服务实体对象
     * @return
     */
    @Override
    public ResponseData add(Payment payment) {
        Date date = new Date();
        payment.setCreateTime(date);
        payment.setUpdateTime(date);
        int addResult = paymentDao.add(payment);
        return addResult > 0 ? ResponseData.success(ResponseCodeEnum.SUCCESS.getCode(), null, OperateStatusEnum.ADD_SUCCESS.getMessage())
                : ResponseData.error(ResponseCodeEnum.ERROR.getCode(), OperateStatusEnum.ADD_FAIL.getMessage());
    }

    /**
     * 通过订单号删除数据
     * @param orderNum 订单号
     * @return
     */
    @Override
    public ResponseData deleteByOrderNum(String orderNum) {
        int deleteResult = paymentDao.deleteByOrderNum(orderNum);
        return deleteResult > 0 ? ResponseData.success(ResponseCodeEnum.SUCCESS.getCode(), null, OperateStatusEnum.DELETE_SUCCESS.getMessage())
                : ResponseData.error(ResponseCodeEnum.ERROR.getCode(), OperateStatusEnum.DELETE_FAIL.getMessage());
    }

    /**
     * 通过主键ID删除数据
     * @param id 主键ID
     * @return
     */
    @Override
    public ResponseData deleteById(Long id) {
        int deleteResult = paymentDao.deleteById(id);
        return deleteResult > 0 ? ResponseData.success(ResponseCodeEnum.SUCCESS.getCode(), null, OperateStatusEnum.DELETE_SUCCESS.getMessage())
                : ResponseData.error(ResponseCodeEnum.ERROR.getCode(), OperateStatusEnum.DELETE_FAIL.getMessage());
    }
}
