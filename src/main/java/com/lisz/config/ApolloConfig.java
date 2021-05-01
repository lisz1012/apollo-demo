package com.lisz.config;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.model.ConfigChange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApolloConfig {

	// Add more logic when the changes happened in the config service
	@Bean
	public void config(){
		Config config = ConfigService.getAppConfig();
		config.addChangeListener(event -> {
			System.out.println("Changes for namespace: " + event.getNamespace());
			for (String key : event.changedKeys()){
				ConfigChange change = event.getChange(key);
				System.out.println(String.format("Found changes: key [%s] old value [%s] new value [%s]", key, change.getOldValue(), change.getNewValue()));
			}
		});
	}
}
