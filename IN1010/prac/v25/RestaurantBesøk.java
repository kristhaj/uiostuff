// 10

class RestaurantBesøk implements Runnable {

    RestaurantMonitor restaurantMonitor;
    Gjestegruppe gjester;

    public RestaurantBesøk(RestaurantMonitor restaurantMonitor, Gjestegruppe gjester) {
        this.restaurantMonitor = restaurantMonitor;
        this.gjester = gjester;
    }

    @Override
    public void run() {
        Bord bordet = restaurantMonitor.taImotGjester(gjester);
        // Spiser (ikke implementert)
        restaurantMonitor.forlatBordet(bordet);
    }

    
}