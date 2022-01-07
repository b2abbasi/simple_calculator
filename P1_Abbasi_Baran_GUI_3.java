import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * this codes a simple 4-function calculator which solves equations from left to right and has
 * a customizable color option.
 */

public class P1_Abbasi_Baran_GUI_3 extends Application{
	private final double WIDTH = 385;
	private final double HEIGHT = 600;
	private final double BTNFSIZE = HEIGHT/17;
	private final double RADIUS = HEIGHT/30;
	private String answer = "";
	private Label calculation;
	private Button cBtn;
	boolean isNegative = true;
	private Button signBtn;
	private Button divideBtn;
	private Button multiplyBtn;
	private Button plusBtn;
	private Button subtrctBtn;
	private Button pointBtn;
	private Button equalsBtn;
	private Button num9Btn;
	private Button num8Btn;
	private Button num7Btn;
	private Button num6Btn;
	private Button num5Btn;
	private Button num4Btn;
	private Button num3Btn;
	private Button num2Btn;
	private Button num1Btn;
	private Button num0Btn;
	private ColorPicker color;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	public void start(Stage stage) throws Exception{
		stage.setTitle("Calculator");
		
		VBox rootNode = new VBox();
		rootNode.setMinWidth(WIDTH);
		rootNode.setMinHeight(HEIGHT);
		
		Scene scene = new Scene(rootNode, WIDTH, HEIGHT - 50);
		
		//HBox calculated results and view
		HBox results = new HBox();
		
		results.setPadding(new Insets(HEIGHT/30));
		results.setMinSize(WIDTH, HEIGHT/5);
		results.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		results.setAlignment(Pos.BOTTOM_RIGHT);
		
		calculation = new Label("CALCTR");
		calculation.setFont(Font.font("PT Sans Narrow", HEIGHT/10));
		calculation.setTextFill(Color.WHITE);
		
		results.getChildren().addAll(calculation);
		

		
		
		//HBox of "c", +/-, %, ÷"
		HBox row1 = new HBox();
		
		row1.setPadding(new Insets(0, HEIGHT/30, 0, HEIGHT/30));
		row1.setMinSize(WIDTH, HEIGHT/7);
		row1.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		row1.setAlignment(Pos.CENTER_RIGHT);
		row1.setSpacing(HEIGHT/30);
		
			//the delete btn
		cBtn = new Button("C");
		cBtn.setFont(Font.font("PT Sans Narrow", BTNFSIZE));
		cBtn.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
		cBtn.setTextFill(Color.BLACK);
		cBtn.setShape(new Circle(RADIUS));
		cBtn.setMinWidth(BTNFSIZE*2);
		
			// the sign that dictates the sign of the number
		signBtn = new Button("±");
		signBtn.setFont(Font.font("PT Sans Narrow", BTNFSIZE));
		signBtn.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
		signBtn.setTextFill(Color.BLACK);
		signBtn.setShape(new Circle(RADIUS*10));
		signBtn.setMinWidth(BTNFSIZE*2);
		
		color = new ColorPicker();
		color.getStyleClass().add("button");
		color.setShape(new Circle(RADIUS));
		color.setMaxWidth(BTNFSIZE*2);
		color.setMinHeight(BTNFSIZE*2);
		color.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
		color.setTooltip(new Tooltip("Choose Color Pallet of Choice"));
		ColorHandler cHandle = new ColorHandler();
		color.valueProperty().addListener(cHandle);
		
		divideBtn = new Button("÷");
		divideBtn.setFont(Font.font("PT Sans Narrow", BTNFSIZE));
		divideBtn.setBackground(new Background(new BackgroundFill(Color.ORANGE, null, null)));
		divideBtn.setTextFill(Color.WHITE);
		divideBtn.setShape(new Circle(RADIUS));
		divideBtn.setMinWidth(BTNFSIZE*2);
		
		row1.getChildren().addAll(cBtn, signBtn, color, divideBtn);
		
		//HBox of #s 7-9 & x
		HBox row2 = new HBox();
		row2.setPadding(new Insets(0, HEIGHT/30, 0, HEIGHT/30));
		row2.setMinSize(WIDTH, HEIGHT/7);
		row2.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		row2.setAlignment(Pos.CENTER_RIGHT);
		row2.setSpacing(HEIGHT/30);
		
		num7Btn = new Button("7");
		num7Btn.setFont(Font.font("PT Sans Narrow", BTNFSIZE));
		num7Btn.setBackground(new Background(new BackgroundFill(Color.web("#3b3b3b"), null, null)));
		num7Btn.setTextFill(Color.WHITE);
		num7Btn.setShape(new Circle(RADIUS));
		num7Btn.setMinWidth(BTNFSIZE*2);
		
		num8Btn = new Button("8");
		num8Btn.setFont(Font.font("PT Sans Narrow", BTNFSIZE));
		num8Btn.setBackground(new Background(new BackgroundFill(Color.web("#3b3b3b"), null, null)));
		num8Btn.setTextFill(Color.WHITE);
		num8Btn.setShape(new Circle(RADIUS));
		num8Btn.setMinWidth(BTNFSIZE*2);
		
		num9Btn = new Button("9");
		num9Btn.setFont(Font.font("PT Sans Narrow", BTNFSIZE));
		num9Btn.setBackground(new Background(new BackgroundFill(Color.web("#3b3b3b"), null, null)));
		num9Btn.setTextFill(Color.WHITE);
		num9Btn.setShape(new Circle(RADIUS));
		num9Btn.setMinWidth(BTNFSIZE*2);
		
		multiplyBtn = new Button("×");
		multiplyBtn.setFont(Font.font("PT Sans Narrow", BTNFSIZE));
		multiplyBtn.setBackground(new Background(new BackgroundFill(Color.ORANGE, null, null)));
		multiplyBtn.setTextFill(Color.WHITE);
		multiplyBtn.setShape(new Circle(RADIUS));
		multiplyBtn.setMinWidth(BTNFSIZE*2);
		
		row2.getChildren().addAll(num7Btn, num8Btn, num9Btn, multiplyBtn);
		
		//HBox of #s 4-5 & -
		HBox row3 = new HBox();
		row3.setPadding(new Insets(0, HEIGHT/30, 0, HEIGHT/30));
		row3.setMinSize(WIDTH, HEIGHT/7);
		row3.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		row3.setAlignment(Pos.CENTER_RIGHT);
		row3.setSpacing(HEIGHT/30);
		
		num4Btn = new Button("4");
		num4Btn.setFont(Font.font("PT Sans Narrow", BTNFSIZE));
		num4Btn.setBackground(new Background(new BackgroundFill(Color.web("#3b3b3b"), null, null)));
		num4Btn.setTextFill(Color.WHITE);
		num4Btn.setShape(new Circle(RADIUS));
		num4Btn.setMinWidth(BTNFSIZE*2);
		
		num5Btn = new Button("5");
		num5Btn.setFont(Font.font("PT Sans Narrow", BTNFSIZE));
		num5Btn.setBackground(new Background(new BackgroundFill(Color.web("#3b3b3b"), null, null)));
		num5Btn.setTextFill(Color.WHITE);
		num5Btn.setShape(new Circle(RADIUS));
		num5Btn.setMinWidth(BTNFSIZE*2);
		
		num6Btn = new Button("6");
		num6Btn.setFont(Font.font("PT Sans Narrow", BTNFSIZE));
		num6Btn.setBackground(new Background(new BackgroundFill(Color.web("#3b3b3b"), null, null)));
		num6Btn.setTextFill(Color.WHITE);
		num6Btn.setShape(new Circle(RADIUS));
		num6Btn.setMinWidth(BTNFSIZE*2);
		
		subtrctBtn = new Button("-");
		subtrctBtn.setFont(Font.font("PT Sans Narrow", BTNFSIZE));
		subtrctBtn.setBackground(new Background(new BackgroundFill(Color.ORANGE, null, null)));
		subtrctBtn.setTextFill(Color.WHITE);
		subtrctBtn.setShape(new Circle(RADIUS));
		subtrctBtn.setMinWidth(BTNFSIZE*2);
		
		row3.getChildren().addAll(num4Btn, num5Btn, num6Btn, subtrctBtn);
		
		//HBox of #s 1-3 & +
		HBox row4 = new HBox();
		row4.setPadding(new Insets(0, HEIGHT/30, 0, HEIGHT/30));
		row4.setMinSize(WIDTH, HEIGHT/7);
		row4.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		row4.setAlignment(Pos.CENTER_RIGHT);
		row4.setSpacing(HEIGHT/30);
		
		num1Btn = new Button("1");
		num1Btn.setFont(Font.font("PT Sans Narrow", BTNFSIZE));
		num1Btn.setBackground(new Background(new BackgroundFill(Color.web("#3b3b3b"), null, null)));
		num1Btn.setTextFill(Color.WHITE);
		num1Btn.setShape(new Circle(RADIUS));
		num1Btn.setMinWidth(BTNFSIZE*2);
		
		num2Btn = new Button("2");
		num2Btn.setFont(Font.font("PT Sans Narrow", BTNFSIZE));
		num2Btn.setBackground(new Background(new BackgroundFill(Color.web("#3b3b3b"), null, null)));
		num2Btn.setTextFill(Color.WHITE);
		num2Btn.setShape(new Circle(RADIUS));
		num2Btn.setMinWidth(BTNFSIZE*2);
		
		num3Btn = new Button("3");
		num3Btn.setFont(Font.font("PT Sans Narrow", BTNFSIZE));
		num3Btn.setBackground(new Background(new BackgroundFill(Color.web("#3b3b3b"), null, null)));
		num3Btn.setTextFill(Color.WHITE);
		num3Btn.setShape(new Circle(RADIUS));
		num3Btn.setMinWidth(BTNFSIZE*2);
		
		plusBtn = new Button("+");
		plusBtn.setFont(Font.font("PT Sans Narrow", BTNFSIZE));
		plusBtn.setBackground(new Background(new BackgroundFill(Color.ORANGE, null, null)));
		plusBtn.setTextFill(Color.WHITE);
		plusBtn.setShape(new Circle(RADIUS));
		plusBtn.setMinWidth(BTNFSIZE*2);
		
		row4.getChildren().addAll(num1Btn, num2Btn, num3Btn, plusBtn);
		
		//HBox of #s 0 and . & =
		HBox row5 = new HBox();
		row5.setPadding(new Insets(0, HEIGHT/30, 0, HEIGHT/30));
		row5.setMinSize(WIDTH, HEIGHT/7);
		row5.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
		row5.setAlignment(Pos.CENTER_RIGHT);
		row5.setSpacing(HEIGHT/30);
		
		num0Btn = new Button("0");
		num0Btn.setFont(Font.font("PT Sans Narrow", BTNFSIZE));
		num0Btn.setBackground(new Background(new BackgroundFill(Color.web("#3b3b3b"), null, null)));
		num0Btn.setTextFill(Color.WHITE);
		num0Btn.setShape(new Circle(RADIUS));
		num0Btn.setMinWidth(BTNFSIZE*4 + HEIGHT/30);
		
		
		pointBtn = new Button(".");
		pointBtn.setFont(Font.font("PT Sans Narrow", BTNFSIZE));
		pointBtn.setBackground(new Background(new BackgroundFill(Color.web("#3b3b3b"), null, null)));
		pointBtn.setTextFill(Color.WHITE);
		pointBtn.setShape(new Circle(RADIUS));
		pointBtn.setMinWidth(BTNFSIZE*2);
		
		equalsBtn = new Button("=");
		equalsBtn.setTooltip(new Tooltip("this is a button"));
		equalsBtn.setFont(Font.font("PT Sans Narrow", BTNFSIZE));
		equalsBtn.setBackground(new Background(new BackgroundFill(Color.ORANGE, null, null)));
		equalsBtn.setTextFill(Color.WHITE);
		equalsBtn.setShape(new Circle(RADIUS));
		equalsBtn.setMinWidth(BTNFSIZE*2 );
		
		row5.getChildren().addAll(num0Btn, pointBtn, equalsBtn);
		
		
		ActionHandler handler = new ActionHandler();
		num9Btn.setOnAction(handler);
		num8Btn.setOnAction(handler);
		num7Btn.setOnAction(handler);
		num6Btn.setOnAction(handler);
		num5Btn.setOnAction(handler);
		num4Btn.setOnAction(handler);
		num3Btn.setOnAction(handler);
		num2Btn.setOnAction(handler);
		num1Btn.setOnAction(handler);
		num0Btn.setOnAction(handler);
		signBtn.setOnAction(handler);
		divideBtn.setOnAction(handler);
		multiplyBtn.setOnAction(handler);
		plusBtn.setOnAction(handler);
		subtrctBtn.setOnAction(handler);
		pointBtn.setOnAction(handler);
		cBtn.setOnAction(handler);
		equalsBtn.setOnAction(handler);
				
		rootNode.getChildren().addAll(results, row1, row2, row3, row4, row5);
		
		
		stage.setScene(scene);
		//stage.setResizable(false);
		stage.sizeToScene();
		stage.show();
	}
	
