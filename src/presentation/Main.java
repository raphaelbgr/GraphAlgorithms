package presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String [] args) {
		
		launch(args);
		
//		GraphMocker mocker = new GraphMocker();
//		Graph graph = null;
//		Algorithm algorithm = null;
//		
//		// MOCKS THE GRAPH
//		graph = mocker.createMockedGraph();
//		
//		algorithm = new DephFirstSearch();
//		algorithm.execute(graph, graph.getNodes().get(0));
//		algorithm.showResults();
//		
//		// RE-MOCKS THE GRAPH
//		graph = mocker.createMockedGraph();
//		
//		algorithm = new BreadthFirstSearch();
//		algorithm.execute(graph, graph.getNodes().get(0));
//		algorithm.showResults();
//		
//		// RE-MOCKS THE GRAPH
//		graph = mocker.createMockedGraph();
//		
//		algorithm = new Dijkstra();
//		algorithm.execute(graph, graph.getNodes().get(0));
//		algorithm.showResults();
	}

	@Override
	public void start(Stage arg0) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(
				"/main_layout_4.fxml"));
		Stage mainStage = new Stage();
		Parent root = (Parent) loader.load();
		Scene scene = new Scene(root);
		scene.setRoot(root);
		mainStage.setScene(scene);
		mainStage.setTitle("raphaelbgr@github.com - GraphAlgorithms");
		mainStage.setResizable(false);
		mainStage.toFront();
		mainStage.show();
	}
	
}
