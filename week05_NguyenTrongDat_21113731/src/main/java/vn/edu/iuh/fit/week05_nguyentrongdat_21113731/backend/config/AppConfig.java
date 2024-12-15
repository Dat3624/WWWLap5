package vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.config;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.backend.models.Job;
import vn.edu.iuh.fit.week05_nguyentrongdat_21113731.frontend.dtos.JobDto;

@Configuration
public class AppConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        return  modelMapper;
    }
}

