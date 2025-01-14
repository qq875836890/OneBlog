package com.zyd.blog.business.aspect;

import com.zyd.blog.business.annotation.RedisCache;
import com.zyd.blog.business.service.RedisService;
import com.zyd.blog.framework.property.AppProperties;
import com.zyd.blog.util.AspectUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Redis业务层数据缓存
 *
 * @author
 * @version 1.0
 * @website
 * @date 2018/4/16 16:26
 * @since 1.0
 */
@Slf4j
@Aspect
@Component
public class RedisCacheAspect {

    private static final String BIZ_CACHE_PREFIX = "biz_cache_";

    @Autowired
    private RedisService redisService;
    @Autowired
    private AppProperties appProperties;

    @Pointcut(value = "@annotation(com.zyd.blog.business.annotation.RedisCache)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object handle(ProceedingJoinPoint point) throws Throwable {
        if (!appProperties.isEnableRedisCache()) {
            return point.proceed();
        }
        Method currentMethod = AspectUtil.INSTANCE.getMethod(point);
        //获取操作名称
        RedisCache cache = currentMethod.getAnnotation(RedisCache.class);
        boolean enable = cache.enable();
        if (!enable) {
            return point.proceed();
        }
        boolean flush = cache.flush();
        if (flush) {
            String classPrefix = AspectUtil.INSTANCE.getKey(point, BIZ_CACHE_PREFIX);
            log.info("清空缓存 - {}*", classPrefix);
            redisService.delBatch(classPrefix);
            return point.proceed();
        }
        String key = AspectUtil.INSTANCE.getKey(point, cache.key(), BIZ_CACHE_PREFIX);
        boolean hasKey = redisService.hasKey(key);
        if (hasKey) {
            try {
                log.info("{}从缓存中获取数据", key);
                return redisService.get(key);
            } catch (Exception e) {
                log.error("从缓存中获取数据失败！", e);
            }
        }
        //先执行业务
        Object result = point.proceed();
        redisService.set(key, result, cache.expire(), cache.unit());
        log.info("{}从数据库中获取数据", key);
        return result;
    }
}
