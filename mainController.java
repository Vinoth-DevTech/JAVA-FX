package application;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class mainController implements Initializable{

	
	@FXML private MediaPlayer mp;
	private Media m;
	 @FXML private MediaView mv;
	@FXML private Slider volumeslider;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		String path=new File("src/media/Vinmeen Vidhayil Thegidi Official HD 1080p Video Song.mp4").getAbsolutePath();
		m=new Media(new File(path).toURI().toString());
		mp=new MediaPlayer(m);
		mv.setMediaPlayer(mp);
		//mp.setAutoPlay(true);
		DoubleProperty width=mv.fitWidthProperty();
		DoubleProperty height=mv.fitHeightProperty();
		width.bind(Bindings.selectDouble(mv.sceneProperty(), "width"));
		height.bind(Bindings.selectDouble(mv.sceneProperty(), "height"));
		volumeslider.setValue(mp.getVolume() *100);
		volumeslider.valueProperty().addListener(new InvalidationListener() {
			
			@Override
			public void invalidated(Observable observable) {
				// TODO Auto-generated method stub
				mp.setVolume(volumeslider.getValue()/100);
			}
		});
		
	}
	
	public void play(ActionEvent event)
	{
		mp.play();
		mp.setRate(1);
	}
	public void pause(ActionEvent event)
	{
		mp.pause();
	}
	public void start(ActionEvent event)
	{
		mp.seek(mp.getStartTime());
		mp.stop();
	}
	public void fast(ActionEvent event)
	{
		mp.setRate(2);
	}
	public void slow(ActionEvent event)
	{
		mp.setRate(0.5);
		
	}
	public void Reload(ActionEvent event)
	{
		mp.seek(mp.getStartTime());
		mp.play();
	}
	public void last(ActionEvent event)
	{
		mp.seek(mp.getTotalDuration());
		mp.stop();
	}
	public void resume(ActionEvent event)
	{
		mp.seek(mp.getCurrentTime());
		mp.play();
	}
	
	
}
