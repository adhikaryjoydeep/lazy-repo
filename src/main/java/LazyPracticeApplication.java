import com.lazypractice.beans.Match;
import com.lazypractice.beans.RawMateStock;
import com.lazypractice.repository.RawMateStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManager;
import java.time.LocalDate;


@SpringBootApplication
@EnableConfigurationProperties
@ComponentScan("com.lazypractice")
@EntityScan(basePackages = {"com.lazypractice.beans"})
@EnableJpaRepositories(basePackages={"com.lazypractice.repository"})
public class LazyPracticeApplication implements CommandLineRunner{

	@Autowired
	private RawMateStockRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(LazyPracticeApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		repository.save(new RawMateStock(
				"Item-1",
				10.50D,
				25d,
				"KG",
				10.50d,
				LocalDate.now(),
				10.50d,
				LocalDate.now()
		));
	}
}
