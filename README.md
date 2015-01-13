# CRUD API
- List all train bookings:
`curl -v -X GET http://localhost:9000/trains | python -m json.tool`
- Book a train:
`curl -v -X POST -d "trainCode=ABC123" http://localhost:9000/trains`
- List all train bookings:
`see above`
- Update a booking:
`curl -v -X PUT -d "trainCode=DEF456" http://localhost:9000/trains/XXX`
- List the booking:
`curl -v -X GET http://localhost:9000/trains/XXX`
- Delete the booking:
`curl -v -X DELETE http://localhost:9000/trains/XXX`
- List all train bookings:
`see above`

#Hypermedia APIs
- List all hotels:
`curl -v -X GET http://localhost:9000/hotels | python -m json.tool`
- List rooms of a hotel:
`curl -v -X GET http://localhost:9000/hotels/1/rooms | python -m json.tool`
- Book a room:
`curl -v -X POST -H "Content-type: application/vnd.travel.booking+json" -d '{"hotelId": 1, "roomId": 2}' http://localhost:9000/booking | python -m json.tool`
- Booking details:
`curl -v -X GET http://localhost:9000/booking/XXX | python -m json.tool`

