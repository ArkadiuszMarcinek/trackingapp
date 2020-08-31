package com.example.trackingapp.models;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
@Setter
@Table(name = "SHIPMENT")
public class ShipmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;

    @Column(name = "SHIPMENT_ID", updatable = false)
    private @NonNull UUID shipmentId;

    @OneToOne(cascade = CascadeType.PERSIST)
    private @NonNull SenderEntity sender;

    @OneToOne(cascade = CascadeType.PERSIST)
    private @NonNull RecipientEntity recipient;

    @Column(name = "TRACKING_NUMBER", updatable = false)
    private String trackingNumber;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<ShipmentStatusEntity> statusHistory;

    @Column(name = "POST_DATE", updatable = false)
    private @NonNull LocalDateTime postDate;

    @Column(name = "RECEIPT_DATE")
    private LocalDateTime receiptDate;

    public Optional<ShipmentStatusEntity> getLastStatus() {
        return statusHistory.stream().max(Comparator.comparing(ShipmentStatusEntity::getDateFrom));
    }
}
