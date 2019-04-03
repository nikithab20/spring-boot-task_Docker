# spring-boot-task_Docker

# Endpoints :

1: To Add person details: http://localhost:8100/people

Sample JSON Request : {
    "personName": "Meera",
    "fatherName": "John",
    "motherName": "Lissy",
    "placeOfBirth": "Berlin",
    "dateOfBirth": "1992-02-25"
}

2:To Get Person Details using Id :http://localhost:8100/people/1

OutPut

{
    "personId": 1,
    "personName": "Meera",
    "fatherName": "John",
    "motherName": "Lissy",
    "placeOfBirth": "Berlin",
    "dateOfBirth": "1992-02-25"
}


3:To Get list of people with name :http://localhost:8100/people/?name=Meera

[
    {
        "personId": 1,
        "personName": "Meera",
        "fatherName": "John",
        "motherName": "Lissy",
        "placeOfBirth": "Berlin",
        "dateOfBirth": "1992-02-25"
    },
    {
        "personId": 2,
        "personName": "Meera",
        "fatherName": "David",
        "motherName": "Lissy",
        "placeOfBirth": "Berlin",
        "dateOfBirth": "1997-02-25"
    },
    {
        "personId": 3,
        "personName": "Meera",
        "fatherName": "John",
        "motherName": "peter",
        "placeOfBirth": "Berlin",
        "dateOfBirth": "1992-06-25"
    }
]

4: To post Marriage relationship between two people : http://localhost:8100/people/relationships

Sample JSON Request :

{
	"personId":1,
	"spouseId":3
}

5: To Update Marriage relationship to Divorce between two people : http://localhost:8100/people/relationships

Sample JSON Request :

{
	"personId":1,
	"spouseId":3
}

6 : To Add relation between two people  : http://localhost:8100/people/relationships

Sample JsOn Request

{
	"personId":1,
	"relativeId":4,
	"relation":"Brother"
	
}

7 : GET - To find list of relation between two people  : http://localhost:8100/people/relationships?person=1&relative=4

Output : 

[
    {
        "relation_description": "Brother"
    }
]



    


