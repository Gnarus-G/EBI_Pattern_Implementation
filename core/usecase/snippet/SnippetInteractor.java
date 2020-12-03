package core.usecase.snippet;

import core.gateway.SnippetGateway;

abstract class SnippetInteractor {

    SnippetGateway gateway;
    
    SnippetInteractor(SnippetGateway gateway){
        this.gateway = gateway;
    }

}
