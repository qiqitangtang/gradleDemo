package com.roobo.demo.junit;
import java.lang.management.ManagementFactory;
import java.util.Date;

import net.sf.ehcache.management.ManagementService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import javax.management.MBeanServer;

/**
 * 第一个ehcache测试
 * 
 * @author leifu
 * @Date 2015年8月12日
 * @Time 上午10:14:13
 */
public class FirstEhcacheTest {
    private static Logger logger = LoggerFactory.getLogger(FirstEhcacheTest.class);
    private static Cache cache;
    @BeforeClass
    public static void setUp() {
        //CacheManager.newInstance(FirstEhcacheTest.class.getClassLoader().getResourceAsStream("ehcache.xml"));//非单例
        //CacheManager.create();//单例
        //new CacheManager(FirstEhcacheTest.class.getClassLoader().getResourceAsStream("ehcache.xml"));//非单例
        CacheManager cacheManager = CacheManager.create(FirstEhcacheTest.class.getClassLoader().getResourceAsStream("ehcache.xml"));//单例 推荐

        //加入jmx
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        ManagementService.registerMBeans(cacheManager, mBeanServer, true, true, true, true);

        // 打印cacheManager管理的cache
        String[] cacheNameArr = cacheManager.getCacheNames();
        for (String cacheName : cacheNameArr) {
            logger.info("cacheName: {}", cacheName);
        }
        cache = cacheManager.getCache("firstEhcache");
    }
    @Test
    public void testCRUD() {
        logger.info("At start, ehcache object size: {}", cache.getSize());
        // 唯一key
        String key = "football:club:1";
        Club club = new Club(1, "AC", "AC米兰", new Date(), 1);
        // 增
        Element element = new Element(key, club);
        cache.put(element);
        logger.info("after add ehcache object size: {}", cache.getSize());
        // 查
        Element elementResult = cache.get(key);
        Club clubResult = (Club) elementResult.getObjectValue();
        logger.info("get key {} value is {}", key, clubResult.toString());
        // 修改
        club.setRank(8888);
        cache.put(element);
        logger.info("after set ehcache object size: {}", cache.getSize());
        // 再查
        Element elementResultAgain = cache.get(key);
        Club clubResultAgain = (Club) elementResultAgain.getObjectValue();
        logger.info("get key {} again value is {}", key, clubResultAgain.toString());
        // 删
        boolean removeResult = cache.remove(key);
        logger.info("remove result is {}, after remove ehcache object size: {}", removeResult, cache.getSize());
        // 增加一条，观察下次启动
        cache.put(element);
        logger.info("At final, ehcache object size: " + cache.getSize());
        // 生产环境不要使用，影响性能 获取内存使用情况
        logger.info("At final, ehcache memory size: " + cache.calculateInMemorySize());
    }
}