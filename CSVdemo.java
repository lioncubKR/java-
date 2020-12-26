package com.example.opencsv;

import java.io.FileReader;
import java.util.Arrays;

import com.opencsv.CSVReader;

public class CSVdemo {

	public static void main(String[] args) {
		
		try {
			CSVReader reader = new CSVReader(new FileReader("/Users/suhwan/Downloads/dvdrental/3055.dat"));
			String[]nextline;
			while((nextline = reader.readNext()) != null){
				if(nextline != null)
				{
					System.out.println(Arrays.toString(nextline));
				}
	}
		}catch(Exception e){
			System.out.println(e);
		}
			System.out.println("CSV Read complete");

	}
}
