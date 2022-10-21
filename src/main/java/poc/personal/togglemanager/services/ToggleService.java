package poc.personal.togglemanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import poc.personal.togglemanager.gateways.ToggleGateway;
import poc.personal.togglemanager.models.Toggle;

import java.util.Optional;

@Service
public class ToggleService {

    private final ToggleGateway toggleGateway;

    @Autowired
    public ToggleService(final ToggleGateway toggleGateway) {

        this.toggleGateway = toggleGateway;
    }


    public boolean isToggleEnabled(final String id) {

        final Optional<Toggle> toggleOptional = Optional.ofNullable(toggleGateway.findToggleById(id));

        return toggleOptional.map(Toggle::isActive).orElse(false);

    }

}
