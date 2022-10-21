package poc.personal.togglemanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import poc.personal.togglemanager.gateways.ToggleGateway;
import poc.personal.togglemanager.models.Toggle;

@RestController
@RequestMapping("toggle")
public class ToggleController {

    private final ToggleGateway toggleGateway;

    @Autowired
    public ToggleController(final ToggleGateway toggleGateway) {

        this.toggleGateway = toggleGateway;
    }

    @GetMapping
    public ResponseEntity<Toggle> findToggleById(@RequestParam final String id) {

        return ResponseEntity.ok(toggleGateway.findToggleById(id));
    }

    @PostMapping
    public ResponseEntity<Void> createToggle(@RequestParam final String id) {

        toggleGateway.createToggle(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Toggle> updateToggleStatus(@RequestParam final String id, @RequestParam(defaultValue = "false") final boolean active) {

        return ResponseEntity.ok(toggleGateway.updateToggleStatus(id, active));
    }


}
