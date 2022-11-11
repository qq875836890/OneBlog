package com.zyd.blog.persistence.mapper;

import com.zyd.blog.persistence.beans.BizStatistics;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 统计
 *
 * @author
 * @website 
 * @version 1.0
 * @date 2018/4/16 16:26
 * @since 1.0
 */
@Repository
public interface BizStatisticsMapper {

    List<BizStatistics> listSpider();

    List<BizStatistics> listType();
}
