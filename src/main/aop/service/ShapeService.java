package main.aop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.aop.dto.Circle;
import main.aop.dto.Triangle;

@Service
public class ShapeService {

		@Autowired
		private Triangle triangle;
		
		@Autowired
		private Circle circle;

		public Triangle getTriangle() {
			return triangle;
		}

		public void setTriangle(Triangle triangle) {
			this.triangle = triangle;
		}

		public Circle getCircle() {
			return circle;
		}

		public void setCircle(Circle circle) {
			this.circle = circle;
		}
}
