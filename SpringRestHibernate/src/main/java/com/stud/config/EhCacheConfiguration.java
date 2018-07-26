package com.stud.config;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
//import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.config.DiskStoreConfiguration;
import net.sf.ehcache.config.PersistenceConfiguration;
import net.sf.ehcache.config.PersistenceConfiguration.Strategy;
import net.sf.ehcache.store.MemoryStoreEvictionPolicy;

@EnableCaching
@Configuration
public class EhCacheConfiguration{

/*	@Bean
	public CacheManager getEhCacheManager(){
	        return  new EhCacheCacheManager(getEhCacheFactory().getObject());
	}
	@Bean
	public EhCacheManagerFactoryBean getEhCacheFactory(){
		EhCacheManagerFactoryBean factoryBean = new EhCacheManagerFactoryBean();
		factoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
		factoryBean.setShared(true);
		return factoryBean;
	}*/
	
	
	@Bean(destroyMethod="shutdown")
    public net.sf.ehcache.CacheManager ehCacheManager() {
       /* CacheConfiguration cacheConfiguration = new CacheConfiguration();
        cacheConfiguration.setName("studcache");
        cacheConfiguration.setMemoryStoreEvictionPolicy("LRU");
        cacheConfiguration.setMaxEntriesLocalHeap(1000);*/

		CacheConfiguration cacheConfiguration = 
				new CacheConfiguration("studcache", 1000)
				.timeToLiveSeconds(3600)
				.timeToIdleSeconds(600)
				.eternal(false)
				.persistence(new PersistenceConfiguration().strategy(Strategy.LOCALTEMPSWAP))
				.memoryStoreEvictionPolicy(MemoryStoreEvictionPolicy.LFU);

		DiskStoreConfiguration diskStoreConfiguration = new DiskStoreConfiguration();
        diskStoreConfiguration.setPath("D:\\data\\ehcache");
        net.sf.ehcache.config.Configuration config = new net.sf.ehcache.config.Configuration();
        config.addCache(cacheConfiguration);
		config.addDiskStore(diskStoreConfiguration);
        return net.sf.ehcache.CacheManager.newInstance(config);
   }

    @Bean
    public CacheManager cacheManager() {
        return new EhCacheCacheManager(ehCacheManager());
    }
	}
