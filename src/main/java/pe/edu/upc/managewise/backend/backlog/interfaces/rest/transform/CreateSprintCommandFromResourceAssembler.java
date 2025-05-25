package pe.edu.upc.managewise.backend.backlog.interfaces.rest.transform;

import pe.edu.upc.managewise.backend.backlog.domain.model.commands.CreateSprintCommand;
import pe.edu.upc.managewise.backend.backlog.interfaces.rest.resources.CreateSprintResource;

public class CreateSprintCommandFromResourceAssembler {
    public static CreateSprintCommand toCommandFromResource(Long userId, CreateSprintResource resource){
        return new CreateSprintCommand(userId, resource.title(), resource.goal(), resource.endDate());
    }
}
