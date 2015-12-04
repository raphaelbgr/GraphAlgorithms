package presentation.window;

import java.util.ArrayList;

import algorithms.Algorithm;
import algorithms.implementation.BreadthFirstSearch;
import algorithms.implementation.DephFirstSearch;
import algorithms.implementation.Dijkstra;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import mockers.GraphMocker;
import model.Graph;

public class WindowController {
	@FXML
	private Button btn_process = null;
	@FXML
	private TextField txt_input = null;
	@FXML
	private TextArea txt_output = null;
	@FXML
	private Button btn_exit = null;
	@FXML
	private RadioButton radio_dfs = null;
	@FXML
	private RadioButton radio_bfs = null;
	@FXML
	private RadioButton radio_dijkstra = null;
	
	public void exit() {
		System.exit(0);
	}
	
	public void process() {
		//TODO -- REGEX VALIDATION
//		Pattern regex = null;
		
		String input = txt_input.getText();
		if (input != null && input.length() > 0) {
			ArrayList<String> commands = formatInput(input);
			
			Graph graph = new Graph();
			GraphMocker graphMocker = new GraphMocker();
			
			graphMocker.insertNode(graph, commands);
			
			Algorithm algorithm = null;
			if (radio_dfs.isSelected()) {
				algorithm = new DephFirstSearch();
			} else if (radio_bfs.isSelected()) {
				algorithm = new BreadthFirstSearch();
			} else if (radio_dijkstra.isSelected()) {
				algorithm = new Dijkstra();
			}
			algorithm.execute(graph, graph.getFirstNode());
			txt_output.setText(formatAlgorithmOutput(algorithm.showResults()));
		}
	}
	
	private ArrayList<String> formatInput(String input) {
		String output = input.trim();
		String [] commandArray = output.split(",");
		ArrayList<String> commandList = new ArrayList<String>();
		
		for (String string : commandArray) {
			commandList.add(string.trim());
		}
		
		return commandList;
	}
	
	private String formatAlgorithmOutput(ArrayList<String> result) {
		String output = null;
		for (String string : result) {
			if (result.get(0).equalsIgnoreCase(string)) {
				output = string;
			} else {
				output = output + "\n" + string;
			}
		}
		return output;
	}
}
