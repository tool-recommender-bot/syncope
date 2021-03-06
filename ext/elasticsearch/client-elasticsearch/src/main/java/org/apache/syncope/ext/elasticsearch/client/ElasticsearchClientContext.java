/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.syncope.ext.elasticsearch.client;

import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticsearchClientContext {

    @ConditionalOnMissingBean
    @Bean
    public ElasticsearchClientFactoryBean elasticsearchClientFactoryBean() {
        ElasticsearchClientFactoryBean factory = new ElasticsearchClientFactoryBean();

        Map<String, String> settings = new HashMap<>();
        settings.put("cluster.name", "elasticsearch");
        settings.put("client.transport.sniff", "false");
        factory.setSettings(settings);

        Map<String, Integer> addresses = new HashMap<>();
        addresses.put("localhost", 9300);
        factory.setAddresses(addresses);

        return factory;
    }

    @ConditionalOnMissingBean
    @Bean
    public ElasticsearchIndexManager elasticsearchIndexManager() {
        return new ElasticsearchIndexManager();
    }

    @ConditionalOnMissingBean
    @Bean
    public ElasticsearchUtils elasticsearchUtils() {
        ElasticsearchUtils utils = new ElasticsearchUtils();
        utils.setIndexMaxResultWindow(10000);
        utils.setRetryOnConflict(5);
        return utils;
    }
}
