import com.fasterxml.jackson.databind.ObjectMapper;

public class ShipmentMapper {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static ShipmentEntity toEntity(Shipment shipment) {

        try {
            return new ShipmentEntity(
                    shipment.getId(),
                    shipment.getSenderId(),
                    shipment.getRecipientId(),
                    shipment.getDeclaredValue(),
                    shipment.getShippingCost(),
                    shipment.getType().name(),
                    shipment.getStatus().name(),
                    objectMapper.writeValueAsString(shipment.getMetadata()),
                    shipment.getCreatedAt(),
                    shipment.getUpdatedAt()
            );
        } catch (Exception e) {
            throw new RuntimeException("Error serializing metadata", e);
        }
    }

    public static Shipment toDomain(ShipmentEntity entity) {

        try {
            return new Shipment(
                    entity.getId(),
                    entity.getSenderId(),
                    entity.getRecipientId(),
                    entity.getDeclaredValue(),
                    ShipmentType.valueOf(entity.getType()),
                    objectMapper.readValue(entity.getMetadata(), Map.class)
            );
        } catch (Exception e) {
            throw new RuntimeException("Error parsing metadata", e);
        }
    }
}