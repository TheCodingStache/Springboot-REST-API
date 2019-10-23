# Springboot-REST-API
Creating REST API using Java Springboot

#Read Hello:
curl -i -H "Content-Type: application/json" -X GET localhost:8080/hello

#Add new pledge
curl -i -H "Content-Type: application/json" -X POST -d '{
    "name": "Dimitris Pallas",
    "statement": "Creating REST API with Springboot"
}' localhost:8080/pledges

#List all pledges
curl -i -H "Content-Type: application/json" \
    -X GET localhost:8080/users

# Get one Pledge
curl -i -H "Content-Type: application/json" \
    -X GET localhost:8080/users/2

# Change one pledge
curl -i -H "Content-Type: application/json" -X POST -d '{
        "name": "Little Lucy",
        "statement": "I vote for the future!"
    }' localhost:8080/users/2
