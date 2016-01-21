package com.goldfishweather.app.util;

import android.text.TextUtils;

import com.goldfishweather.app.model.City;
import com.goldfishweather.app.model.County;
import com.goldfishweather.app.model.GoldfishWeatherDB;
import com.goldfishweather.app.model.Province;

public class Utility {
	
	/**
	 * �����ʹ�����������ص�ʡ������
	 */
	public synchronized static boolean handleProvincesResponse(GoldfishWeatherDB 
			goldfishWeatherDB,String response) {
		// TODO Auto-generated method stub
		if(!TextUtils.isEmpty(response)){
			String[] allProvinces=response.split(",");
			if(allProvinces!=null&&allProvinces.length>0){
				for(String p:allProvinces){
					String[] array=p.split("\\|");
					Province province=new Province();
					province.setProvinceCode(array[0]);
					province.setProvinceName(array[1]);
					//���������������ݴ洢��Provice��
					goldfishWeatherDB.saveProvince(province);
				}
				return true;
			}
		}
		return false;
	}
	
	/**
	 * �����ʹ�����������ص��м�����
	 */
	public static boolean handleCitiesResponse(GoldfishWeatherDB goldfishWeatherDB,
			String response,int provinceId) {
		// TODO Auto-generated method stub
		if(!TextUtils.isEmpty(response)){
			String[] allCities=response.split(",");
			if(allCities!=null&&allCities.length>0){
				for(String c:allCities){
					String[] array=c.split("\\|");
					City city=new City();
					city.setCityCode(array[0]);
					city.setCityName(array[1]);
					city.setProvinceId(provinceId);
					//���������������ݴ洢��City��
					goldfishWeatherDB.saveCity(city);
				}
				return true;
			}
		}
		return false;
	}
	
	/**
	 * �����ʹ�����������ص��ؼ�����
	 */
	public static boolean handleCountiesResponse(GoldfishWeatherDB goldfishWeatherDB,
			String response,int cityId) {
		// TODO Auto-generated method stub
		if(!TextUtils.isEmpty(response)){
			String[] allCounties=response.split(",");
			if(allCounties!=null&&allCounties.length>0){
				for(String c:allCounties){
					String[] array=c.split("\\|");
					County county=new County();
					county.setCountyCode(array[0]);
					county.setCountyName(array[1]);
					county.setCityId(cityId);
					//���������������ݴ洢��County��
					goldfishWeatherDB.saveCounty(county);
				}
				return true;
			}
		}
		return false;
	}
}
