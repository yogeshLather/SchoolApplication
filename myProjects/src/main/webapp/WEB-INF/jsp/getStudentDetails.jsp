<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<body>
    <div>
        <div>
            <h4>Please Enter RollNumber and Class to get Details</h4> <br>
            <form action="/showStudentDetails" method="post">
            	Class: <input type="text" name="class"> <br>
            	RollNumber: <input type="text" name="rollNumber"> <br>
            	<input type="submit" value="Submit">
            </form>
        </div>
    </div>
</body>
</html>