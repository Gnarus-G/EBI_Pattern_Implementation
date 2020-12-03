package core.usecase.snippet;

import core.entity.Snippet;
import core.gateway.SnippetGateway;
import core.usecase.*;

public class CreateSnippet extends SnippetInteractor
        implements Command<CreateSnippet.RequestModel, CreateSnippet.ResponseModel> {

    public CreateSnippet(SnippetGateway gateway) {
        super(gateway);
    }

    @Override
    public ResponseModel execute(RequestModelBuilder<RequestModel> requestModelBuilder) {
        // get the request model
        RequestModel req = requestModelBuilder.build(new RequestModel());

        // process
        Snippet snippet = new Snippet(req.snippetId, req.title, req.language, req.framework, req.code, req.description, req.resource);
        gateway.saveById(snippet);

        // build the response
        return new ResponseModel() {
            {
                okMessage = "Snippet #" + req.snippetId + " created";
            }
        };
    }

    public static class RequestModel {
        public long snippetId;
        public String title;
        public String language;
        public String framework;
        public String code;
        public String description;
        public String resource;

    }

    public static class ResponseModel {
        public String okMessage;
    }

}
