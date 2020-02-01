##Status Codes        
Status Code  | Description
------------- | -------------
200  | OK
201  | CREATED
400  | BAD REQUEST
404  | NOT FOUND


##API endpoints
####Connect to API
<pre>POST:  http://localhost:9090/api></pre>

####Create new User
<pre>POST: http://localhost:9090/api/users </pre>

#####Request
<pre>
{
    “nic”: “{nic}”,
    “mobile”: “+94778976377”
}
</pre>

 #####Response

**400 Bad Request**

<pre>
If mobile no is not set
{
       "message": "Mobile no is not set",
       "developerMessage": " User creation failed because the mobile no is not set"
}
If nic no is not set
{
       "message": "Nic no is not set",
       "developerMessage": " User creation failed because the nic no is not set"
}
</pre>

####Create new Vehicle
<pre>POST:  http://localhost:9090/api/vehicles </pre>

#####Response
**Status 201**
<pre>
{
    “self”: “http://localhost:9090/api/vehicles/{vehicle_id}”,
    “vehicle_number”: “{vehicle_number} ”
}
</pre>

**400 Bad Request**
If the vehicle no is invalid or if vehicle no is not set.
**Status 409**
If a vehicle with that number already exists.
<pre>
{
   "message": "A vehicle with vehicle_number: {vehicle_number} already exists",
   	"developerMessage": "Vehicle creation failed because the vehicle_number: {vehicle_number} already exists",   
}
</pre>

####Return all available vehicles
<pre>GET: http://localhost:9090/api/vehicles </pre>

 #####Response
**Status  200**
<pre>
{
    “vehicles”: [
           {
               “self”: “http://localhost:9090/api/vehicles/{vehicle_id}”,
               “id”: “{id}”,
               “vehicle_number”: “{vehicle_number}”
           },
           …
   ]
}
</pre>


####Create new Officers
<pre>POST:  http://localhost:9090/api/officers</pre>

#####Request
<pre>
{
    “employment_number”: “{employment_number}”
}
Or
{
    “employment_number”: “{employment_number}”,
    	"role": "admin"
}

</pre>

#####Response

**Status 201**
<pre>
{
“self”: “http://localhost:9090/api/officers/{officer_id}”,
 “employment_number”:“{employment_number}”,
 "role": "employee"
}
Or
{
“self”: “http://localhost:9090/api/officers/{officer_id}”,
“employment_number”: “{employment_number}”,
 "role": "admin"
}
</pre>


**Status 409**
<pre>
{
"message":  "Officer with employment_number: {employment_number} already exists",
"developerMessage":  "Officer creation failed because the employment_number: {employment_number} already exists"
}
</pre>

