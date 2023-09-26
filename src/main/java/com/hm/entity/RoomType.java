package com.hm.entity;

public enum RoomType {
	  SINGLE(3000.0),
	    DOUBLE(4000.0),
	    SUITE(5000.0),
	    DELUXE(6000.0);

	    private final double price;

	    RoomType(double price) {
	        this.price = price;
	    }

	    public double getPrice() {
	        return price;
	    }
	    public RoomType convertStringToRoomType(String roomTypeString) {
	        switch (roomTypeString.toUpperCase()) {
	            case "SINGLE":
	                return RoomType.SINGLE;
	            case "DOUBLE":
	                return RoomType.DOUBLE;
	            case "SUITE":
	                return RoomType.SUITE;
	            case "DELUXE":
	                return RoomType.DELUXE;
	            default:
	                throw new IllegalArgumentException("Invalid room type: " + roomTypeString);
	        }
	    }

}
