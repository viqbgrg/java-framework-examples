package com.github.viqbgrg.demo.ehcache;

import lombok.extern.slf4j.Slf4j;
import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.Configuration;
import org.ehcache.xml.XmlConfiguration;
import org.junit.jupiter.api.Test;

import static org.ehcache.config.builders.CacheManagerBuilder.newCacheManager;


@Slf4j
public class BasicXML {

    @Test
    void first() {
        log.info("Creating cache manager via XML resource");
        Configuration xmlConfig = new XmlConfiguration(BasicXML.class.getResource("/ehcache.xml"));
        try (CacheManager cacheManager = newCacheManager(xmlConfig)) {
            cacheManager.init();

            Cache<Long, String> basicCache = cacheManager.getCache("basicCache", Long.class, String.class);

            log.info("Putting to cache");
            basicCache.put(1L, "da one!");
            String value = basicCache.get(1L);
            log.info("Retrieved '{}'", value);
            log.info("Closing cache manager");
        }

        log.info("Exiting");
    }
}
