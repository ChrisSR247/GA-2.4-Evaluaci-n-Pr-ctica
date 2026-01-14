public class Main {

    public static void main(String[] args) {

        System.out.println("SISTEMA DE GESTION DE ENVIOS");

        Package<String> p1 = new Package<>("PKG001", "Documentos", PackageType.STANDARD, 3);
        Package<String> p2 = new Package<>("PKG002", "Vidrio", PackageType.FRAGILE, 1);
        Package<String> p3 = new Package<>("PKG003", "Medicinas", PackageType.EXPRESS, 2);

        RouteManager<Package<?>> route = new RouteManager<>();
        route.add(p1);
        route.add(p2);
        route.add(p3);

        route.moveNext();
        route.moveNext();
        route.movePrev();

        HashTable<String, String> inventory = new HashTable<>(10);
        inventory.put(p1.getId(), "En almacen");
        inventory.put(p2.getId(), "En ruta");
        inventory.put(p3.getId(), "Entregado");

        System.out.println("\nEstado PKG002: " + inventory.get("PKG002"));
        

        Package<?>[] packages = { p1, p2, p3 };

        System.out.println("\nAntes:");
        for (Package<?> p : packages) {
            System.out.println(p + "Prioridad: " + p.getPriority());
        }

        PrioritySorter.insertionSort(packages);

        System.out.println("\nDespues:");
        for (Package<?> p : packages) {
            System.out.println(p + "Prioridad: " + p.getPriority());
        }
    }
}
