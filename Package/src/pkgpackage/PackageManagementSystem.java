/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkgpackage;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PackageManagementSystem {
    private static List<Paquete> packages = new ArrayList<>();

    public static void main(String[] args) {
        int option = 0;

        while (option != 9) {
            option = Integer.parseInt(JOptionPane.showInputDialog(
                    "Menu:\n" +
                            "1. Registrar un paquete\n" +
                            "2. Clasificar Paquetes\n" +
                            "3. Actualizar estado de envío\n" +
                            "4. Consultar lista de envíos registrados\n" +
                            "5. Buscar paquete\n" +
                            "6. Consultar registro de paquetes ingresados\n" +
                            "7. Consultar estado de envío de un paquete\n" +
                            "8. Consultar paquetes no clasificados\n" +
                            "9. Salir"));

            switch (option) {
                case 1:
                    registerPackage();
                    break;
                case 2:
                    classifyPackages();
                    break;
                case 3:
                    updatePackageStatus();
                    break;
                case 4:
                    displayRegisteredPackages();
                    break;
                case 5:
                    searchPackage();
                    break;
                case 6:
                    displayIncomingPackages();
                    break;
                case 7:
                    checkPackageStatus();
                    break;
                case 8:
                    displayUnclassifiedPackages();
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }

    private static void registerPackage() {
        String trackingNumber = JOptionPane.showInputDialog("Ingrese el número de seguimiento:");
        String sender = JOptionPane.showInputDialog("Ingrese el remitente:");
        String recipient = JOptionPane.showInputDialog("Ingrese el destinatario:");
        String receivingDepartment = JOptionPane.showInputDialog("Ingrese el departamento de recepción:");
        String destinationDepartment = JOptionPane.showInputDialog("Ingrese el departamento de destino:");
        String description = JOptionPane.showInputDialog("Ingrese la descripción del paquete:");
        double weight = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso del paquete:"));
        

        Paquete newPackage = new Paquete(trackingNumber, sender, recipient, receivingDepartment,
                destinationDepartment, description, weight);

        packages.add(newPackage);

        JOptionPane.showMessageDialog(null, "Paquete registrado exitosamente.");
    }

    private static void updatePackageStatus() {
        String trackingNumber = JOptionPane.showInputDialog("Ingrese el número de seguimiento del paquete:");

        Paquete packageToUpdate = getPackageByTrackingNumber(trackingNumber);

        if (packageToUpdate != null) {
            String newStatus = JOptionPane.showInputDialog("Ingrese el nuevo estado del envío (Recibido, En Tránsito o Entregado):");
            packageToUpdate.setStatus(newStatus);
            JOptionPane.showMessageDialog(null, "Estado del envío actualizado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Paquete no encontrado.");
        }
    }

    private static void displayRegisteredPackages() {
        if (packages.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se han registrado paquetes.");
        } else {
            StringBuilder packageList = new StringBuilder("Lista de envíos registrados:\n\n");

            for (Paquete pack : packages) {
                packageList.append(pack.toString()).append("\n\n");
            }

            JOptionPane.showMessageDialog(null, packageList.toString());
        }
    }

    private static void searchPackageByTrackingNumber() {
        String trackingNumber = JOptionPane.showInputDialog("Ingrese el número de seguimiento del paquete:");

        Paquete packageToSearch = getPackageByTrackingNumber(trackingNumber);

        if (packageToSearch != null) {
            JOptionPane.showMessageDialog(null, packageToSearch.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Paquete no encontrado.");
        }
    }

    private static void searchPackage(){
        int op = 0;
        while (op != 4) {
            op = Integer.parseInt(JOptionPane.showInputDialog(
                    "Menu:\n" +
                            "1. Buscar por numero de seguimiento\n" +
                            "2. Buscar por remitente\n" +
                            "3. Actualizar por destinatario\n" +
                            "4. Salir"));
            switch (op) {
                case 1:
                    searchPackageByTrackingNumber();
                    break;
                case 2:
                    searchPackageBySender();
                    break;
                case 3:
                    searchPackageByRecipient();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }

    private static void searchPackageBySender() {
        String sender = JOptionPane.showInputDialog("Ingrese el remitente del paquete:");

        List<Paquete> packagesBySender = getPackagesBySender(sender);

        if (packagesBySender.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se encontraron paquetes enviados por ese remitente.");
        } else {
            StringBuilder packageList = new StringBuilder("Paquetes enviados por " + sender + ":\n\n");

            for (Paquete pack : packagesBySender) {
                packageList.append(pack.toString()).append("\n\n");
            }

            JOptionPane.showMessageDialog(null, packageList.toString());
        }
    }

    private static void searchPackageByRecipient() {
        String recipient = JOptionPane.showInputDialog("Ingrese el destinatario del paquete:");

        List<Paquete> packagesByRecipient = getPackagesByRecipient(recipient);

        if (packagesByRecipient.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se encontraron paquetes enviados a ese destinatario.");
        } else {
            StringBuilder packageList = new StringBuilder("Paquetes enviados a " + recipient + ":\n\n");

            for (Paquete pack : packagesByRecipient) {
                packageList.append(pack.toString()).append("\n\n");
            }

            JOptionPane.showMessageDialog(null, packageList.toString());
        }
    }

    private static void displayIncomingPackages() {
        StringBuilder packageList = new StringBuilder("Registro de paquetes ingresados:\n\n");

        for (int i = packages.size() - 1; i >= 0; i--) {
            packageList.append(packages.get(i).toString()).append("\n\n");
        }

        JOptionPane.showMessageDialog(null, packageList.toString());
    }

    private static void checkPackageStatus() {
        String trackingNumber = JOptionPane.showInputDialog("Ingrese el número de seguimiento del paquete:");

        Paquete packageToCheck = getPackageByTrackingNumber(trackingNumber);

        if (packageToCheck != null) {
            JOptionPane.showMessageDialog(null, "Estado del envío: " + packageToCheck.getStatus());
        } else {
            JOptionPane.showMessageDialog(null, "Paquete no encontrado.");
        }
    }

    private static void displayUnclassifiedPackages() {
        StringBuilder packageList = new StringBuilder("Paquetes no clasificados:\n\n");

        for (Paquete pack : packages) {
            if (pack.getClassification().equals("")) {
                packageList.append(pack.toString()).append("\n\n");
            }
        }

        if (packageList.toString().equals("Paquetes no clasificados:\n\n")) {
            JOptionPane.showMessageDialog(null, "Todos los paquetes han sido clasificados.");
        } else {
            JOptionPane.showMessageDialog(null, packageList.toString());
        }
    }

    private static Paquete getPackageByTrackingNumber(String trackingNumber) {
        for (Paquete pack : packages) {
            if (pack.getTrackingNumber().equals(trackingNumber)) {
                return pack;
            }
        }
        return null;
    }

    private static List<Paquete> getPackagesBySender(String sender) {
        List<Paquete> packagesBySender = new ArrayList<>();

        for (Paquete pack : packages) {
            if (pack.getSender().equals(sender)) {
                packagesBySender.add(pack);
            }
        }

        return packagesBySender;
    }

    private static List<Paquete> getPackagesByRecipient(String recipient) {
        List<Paquete> packagesByRecipient = new ArrayList<>();

        for (Paquete pack : packages) {
            if (pack.getRecipient().equals(recipient)) {
                packagesByRecipient.add(pack);
            }
        }

        return packagesByRecipient;
    }
    
    private static void classifyPackages() {
    for (Paquete pack : packages) {
        if (pack.getStatus().equals("Recibido")) {
            if (pack.getWeight() <= 1.0) {
                pack.setClassification("Sobre");
            } else if (pack.getWeight() <= 5.0) {
                pack.setClassification("Bolsa");
            } else if (pack.getWeight() <= 10.0) {
                pack.setClassification("Paquete mediano");
            } else {
                pack.setClassification("Paquete grande");
            }
        }
    }
}
}

