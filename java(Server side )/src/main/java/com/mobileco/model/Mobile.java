package com.mobileco.model;

public class Mobile {

	private int id;
	private String name;
	private int ram;
	private int rom;
	private int fcamera;
	private int rcamera;

	public Mobile() {
		// TODO Auto-generated constructor stub
	}

	public Mobile(int id, String name, int ram, int rom, int fcamera, int rcamera) {
		super();
		this.id = id;
		this.name = name;
		this.ram = ram;
		this.rom = rom;
		this.fcamera = fcamera;
		this.rcamera = rcamera;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public int getRom() {
		return rom;
	}

	public void setRom(int rom) {
		this.rom = rom;
	}

	public int getFcamera() {
		return fcamera;
	}

	public void setFcamera(int fcamera) {
		this.fcamera = fcamera;
	}

	public int getRcamera() {
		return rcamera;
	}

	public void setRcamera(int rcamera) {
		this.rcamera = rcamera;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fcamera;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ram;
		result = prime * result + rcamera;
		result = prime * result + rom;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mobile other = (Mobile) obj;
		if (fcamera != other.fcamera)
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (ram != other.ram)
			return false;
		if (rcamera != other.rcamera)
			return false;
		if (rom != other.rom)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Mobile [id=" + id + ", name=" + name + ", ram=" + ram + ", rom=" + rom + ", fcamera=" + fcamera
				+ ", rcamera=" + rcamera + "]";
	}

}
