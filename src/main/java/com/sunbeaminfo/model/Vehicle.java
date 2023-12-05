
package com.sunbeaminfo.model;

//Vehicle class
public class Vehicle {
 private String vehicleName;
 private String vehicleId;
 private String frameMaterial;
 private String powertrain;

 // Constructors
 public Vehicle() {
     // Default constructor
 }

 public Vehicle(String vehicleName, String vehicleId, String frameMaterial, String powertrain) {
     this.vehicleName = vehicleName;
     this.vehicleId = vehicleId;
     this.frameMaterial = frameMaterial;
     this.powertrain = powertrain;
 }

 // Getters and setters
 public String getVehicleName() {
     return vehicleName;
 }

 public void setVehicleName(String vehicleName) {
     this.vehicleName = vehicleName;
 }

 public String getVehicleId() {
     return vehicleId;
 }

 public void setVehicleId(String vehicleId) {
     this.vehicleId = vehicleId;
 }

 public String getFrameMaterial() {
     return frameMaterial;
 }

 public void setFrameMaterial(String frameMaterial) {
     this.frameMaterial = frameMaterial;
 }

 public String getPowertrain() {
     return powertrain;
 }

 public void setPowertrain(String powertrain) {
     this.powertrain = powertrain;
 }
}

//WithWheels class (subclass of Vehicle)
class WithWheels extends Vehicle {
private String wheelPosition;

// Constructors (inherits from Vehicle)
public WithWheels(String vehicleName, String vehicleId, String frameMaterial, String powertrain, String wheelPosition) {
  super(vehicleName, vehicleId, frameMaterial, powertrain);
  this.wheelPosition = wheelPosition;
}

// Getter and setter for wheelPosition
public String getWheelPosition() {
  return wheelPosition;
}

public void setWheelPosition(String wheelPosition) {
  this.wheelPosition = wheelPosition;
}
}

//WithoutWheels class (subclass of Vehicle)
class WithoutWheels extends Vehicle {
// Constructors (inherits from Vehicle)
public WithoutWheels(String vehicleName, String vehicleId, String frameMaterial, String powertrain) {
  super(vehicleName, vehicleId, frameMaterial, powertrain);
}
}

//Hanglider class having a has-a relationship with WithoutWheels class
class Hanglider {
private WithoutWheels withoutWheels;

// Constructors, getters, setters, or methods as needed
public Hanglider(WithoutWheels withoutWheels) {
  this.withoutWheels = withoutWheels;
}

public WithoutWheels getWithoutWheels() {
  return withoutWheels;
}

public void setWithoutWheels(WithoutWheels withoutWheels) {
  this.withoutWheels = withoutWheels;
}
}

//Bicycle class having a has-a relationship with WithWheels class
class Bicycle {
private WithWheels withWheels;

// Constructors, getters, setters, or methods as needed
public Bicycle(WithWheels withWheels) {
  this.withWheels = withWheels;
}

public WithWheels getWithWheels() {
  return withWheels;
}

public void setWithWheels(WithWheels withWheels) {
  this.withWheels = withWheels;
}
}

//Motorcycle class having a has-a relationship with WithWheels class
class Motorcycle {
private WithWheels withWheels;

// Constructors, getters, setters, or methods as needed
public Motorcycle(WithWheels withWheels) {
  this.withWheels = withWheels;
}

public WithWheels getWithWheels() {
  return withWheels;
}

public void setWithWheels(WithWheels withWheels) {
  this.withWheels = withWheels;
}
}

//BigWheel class having a has-a relationship with WithWheels class
class BigWheel {
private WithWheels withWheels;

// Constructors, getters, setters, or methods as needed
public BigWheel(WithWheels withWheels) {
  this.withWheels = withWheels;
}

public WithWheels getWithWheels() {
  return withWheels;
}

public void setWithWheels(WithWheels withWheels) {
  this.withWheels = withWheels;
}
}

//Car class having a has-a relationship with WithWheels class
class Car {
private WithWheels withWheels;

// Constructors, getters, setters, or methods as needed
public Car(WithWheels withWheels) {
  this.withWheels = withWheels;
}

public WithWheels getWithWheels() {
  return withWheels;
}

public void setWithWheels(WithWheels withWheels) {
  this.withWheels = withWheels;
}
}

