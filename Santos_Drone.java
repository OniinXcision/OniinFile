//Name:Marcus Santos
//Date:5/10/19
//Program:Santos_Drone
//Purpose:Simulation using button, drone movement in x,y,z location
//===============================================================================================================================================================================
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class Santos_Drone extends Application {
	//Sets position of drone to 0
	int xPosition = 0;
	int yPosition = 0;
	int zPosition = 0;
	//buttons and labels for UI config
	Button btUP = new Button("UP");
	Button btDOWN = new Button("DOWN");
	Button btLEFT = new Button("LEFT");
	Button btRIGHT = new Button("RIGHT");
	Button btFORWARD = new Button("FORWARD");
	Button btBACKWARD = new Button("BACKWARD");
	Label lblXCoord = new Label("");
	Label lblYCoord = new Label("");
	Label lblZCoord = new Label("");
	

	public int getxPosition() {
		return xPosition;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	public int getzPosition() {
		return zPosition;
	}

	public void setzPosition(int zPosition) {
		this.zPosition = zPosition;
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		btFORWARD.setOnAction(e -> moveFORWARD(yPosition));
		btBACKWARD.setOnAction(e -> moveBACKWARD(yPosition));
		btLEFT.setOnAction(e -> moveLEFT(xPosition));
		btRIGHT.setOnAction(e -> moveRIGHT(xPosition));
		btUP.setOnAction(e -> moveUP(zPosition));
		btDOWN.setOnAction(e -> moveDOWN(zPosition));
		Scene scene = new Scene(getUI(), 350, 250);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Santos-DroneUI");
		primaryStage.show();
		
	}
//moves drone down the z axis,does not allow negative integers, would mean underground drone
	public int moveDOWN(int z) {
		z = zPosition;
		lblZCoord.setText("Z:"+zPosition);
		if(zPosition == 0)
			return 0;
		else
			zPosition--;
			return z;
	}
//moves drone up z axis
	public int moveUP(int z) {
		zPosition++;
		z = zPosition;
		lblZCoord.setText("Z:"+zPosition);
		return z;
	}
//moves drone right on x axis
	public int moveRIGHT(int x) {
		xPosition++;
		x = xPosition;
		lblXCoord.setText("X:"+xPosition);
		return x;
	}
//moves drone left on x axis
	public int moveLEFT(int x) {
		xPosition--;
		x = xPosition;
		lblXCoord.setText("X:"+xPosition);
		return x;
	}
//moves drone back on y axis
	public int moveBACKWARD(int y) {
		yPosition--;
		y = yPosition;
		lblYCoord.setText("Y:"+yPosition);
		return y;
	}
//moves drone forward on y axis
	public int moveFORWARD(int y) {
		yPosition++;
		y = yPosition;
		lblYCoord.setText("Y:"+yPosition);
	return y;
	}

//Creates basic ui functions for drone
	public BorderPane getUI() {
		GridPane gridUI = new GridPane();
		gridUI.setVgap(5);
		gridUI.setPadding(new Insets(5, 0, 5, 0));
		gridUI.setAlignment(Pos.CENTER);
		gridUI.add(btRIGHT, 6, 2);
		gridUI.add(btFORWARD, 5, 1);
		gridUI.add(btBACKWARD, 5, 3);
		gridUI.add(btLEFT, 4, 2);
		gridUI.add(btUP, 0, 0);
		gridUI.add(btDOWN, 0, 4);
		gridUI.add(lblXCoord, 7,4 );
		gridUI.add(lblYCoord, 7,5 );
		gridUI.add(lblZCoord, 7,6 );
		
		BorderPane paneUI = new BorderPane();
		paneUI.setCenter(gridUI);
		return paneUI;
		
	}

}
