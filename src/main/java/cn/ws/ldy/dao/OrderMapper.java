package cn.ws.ldy.dao;

import cn.ws.ldy.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: wangsong
 * QQ/WX: 1720696548
 * @create: 2019-05-14 23:58
 */
@Repository
public interface OrderMapper extends JpaRepository<Order, Integer> {

    /**
     * 分页查询
     */
    Page<Order> findAll(Specification<Order> spec, Pageable pageable);
}
