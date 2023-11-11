import kotlin.math.pow
import kotlin.math.sqrt

class Point(val x: Double, val y: Double)

class Triangle(
    private val point1: Point,
    private val point2: Point,
    private val point3: Point)
{
    fun getCenterOfCircle() : Point
    {
        val x4 = (point1.x +  point2.x) / 2;
        val y4 = (point1.y + point2.y) / 2;

        val x5 = (point1.x + point3.x) / 2;
        val y5 = (point1.y + point3.y) / 2;

        val a1 = point2.x - point1.x;
        val b1 = point2.y - point1.y;

        val a2 = point3.x - point1.x;
        val b2 = point3.y - point1.y;

        val c1 = x4 * a1 + y4 * b1;
        val c2 = x5 * a2 + y5 * b2;

        val xr = (c1 * b2 - c2 * b1) / (a1 * b2 - a2 * b1);
        val yr = (a1 * c2 - a2 * c1) / (a1 * b2 - a2 * b1);

        return Point(xr, yr);
    }

    fun getRadius() : Double
    {
        val center = getCenterOfCircle();
        return sqrt((point1.x - center.x).pow(2) + (point1.y - center.y).pow(2));
    }
}


fun main()
{
    val point1 = Point(1.0, 1.0);
    val point2 = Point(3.0, 2.0);
    val point3 = Point(1.0, 3.0);

    val triangle = Triangle(point1, point2, point3);

    val center = triangle.getCenterOfCircle();
    val radius = triangle.getRadius();

    println("Координаты центра описанной окружности: (${center.x} ; ${center.y})")
    println("Радиус описанной окружности: ${radius}")

}
