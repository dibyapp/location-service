package com.itdib.service;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

import org.springframework.stereotype.Service;

import com.itdib.model.ServerLocation;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.Location;

@Service
public class ServerLocationService {

	public ServerLocation getLocation(String ipAddress) {
		String dataFile = "/Users/dibyaprakashpradhan/Downloads/GeoLite2-City_20220902/GeoLite2-City.mmdb";
		try {
			return getLocation(ipAddress, dataFile);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (GeoIp2Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private ServerLocation getLocation(String ipA, String locationDataFile) throws IOException, GeoIp2Exception {

		File database = new File(locationDataFile);
		DatabaseReader reader = new DatabaseReader.Builder(database).build();
		InetAddress ipAddress = InetAddress.getByName(ipA);
		CityResponse response = reader.city(ipAddress);
		Location location = response.getLocation();
		ServerLocation serverLocation = new ServerLocation();
		serverLocation.setLatitude(String.valueOf(location.getLatitude()));
		serverLocation.setLongitude(String.valueOf(location.getLongitude()));

		return serverLocation;

	}
}