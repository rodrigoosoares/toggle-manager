package poc.personal.togglemanager.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import poc.personal.togglemanager.models.Toggle;

@Repository
public class ToggleRepository {

    private static final String TOGGLES_COLLECTION = "Toggles";
    private final MongoOperations mongoOperations;

    @Autowired
    public ToggleRepository(final MongoOperations mongoOperations) {

        this.mongoOperations = mongoOperations;
    }

    public Toggle findToggleById(final String id) {

        return mongoOperations.findById(id, Toggle.class, TOGGLES_COLLECTION);
    }

    public void createToggle(final Toggle toggle) {

        mongoOperations.insert(toggle, TOGGLES_COLLECTION);
    }
    
    public Toggle updateToggleStatus(final Toggle toggle) {

        final Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(toggle.getId()));

        final Update update = new Update();
        update.set("_id", toggle.getId());
        update.set("active", toggle.isActive());

        mongoOperations.updateFirst(query, update, TOGGLES_COLLECTION);

        return toggle;
    }
}
