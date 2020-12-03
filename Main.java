import core.boundary.SnippetInteractionOrchestrator;
import io.SnippetController;
import io.SnippetPresenter;
import io.SnippetViewModel;

public class Main {

    public static void main(String[] args) {
        exampleWithControllerAndPresenterAndViewModel();
        // exampleWithControllerAsPresenter();
    }

    static void exampleWithControllerAndPresenterAndViewModel(){
        SnippetViewModel viewModel = new SnippetViewModel();
        SnippetPresenter presenter = new SnippetPresenter(viewModel);
        SnippetController controller = new SnippetController(new SnippetInteractionOrchestrator(new MockSnippetRepository(), presenter));

        controller.createSnippetRequest(90);
        System.out.println(viewModel.getAlertMessage());
        controller.createSnippetRequest(80);
        System.out.println(viewModel.getAlertMessage());

        controller.userLikesASnippetRequest(100, 90);
        System.out.println(viewModel.getAlertMessage());

        controller.findRecentSnippetsRequest(4);
        System.out.println(viewModel.getSnippets());

    }

    static void exampleWithControllerAsPresenter() {
        SnippetController controller = new SnippetController(null);
        controller = new SnippetController(new SnippetInteractionOrchestrator(new MockSnippetRepository(), controller));

        controller.createSnippetRequest(40);
        controller.createSnippetRequest(80);
        controller.createSnippetRequest(990);
        controller.createSnippetRequest(90);

        controller.userLikesASnippetRequest(100, 90);
        controller.userLikesASnippetRequest(22, 199);

        controller.findRecentSnippetsRequest(3);

        controller.createSnippetRequest(34);

    }

}