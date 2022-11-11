package com.zyd.blog.business.service;


import com.zyd.blog.business.entity.ArticleTags;

import java.util.List;

/**
 * 文章标签
 *
 * @author
 * @version 1.0
 * @website
 * @date 2018/4/16 16:26
 * @since 1.0
 */
public interface BizArticleTagsService {

    int removeByArticleId(Long articleId);

    void insertList(Long[] tagIds, Long articleId);

    ArticleTags insert(ArticleTags entity);

    void insertList(List<ArticleTags> entities);
}
