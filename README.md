# spring-boot-task_Docker

# Endpoints :

1: POST- To Add person details: http://localhost:8100/people

Sample JSON Request : {
    "personName": "Meera",
    "fatherName": "John",
    "motherName": "Lissy",
    "placeOfBirth": "Berlin",
    "dateOfBirth": "1992-02-25"
}

2:GET - To Get Person Details using Id :http://localhost:8100/people/1

OutPut

{
    "personId": 1,
    "personName": "Meera",
    "fatherName": "John",
    "motherName": "Lissy",
    "placeOfBirth": "Berlin",
    "dateOfBirth": "1992-02-25"
}


3: GET - To Get list of people with name :http://localhost:8100/people/?name=Meera

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

4: POST - To post Marriage relationship between two people : http://localhost:8100/people/relationships

Sample JSON Request :

{
	"personId":1,
	"spouseId":3
}

5: PUT-  To Update Marriage relationship to Divorce between two people : http://localhost:8100/people/relationships

Sample JSON Request :

{
	"personId":1,
	"spouseId":3
}

6 : POST - To Add relation between two people  : http://localhost:8100/people/relationships

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

8 : POST - To add new relation Types  : http://localhost:8100/people/relationships/types

Sample json request

{
    "relationName": "Uncle",
    "relnWithParent" : "parents Sibling",
    "sexCriteria":"Male"
}




    


