package msgservice.domain;

import java.util.Date;
import java.util.List;
import msgservice.domain.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "msgLists", path = "msgLists")
public interface MsgListRepository
    extends PagingAndSortingRepository<MsgList, Long> {}
