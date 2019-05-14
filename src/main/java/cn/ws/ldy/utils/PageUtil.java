package cn.ws.ldy.utils;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
/**
 * 初始化分页
 * @author wangsong
 */
@Component
@PropertySource({"classpath:application.properties"})
public class PageUtil {

    /**
     * 读取配置文件的数据，springboot的读取方式，在 application.properties中定义
     *  #默认分页条数，
     *  page.pageSize=20
     */
    public  static Integer pageSizeVal;

    @Value(value = "${page.pageSize}")
    public void setPageSize(Integer pageSize) {
        PageUtil.pageSizeVal = pageSize;
    }

    /**
     * 初始化分页数据默认第几页，每页几条，和上一页下一页最大页数最小页数判断
     * @param pageNum
     * @param totalPages
     * @param pageSize
     * @return
     */
    public static Map<String,Integer> pageNum(Integer pageNum,Integer totalPages,Integer pageSize){
        Map<String,Integer> pageMap = new HashMap<>(2);
        if (pageNum == null || pageNum < 1) {
            pageNum = 1;
        }
        if (totalPages != null) {
            if (pageNum > totalPages) {
                pageNum = totalPages;
            }
        }
        if(pageSize == null){
            pageSize = Integer.valueOf(pageSizeVal) ;
        }
        pageMap.put("pageNum", pageNum);
        pageMap.put("pageSize", pageSize);
        return pageMap;
    }
}

