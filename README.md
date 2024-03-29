## Hotel Reservation (MVP Hotel Booking)
Create a new Hotel Booking integration for a new API partner who serves 3 million booking requests per hour. As with any other reservation system, our users will need to be able to Search, Create, Update, View and Cancel their hotel bookings. Assume all users have the same role and permission levels.
design a cloud-based Event Driven Architecture (EDA) to create a more robust and flexible solution.

### Objectives
1.	Design a highly available and fault-tolerant EDA-based hotel reservation system using AWS services.
2.	In your architecture, demonstrate how you would integrate external APIs for making bookings and payments into the system.
3.	Provide recommendations for future enhancements or optimizations based on performance metrics and customer feedback.

### Solution
Based on provided requirements and objectives for designing a Cloud-based Event-Driven Architecture (EDA) for a hotel reservation system using AWS services, we can identify several potential bounded contexts.

### Reservation Management:
This bounded context encompasses the core functionality of managing hotel reservations, ensuring timely and accurate processing of requests. It includes creating, updating, and canceling reservations, managing guest information, room availability, and booking rules. The objective of designing a highly available and fault-tolerant EDA-based hotel reservation system directly aligns with this context.

### External API Integration:
The reliance of hotels on third-party providers for reservation systems highlights the need for integrating external APIs. This context focuses on integrating APIs for making bookings and payments into the system. The objective to demonstrate integration of external APIs aligns with this context, emphasizing seamless interaction with external systems.

### Availability and Inventory Management:
The challenges associated with integration and potential downtime underscore the importance of managing availability and inventory. This context involves tracking room availability, managing blackout dates, and optimizing room allocation. Recommendations for future enhancements and optimizations based on performance metrics also align with this context, emphasizing the need for improving availability and optimizing inventory management.


### Billing and Payment Processing:
Managing payments and processing transactions is crucial for hotel reservations. This context handles billing, processing payments, managing invoices, and ensuring compliance with payment regulations. Integrating payment APIs and providing recommendations for optimizing payment processing align with this context.

### Notification and Communication:
Effective communication with guests regarding reservations is essential. This context focuses on sending reservation confirmations, reminders, and updates to guests via email, SMS, or push notifications. Recommendations for enhancing communication and customer feedback align with this context, emphasizing the importance of improving notification systems.

### Reporting and Analytics:
Analyzing performance metrics and customer feedback is vital for continuous improvement. This context involves generating reports, analyzing reservation data, and providing insights into reservation trends, occupancy rates, and revenue performance. Recommendations for future enhancements based on performance metrics and customer feedback align with this context, emphasizing the importance of data-driven decision-making.

### Hotel Reservation Context

<img alt="image" src="https://github.com/hamony/hotel-microservices-springboot/assets/5976944/bb0076fe-5029-4f91-84b7-f157658ca2cd">

### Hotel Reservation Container
![Booking-Container](https://github.com/hamony/booking-microservices/assets/5976944/54515448-7517-4f1a-abe4-503a45bc892f)

## Technical stack
1. Architecture: Microservices and Event Driven Architecture
2. Design Pattern: Layered Architecture and DDD(Domain Driven Design)
3. Infrastructure Orchestration: Kubernetes
4. Message Broker and Streaming Data: Kafka
5. API Gateway: Kong (Might be changed for optimizing solution)
6. AWS SNS Notification
7. Log Aggregation Tool: Fluentd
8. Service Mesh: Istio
9. Monitoring and Observable: Grafana and Prometheus
10. Cache: Redis
11. Processing Concurrency among multi instances: To be defined.

## Microservices Repository
1. https://github.com/hamony/reservation-service
2. https://github.com/hamony/external-service

## Contact
I'm a software engineer, please contact me via email: khoa.zamioza@gmail.com or Linkedin https://www.linkedin.com/in/khoa-nguyen-software-engineer feel free to ask me.

