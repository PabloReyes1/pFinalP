/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkgpackage;

class Paquete {
    private String trackingNumber;
    private String sender;
    private String recipient;
    private String receivingDepartment;
    private String destinationDepartment;
    private String description;
    private double weight;
    private String status;
    private String classification;

    public Paquete(String trackingNumber, String sender, String recipient, String receivingDepartment,
                   String destinationDepartment, String description, double weight) {
        this.trackingNumber = trackingNumber;
        this.sender = sender;
        this.recipient = recipient;
        this.receivingDepartment = receivingDepartment;
        this.destinationDepartment = destinationDepartment;
        this.description = description;
        this.weight = weight;
        this.status = "Recibido";
        this.classification = "Sin clasificar";
    }

    // Getters and setters

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getReceivingDepartment() {
        return receivingDepartment;
    }

    public void setReceivingDepartment(String receivingDepartment) {
        this.receivingDepartment = receivingDepartment;
    }

    public String getDestinationDepartment() {
        return destinationDepartment;
    }

    public void setDestinationDepartment(String destinationDepartment) {
        this.destinationDepartment = destinationDepartment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    @Override
    public String toString() {
        return "Numero de Seguimiento: " + trackingNumber + "\n" +
                "Remitente: " + sender + "\n" +
                "Destinatario: " + recipient + "\n" +
                "Depto. Recepcion: " + receivingDepartment + "\n" +
                "Depto. Destino: " + destinationDepartment + "\n" +
                "Descripcion: " + description + "\n" +
                "Peso: " + weight + "\n" +
                "Estado: " + status + "\n" +
                "Clasificacion: " + classification;
    }
}

