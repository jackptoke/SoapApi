package dev.toke.capitalsoapapi.soap;

import dev.toke.capitalsoapapi.models.Component;
import dev.toke.capitalsoapapi.models.ComponentNotFoundException;
import dev.toke.capitalsoapapi.services.ComponentService;
import dev.toke.components.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ComponentsEndpoint {
    final
    ComponentService componentService;

    public ComponentsEndpoint(@Autowired ComponentService componentService) {
        this.componentService = componentService;
    }

    @PayloadRoot(namespace = "http://www.toke.dev/components", localPart = "AllComponentsRequest")
    @ResponsePayload
    public AllComponentsResponse getComponents(@RequestPayload AllComponentsRequest request) {
        var components = componentService.findAll();
        var result = components.stream().map(component -> getComponentDetail(component));
        AllComponentsResponse allComponentsResponse = new AllComponentsResponse();
        allComponentsResponse.getComponentDetails().addAll(result.toList());
        return allComponentsResponse;
    }

    @PayloadRoot(namespace = "http://www.toke.dev/components", localPart = "ComponentRequest")
    @ResponsePayload
    public ComponentResponse getComponents(@RequestPayload ComponentRequest request) throws ComponentNotFoundException {
        var component = componentService.findById(request.getPartnumber());

        if(component == null) throw new ComponentNotFoundException("Invalid component part number " + request.getPartnumber());

        ComponentResponse response = new ComponentResponse();
        response.setComponentDetails(getComponentDetail(component));
        return response;
    }

    @PayloadRoot(namespace = "http://www.toke.dev/components", localPart = "DeleteComponentRequest")
    @ResponsePayload
    public DeleteComponentResponse deleteComponent(@RequestPayload DeleteComponentRequest request) {
        ComponentService.Status result = componentService.deleteById(request.getPartnumber());
        var deleteResponse = new DeleteComponentResponse();
        deleteResponse.setStatus(result == ComponentService.Status.SUCCESS ? Status.SUCCESS : Status.FAILURE);
        return deleteResponse;
    }

    private ComponentDetails getComponentDetail(Component component) {
        ComponentDetails newDetail = new ComponentDetails();
        newDetail.setPartnumber(component.getPartNumber());
        newDetail.setDescription(component.getDescription());
        newDetail.setWeight(component.getWeight());
        return newDetail;
    }
}
