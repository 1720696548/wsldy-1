package cn.ws.ldy.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author: wangsong
 * QQ/WX: 1720696548
 * @create: 2019-05-14 23:54
 */
@Table(name = "t_order")
@Entity
public class Order {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer uid;

    private Integer type;

    private double money;

    private double msg;

    private Date time;


    public double getMsg() {
        return msg;
    }

    public void setMsg(double msg) {
        this.msg = msg;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
