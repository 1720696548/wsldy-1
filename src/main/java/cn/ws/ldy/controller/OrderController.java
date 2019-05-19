package cn.ws.ldy.controller;

import cn.ws.ldy.entity.Order;
import cn.ws.ldy.service.OrderService;
import cn.ws.ldy.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

/**
 * @author: wangsong
 * QQ/WX: 1720696548
 * @create: 2019-05-14 23:45
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 分页查询
     * @return
     */
    @RequestMapping("/main")
    String main(Model model, Integer pageNum, Integer totalPages, Integer pageSize) {
        Map<String, Integer> map = PageUtil.pageNum(pageNum, totalPages, pageSize);
        //查询条件
        Map<String, Object> param = new HashMap<String, Object>(8);
        // param.put("name", ));
        Page<Order> page = orderService.Page(map.get("pageNum"), map.get("pageSize"), param);
        //回写数据
        param.put("page", page);
        param.put("pageSize", map.get("pageSize"));
        model.addAttribute("echo", param);
        return "views/order/main";
    }
  

    /**
     * 添加+修改页面
     */
    @RequestMapping("/addOrUpd")
    public String addOrUpd(Integer id) {
        if(id == null){
            return "views/order/add";
        }else{
            return "views/order/upd";
        }
    }
    /**
     * 添加+修改
     */
    @RequestMapping("/addAndUpd")
    @ResponseBody
    public String addAndUpd(Order query) {
        if (query.getId() != null) {
            // 修改
            Order order = orderService.get(query.getId());
            order.setUid(1);
            order.setType(query.getType());
            order.setMoney(query.getMoney());
            order.setTime(new Date());
            orderService.addAndUpd(order);
        } else {
            // 添加
            query.setUid(1);
            query.setTime(new Date());
            orderService.addAndUpd(query);
        }
        return "seccess";
    }

    /**
     * 删除
     */
    @RequestMapping("/deleteId")
    public String deleteId(Integer id) {
        if (id != null) {
            orderService.delete(id);
        }
        return "redirect:/order/main";
    }
  
    /**
     * =======================================================================
     *                    vue-wxlay 接口
     * =======================================================================
     */
    
    /**
     * 分页查询
     * @return
     */
    @RequestMapping(value="/findOrderAll",method = RequestMethod.GET)
    @ResponseBody
    List<Order> findOrderAll(HttpServletResponse response,Model model, Integer pageNum, Integer totalPages, Integer pageSize) {
    	response.setHeader("Access-Control-Allow-Origin", "*");
    	Map<String, Integer> map = PageUtil.pageNum(pageNum, totalPages, pageSize);
        //查询条件
        Map<String, Object> param = new HashMap<String, Object>(8);
        // param.put("name", ));
        Page<Order> page = orderService.Page(map.get("pageNum"), map.get("pageSize"), param);
        //回写数据
//        param.put("page", page);
//        param.put("pageSize", map.get("pageSize"));
//        model.addAttribute("echo", param);
        return page.getContent();
    }
    
    /**
     * 添加+修改
     */
    @RequestMapping("/vue_addUpd")
    @ResponseBody
    public String vue_addUpd(HttpServletResponse response,Order query) {
    	response.setHeader("Access-Control-Allow-Origin", "*");
        if (query.getId() != null) {
            // 修改
            Order order = orderService.get(query.getId());
            order.setUid(1);
            order.setType(query.getType());
            order.setMoney(query.getMoney());
            order.setTime(new Date());
            orderService.addAndUpd(order);
        } else {
            // 添加
            query.setUid(1);
            query.setTime(new Date());
            orderService.addAndUpd(query);
        }
        return "seccess";
    }
}
