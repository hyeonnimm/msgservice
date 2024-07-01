package msgservice.infra;

import msgservice.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class RateHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Rate>> {

    @Override
    public EntityModel<Rate> process(EntityModel<Rate> model) {
        return model;
    }
}
