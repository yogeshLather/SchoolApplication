<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<body>
    <div>
        <div>
            <h4>Please Enter Student Details</h4> <br>
            <form action="addStudentDetails" method="post">
            	Class: <input type="text" name="class"> <br>
            	RollNumber: <input type="text" name="rollNumber"> <br>
            	Name: <input type="text" name="name"> <br>
            	<input type="submit" value="Submit">
            </form>
        </div>
    </div>
</body>
</html>