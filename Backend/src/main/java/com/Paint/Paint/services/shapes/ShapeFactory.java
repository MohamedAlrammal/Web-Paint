package com.Paint.Paint.services.shapes;

public class ShapeFactory {
    public shape createShape(ShapeDTO dto) {
        switch (dto.name) {
            case "square":
                dto.Konvaname="Rect";
                return new Square(dto);
            case "Rect":
                dto.Konvaname="Rect";
                return new Rectangle(dto);
            case "ellipse":
                dto.Konvaname="Elipse"; 
                return new Elipse(dto);
            case "Circle":
                dto.Konvaname="Circle";
                return new Circle(dto);
            case "triangle":
                dto.Konvaname="RegularPolygon";
                return new Triangle(dto);
            case "hexagon":
              dto.Konvaname="RegularPolygon";
              return new Hexagon(dto);
            default:
                throw new IllegalArgumentException("Invalid shape name: " + dto.name);
        }
    }
    public shape createShape(shape s) {
        switch (s.getName()) {
            case "square":
                return new Square((Square) s);
            case "Rect":
                return new Rectangle((Rectangle) s);
            case "ellipse":
                return new Elipse((Elipse) s);
            case "Circle":
                return new Circle((Circle) s);
            case "triangle":
                return new Triangle((Triangle) s);
            case "hexagon":
                return new Hexagon((Hexagon) s);
            default:
                throw new IllegalArgumentException("Invalid shape type: " + s.getName());
        }
    }
}