	private class ColorHandler implements ChangeListener<Color>{

		@Override
		public void changed(ObservableValue<? extends Color> arg0, Color oldColor, Color newColor) {
			// TODO Auto-generated method stub
			Background newFill = new Background(new BackgroundFill(newColor, null, null));
			divideBtn.setBackground(newFill);
			multiplyBtn.setBackground(newFill);
			subtrctBtn.setBackground(newFill);
			plusBtn.setBackground(newFill);
			equalsBtn.setBackground(newFill);
		}
		
	}
	
	private class ActionHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			if(event.getSource() == cBtn) {
				if(answer.equals("Error")) {
					answer = "";
				}else if(answer.length() > 0) {
					answer = answer.substring(0, answer.length() - 1);
				}
			}else if(event.getSource() == equalsBtn) {
				calculate(answer);
			}else if(event.getSource() == signBtn){
				String add;
				if(isNegative == true) {
					add = "-";
					if(answer.substring(answer.length() - 1).equals("+")|| answer.substring(answer.length() - 1).equals("-")){
						answer = answer.substring(0, answer.length() - 1);
					}
					isNegative = false;
				}else {
					add = "+";
					if(answer.substring(answer.length() - 1).equals("-") || answer.substring(answer.length() - 1).equals("+")) {
						answer = answer.substring(0, answer.length() - 1);
					}
					isNegative = true;
				}
				answer += add;
			}else {
				answer += ((Button) event.getSource()).getText();
			}
			
