===============================================================
# PROJECT
# GET
	http://localhost:8080/api/v1/project/find-all
	
# GET BY ID
	http://localhost:8080/api/v1/project/{projectId}
	
# POST
	http://localhost:8080/api/v1/project/save
	
	{
        "projectName":"Fireball",
        "projectDescription":"Fireball Automation",
        "enabled":"true",
        "createdAt":null,
        "updatedAt":null,
        "lastUpdatedBy": "Sreekanth"
	}
	
# PUT
    http://localhost:8080/api/v1/project/update/{projectId}

    {
        "projectName":"Fireball",
        "projectDescription":"Fireball Automation",
        "enabled":"true",
        "createdAt":null,
        "updatedAt":null,
        "lastUpdatedBy": "Sreekanth"
	}

# DELETE
    http://localhost:8080/api/v1/project/delete/{projectId}
===============================================================