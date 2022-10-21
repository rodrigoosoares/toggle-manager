package poc.personal.togglemanager.gateways;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import poc.personal.togglemanager.models.Toggle;
import poc.personal.togglemanager.repositories.ToggleRepository;

@Component
public class ToggleGateway {

    private final ToggleRepository toggleRepository;

    @Autowired
    public ToggleGateway(final ToggleRepository toggleRepository) {

        this.toggleRepository = toggleRepository;
    }

    @Cacheable("toggles")
    public Toggle findToggleById(final String id) {

        return toggleRepository.findToggleById(id);
    }

    public void createToggle(final String id) {

        final Toggle toggle = new Toggle();
        toggle.setId(id);
        toggle.setActive(false);

        toggleRepository.createToggle(toggle);
    }

    @CacheEvict(value = "toggles", key = "#id")
    public Toggle updateToggleStatus(final String id, final boolean active) {

        final Toggle toggle = new Toggle();
        toggle.setId(id);
        toggle.setActive(active);

        return toggleRepository.updateToggleStatus(toggle);
    }

}
