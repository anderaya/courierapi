@Entity
@Table(name = "shipments")
public class ShipmentEntity {

    @Id
    private UUID id;

    private UUID senderId;
    private UUID recipientId;

    private BigDecimal declaredValue;
    private BigDecimal shippingCost;

    private String type;
    private String status;

    @Column(columnDefinition = "jsonb")
    private String metadata;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}