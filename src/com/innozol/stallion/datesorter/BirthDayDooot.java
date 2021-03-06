/*
 * Copyright (C) 2013 km innozol IT solutions Pvt Ltd <http://innozol.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.innozol.stallion.datesorter;

import java.io.Serializable;
import java.util.Calendar;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * A person profile class. It is serialized to save object on file. And also implements 
 * parcelable to pass its objects through activities.
 * Doooot is a funny name actually mean Dude.
 * 
 * @author Ashwin
 */
public class BirthDayDooot implements Parcelable,Serializable{
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 87L;

	private String dootName;
	private Calendar dootBDay;
	private String dootImgUrl;
	private String dootType;
	private String dootId;
	private String dootSBDay = "";
	private String dootEvent;
	
	public BirthDayDooot(String name,Calendar bDay, String imgUrl,String id,String type,String event) {
		BirthDayDooot.this.dootBDay = bDay;
		if(dootSBDay != null)
			setBDay(CalendarUtils.calendarToString(dootBDay));
		BirthDayDooot.this.dootName = name;
		BirthDayDooot.this.dootImgUrl = imgUrl;
		BirthDayDooot.this.dootId = id;
		BirthDayDooot.this.dootType = type;
		BirthDayDooot.this.dootEvent = event;
	}
	
	public void setBDay(String bDay){
		dootSBDay = bDay;
	}
	
	public String getSBDay(){
		return dootSBDay;
	}
	
	public void setEvent(String event){
		dootEvent = event;
	}
	
	public String getEvent(){
		return BirthDayDooot.this.dootEvent;
	}
	
	public String getDootName(){
		return BirthDayDooot.this.dootName;
	}
	
	public Calendar getDootBirthDay(){
		return BirthDayDooot.this.dootBDay;
	}
	
	public String getDootImageUrl(){
		return BirthDayDooot.this.dootImgUrl;
	}
	
	public void setDootBirthday(Calendar cal){
		dootBDay = cal;
	}
	
	public String getDootId(){
		return BirthDayDooot.this.dootId;
	}
	
	public String getDootType(){
		return BirthDayDooot.this.dootType;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(dootId);
		dest.writeString(dootImgUrl);
		dest.writeString(dootName);
		dest.writeString(dootSBDay);
		dest.writeString(dootType);
		dest.writeValue(dootBDay);
		dest.writeValue(dootEvent);
	}
	
	public BirthDayDooot(Parcel in){
		dootId = in.readString();
		dootImgUrl = in.readString();
		dootName = in.readString();
		dootSBDay = in.readString();
		dootType = in.readString();
		dootBDay = (Calendar)in.readValue(getClass().getClassLoader());
		dootEvent = in.readString();
	}
	
	
	public static final Parcelable.Creator<BirthDayDooot> CREATOR = new  Parcelable.Creator<BirthDayDooot>() {

		@Override
		public BirthDayDooot createFromParcel(Parcel source) {
			return new BirthDayDooot(source);
		}

		@Override
		public BirthDayDooot[] newArray(int size) {
			return new BirthDayDooot[size];
		}
	};
}
