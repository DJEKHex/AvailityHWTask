# AvailityHW
 
1.My proudest professional achievement would be passing the Oracle Certified Associate Java SE 8 Programmer Exam. Although for most this is not a great accomplishment I am proudest of it because I struggle with any sort of exam or assessment. 

2.A book that I have recently read that i would recommend would be The Design of Everyday Things by Don Norman. The book is about design theories. Although not directly talking about software development, many of the concepts I feel transfer rather well.

3.If I were to explain to my grandmother what Availity does, I would say that they provide software to health care providers and insurance companies so they are able to track patient benefits, allow claims to be made and authorize payments. It allows providers and insurance companies to interact with one another more easily.

4.For this task I only checked that there are an equal number of ‘(‘ as ‘)’ and that no ‘)’ shows up before its ‘(‘. This code helps prevent errors due to syntax but it will not prevent issues like invalid parameters for a function or undefined values being used.

5.For this task I hardcoded a sample CSV file to be parsed. I assumed the file was strictly filled with data and did not contain header information. If a header were to be present a line would need to be added to the code to check the values in the line and ignore them if they are the expected column names. The method also assumes that the userid is unique to a user making any duplications of userid is just a different version of that user. The basic steps of the method are:
Go through the CSV file line by line.
Create a user object for each line and place it in the correct map if the user id does not already exist. If there is a duplicate then update the version of that user.
Once all rows are inserted each map gets converted into an array and sorted.
Lastly the contents of each array are printed to a  new CSV file. 
