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

import java.util.ArrayList;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;
import android.app.Activity;

public class MainActivity extends Activity {
	
	
	private String[] dates= {"08/14","10/05","01/01","08/28","10/31","02/08","11/14","10/02"};
	private ArrayList<BirthDayDooot> dudes = null;
	private TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tv = (TextView) findViewById(R.id.txtView);
		tv.setText("");
		dudes = new ArrayList<BirthDayDooot>();
		
		BirthDayDooot dudeOne = new BirthDayDooot("Aswin", // Person Name
				CalendarUtils.stringToCalendar(CalendarUtils.formatDate(dates[0])), // Event date
				null, // Person profile picture URL
				null, // Some Unique ID
				null, // Ignore this. Pass Null
				"B'Day" // Event name
				);
		dudes.add(dudeOne);
		
		BirthDayDooot dudeTwo = new BirthDayDooot("Jobs",
				CalendarUtils.stringToCalendar(CalendarUtils.formatDate(dates[1])),
				null,
				null,
				null,
				"Death Day"
				);
		dudes.add(dudeTwo);
		
		BirthDayDooot dudeThree = new BirthDayDooot("Lucky Day",
				CalendarUtils.stringToCalendar(CalendarUtils.formatDate(dates[2])),
				null,
				null,
				null,
				"New Year"
				);
		dudes.add(dudeThree);
		
		BirthDayDooot dudeFour = new BirthDayDooot("Rahul",
				CalendarUtils.stringToCalendar(CalendarUtils.formatDate(dates[3])),
				null,
				null,
				null,
				"Wedding"
				);
		dudes.add(dudeFour);
		
		BirthDayDooot dudeFive = new BirthDayDooot("Piya",
				CalendarUtils.stringToCalendar(CalendarUtils.formatDate(dates[4])),
				null,
				null,
				null,
				"B'Day"
				);
		dudes.add(dudeFive);
		
		BirthDayDooot dudeSix = new BirthDayDooot("Guru",
				CalendarUtils.stringToCalendar(CalendarUtils.formatDate(dates[5])),
				null,
				null,
				null,
				"Wedding"
				);
		dudes.add(dudeSix);
		
		BirthDayDooot dudeSeven = new BirthDayDooot("Babies",
				CalendarUtils.stringToCalendar(CalendarUtils.formatDate(dates[6])),
				null,
				null,
				null,
				"Children's Day"
				);
		dudes.add(dudeSeven);
		
		BirthDayDooot dudeEight = new BirthDayDooot("Anshu",
				CalendarUtils.stringToCalendar(CalendarUtils.formatDate(dates[7])),
				null,
				null,
				null,
				"B'Day"
				);
		dudes.add(dudeEight);
		
		
		SortListService.sortList(getApplicationContext(), dudes, new SortListService.SortCallback() {
			
			@Override
			public void onSort(ArrayList<BirthDayDooot> dooots) {
				tv.append(Html.fromHtml("<b>Name\t\tDate\t\t\tEvent\n</b><br>"));
				
				for(BirthDayDooot dude:dooots){
					tv.append("\n"+dude.getDootName()+"\t\t"+Html.fromHtml(dude.getSBDay())+"\t\t"+dude.getEvent());
				}
			}
		});
	}

}
