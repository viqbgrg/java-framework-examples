package com.github.viqbgrg.demo.ehcache;

import lombok.extern.slf4j.Slf4j;
import org.ehcache.CacheManager;
import org.ehcache.config.Configuration;
import org.ehcache.xml.XmlConfiguration;

import static org.ehcache.config.builders.CacheManagerBuilder.newCacheManager;


@Slf4j
public class BasicXML {

    public CacheManager getCacheManager() {
        log.info("Creating cache manager via XML resource");
        Configuration xmlConfig = new XmlConfiguration(BasicXML.class.getResource("/ehcache.xml"));
        try (CacheManager cacheManager = newCacheManager(xmlConfig)) {
            cacheManager.init();
            return cacheManager;
        }
    }
}