####Return all available employees
<pre>GET:  http://localhost:9090/api/officers </pre>

 #####Response
 
 <pre>
 {
    “officers”: [
           {
                 “self”: “http://localhost:9090/api/officers/{officer_id}”,
                 “id”: “{id}”,
                 “employment_number”: “{employment_number}”,
                 "role": "{role}"
           },
           …
   ]
 </pre>

####Create new Route
<pre>POST: http://localhost:9090/api/routes </pre>

#####Request
<pre>
{
    "route_name": "{route_name}"
}
</pre>

#####Response
**Status 201**
<pre>
{
	"self": "http://localhost:9090/api/routes/{route_id}",
  	"route_name": "{route_name}"
}
</pre>


**Status 409**
<pre>
{
"message": "A route with route_name: {route_name} already exists",
"developerMessage": "Route creation failed because the route_name: {route_name} already exists"
}
</pre>

####Return, all the available routes.
<pre>GET:  http://localhost:9090/api/routes </pre>

#####Response
<pre>
{
    "routes": [
  	{
			"self":  "http://localhost:9090/api/routes/{route_id}",
			 "id": "{id}",
			 "route_name": "{route}"
        },
           …
   ]
}
</pre>
####Create newTime Table
<pre>POST:  http://localhost:9090/api/timetables </pre>

**Request**
<pre>
{         
        “start_time”: “11:30:00”,
         “end_time”: “14:30:00”,
         “day”: “Tuesday”,
         “officer_id”: “{officer_id}”,
         “vehicle_id”: “{vehicle_id}”,
         “route_id”: “{route_id},      
}
</pre>

#####Response
**Status 201**
<pre>
{
   “self”: “http://localhost:9090/api/timetables/{timetable_id}”,
   “start_time”: “11:30:00”,
   “end_time”: “14:30:00”,
   “day”: “Tuesday”,
   “officer”: {
                 “self”: “http://localhost:9090/api/officers/{officer_id}”,
                 “employment_number”: “{employment_number}”
                       ...
     },
    “vehicle”: {
                 “self”: “http://localhost:9090/api/vehicles/{vehicle_id}”,
                 “vehicle_number”: “{vehicle_number} ”
                         ..
     },
    “route”: {
                 “self”: “http://localhost:9090/api/routes/{route_id}”,
                 “route_name”: “{route_name}”
                ...
        }
}
</pre>

**Status 400 **
Return if the vehicle_id or officer_id or route_id is not set

**Status 404**
 If vehicle_id or officer_id or route_id not present to find.

<pre>
{
		"message": " No value present route_id: {route_id}",
		"developerMessage": "Timetable creation failed because no value present 		route_id: {route_id}"
}
</pre>

####Get time table by id number
<pre>GET:  http://localhost:9090/api/timetables/{timetable_id}</pre>

#####Response
<pre>{
    “self”: “http://localhost:9090/api/timetables/{timetable_id}”,
    “id”: “{id}”,
              “start_time”: “{start_time}”,
               “end_time”: “{end_time}”,
               “day”: “{day}”,
                “officer”: {
                     “self”: “http://localhost:9090/api/officers/{officer_id}”,
                     “employment_number”: “{employment_number}”
                      ...
               },
              “vehicle”: {
                     “self”: “http://localhost:9090/api/vehicles/{vehicle_id}”,
                     “vehicle_number”: “{vehicle_number} ”
                      ...
               },
               “route”: {
                      “self”: “http://localhost:9090/api/routes/{route_id}”,
                      “route_name”: “{route_name}”
                       ….
               }
}
</pre>

**Status 401**
If the requested timetable was not found.

####Get All Timetables
<pre>GET:  http://localhost:9090/api/timetables </pre>

#####Query parameters     
Status Code  | Description
------------- | -------------
vehicle_id={vehicle_id}  | Query timetables by vehicle.
officer_id={officer_id}  | Query timetables by officers.
route_id={route_id}  | Query timetables by route.

#####Response
<pre>
{
    “timetables”: [
             {
                  “self”: “http://localhost:9090/api/timetables/{timetable_id}”,
                  “id”: “{id}”,
                  “start_time”: “{start_time}”,
                  “end_time”: “{end_time}”,
                  “day”: “{day}”,
                  “officer”: {
                     “self”: “http://localhost:9090/api/officers/{officer_id}”,
                     “employment_number”: “{employment_number}”,
                      ...
                 },
                “vehicle”: {
                    “self”: “http://localhost:9090/api/vehicles/{vehicle_id}”,
                    “vehicle_number”: “{vehicle_number} ”,
                    ...
                },
                “route”: {
                    “self”: “http://localhost:9090/api/routes/{route_id}”,
                    “route_name”: “{route_name}”,
                     ....
               }
       },
             …
   ]
}
</pre>

## Best Practices

####Best practices for culture and communication

* Adapt the language good for non-native english speakers 
* Be super friendly
* Use a friendly tone when talking to each other
* Staying modest for new comers.
* Be nice and welcoming and show appreciation for the good  work of the co-developers
* If you don't know something try to understand from public channels (stackoverflow, youtube)

####  Best prctices for Commits and pull requests 
* All pull requests are associated with one issue 
* All pull-requests are assigned to the person who os working on it
* Larger issues must be divided down into samller issues
* Add the issue number to the description of the issue
* Write clear meaningful commit messages
* Squash the commit if there are very small changes in the code

####  Branch Policies
* Must not  push straight to the master
* Must not commit the code changes as an unidentified author
* Must not commit the dependancies to the git repository
* Create meaningful gitignore files
* Using a banch naming convention

####Coding best practices
* Code refactoring

