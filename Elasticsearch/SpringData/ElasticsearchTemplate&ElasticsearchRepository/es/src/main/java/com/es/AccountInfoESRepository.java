package com.es;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface AccountInfoESRepository extends ElasticsearchRepository<AccountInfo, Long> {
}
