package com.example.consultants.week4_daily1;

import com.example.consultants.week4_daily1.model.Person;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RandomParser {

    public static final String TAG = RandomParser.class.getSimpleName() + "_TAG";
//    private static ArrayList<JSONArray> parseList;


    public static List<Person> personList = new ArrayList<>();
    public static List<JSONObject> parseList = new ArrayList<>();

    public static String first;
    public static String last;
    public static String personAge;
    public static String gender;
    public static String nationality;

    public static List<Person> parsePerson(String reponseStr) {

        JSONObject response = null;
        try {

            Person person = null;

            response = new JSONObject(reponseStr);
            JSONArray results = response.getJSONArray("results");

            for (int i = 0; i < results.length(); i++) {
                parseList.add(results.getJSONObject(i));
            }

            for (int i = 0; i < parseList.size(); i++) {
//                retrieve column from the # iteration (i) into string

                JSONObject name = results.getJSONObject(i).getJSONObject("name");
                first = name.getString("first");
                last = name.getString("last");

                JSONObject dob = results.getJSONObject(i).getJSONObject("dob");
                personAge = dob.getString("age");

                gender = results.getJSONObject(i).getString("gender");

                nationality = results.getJSONObject(i).getString("nat");

                Person lePerson = new Person(first, last, personAge, gender, nationality);
//                person.setFirstname(first);
//                person.setLastname(last);
//                person.setGender(gender);
//                person.setAge(personAge);
//                person.setNationality(nationality);
                personList.add(lePerson);
            }

//            JSONObject user = (JSONObject) results.get(0);
//
//            //String email
////            String email = user.getString("email");
////            Log.d(TAG, "parsePerson: " + email);
//
//            gender = user.getString("gender");
//
//            JSONObject name = user.getJSONObject("name");
//            first = name.getString("first");
//            last = name.getString("last");
//
//            JSONObject age = user.getJSONObject("registered");
//            personAge = age.getString("age");
//
//            nationality = user.getString("natl");
//
//            //pass the information into person
////            person(first, last, gender, personAge, nationality);
//            person.setFirstname(first);
//            person.setLastname(last);
//            person.setGender(gender);
//            person.setAge(personAge);
//            person.setNationality(nationality);
//
//            personList.add(person);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return personList;
    }

}
