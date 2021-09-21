package ha.otus.simple.social.network.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration

@EnableTransactionManagement
@MapperScan("ha.otus.simple.social.network.mapper")
// mybatis scan path for interface Mapper class

public class PersistenceConfig {
}
