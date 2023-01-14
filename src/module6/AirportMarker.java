package module6;

import java.util.List;

import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimpleLinesMarker;
import processing.core.PConstants;
import processing.core.PGraphics;


public class AirportMarker extends CommonMarker {
	public static List<SimpleLinesMarker> routes;
	
	public AirportMarker(Feature city) {
		super(((PointFeature)city).getLocation(), city.getProperties());
	
	}
	
	@Override
	public void drawMarker(PGraphics pg, float x, float y) {
		pg.fill(11);
		pg.ellipse(x, y, 5, 5);
		
		
	}
	

	@Override
	public void showTitle(PGraphics pg, float x, float y) {
		 // show rectangle with title
		String title = (String) getProperty("name");
		pg.pushStyle();
		
		pg.rectMode(PConstants.CORNER);
		pg.stroke(110);
		pg.fill(255,255,255);
		pg.rect(x, y + 15, pg.textWidth(title) +6, 18, 5);
		
		pg.textAlign(PConstants.LEFT, PConstants.TOP);
		if (x + pg.textWidth(title) + 6 > 650) {
			pg.rect(x - pg.textWidth(title) - 3, y + 15, pg.textWidth(title) +6, 18, 5);
			pg.fill(0);
			pg.text(title, x - pg.textWidth(title) , y +18);
			
		} else {
			pg.rect(x, y + 15, pg.textWidth(title) +6, 18, 5);
			pg.fill(0);
			pg.text(title, x + 3 , y +18);
		}
		// show routes
		
		
	}
	
}
