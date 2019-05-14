package cn.ws.ldy.service;

import cn.ws.ldy.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import java.util.Map;

/**
 * @author: wangsong
 * QQ/WX: 1720696548
 */

public interface OrderService {
    /**
     * 分页查询
     * @param page
     * @param size
     * @param param
     * @return
     */
     Page<Order> Page(int page, int size, Map<String, Object> param);

    /**
     * id查询
     * @param id
     * @return
     */
    Order get(int id) ;

    /**
     * 添加或修改
     * @param query
     * @return
     */
     boolean addAndUpd(Order query);


    /**
     * 删除
     * @param id
     * @return
     */
    boolean delete(int id);
}
