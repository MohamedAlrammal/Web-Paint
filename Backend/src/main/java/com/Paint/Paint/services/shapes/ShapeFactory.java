package com.Paint.Paint.services.shapes;

public class ShapeFactory {
    public shape createShape(ShapeDTO dto) {
        switch (dto.name) {
            case "square":
                return new Square(dto);
            case "Rect":
                return new Rectangle(dto);
            case "ellipse":
                return new Ellipse(dto);
            case "Circle":
                return new Circle(dto);
            case "triangle":
                return new Triangle(dto);
            case "hexagon":
              return new Hexagon(dto);
            case "text":
                dto.fill="black";
                dto.text="Enter Something";
                dto.fontFamily="Arial";
                dto.fontSize = 30;
                return new Text(dto);
            case "Line":
                return new Line(dto);
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
                return new Ellipse((Ellipse) s);
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