			calculation.setText(answer);
			
		}
		
		public void calculate(String equation) {
			if(hasError(equation)) {
				answer = "Error";
			}else {
				answer = "" + solve(equation);
				//answer = "Calculating...";
			}
			
			
		}
		
		public boolean hasError(String equation) {
			int strInARow = 0;
			for(int i = 0; i < equation.length(); i++) {
				char chr = equation.charAt(i);
				if(!Character.isDigit(chr)) {
					strInARow++;
				}else {
					strInARow = 0;
				}
				
				if(strInARow == 2) {
					return true;
				}
			}
			if(strInARow == 2 || !Character.isDigit(equation.charAt(0)) || !Character.isDigit(equation.charAt(equation.length() - 1))) {
				return true;
			}
			return false;
		}
		
		
		public double solve(String equation) {
			double ans = 0;
			int numEq = numValues(equation);
			int i = 0;
			int index = nextValue(equation, i);
			ans = Double.parseDouble(equation.substring(i, index));
			while(i < numEq) {
				char symbol = equation.charAt(index);
				int last = index + 1;
				index = nextValue(equation, last);
				double otherInt = Double.parseDouble(equation.substring(last, index));
				if(symbol == '-') {
					ans -= otherInt;
				}else if(symbol == '+') {
					ans += otherInt;
				}else if(symbol == '÷') {
					ans /= otherInt;
				}else {
					ans *= otherInt;
				}
				i++;
			}
			return ans;
		}
		
		//index is inclusive;
		public int nextValue(String equation, int index) {
			int i = index;
			while( i < equation.length()) {
				char current = equation.charAt(i);
				if(Character.isDigit(current) || current == '.') {
					i ++;
				}else {
					break;
				}	
			}
			return i;
		}
		
		public int numValues(String equation) {
			int count = 0;
			for(int i = 0; i < equation.length(); i ++) {
				char current = equation.charAt(i);
				if(!Character.isDigit(current) && current != '.') {
					count++;
				}
			}
			return count;
		}
		
	}

}
