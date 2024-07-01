package msgservice.domain;

import msgservice.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "rates", path = "rates")
public interface RateRepository
    extends PagingAndSortingRepository<Rate, Long> {}
