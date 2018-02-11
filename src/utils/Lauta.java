package utils;

import nappulat.Nappula;

public class Lauta {
	final char[] characters = {'A','B','C','D','E','F','G','H'};
	Position[][] pelilauta;
	public Lauta() {
		 pelilauta = new Position[8][8];
		 for(int i = 0; i < pelilauta.length; i++) {
			 for(int o = 0; o < pelilauta[i].length; o++) {
				 Position temp = new Position(i, o, false);
				 pelilauta[i][o] = temp;
			 }
		 }
	}
	
	public Position[][] getPelilauta() {
		return pelilauta;
	}
	
	public Position getPosition(int x, int y) {
		return pelilauta[x][y];
	}
	
	public void setPosition(int x, int y, Position pos) {
		pelilauta[x][y] = pos;
	}
	
	public void setNappula(int x, int y, Nappula nap) {
		pelilauta[x][x].setNappula(nap);
		pelilauta[x][x].setHasNappula(true);
	}
	
	public void setPelilauta(Position[][] pelilauta) {
		this.pelilauta = pelilauta;
	}
	
	public boolean legitMove(int x, int y) {
		return x <= 7 && y <= 7 ? true : false;
	}
	
	public boolean legitMove(String x, int y) {
		int tempX = 0;
		for (int i = 0; i < characters.length; i++) {
			if(("" + characters[i]).toLowerCase().equals(x.toLowerCase())){
				tempX = i;
			}
		}
		return legitMove(tempX, y-1);
	}
	
	@Override
	public String toString() {
		StringBuilder ready = new StringBuilder();
		ready.append("   1  2  3  4  5  6  7  8\n  ┌──┬──┬──┬──┬──┬──┬──┬──┐\n");
		
		for(int i = 0; i < pelilauta.length; i++) {
			ready.append(characters[i] + " │");
			 for(int o = 0; o < pelilauta[i].length; o++) {
				 ready.append(pelilauta[i][o].toString() + "│");
			 }
			 if (i != 7)
				 ready.append("\n  ├──┼──┼──┼──┼──┼──┼──┼──┤\n");
			 else
				 ready.append("\n  └──┴──┴──┴──┴──┴──┴──┴──┘\n");
		 }
		return ready.toString();
	}
}