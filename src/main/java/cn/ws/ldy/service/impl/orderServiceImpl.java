package cn.ws.ldy.service.impl;

import cn.ws.ldy.dao.OrderMapper;
import cn.ws.ldy.entity.Order;
import cn.ws.ldy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author: wangsong
 * QQ/WX: 1720696548
 * @create: 2019-05-15 00:04
 */
@Service
public class orderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Override
    public Page<Order> Page(int page, int size, Map<String, Object> param) {
        return orderMapper.findAll(new Specification<Order>() {
            private static final long serialVersionUID = 1L;

            @Override
            public Predicate toPredicate(Root<Order> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                // TODO Auto-generated method stub
                List<Predicate> list = new ArrayList<>();
                for (String key : param.keySet()) {
                    list.add(cb.like(root.get(key).as(String.class), ("%" + param.get(key) + "%").toString()));
                }
                Predicate[] p = list.toArray(new Predicate[0]);
                return cb.and(p);
            }
        }, PageRequest.of(page - 1, size, Sort.Direction.DESC, "id"));
    }

    @Override
    public Order get(int id) {
        Optional<Order> optional = orderMapper.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public boolean addAndUpd(Order query) {
        if (orderMapper.save(query) != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        orderMapper.deleteById(id);
        return true;
    }
}
