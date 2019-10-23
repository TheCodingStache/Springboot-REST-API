# Springboot-REST-API
Creating REST API using Java Springboot

#Read Hello:
curl -i -H "Content-Type: application/json" -X GET localhost:8080/hello

#Add new user
curl -i -H "Content-Type: application/json" -X POST -d '{
    "name": "Dimitris Pallas",
    "statement": "Creating REST API with Springboot"
}' localhost:8080/users

#List all users
curl -i -H "Content-Type: application/json" \
    -X GET localhost:8080/users

# Get one user
curl -i -H "Content-Type: application/json" \
    -X GET localhost:8080/users/2

# Change one user
curl -i -H "Content-Type: application/json" -X POST -d '{
        "name": "Little Lucy",
        "statement": "I vote for the future!"
    }' localhost:8080/users/2
