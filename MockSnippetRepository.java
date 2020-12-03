import java.util.*;

import core.entity.Snippet;
import core.gateway.SnippetGateway;

public class MockSnippetRepository implements SnippetGateway {

    private Map<Long, Snippet> map = new HashMap<>();

    @Override
    public void saveById(Snippet snippet) {
        map.put(snippet.getId(), snippet);
    }

    @Override
    public Snippet findById(Long id) {
        return map.get(id);
    }

    @Override
    public Collection<Snippet> findAll() {
        return map.values();
    }

}
