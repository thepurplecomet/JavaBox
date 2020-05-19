public class Mesh3D
{
    public Polygon3D[] polygons;
    
    public Mesh3D(Polygon3D... polys){
        this.polygons = polys;
    }
}