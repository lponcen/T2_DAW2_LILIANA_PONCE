package com.cibertec.assessment.service.imp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.assessment.model.Polygon;
import com.cibertec.assessment.model.Square;
import com.cibertec.assessment.repo.PolygonRepo;
import com.cibertec.assessment.repo.SquareRepo;
import com.cibertec.assessment.service.SquareService;


@Service
public class SquareService1Impl implements SquareService {

	@Autowired
	  SquareRepo SquaRepo;

	  @Autowired
	  PolygonRepo polyRepo;

	  @Override
		public Square create(Square s) {
			List<String> intersectedPolygons = findIntersectedPolygons(s);
			s.setPolygons(intersectedPolygons);

			return SquaRepo.save(s);
		}

		@Override
		public List<Square> list() {
			return SquaRepo.findAll();
		}

		private List<String> findIntersectedPolygons(Square square) {
			List<Polygon> allPolygons = polyRepo.findAll();
			List<String> intersectedPolygons = new ArrayList<>();

			for (Polygon polygon : allPolygons) {
				// Lógica de intersección entre square y polygon
				if (isIntersecting(square, polygon)) {
					intersectedPolygons.add(String.valueOf(polygon.getId()));
				}
			}

			return intersectedPolygons;
		}

		private boolean isIntersecting(Square square, Polygon polygon) {
			// Obtener los puntos del square
			List<Integer> squareXPoints = Arrays.asList(square.getXpoints());
			List<Integer> squareYPoints = Arrays.asList(square.getYpoints());

			// Verifica si algún punto del cuadrado está dentro del polígono
			for (int i = 0; i < squareXPoints.size(); i++) {
				int x = squareXPoints.get(i);
				int y = squareYPoints.get(i);

				if (isPointInsidePolygon(x, y, polygon)) {
					return true;
				}
			}

			return false;
		}

		private boolean isPointInsidePolygon(int x, int y, Polygon polygon) {

	      List<Integer> polygonXPoints = Arrays.asList(polygon.getXPoints());
	      List<Integer> polygonYPoints = Arrays.asList(polygon.getYPoints());

	      return x >= Collections.min(polygonXPoints) && x <= Collections.max(polygonXPoints)
	              && y >= Collections.min(polygonYPoints) && y <= Collections.max(polygonYPoints);
	  }
}